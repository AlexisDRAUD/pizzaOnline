package fr.eni.pizzaOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.bo.Produit;
import fr.eni.pizzaOnline.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository pr;
	
	@Override
	public List<Produit> tousLesProduits() {
		return pr.findAllProduits();
	}

	@Override
	public Produit ProduitParID(long id) {
		return pr.findProduitByID(id);
	}

	@Override
	public void ajouterUnProduit(Produit produit) {
		pr.addProduit(produit);
	}

	@Override
	public void modifierUnProduit(Produit produit) {
		pr.updateProduit(produit);
	}

	@Override
	public void supprimerUnProduitParID(long id) {
		pr.removeProduitByID(id);
	}

}
