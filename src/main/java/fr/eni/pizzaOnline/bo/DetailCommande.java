package fr.eni.pizzaOnline.bo;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class DetailCommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetailCommandeID id = new DetailCommandeID();
	
	private int quantite;
	
	@ManyToOne
	@MapsId("commandeId")
	private Commande commande;
	
	@ManyToOne
	@MapsId("produitId")
	private Produit produit;

	public DetailCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailCommande(int quantite, Commande commande, Produit produit) {
		super();
		this.quantite = quantite;
		this.commande = commande;
		this.produit = produit;
	}

	public DetailCommandeID getId() {
		return id;
	}

	public void setId(DetailCommandeID id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "DetailCommande [id=" + id + ", quantite=" + quantite + ", commande=" + ", produit=" + produit
				+ "]";
	}
	
	
}
