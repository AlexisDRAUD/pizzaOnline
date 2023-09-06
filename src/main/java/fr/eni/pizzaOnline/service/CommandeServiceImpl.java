package fr.eni.pizzaOnline.service;

import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.bo.Commande;
import fr.eni.pizzaOnline.bo.DetailCommande;
import fr.eni.pizzaOnline.bo.Produit;

@Service
public class CommandeServiceImpl implements CommandeService {

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
	
	

}
