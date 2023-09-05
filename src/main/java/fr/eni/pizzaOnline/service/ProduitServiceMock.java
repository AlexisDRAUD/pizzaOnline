package fr.eni.pizzaOnline.service;

import java.util.ArrayList;
import java.util.List;

import fr.eni.pizzaOnline.bo.Produit;

public class ProduitServiceMock implements ProduitService {
	
	public List<Produit> pizzas = new ArrayList<>();
	public int cptID = 4; 
	
	public ProduitServiceMock() {
		pizzas.add(new Produit(1l, "Reine","Sauce tomate, mozzarella, jambon, champignons de Paris.",14.49f,"https://commande.dominos.fr/ManagedAssets/FR/product/PREI/FR_PREI_fr_hero_12192.png?v-1832445367"));
		pizzas.add(new Produit(2l, "Indienne","Crème fraîche légère française, mozzarella, oignons, poulet rôti, champignons de Paris, emmental.",15.49f,"https://commande.dominos.fr/ManagedAssets/FR/product/PIND/FR_PIND_fr_hero_12192.png?v451031"));
		pizzas.add(new Produit(3l, "Margherita","Sauce tomate, mozzarella.",12f,"https://commande.dominos.fr/ManagedAssets/FR/product/PMAR/FR_PMAR_fr_hero_12192.png?v952395148"));
	}

	@Override
	public List<Produit> tousLesProduits() {
		return pizzas;
	}

	@Override
	public Produit ProduitParID(long id) {
		for (Produit produit : pizzas) {
			if(produit.getId()==id) {
				return produit;
			}
		}
		return null;
	}

	@Override
	public void ajouterUnProduit(Produit produit) {
		//
		produit.setId(Long.valueOf(cptID));
		//
		pizzas.add(produit);
		//
			cptID++;
		//
	}

	@Override
	public void modifierUnProduit(Produit produit) {
		for (Produit produitDeList : pizzas) {
			if(produitDeList.getId()==produit.getId()) {
				pizzas.set(pizzas.indexOf(produitDeList), produit);
			}
		}
	}

	@Override
	public void supprimerUnProduitParID(long id) {
		pizzas.remove(pizzas.indexOf(ProduitParID(id)));
	}

	
	
}
