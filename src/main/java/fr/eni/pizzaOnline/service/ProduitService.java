package fr.eni.pizzaOnline.service;

import java.util.List;

import fr.eni.pizzaOnline.bo.Produit;

public interface ProduitService {

	List<Produit> tousLesProduits();
	Produit ProduitParID(long id);
	void ajouterUnProduit(Produit produit);
	void modifierUnProduit(Produit produit);
	void supprimerUnProduitParID(long id);

}
