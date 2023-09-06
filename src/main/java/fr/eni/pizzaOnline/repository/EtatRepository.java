package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnline.bo.Etat;

public interface EtatRepository extends JpaRepository<Etat, Integer> {

}
