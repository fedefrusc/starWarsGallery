package com.starwarsGallery.gallery.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.starwarsGallery.gallery.model.Autore;
import com.starwarsGallery.gallery.model.Utente;

public interface AutoreRepository extends CrudRepository<Autore, Long>{
	
	Autore findById(Long id);
	
}
