package it.uniroma3.siw.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Prodotto;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.ProdottoRepository;
import it.uniroma3.siw.repository.RecensioneRepository;
import it.uniroma3.siw.service.CredenzialiService;
import jakarta.validation.Valid;

@Controller
public class RecensioneController {

	@Autowired
	ProdottoRepository prodottoRepository;
	@Autowired
	RecensioneRepository recensioneRepository;
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
		Prodotto prodotto = this.prodottoRepository.findById(idProdotto).get();
		if (!bindingResult.hasErrors()) {
			if (this.recensioneRepository.existsByProdottoAndUtente(prodotto, utente)) {
				// controllo se questo utente ha già inserito una recensione per questo prodotto
				// e lo mando a modificare la recensione
				return "recensione.html";
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
}