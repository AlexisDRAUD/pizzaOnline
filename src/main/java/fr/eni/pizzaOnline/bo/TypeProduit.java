package fr.eni.pizzaOnline.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TypeProduit {

	@Id
	private Integer id;
	private String libelle;
	
	public TypeProduit() {
		super();
	}
	public TypeProduit(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	public TypeProduit(String libelle) {
		super();
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		return "TypeProduit [id=" + id + ", libelle=" + libelle + "]";
	}
	
}
