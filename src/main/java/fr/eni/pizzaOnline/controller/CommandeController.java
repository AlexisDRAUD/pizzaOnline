package fr.eni.pizzaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/commande/ajouter/{id:[0-9]+}")
	public String ajouterAuPanier(@PathVariable long id, @ModelAttribute("commande") Commande commande) {
		commande = cs.ajouterProduitAuPanier(commande, 1, ps.ProduitParID(id));
		return "redirect:/carte";
	}
	
	@GetMapping("/panier")
	public String afficherPanier(Model model, @ModelAttribute("commande") Commande commande) {
		model.addAttribute("detailsCommande",commande.getDetailsCommande());
		return "commande/panier";
	}
	
}
