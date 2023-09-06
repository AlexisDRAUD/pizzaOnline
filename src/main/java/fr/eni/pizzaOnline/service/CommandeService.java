package fr.eni.pizzaOnline.service;

import fr.eni.pizzaOnline.bo.Commande;
import fr.eni.pizzaOnline.bo.Produit;

public interface CommandeService {

	Commande ajouterProduitAuPanier(Commande commande, int quantite, Produit produit);
	Commande ajouterQuantiteProduitParID(Commande commande, Produit produit);
	Commande soustraireQuantiteProduitParID(Commande commande, Produit produit);
	Commande supprimerProduitParID(Commande commande, Produit produit);
	float getTotalPrixCommande(Commande commande);
	
	void ajouterUneCommande(Commande commande);
	
}
