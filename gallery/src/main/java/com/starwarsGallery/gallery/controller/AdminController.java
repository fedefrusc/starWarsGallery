package com.starwarsGallery.gallery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.starwarsGallery.gallery.model.Autore;
import com.starwarsGallery.gallery.model.Opera;
import com.starwarsGallery.gallery.model.Utente;
import com.starwarsGallery.gallery.service.AutoreService;
import com.starwarsGallery.gallery.service.OperaService;
import com.starwarsGallery.gallery.service.UtenteService;

@Controller
public class AdminController {
	@Autowired
	private UtenteService utenteService;

	@Autowired
	private OperaService operaService;

	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/admin/paginaAdmin")
	public String paginaAdmin(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());

		model.addAttribute("admin", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		return"admin/paginaAdmin";
	}
	
	
	@GetMapping("/admin")
	public String getInfoAdmin(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());

		model.addAttribute("admin", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		return"admin/infoAdmin";
	}

	@GetMapping("/admin/adminOpera")
	public String formOpera(Model model,Opera opera){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());
		model.addAttribute("listaAutori", autoreService.findAll());
		model.addAttribute("admin", "Benvenuto "+utente.getNome().toUpperCase());
		return "admin/formOpera";
	}



	@PostMapping(value="/admin/adminOpera")
	public String salvaOpera(@Valid @ModelAttribute Opera opera,BindingResult bindingResult, Model model){

		if (bindingResult.hasErrors()) {
			model.addAttribute("admin", "Benvenuto amministratore");
			model.addAttribute("listaAutori", autoreService.findAll());
			return "admin/formOpera";
		}
		else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Utente utente = utenteService.findByEmail(auth.getName());
			model.addAttribute("admin", "Benvenuto "+utente.getNome().toUpperCase());
			model.addAttribute("utente",utente);

			model.addAttribute("opera",opera);
			model.addAttribute("successMessage", "Opera has been registered successfully");
			operaService.add(opera); 
			Autore autore =autoreService.findById(opera.getAutore().getId());
			model.addAttribute(autore);
		}
		return "admin/infoOpera";
	}
	@GetMapping("/admin/listaAutori")
	public String listaAutori(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());
		model.addAttribute("admin", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		model.addAttribute("listaAutori", autoreService.findAll());
		return"admin/listaAutori";
	}




}
