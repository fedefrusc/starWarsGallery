package com.starwarsGallery.gallery.repository;

import org.springframework.data.repository.CrudRepository;

import com.starwarsGallery.gallery.model.Role;


public interface RoleRepository extends CrudRepository<Role, Long>{
	
	Role findByRole(String role);
	
	
}
