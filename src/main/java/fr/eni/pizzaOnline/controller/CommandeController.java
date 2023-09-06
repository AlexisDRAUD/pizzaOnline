package fr.eni.pizzaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.pizzaOnline.bo.Commande;
import fr.eni.pizzaOnline.service.CommandeService;
import fr.eni.pizzaOnline.service.ProduitService;

@Controller
@SessionAttributes({"commande"})
public class CommandeController {
	
	@ModelAttribute("commande")
	Commande setCommande() {
		return new Commande();
	}
	
	@Autowired
	ProduitService ps;
	@Autowired
	CommandeService cs;
	
	@GetMapping("/commande")
	public String afficherCarte(Model model) {
		model.addAttribute("produits", ps.tousLesProduits());		
		return "commande/liste";
	}
	
	@PostMapping("/commande/ajouter/{id:[0-9]+}")
	public String ajouterAuPanier(@PathVariable long id, @ModelAttribute("commande") Commande commande,
									@RequestParam int quantite) {
		commande = cs.ajouterProduitAuPanier(commande, quantite, ps.ProduitParID(id));
		return "redirect:/commande";
	}
	
}
