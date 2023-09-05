package fr.eni.pizzaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.eni.pizzaOnline.bo.Commande;
import fr.eni.pizzaOnline.service.ProduitService;

@Controller
public class CommandeController {

	public Commande commande = new Commande();
	
	@Autowired
	ProduitService ps;
	
	@GetMapping("/commande/ajouter/{id:[0-9]+}")
	public String ajouterAuPanier(@PathVariable long id) {
		commande.getListProd().add(ps.ProduitParID(id));
		System.out.println(commande.getListProd());
		return "redirect:/carte";
	}
	
	@GetMapping("/panier")
	public String afficherPanier(Model model) {
		model.addAttribute("produitsPanier",commande.getListProd());
		return "commande/panier";
	}
	
}
