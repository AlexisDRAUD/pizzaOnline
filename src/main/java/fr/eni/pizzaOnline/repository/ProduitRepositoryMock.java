package fr.eni.pizzaOnline.repository;

import java.util.ArrayList;
import java.util.List;

import fr.eni.pizzaOnline.bo.Produit;

public class ProduitRepositoryMock {

	public List<Produit> pizzas = new ArrayList<>();
	public int cptID = 4; 

//	public ProduitRepositoryMock() {
//		pizzas.add(new Produit(1l, "Reine","Sauce tomate, mozzarella, jambon, champignons de Paris.",14.49f,"https://commande.dominos.fr/ManagedAssets/FR/product/PREI/FR_PREI_fr_hero_12192.png?v-1832445367"));
//		pizzas.add(new Produit(2l, "Indienne","Crème fraîche légère française, mozzarella, oignons, poulet rôti, champignons de Paris, emmental.",15.49f,"https://commande.dominos.fr/ManagedAssets/FR/product/PIND/FR_PIND_fr_hero_12192.png?v451031"));
//		pizzas.add(new Produit(3l, "Margherita","Sauce tomate, mozzarella.",12f,"https://commande.dominos.fr/ManagedAssets/FR/product/PMAR/FR_PMAR_fr_hero_12192.png?v952395148"));
//	}
	
	@Override
	public List<Produit> findAllProduits() {
		return pizzas;
	}

	@Override
	public Produit findProduitByID(long id) {
		for (Produit produit : pizzas) {
			if(produit.getId()==id) {
				return produit;
			}
		}
		return null;
	}

	@Override
	public void addProduit(Produit produit) {
		//
		produit.setId(Long.valueOf(cptID));
		//
		pizzas.add(produit);
		//
			cptID++;
		//		
	}

	@Override
	public void updateProduit(Produit produit) {
		for (Produit produitDeList : pizzas) {
			if(produitDeList.getId()==produit.getId()) {
				pizzas.set(pizzas.indexOf(produitDeList), produit);
			}
		}
	}

	@Override
	public void removeProduitByID(long id) {
		pizzas.remove(pizzas.indexOf(findProduitByID(id)));
	}

	
	
}
