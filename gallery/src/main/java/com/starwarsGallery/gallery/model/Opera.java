package com.starwarsGallery.gallery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;


@Entity
public class Opera {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long id;
	@NotNull
	@Size(min=2, max=30)
	private String titolo;
	@ManyToOne
	@NotNull
	private Autore autore;
	@NotNull
	private Integer anno;
	@NotNull
	@Size(min=2, max=30)
	private String tecnica;
	@NotNull
	@Size(min=2, max=30)
	private String dimensioni;
	
	@NotNull
	private String pathImage;
	
	protected Opera() {}
	
	
	


	public Opera(String titolo, Autore autore, int anno, String tecnica, String dimensioni) {
		this.titolo = titolo;
		this.autore = autore;
		this.anno = anno;
		this.tecnica = tecnica;
		this.dimensioni = dimensioni;
	}
	
	

	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getPathImage() {
		return pathImage;
	}





	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}





	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public String getDimensioni() {
		return dimensioni;
	}
	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}
	
	@Override
	public String toString() {
		return "Opera [titolo=" + titolo + ", autore=" + autore + ", anno=" + anno + ", tecnica=" + tecnica
				+ ", dimensioni=" + dimensioni + "]";
	}
	
	

}
