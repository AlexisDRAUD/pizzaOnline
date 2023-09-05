package fr.eni.pizzaOnline.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<DetailCommande> detailsCommande = new ArrayList<>();
	//private List<Produit> listProd = new ArrayList<>();

	public Commande() {
		super();
	}

	public Commande(Long id, List<DetailCommande> detailsCommande) {
		super();
		this.id = id;
		this.detailsCommande = detailsCommande;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DetailCommande> getDetailsCommande() {
		return detailsCommande;
	}

	public void setDetailsCommande(List<DetailCommande> detailsCommande) {
		this.detailsCommande = detailsCommande;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", detailsCommande=" + detailsCommande + "]";
	}
	

//	public List<Produit> getListProd() {
//		return listProd;
//	}
//
//	public void setListProd(List<Produit> listProd) {
//		this.listProd = listProd;
//	}
	
	
//	private LocalDateTime dateHeureLivraison;
//	private LocalDateTime dateHeurePreparation;

//	private Etat etat;
	
	
	
}