package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.Prodotto;
import it.uniroma3.siw.model.Produttore;
import it.uniroma3.siw.model.Tipologia;
import it.uniroma3.siw.repository.ProdottoRepository;
import it.uniroma3.siw.repository.ProduttoreRepository;
import it.uniroma3.siw.repository.TipologiaRepository;
import it.uniroma3.siw.service.CredenzialiService;

@Controller
public class ProdottoController {

	@Autowired
	ProdottoRepository prodottoRepository;
	@Autowired
	TipologiaRepository tipologiaRepository;
	@Autowired
	ProduttoreRepository produttoreRepository;
	@Autowired
	GlobalController globalController;
	@Autowired
	CredenzialiService credenzialiService;
	

	@GetMapping("/tuttiProdotti")
	public String mostraTuttiProdotti(Model model) {
		model.addAttribute("credenziali", credenzialiService.getCredenziali(globalController.getUser()));
		model.addAttribute("prodotti", this.prodottoRepository.findAll());
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		model.addAttribute("produttori", this.produttoreRepository.findAll());
		model.addAttribute("title", "Prodotti");
		return "prodotti.html";
	}

	@GetMapping("/prodotti/tipologia/{id}")
	public String mostraProdottiPerTipologia(@PathVariable("id") Long id, Model model) {
		model.addAttribute("credenziali", credenzialiService.getCredenziali(globalController.getUser()));
		Tipologia tipologia = this.tipologiaRepository.findById(id).get();
		model.addAttribute("prodotti", this.prodottoRepository.findByTipologia(tipologia));

		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		model.addAttribute("produttori", this.produttoreRepository.findAll());
		model.addAttribute("title", "Prodotti");
		return "prodotti.html";
	}

	@GetMapping("/prodotti/produttore/{id}")
	public String mostraProdottiPerProduttore(@PathVariable("id") Long id, Model model) {
		model.addAttribute("credenziali", credenzialiService.getCredenziali(globalController.getUser()));
		Produttore produttore = this.produttoreRepository.findById(id).get();
		model.addAttribute("prodotti", this.prodottoRepository.findByProduttore(produttore));

		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		model.addAttribute("produttori", this.produttoreRepository.findAll());
		model.addAttribute("title", "Prodotti");
		return "prodotti.html";
	}

	@GetMapping("/prodotti/keyword/{keyword}")
	public String mostraProdottiPerKeyword(@PathVariable("keyword") String keyword, Model model) {
		model.addAttribute("credenziali", credenzialiService.getCredenziali(globalController.getUser()));
		List<Prodotto> prodotti = (List<Prodotto>) this.prodottoRepository.findByNomeContaining(keyword);
		model.addAttribute("prodotti", prodotti);
		model.addAttribute("tipologie", this.tipologiaRepository.findByProdotti(prodotti));
		model.addAttribute("produttori", this.produttoreRepository.findByProdotti(prodotti));
		model.addAttribute("title", "Prodotti");
		return "prodotti.html";
	}
	
	@GetMapping("/prodotto/{id}")
	public String mostraProdotto(@PathVariable("id") Long id, Model model) {
		model.addAttribute("credenziali", credenzialiService.getCredenziali(globalController.getUser()));
		model.addAttribute("title", "Prodotto");
		model.addAttribute("prodotto", this.prodottoRepository.findById(id).get());
		return "prodotto.html";
	}

	
}
