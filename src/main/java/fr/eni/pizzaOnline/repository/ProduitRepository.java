package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnline.bo.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
