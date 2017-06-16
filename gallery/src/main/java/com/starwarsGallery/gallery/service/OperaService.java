package com.starwarsGallery.gallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starwarsGallery.gallery.model.Autore;
import com.starwarsGallery.gallery.model.Opera;
import com.starwarsGallery.gallery.repository.OperaRepository;



@Service
public class OperaService {
	
	@Autowired
	private OperaRepository operaRepository;
	
	public Iterable<Opera> findAll() {
		return this.operaRepository.findAll();
	}
	
	public Opera findById(Long id){
		return this.operaRepository.findOne(id);
	}
	
	public Iterable<Opera> findByAutore(Autore autore){
		return this.operaRepository.findByAutore(autore);
	}
	
	public Iterable<Opera> findByAnno(Integer anno){
		return this.operaRepository.findByAnno(anno);
	}
	
	@Transactional
	public void add(final Opera opera) {
		this.operaRepository.save(opera);
	}
	
	public Opera findbyId(Long id) {
		return this.operaRepository.findOne(id);
	}
	
	public void cancellaOpera (Opera opera) {
		this.operaRepository.delete(opera);
	}
	
	
	
	

	
	

}
