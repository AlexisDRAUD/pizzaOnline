package fr.eni.pizzaOnline.bo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<DetailCommande> detailsCommande = new ArrayList<>();

	@ManyToOne
	private Etat etat;
	
	private LocalDateTime dateHeureLivraison = LocalDateTime.now().plusHours(2);
	private LocalDateTime dateHeurePreparation = LocalDateTime.now().plusHours(1);

	public Commande() {
		super();
	}
	 
	public Commande(Etat etat) {
		this.etat = etat;
	}

	public Commande(Long id, List<DetailCommande> detailsCommande, Etat etat) {
		super();
		this.id = id;
		this.detailsCommande = detailsCommande;
		this.etat = etat;
	}

	public Commande(Long id, List<DetailCommande> detailsCommande, Etat etat, LocalDateTime dateHeureLivraison,
			LocalDateTime dateHeurePreparation) {
		super();
		this.id = id;
		this.detailsCommande = detailsCommande;
		this.etat = etat;
		this.dateHeureLivraison = dateHeureLivraison;
		this.dateHeurePreparation = dateHeurePreparation;
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

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public LocalDateTime getDateHeureLivraison() {
		return dateHeureLivraison;
	}

	public void setDateHeureLivraison(LocalDateTime dateHeureLivraison) {
		this.dateHeureLivraison = dateHeureLivraison;
	}

	public LocalDateTime getDateHeurePreparation() {
		return dateHeurePreparation;
	}

	public void setDateHeurePreparation(LocalDateTime dateHeurePreparation) {
		this.dateHeurePreparation = dateHeurePreparation;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", detailsCommande=" + detailsCommande + ", etat=" + etat
				+ ", dateHeureLivraison=" + dateHeureLivraison + ", dateHeurePreparation=" + dateHeurePreparation + "]";
	}


}
