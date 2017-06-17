package com.starwarsGallery.gallery.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name="utente")
public class Utente {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="utente_id")
    private Long id;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Transient
	@Size(min=4)
	private String password;
	
	@NotNull
	@Size(min=2, max=30)
	private String nome;
	
	@NotNull
	@Size(min=2, max=30)
	private String cognome;
	@Column(name = "active")
	private int active;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "utente_role", joinColumns = @JoinColumn(name = "utente_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	protected Utente() {}


	public Utente(String email, String password, String nome, String cognome) {
		
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}




	

	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRuoli(Set<Role> roles) {
		this.roles = roles;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome + "]";
	}


	
	

}
