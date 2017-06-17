package com.starwarsGallery.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starwarsGallery.gallery.model.Utente;
import com.starwarsGallery.gallery.service.UtenteService;
@Controller
public class MainController {
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value ={"/","index"})
	public String redirectHome(){
		return "home";
		
	}
	@RequestMapping("/access-denied")
	public String accessoNegato(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());
		model.addAttribute("nomeUtente", "Benvenuto "+utente.getNome().toUpperCase());
		return"access-denied";
	}
}
