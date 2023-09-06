package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnline.bo.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
