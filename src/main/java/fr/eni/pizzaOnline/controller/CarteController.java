package fr.eni.pizzaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnline.bo.Produit;
import fr.eni.pizzaOnline.repository.TypeProduitRepository;
import fr.eni.pizzaOnline.service.ProduitService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/carte")
public class CarteController {
	
	@Autowired
	ProduitService ps;
	
	@Autowired
	TypeProduitRepository tpr;
	
	@GetMapping
	public String afficherCarte(Model model) {
		model.addAttribute("produits", ps.tousLesProduits());		
		return "carte/liste";
	}
	
	@GetMapping("/ajouter")
	public String ajouterUnProduitView(Model model) {
		model.addAttribute("typesProduit", tpr.findAll());
		model.addAttribute("produit", new Produit());
		return "carte/ajouter";
	}	
	
	@PostMapping("/ajouter")
	public String ajouterUnProduitLogic(@Valid @ModelAttribute Produit produit, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "carte/ajouter";
		}
		ps.ajouterUnProduit(produit);
		return "redirect:/carte";
	}
	
	@GetMapping("/modifier/{id:[0-9]+}")
	public String modifierUnProduitView(@PathVariable long id, Model model) {
		model.addAttribute("produit", ps.ProduitParID(id));
		return "carte/modifier";
	}	
	
	@PostMapping("/modifier/{id:[0-9]+}")
	public String modifierUnProduitLogic(@Valid @ModelAttribute Produit produit, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "carte/ajout";
		}
		ps.modifierUnProduit(produit);
		return "redirect:/carte";
	}
	
	@GetMapping("supprimer/{id:[0-9]+}")
	public String details(@PathVariable long id) {
		ps.supprimerUnProduitParID(id);
		return "redirect:/carte";
	}
	

}
