package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnline.bo.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

//	List<Produit> findAllProduits();
//	Produit findProduitByID(long id);
//	void addProduit(Produit produit);
//	void updateProduit(Produit produit);
//	void removeProduitByID(long id);

}
