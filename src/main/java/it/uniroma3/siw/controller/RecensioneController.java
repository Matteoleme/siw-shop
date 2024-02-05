package it.uniroma3.siw.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Prodotto;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.ProdottoRepository;
import it.uniroma3.siw.repository.RecensioneRepository;
import it.uniroma3.siw.repository.TipologiaRepository;
import it.uniroma3.siw.service.CredenzialiService;
import jakarta.validation.Valid;

@Controller
public class RecensioneController {

	@Autowired
	ProdottoRepository prodottoRepository;
	@Autowired
	RecensioneRepository recensioneRepository;
	@Autowired
	TipologiaRepository tipologiaRepository;
	@Autowired
	GlobalController globalController;
	@Autowired
	CredenzialiService credenzialiService;

	@PostMapping("/nuovaRecensione/{idProdotto}")
	public String nuovaRecensione(@PathVariable("idProdotto") Long idProdotto,
			@Valid @ModelAttribute("recensione") Recensione recensione, BindingResult bindingResult, Model model) {
		Credenziali credenziali = credenzialiService.getCredenziali(globalController.getUser());
		Utente utente = credenziali.getUtente();
		model.addAttribute("credenziali", credenziali);
		model.addAttribute("title", "Prodotto");
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		Prodotto prodotto = this.prodottoRepository.findById(idProdotto).get();
		if (!bindingResult.hasErrors()) {
			if (this.recensioneRepository.existsByProdottoAndUtente(prodotto, utente)) {
				// controllo se questo utente ha già inserito una recensione per questo prodotto
				// e lo mando a modificare la recensione
				model.addAttribute("recensione", this.recensioneRepository.findByProdottoAndUtente(prodotto, utente).get());

				return "modificaRecensione.html";
			} else {
				recensione.setProdotto(prodotto);
				recensione.setUtente(utente);
				recensione.setTimestamp(LocalDate.now());
				this.recensioneRepository.save(recensione);
			}
		} else {
			model.addAttribute("title", "Errore aggiunta recensione");
			return "blank.html";
		}
		model.addAttribute("prodotto", prodotto);
		model.addAttribute("recensioni", this.recensioneRepository.findByProdotto(prodotto));
		model.addAttribute("media_recensioni", this.recensioneRepository.findMediaRecensioniByProdottoId(idProdotto));
		model.addAttribute("nuova_recensione", new Recensione());

		return "prodotto.html";
	}

	@GetMapping("/mostraRecensioni")
	public String mostraRecensioni(Model model) {
		// mi faccio dare le info sull utente e poi stampo quelle dell utente
		Credenziali credenziali = credenzialiService.getCredenziali(globalController.getUser());
		Utente utente = credenziali.getUtente();
		model.addAttribute("credenziali", credenziali);
		model.addAttribute("title", "Recensioni utente");
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		model.addAttribute("recensioni", this.recensioneRepository.findByUtente(utente));
		return "recensioni.html";
	}

	
	@GetMapping("/modificaRecensione/{id}")
	public String formModificaRecensione(@PathVariable("id") Long id, Model model) {
		// mi faccio dare le info sull utente e poi stampo quelle dell utente
		Credenziali credenziali = credenzialiService.getCredenziali(globalController.getUser());
		model.addAttribute("credenziali", credenziali);
		model.addAttribute("title", "Modifica recensione");
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		model.addAttribute("recensione", this.recensioneRepository.findById(id).get());
		return "modificaRecensione.html";
	}

	@PostMapping("/recensioneModificata/{id}")
	public String modificaRecensione(@PathVariable("id") Long id,
			@ModelAttribute("recensione") Recensione nuovaRecensione, Model model) {
		Credenziali credenziali = credenzialiService.getCredenziali(globalController.getUser());
		Utente utente = credenziali.getUtente();
		Recensione recensione = this.recensioneRepository.findById(id).get();
		model.addAttribute("credenziali", credenziali);
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		if (nuovaRecensione.getValutazione() > 0 && nuovaRecensione.getValutazione() <= 5) {
			recensione.setDescrizione(nuovaRecensione.getDescrizione());
			recensione.setValutazione(nuovaRecensione.getValutazione());
			recensione.setTimestamp(LocalDate.now());
			this.recensioneRepository.save(recensione);
		} else {
			model.addAttribute("title", "Errore modifica recensione");
			model.addAttribute("recensione", recensione.getId());
			return "modificaRecensione.html";
		}
		model.addAttribute("title", "Recensioni utente");
		model.addAttribute("recensioni", this.recensioneRepository.findByUtente(utente));
		return "recensioni.html";
	}
	
	/* ADMIN */
	@GetMapping("/admin/mostraRecensioni")
	public String adminMostraRecensioni(Model model) {
		// mi faccio dare le info sull utente e poi stampo quelle dell utente
		Credenziali credenziali = credenzialiService.getCredenziali(globalController.getUser());
		model.addAttribute("credenziali", credenziali);
		model.addAttribute("title", "Recensioni Utenti");
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		model.addAttribute("recensioni", this.recensioneRepository.findAll());
		return "admin/recensioni.html";
	}
	
	@PostMapping("/admin/eliminaRecensione/{id}")
	public String eliminaRecensione(@PathVariable("id") Long id, Model model) {
		Credenziali credenziali = credenzialiService.getCredenziali(globalController.getUser());
		model.addAttribute("credenziali", credenziali);
		model.addAttribute("title", "Recensioni Utenti");
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		Recensione recensione = this.recensioneRepository.findById(id).get();
		this.recensioneRepository.delete(recensione);
		model.addAttribute("recensioni", this.recensioneRepository.findAll());
		return "admin/recensioni.html";
	}
}
