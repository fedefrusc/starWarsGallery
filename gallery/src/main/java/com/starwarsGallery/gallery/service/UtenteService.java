package com.starwarsGallery.gallery.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starwarsGallery.gallery.model.Role;
import com.starwarsGallery.gallery.model.Utente;
import com.starwarsGallery.gallery.repository.RoleRepository;

import com.starwarsGallery.gallery.repository.UtenteRepository;



@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private RoleRepository ruoloRepository;
	 @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	 
	 public Utente findByEmail(String email) {
		 return utenteRepository.findByEmail(email);
		}
	 
	public Iterable<Utente> findAll() {
		return this.utenteRepository.findAll();
	}
	
	@Transactional
	public void add(Utente utente) {
		utente.setPassword(bCryptPasswordEncoder.encode(utente.getPassword()));
		Role utenteRuolo = ruoloRepository.findByRole("USER");
		utente.setActive(1);
		utente.setRuoli(new HashSet<Role>(Arrays.asList(utenteRuolo)));
		this.utenteRepository.save(utente);
	}
	
	public Utente findbyId(Long id) {
		return this.utenteRepository.findOne(id);
	}
	
	public void cancellaUtente(Utente utente) {
		this.utenteRepository.delete(utente);
	}
}
