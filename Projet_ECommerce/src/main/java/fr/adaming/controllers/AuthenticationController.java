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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@SessionAttributes("monPannier")
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	private IProduitService produitService;
<<<<<<< HEAD

=======
	
	@Autowired
	private ICategorieService categorieService;
	
	@Autowired
	private ILigneCommandeService ligneCommandeService;
	
>>>>>>> branch 'master' of https://github.com/DavidManu/Projet-ECommerce.git
	/**
	 * @return the produitService
	 */
	public IProduitService getProduitService() {
		return produitService;
	}

	/**
	 * @param produitService
	 *            the produitService to set
	 */
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
<<<<<<< HEAD

=======
		
	
	/**
	 * @return the categorieService
	 */
	public ICategorieService getCategorieService() {
		return categorieService;
	}

	/**
	 * @param categorieService the categorieService to set
	 */
	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}
	

	/**
	 * @return the ligneCommandeService
	 */
	public ILigneCommandeService getLigneCommandeService() {
		return ligneCommandeService;
	}

	/**
	 * @param ligneCommandeService the ligneCommandeService to set
	 */
	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	@ModelAttribute("monPannier")
	public Panier getPanier(){
		return new Panier();
	}
	
>>>>>>> branch 'master' of https://github.com/DavidManu/Projet-ECommerce.git
	/**
	 * @return the pService
	 */
<<<<<<< HEAD
	@RequestMapping(method = RequestMethod.GET) // value="/welcome",
	public String goToWelcomePage(ModelMap model) {
		List<Produit> listeProduits = produitService.getAllProduit();
=======
	@RequestMapping(method = RequestMethod.GET)//value="/welcome",
	public String goToWelcomePage(ModelMap model, SessionStatus sessionStatus) {
		List<Produit> listeProduits=produitService.getAllProduit();
>>>>>>> branch 'master' of https://github.com/DavidManu/Projet-ECommerce.git
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		model.addAttribute("mLigneCommande", new LigneCommande());
//		new ModelAndView("welcome", "mLigneCommande", new LigneCommande());
		return "welcome";
	}
<<<<<<< HEAD

	// /**
	// * @return the pService
	// */
	// @RequestMapping( method = RequestMethod.GET)
	// public String getBasket(ModelMap model) {
	// Map<Integer, Integer> mapPanier=new HashMap<Integer, Integer>();
	// model.addAttribute("panierMap", mapPanier);
	// return "welcome";
	// }
	//
	// @RequestMapping( method = RequestMethod.GET)
	// public String addToBasket(ModelMap model) {
	// Map<Integer, Integer> mapPanier=new HashMap<Integer, Integer>();
	// model.addAttribute("panierMap", mapPanier);
	// return "welcome";
	// }
=======
	
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
>>>>>>> branch 'master' of https://github.com/DavidManu/Projet-ECommerce.git

	@RequestMapping(value = "/ajouterLigneCommande", method = RequestMethod.POST)
	public String addLigneCommande(@ModelAttribute("mLigneCommande") LigneCommande pLigneCommande, ModelMap model, BindingResult result, @ModelAttribute("monPannier") Panier monPannier)
			throws Exception {//
		System.out.println("je rentre dans addligne");

		if (result.hasErrors()) {
			return "welcome";
		} else {
			System.out.println("je suis dans le else");
			LigneCommande lc_rec=ligneCommandeService.createLigneCommande(pLigneCommande);
			System.out.println(lc_rec);
			monPannier.getListLigneCommandes().add(lc_rec);
			List<LigneCommande> listeLigneCommandes = monPannier.getListLigneCommandes();
			model.addAttribute("lcListe", listeLigneCommandes);
			return "welcome";
		}
	}
		

	
	@RequestMapping(value = "/adminCatProd/adminCatProdPage", method = RequestMethod.GET)
	public String goToAdminCatProdPage(ModelMap model) {
		// Récuperer l'admin cat qui vient de se connecter
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nom = auth.getName();
		model.addAttribute("nomAdminCatProd", nom);
		model.addAttribute("msg",
				"Bonjour Mr. l'administrateur vous avez les droits d'édition des catégories et des produit");
		return "adminCatProd";
	}

	@RequestMapping(value = "/adminProd/adminProdPage", method = RequestMethod.GET)
	public String affichePageUser(ModelMap model) {
		// Récuperer l'admin prod qui vient de se connecter
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nom = auth.getName();
		model.addAttribute("nomAdminProd", nom);
		model.addAttribute("msg", "Bonjour Mr. l'administrateur vous avez le droit d'édition des produit");
		return "adminProd";
	}
}
