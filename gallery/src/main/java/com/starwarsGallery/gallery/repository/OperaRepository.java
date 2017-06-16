package com.starwarsGallery.gallery.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.starwarsGallery.gallery.model.Autore;
import com.starwarsGallery.gallery.model.Opera;

public interface OperaRepository extends CrudRepository<Opera,Long> {
	
List<Opera> findByAnno (Integer anno);
	
List<Opera> findByAutore(Autore autore);



}
