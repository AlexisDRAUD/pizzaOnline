package fr.eni.pizzaOnline.repository;

import java.util.List;

import fr.eni.pizzaOnline.bo.Produit;

public interface ProduitRepository {

		List<Produit> findAllProduits();
		Produit findProduitByID(long id);
		void addProduit(Produit produit);
		void modifierProduit(Produit produit);
		void removeProduitByID(long id);

}
