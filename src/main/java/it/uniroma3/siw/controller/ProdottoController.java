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

@Controller
public class ProdottoController {

	@Autowired
	ProdottoRepository prodottoRepository;
	@Autowired
	TipologiaRepository tipologiaRepository;
	@Autowired
	ProduttoreRepository produttoreRepository;

	/* da spostare */
	@GetMapping("/index")
	public String index(Model model) {

		return "index.html";
	}

	@GetMapping("/tuttiProdotti")
	public String mostraTuttiProdotti(Model model) {
		model.addAttribute("prodotti", this.prodottoRepository.findAll());
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		model.addAttribute("produttori", this.produttoreRepository.findAll());
		return "prodotti.html";
	}

	@GetMapping("/prodotti/tipologia/{id}")
	public String mostraProdottiPerTipologia(@PathVariable("id") Long id, Model model) {
		Tipologia tipologia = this.tipologiaRepository.findById(id).get();
		model.addAttribute("prodotti", this.prodottoRepository.findByTipologia(tipologia));

		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		model.addAttribute("produttori", this.produttoreRepository.findAll());
		return "prodotti.html";
	}

	@GetMapping("/prodotti/produttore/{id}")
	public String mostraProdottiPerProduttore(@PathVariable("id") Long id, Model model) {
		Produttore produttore = this.produttoreRepository.findById(id).get();
		model.addAttribute("prodotti", this.prodottoRepository.findByProduttore(produttore));

		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		model.addAttribute("produttori", this.produttoreRepository.findAll());
		return "prodotti.html";
	}

	@GetMapping("/prodotti/keyword/{keyword}")
	public String mostraProdottiPerKeyword(@PathVariable("keyword") String keyword, Model model) {
		List<Prodotto> prodotti = (List<Prodotto>) this.prodottoRepository.findByNomeContaining(keyword);
		model.addAttribute("prodotti", prodotti);
		model.addAttribute("tipologie", this.tipologiaRepository.findByProdotti(prodotti));
		model.addAttribute("produttori", this.produttoreRepository.findByProdotti(prodotti));
		return "prodotti.html";
	}
}
