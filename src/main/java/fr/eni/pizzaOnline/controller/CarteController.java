package fr.eni.pizzaOnline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnline.bo.Produit;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/carte")
public class CarteController {
	
	public List<Produit> pizzas = new ArrayList<>();
	public int cptID = 4; 
	
	public CarteController() {
		pizzas.add(new Produit(1l, "Reine","Sauce tomate, mozzarella, jambon, champignons de Paris.",14.49f,"https://commande.dominos.fr/ManagedAssets/FR/product/PREI/FR_PREI_fr_hero_12192.png?v-1832445367"));
		pizzas.add(new Produit(2l, "Indienne","Crème fraîche légère française, mozzarella, oignons, poulet rôti, champignons de Paris, emmental.",15.49f,"https://commande.dominos.fr/ManagedAssets/FR/product/PIND/FR_PIND_fr_hero_12192.png?v451031"));
		pizzas.add(new Produit(3l, "Margherita","Sauce tomate, mozzarella.",12f,"https://commande.dominos.fr/ManagedAssets/FR/product/PMAR/FR_PMAR_fr_hero_12192.png?v952395148"));
	}
	
	@GetMapping
	public String afficherCarte(Model model) {
		model.addAttribute("pizzas", pizzas);
		return "carte/liste";
		
	}
	
	@GetMapping("/ajout")
	public String ajouterUnProduitView(Model model) {
		model.addAttribute("produit", new Produit());
		return "carte/ajout";
	}	
	
	@PostMapping("/ajout")
	public String ajouterUnProduitLogic(@Valid @ModelAttribute Produit produit, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "carte/ajout";
		}
		//
			produit.setId(Long.valueOf(cptID));
		//
		pizzas.add(produit);
		//
			cptID++;
		//
		return "redirect:/carte";
	}
	
	@GetMapping("/modifier/{id:[0-9]+}")
	public String modifierUnProduitView(@PathVariable long id, Model model) {
		for (Produit produit : pizzas) {
			if(produit.getId()==id) {
				model.addAttribute("produit", produit);
			}
		}
		return "carte/modifier";
	}	
	
	@PostMapping("/modifier/{id:[0-9]+}")
	public String modifierUnProduitLogic(@Valid @ModelAttribute Produit produit, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "carte/ajout";
		}
		for (Produit produitDeList : pizzas) {
			if(produitDeList.getId()==produit.getId()) {
				pizzas.set(pizzas.indexOf(produitDeList), produit);
				return "redirect:/carte";
			}
		}
		return "redirect:/carte";
	}
	
	@GetMapping("supprimer/{id:[0-9]+}")
	public String details(@PathVariable long id) {
		for (Produit produit : pizzas) {
			if(produit.getId()==id) {
				pizzas.remove(pizzas.indexOf(produit));
				return "redirect:/carte";
			}
		}
		return "redirect:/carte";
	}
	

}
