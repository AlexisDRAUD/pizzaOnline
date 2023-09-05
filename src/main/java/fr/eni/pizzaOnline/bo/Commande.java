package fr.eni.pizzaOnline.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private List<Produit> listProd = new ArrayList<>();

	public Commande() {
		super();
	}

	public Commande(Long id, List<Produit> listProd) {
		super();
		this.id = id;
		this.listProd = listProd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produit> getListProd() {
		return listProd;
	}

	public void setListProd(List<Produit> listProd) {
		this.listProd = listProd;
	}
	
	
//	private LocalDateTime dateHeureLivraison;
//	private LocalDateTime dateHeurePreparation;

//	private Etat etat;
	
	
	
}
