package fr.eni.pizzaOnline.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnline.bo.Produit;

@Controller
@RequestMapping("/carte")
public class CarteController {
	
	public List<Produit> pizzas = new ArrayList<>();
	
	@GetMapping
	public String afficherCarte(Model model) {
		
		pizzas.clear();
		pizzas.add(new Produit("Original","descrption de test",10f,""));
		pizzas.add(new Produit("Original","descrption de test",10f,""));
		pizzas.add(new Produit("Original","descrption de test",10f,""));
		model.addAttribute("pizzas", pizzas);
		return "carte/liste";
		
	}
	
	@GetMapping("/ajout")
	public String ajouterUnFilmView(Model model) {
		model.addAttribute("pizza", new Produit());
		return "carte/ajout";
	}	
	
	@PostMapping("/ajout")
	public String ajouterUnFilmLogic(@ModelAttribute Produit pizza, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "carte/ajout";
		}
		pizzas.add(pizza);
		return "redirect:/carte";
	}
	
}
