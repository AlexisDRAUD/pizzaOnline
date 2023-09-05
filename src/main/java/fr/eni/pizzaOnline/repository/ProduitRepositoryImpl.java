package fr.eni.pizzaOnline.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.eni.pizzaOnline.bo.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

public class ProduitRepositoryImpl {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Produit> findAllProduits() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
		
		Root<Produit> root = cq.from(Produit.class);
		cq.select(root);
		
		TypedQuery<Produit> tq = em.createQuery(cq);
		System.out.println(tq.getResultList());
		return tq.getResultList();	
	}

	@Override
	@Transactional
	public Produit findProduitByID(long id) {
		Produit produit = em.find(Produit.class, id);
		return produit;
	}

	@Override
	@Transactional
	public void addProduit(Produit produit) {
		em.persist(produit);
	}

	@Override
	@Transactional
	public void updateProduit(Produit produit) {
		em.merge(produit);
	}

	@Override
	@Transactional
	public void removeProduitByID(long id) {
		Produit produit = findProduitByID(id);
		em.remove(produit);
	}

	
	
}
