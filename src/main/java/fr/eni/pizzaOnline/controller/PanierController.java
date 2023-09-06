package fr.eni.pizzaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.pizzaOnline.bo.Commande;
import fr.eni.pizzaOnline.service.CommandeService;
import fr.eni.pizzaOnline.service.ProduitService;

@Controller
@RequestMapping("/panier")
@SessionAttributes({"commande"})
public class PanierController {

	@Autowired
	ProduitService ps;
	@Autowired
	CommandeService cs;
	
	@GetMapping
	public String afficherPanier(Model model, @ModelAttribute("commande") Commande commande) {
		model.addAttribute("detailsCommande",commande.getDetailsCommande());
		return "commande/panier";
	}
	
	@GetMapping("/ajouterQuantite/{id:[0-9]+}")
	public String ajouterQuantite(@PathVariable long id, @ModelAttribute("commande") Commande commande) {
		commande = cs.ajouterQuantiteProduitParID(commande, ps.ProduitParID(id));
		return "redirect:/panier";
	}
	
	@GetMapping("/soustraireQuantite/{id:[0-9]+}")
	public String soustraireQuantite(@PathVariable long id, @ModelAttribute("commande") Commande commande) {
		commande = cs.soustraireQuantiteProduitParID(commande, ps.ProduitParID(id));
		return "redirect:/panier";
	}
	
}
