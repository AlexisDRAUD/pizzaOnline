package fr.eni.pizzaOnline.service;

import fr.eni.pizzaOnline.bo.Commande;
import fr.eni.pizzaOnline.bo.Produit;

public interface CommandeService {

	Commande ajouterProduitAuPanier(Commande commande, int quantite, Produit produit);
	
}
