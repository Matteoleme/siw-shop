package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.Tipologia;
import it.uniroma3.siw.repository.ProdottoRepository;
import it.uniroma3.siw.repository.TipologiaRepository;

@Controller
public class ProdottoController {
	
	@Autowired
	ProdottoRepository prodottoRepository;
	@Autowired
	TipologiaRepository tipologiaRepository;

	
	/* da spostare */
	@GetMapping("/index")
	public String index(Model model) {
		
		return "index.html";
	}
	
	@GetMapping("/tuttiProdotti")
	public String mostraTuttiProdotti(Model model) {
		model.addAttribute("prodotti", this.prodottoRepository.findAll());
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());		
		return "prodotti.html";
	}
	
	@GetMapping("/prodotti/tipologia/{id}")
	public String mostraProdottiPerTipologia(@PathVariable("id") Long id, Model model) {
		Tipologia tipologia = this.tipologiaRepository.findById(id).get();
		model.addAttribute("prodotti", this.prodottoRepository.findByTipologia(tipologia));
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());		
		return "prodotti.html";
	}
	
}
