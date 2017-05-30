package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	private IProduitService produitService;

	@Autowired
	private ICategorieService categorieService;

	@Autowired
	private ILigneCommandeService ligneCommandeService;

	Panier monPanier = new Panier();

	/**
	 * @return the monPanier
	 */
	public Panier getMonPanier() {
		return monPanier;
	}

	/**
	 * @param monPanier
	 *            the monPanier to set
	 */
	public void setMonPanier(Panier monPanier) {
		this.monPanier = monPanier;
	}

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

	/**
	 * @return the categorieService
	 */
	public ICategorieService getCategorieService() {
		return categorieService;
	}

	/**
	 * @param categorieService
	 *            the categorieService to set
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
	 * @param ligneCommandeService
	 *            the ligneCommandeService to set
	 */
	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	/**
	 * @return the pService
	 */
	@RequestMapping(method = RequestMethod.GET) // value="/welcome",
	public String goToWelcomePage(ModelMap model, SessionStatus sessionStatus) {
		List<Produit> listeProduits = produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		// List<LigneCommande> listeLigneCommandes =
		// monPanier.getListLigneCommandes();
		model.addAttribute("lcListe", monPanier.getListLigneCommandes());
		model.addAttribute("panierTot", monPanier.getTotal());
		// model.addAttribute("mIdProduit", new Integer(int));
		// new ModelAndView("welcome", "mLigneCommande", new LigneCommande());
		return "welcome";
	}

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

	@RequestMapping(value = "/ajouterLigneCommande/{idP}") // , method =
															// RequestMethod.POST
	public String addLigneCommande(ModelMap model, @PathVariable("idP") Long pId) {// ,@ModelAttribute("mIdProduit")
																					// int
																					// pIdProduit,
																					// @ModelAttribute("mLigneCommande")
																					// LigneCommande
		Produit p_rec = produitService.getOneProduit(pId);
		LigneCommande lc_rec = new LigneCommande();
		lc_rec.setProduit(p_rec);
		lc_rec.setPrix((int) p_rec.getPrix());
		lc_rec.setQuantite(1);
		boolean rep = false;
		for (LigneCommande lc : monPanier.getListLigneCommandes()) {
			if (lc.getProduit().getIdProduit().equals(pId)) {
				rep = true;
				lc.setQuantite(lc.getQuantite() + 1);
			}
		}
		if (rep == false) {
			monPanier.getListLigneCommandes().add(lc_rec);
		}
		// ligneCommandeService.createLigneCommande(lc_rec);
		monPanier.setTotal(monPanier.getTotal() + p_rec.getPrix());

		// reload infos
		List<Produit> listeProduits = produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		// List<LigneCommande> listeLigneCommandes =
		// monPanier.getListLigneCommandes();
		model.addAttribute("lcListe", monPanier.getListLigneCommandes());
		model.addAttribute("panierTot", monPanier.getTotal());

		return "welcome";
	}

	@RequestMapping(value = "/supprimerLigneCommande/{idDes}") // , method =
																// RequestMethod.POST
	public String deleteLigneCommande(ModelMap model, @PathVariable("idDes") String lcDes) {// ,@ModelAttribute("mIdProduit")
		// int
		// pIdProduit,
		// @ModelAttribute("mLigneCommande")
		// LigneCommande lc_rec =
		// ligneCommandeService.getOneLigneCommande(lcId); // LigneCommande
		List<LigneCommande> lcremove = new ArrayList<>();
		for (LigneCommande lc : monPanier.getListLigneCommandes()) {
			if (lc.getProduit().getDesignation().equals(lcDes)) {
				int a = lc.getQuantite() - 1;
				lc.setQuantite(a);
				double d = monPanier.getTotal() - lc.getProduit().getPrix();
				monPanier.setTotal(d);
				if (lc.getQuantite() == 0) {
					lcremove.add(lc);
				}
			}
		}

		monPanier.getListLigneCommandes().removeAll(lcremove);

		System.out.println("je sors des if");

		// reload infos
		List<Produit> listeProduits = produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		// List<LigneCommande> listeLigneCommandes =
		// monPanier.getListLigneCommandes();
		model.addAttribute("lcListe", monPanier.getListLigneCommandes());
		model.addAttribute("panierTot", monPanier.getTotal());

		return "welcome";
	}

	// @RequestMapping(value = "/AaliderCommande/{idDes}")
	// public String validateCommande(ModelMap model) {
	// List<LigneCommande> lcremove = new ArrayList<>();
	//
	// monPanier.getListLigneCommandes().removeAll(lcremove);
	// System.out.println("je sors des if");
	// List<Produit> listeProduits = produitService.getAllProduit();
	// model.addAttribute("pListe", listeProduits);
	// List<Categorie> listeCategories = categorieService.getAllCategorie();
	// model.addAttribute("cListe", listeCategories);
	// model.addAttribute("lcListe", monPanier.getListLigneCommandes());
	// model.addAttribute("panierTot", monPanier.getTotal());
	///
	// return "welcome";
	// }
//blalbla
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
