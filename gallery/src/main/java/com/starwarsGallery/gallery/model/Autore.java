package com.starwarsGallery.gallery.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Autore {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String pianeta;
	private String dataDiNascita;
	private String dataDiMorte;
	@OneToMany(mappedBy="autore")
	private List<Opera> opere;
	
	
	public Autore() {}
	
	public Autore(String nome, String pianeta, String dataDiNascita, String dataDiMorte ) {
		this.nome = nome;
		this.pianeta = pianeta;
		this.dataDiNascita = dataDiNascita;
		this.dataDiMorte = dataDiMorte;
		this.opere = new ArrayList<Opera>();
	}
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Opera> getOpere() {
		return opere;
	}
	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPianeta() {
		return pianeta;
	}

	public void setPianeta(String pianeta) {
		this.pianeta = pianeta;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getDataDiMorte() {
		return dataDiMorte;
	}

	public void setDataDiMorte(String dataDiMorte) {
		this.dataDiMorte = dataDiMorte;
	}

	@Override
	public String toString() {
		return "Autore [pianeta=" + pianeta + ", dataDiNascita=" + dataDiNascita + ", dataDiMorte=" + dataDiMorte
				+ ", nome=" + nome + "]";
	}

	
	
	
	
	
	
	

}
