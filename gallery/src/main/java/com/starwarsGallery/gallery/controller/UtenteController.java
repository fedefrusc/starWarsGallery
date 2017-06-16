package com.starwarsGallery.gallery.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.context.request.WebRequest;

import com.starwarsGallery.gallery.model.Autore;
import com.starwarsGallery.gallery.model.Opera;
import com.starwarsGallery.gallery.model.Utente;
import com.starwarsGallery.gallery.service.AutoreService;
import com.starwarsGallery.gallery.service.OperaService;
import com.starwarsGallery.gallery.service.UtenteService;



@Controller
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private OperaService operaService;

	@Autowired
	private AutoreService autoreService;

	
	@GetMapping("/listaAutoriUtente")
	public String listaAutori(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());
		model.addAttribute("nomeUtente", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		model.addAttribute("listaAutori", autoreService.findAll());
		return"utente/listaAutori";
	}
	@GetMapping("opereAutoreUtente")
	public String opereArtista(Model model, WebRequest request){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());
		model.addAttribute("nomeUtente", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		Long id = Long.parseLong(request.getParameter("id"));
		Autore autore = autoreService.findById(id);
		model.addAttribute("listaOpere", operaService.findByAutore(autore));
		model.addAttribute(autore);
		return "utente/listaOpere";
	}
	@GetMapping("infoOpera")
	public String infoOpera(Model model, WebRequest request){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());
		model.addAttribute("nomeUtente", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		
		
		Long id = Long.parseLong(request.getParameter("id"));
		Opera opera= operaService.findbyId(id);
		Autore autore= opera.getAutore();
		model.addAttribute("opera",opera);
		model.addAttribute("autore",autore);
		
		return "utente/infoOpera";
	}
	@GetMapping("/listaAnni")
	public String listaAnni(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());
		model.addAttribute("nomeUtente", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		Iterable<Opera> listaOpere = operaService.findAll();
		Set<Integer> listaAnni = new HashSet<Integer>();
		for(Opera o : listaOpere){
			listaAnni.add(o.getAnno());
		}
		model.addAttribute("listaAnni",listaAnni);
		return"utente/listaAnni";
	}
	
	
	
	@GetMapping("/annoOpereUtente")
	public String operaPerAnno(Model model,WebRequest request){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());
		model.addAttribute("nomeUtente", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		Integer anno = Integer.parseInt(request.getParameter("a"));
		System.out.println(anno.getClass().toString());
		model.addAttribute("listaOpere", operaService.findByAnno(anno));
		return "utente/listaOpere";
	}
	@GetMapping("/infoUtente")
	public String getInfoUtente(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utenteService.findByEmail(auth.getName());

		model.addAttribute("nomeUtente", "Benvenuto "+utente.getNome().toUpperCase());
		model.addAttribute("utente",utente);
		return"utente/infoUtente";
	}
}
