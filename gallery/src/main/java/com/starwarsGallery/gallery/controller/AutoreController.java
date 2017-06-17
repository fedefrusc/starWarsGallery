package com.starwarsGallery.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import com.starwarsGallery.gallery.model.Autore;
import com.starwarsGallery.gallery.model.Utente;
import com.starwarsGallery.gallery.service.AutoreService;
import com.starwarsGallery.gallery.service.OperaService;
import com.starwarsGallery.gallery.service.UtenteService;

@Controller
public class AutoreController {
		
	@Autowired
	private AutoreService autoreService;
	
	@Autowired
	private OperaService operaService;
	

	@Autowired
	private UtenteService utenteService;
	@GetMapping("/admin/opereAutore")
	public String opereArtista(Model model, WebRequest request){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());
		model.addAttribute("admin", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		Long id = Long.parseLong(request.getParameter("id"));
		Autore autore = autoreService.findById(id);
		model.addAttribute("listaOpere", operaService.findByAutore(autore));
		model.addAttribute(autore);
		return "admin/listaOpere";
	}
	
	
}
