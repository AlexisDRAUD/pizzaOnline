package fr.eni.pizzaOnline.bo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Etat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String libelle;
	
	public Etat() {
		super();
	}
	
	public Etat(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	public Etat(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Etat [id=" + id + ", libelle=" + libelle + "]";
	}
	
}
