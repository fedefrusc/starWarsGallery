package com.starwarsGallery.gallery.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.starwarsGallery.gallery.model.Utente;



public interface UtenteRepository extends CrudRepository<Utente, Long>{
		
		Utente findByEmail(String email);
		
		List<Utente> findByNome(String nome);

	    List<Utente> findByCognome(String cognome);
	    
	   
}
