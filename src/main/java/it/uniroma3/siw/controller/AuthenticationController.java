package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Credenziali;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.repository.ProduttoreRepository;
import it.uniroma3.siw.repository.TipologiaRepository;
import it.uniroma3.siw.service.CredenzialiService;
import jakarta.validation.Valid;

@Controller
public class AuthenticationController {
	@Autowired
	private CredenzialiService credenzialiService;
	@Autowired
	ProduttoreRepository produttoreRepository;
	@Autowired
	TipologiaRepository tipologiaRepository;
	
	@Autowired
	GlobalController globalController;

	@GetMapping(value = "/registrati")
	public String showRegisterForm(Model model) {
		model.addAttribute("utente", new Utente());
		model.addAttribute("credenziali", new Credenziali());
		model.addAttribute("title", "Registrazione");
		return "formRegistraUtente.html";
	}

	@GetMapping(value = "/login")
	public String showLoginForm(Model model) {
		model.addAttribute("title", "Login page");
		return "login.html";
	}

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("title", "Home");
		model.addAttribute("produttori", this.produttoreRepository.findAll());
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof AnonymousAuthenticationToken) {
			return "index.html";
		} else {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
			model.addAttribute("credenziali", credenziali);
			if (credenziali.getRuolo().equals(Credenziali.ADMIN_ROLE)) {
				return "admin/index.html";
			}
		}
		return "index.html";
	}

	@GetMapping(value = "/success")
	public String defaultAfterLogin(Model model) {
		model.addAttribute("title", "Home");
		model.addAttribute("produttori", this.produttoreRepository.findAll());
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
		model.addAttribute("credenziali", credenziali);
		if (credenziali.getRuolo().equals(Credenziali.ADMIN_ROLE)) {
			return "admin/index.html";
		}
		return "index.html";
	}

	@PostMapping(value = { "/registrati" })
	public String registerUser(@Valid @ModelAttribute("utente") Utente utente, BindingResult userBindingResult,
			@Valid @ModelAttribute("credenziali") Credenziali credenziali, BindingResult credentialsBindingResult,
			Model model) {

		// se user e credential hanno entrambi contenuti validi, memorizza User e the
		// Credentials nel DB
		if (!userBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
			credenziali.setUtente(utente);
			utente.setCredenziali(credenziali);
			credenzialiService.saveCredentials(credenziali);
			model.addAttribute("utente", utente);
			model.addAttribute("credenziali", credenziali);
			model.addAttribute("title", "Riepilogo Utente");
			return "utente.html";
		}
		model.addAttribute("title", "Registrazione");
		return "formRegistraUtente.html";
	}
	
	@GetMapping("/account")
	public String getAccount(Model model) {
		Credenziali credenziali = credenzialiService.getCredenziali(globalController.getUser());
		model.addAttribute("credenziali", credenziali);
		model.addAttribute("utente", credenziali.getUtente());
		model.addAttribute("title", "Riepilogo Utente");
		return "utente.html";
	}

	@GetMapping("/blank")
	public String blankPage(Model model) {
		model.addAttribute("title", "Blank Page");
		model.addAttribute("produttori", this.produttoreRepository.findAll());
		model.addAttribute("tipologie", this.tipologiaRepository.findAll());
		return "blank.html";
	}
}
