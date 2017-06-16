package com.starwarsGallery.gallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwarsGallery.gallery.model.Autore;
import com.starwarsGallery.gallery.repository.AutoreRepository;

@Service
public class AutoreService {
	
	
	@Autowired
	private AutoreRepository autoreRepository;
	
	public Autore findById(Long id){
		return autoreRepository.findOne(id);
	}

	public Iterable<Autore> findAll() {
		return this.autoreRepository.findAll();
	}
}
