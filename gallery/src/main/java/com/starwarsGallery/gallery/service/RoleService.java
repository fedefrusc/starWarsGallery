package com.starwarsGallery.gallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starwarsGallery.gallery.model.Role;
import com.starwarsGallery.gallery.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public void add(final Role utenteRuolo) {
		this.roleRepository.save(utenteRuolo);
	}
}
