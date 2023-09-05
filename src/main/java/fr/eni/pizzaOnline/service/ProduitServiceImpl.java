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
		return pr.findAll();
	}

	@Override
	public Produit ProduitParID(long id) {
		return pr.findById(id).get();
	}

	@Override
	public void ajouterUnProduit(Produit produit) {
		pr.save(produit);
	}

	@Override
	public void modifierUnProduit(Produit produit) {
		pr.save(produit);
	}

	@Override
	public void supprimerUnProduitParID(long id) {
		pr.deleteById(id);
	}

}
