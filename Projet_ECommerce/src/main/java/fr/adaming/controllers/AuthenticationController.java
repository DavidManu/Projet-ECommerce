package fr.adaming.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@Controller
@Scope("session")
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	private IProduitService produitService;
	
	
	/**
	 * @return the produitService
	 */
	public IProduitService getProduitService() {
		return produitService;
	}

	/**
	 * @param produitService the produitService to set
	 */
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
		
	/**
	 * @return the pService
	 */
	@RequestMapping( method = RequestMethod.GET)//value="/welcome",
	public String goToWelcomePage(ModelMap model) {
		List<Produit> listeProduits=produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		return "welcome";
	}
	
//	/**
//	 * @return the pService
//	 */
//	@RequestMapping( method = RequestMethod.GET)
//	public String getBasket(ModelMap model) {
//		Map<Integer, Integer> mapPanier=new HashMap<Integer, Integer>();
//		model.addAttribute("panierMap", mapPanier);
//		return "welcome";
//	}
//	
//	@RequestMapping( method = RequestMethod.GET)
//	public String addToBasket(ModelMap model) {
//		Map<Integer, Integer> mapPanier=new HashMap<Integer, Integer>();
//		model.addAttribute("panierMap", mapPanier);
//		return "welcome";
//	}	

	@RequestMapping(value = "/adminCatProd/adminCatProdPage", method = RequestMethod.GET)
	public String goToAdminCatProdPage(ModelMap model) {
		// Récuperer l'admin cat qui vient de se connecter
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String nom = auth.getName();
		model.addAttribute("nomAdminCatProd", nom);
		model.addAttribute(
				"msg",
				"Bonjour Mr. l'administrateur vous avez les droits d'édition des catégories et des produit");
		return "adminCatProd";
	}

	@RequestMapping(value = "/adminProd/adminProdPage", method = RequestMethod.GET)
	public String affichePageUser(ModelMap model) {
		// Récuperer l'admin prod qui vient de se connecter
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String nom = auth.getName();
		model.addAttribute("nomAdminProd", nom);
		model.addAttribute("msg",
				"Bonjour Mr. l'administrateur vous avez le droit d'édition des produit");
		return "adminProd";
	}
}
