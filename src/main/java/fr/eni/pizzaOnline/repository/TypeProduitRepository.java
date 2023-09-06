package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnline.bo.TypeProduit;

public interface TypeProduitRepository extends JpaRepository<TypeProduit, Integer> {

}
