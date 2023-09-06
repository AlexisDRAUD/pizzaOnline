package fr.eni.pizzaOnline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.bo.Commande;
import fr.eni.pizzaOnline.bo.DetailCommande;
import fr.eni.pizzaOnline.bo.Produit;
import fr.eni.pizzaOnline.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	CommandeRepository cr;
	
	@Override
	public Commande ajouterProduitAuPanier(Commande commande, int quantite, Produit produit) {
		DetailCommande detailCommandeToAdd = new DetailCommande(quantite, commande, produit);
		if(commande.getDetailsCommande().contains(detailCommandeToAdd)) {
			quantite+=commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).getQuantite();
			commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).setQuantite(quantite);
		} else {
			commande.getDetailsCommande().add(detailCommandeToAdd);
		}
		return commande;
	}

	@Override
	public Commande ajouterQuantiteProduitParID(Commande commande, Produit produit) {
		DetailCommande detailCommandeToAdd = new DetailCommande(1, commande, produit);
		if(commande.getDetailsCommande().contains(detailCommandeToAdd)) {
			int quantite = commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).getQuantite()+1;
			commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).setQuantite(quantite);
		}
		return commande;
	}

	@Override
	public Commande soustraireQuantiteProduitParID(Commande commande, Produit produit) {
		DetailCommande detailCommandeToAdd = new DetailCommande(1, commande, produit);
		if(commande.getDetailsCommande().contains(detailCommandeToAdd)) {
			int quantite = commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).getQuantite()-1;
			commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).setQuantite(quantite);
		}
		return commande;
	}

	@Override
	public Commande supprimerProduitParID(Commande commande, Produit produit) {
		DetailCommande detailCommandeToSuppr = new DetailCommande(1, commande, produit);
		if(commande.getDetailsCommande().contains(detailCommandeToSuppr)) {
			commande.getDetailsCommande().remove(detailCommandeToSuppr);
		}
		return commande;
	}

	@Override
	public float getTotalPrixCommande(Commande commande) {
		float totalPrix = 0;
		for (DetailCommande detailCommande : commande.getDetailsCommande()) {
			totalPrix += detailCommande.getProduit().getPrix()*detailCommande.getQuantite();
		}
		return totalPrix;
	}

	@Override
	public void ajouterUneCommande(Commande commande) {
		cr.save(commande);
	}	

}
