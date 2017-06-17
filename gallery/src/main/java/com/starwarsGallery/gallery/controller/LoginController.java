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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.starwarsGallery.gallery.model.Utente;
import com.starwarsGallery.gallery.service.UtenteService;

@Controller
public class LoginController {
	
	@Autowired
	private UtenteService utenteService;
	
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	 @GetMapping("/registration")
	  public String formUtente(Utente utente) {
	    return "registration";
	  }
	 @PostMapping(value = "/registration")
	    public String checkUtenteInfo(@Valid @ModelAttribute Utente utente,BindingResult bindingResult, Model model) {
	    	
	        if (bindingResult.hasErrors()) {
	            return "registration";
	        }
	        else {
	        		
	            	model.addAttribute(utente);
	            	model.addAttribute("successMessage", "Utente Registarto con Successo");
	                utenteService.add(utente); 
	            }
	        return "registrationConfirm";
	    }
	 
	 
	 @RequestMapping(value="/default", method = RequestMethod.GET)
	 public String home(Model model){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 Utente utente = utenteService.findByEmail(auth.getName());
		 model.addAttribute("nomeUtente", "Benvenuto utente: "+utente.getNome().toUpperCase());
		 model.addAttribute("admin", "Benvenuto amministratore");
		 if(utente.getRoles().iterator().next().getRole().equals("ADMIN"))
			 return "admin/paginaAdmin";
		 return "utente/paginaUtente";
	 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
