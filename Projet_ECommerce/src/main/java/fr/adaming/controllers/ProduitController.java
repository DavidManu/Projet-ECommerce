package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

/**
 * 
 * Definition de la classe Produit Controller
 *
 */
@Controller
@RequestMapping("/produit")
public class ProduitController {
	/**
	 * Injection de la classeService dans le controller
	 */
	// Commit
	@Autowired
	private ICategorieService categorieService;

	/**
	 * Definition des getters et setters
	 */

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
	 * Injection de la classeService dans le controller
	 */

	@Autowired
	private IProduitService produitService;

	/**
	 * Definition des getters et setters
	 */

	/**
	 * @param produitService
	 *            the produitService to set
	 */
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	/**
	 * Definition des methodes
	 */

	/**
	 * Redirection sur la page de gestion des produits
	 */
	@RequestMapping(value = "/produitAdmin", method = RequestMethod.GET)
	public String gestionProduits(ModelMap model) {

		model.addAttribute("msg1", "Gestionnaire des produits");

		return "produitAdmin";
	}

	/**
	 * Generation de la liste de produits
	 */
	@RequestMapping(value = "/listeproduits", method = RequestMethod.GET)
	public String afficherListeProduits(ModelMap model) {
		List<Produit> listeProduits = produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		return "produits";
	}

	/**
	 * Ajout d'un produit à liste de produits
	 */

	@RequestMapping(value = "/afficheCreateProduitForm", method = RequestMethod.GET)
	public ModelAndView afficheCreateProduitForm() {
		String viewName = "afficheCreateProduitForm";

		return new ModelAndView(viewName, "mProduit", new Produit());
	}

	@RequestMapping(value = "/insererProduit", method = RequestMethod.POST)
	public String ajouterProduit(@ModelAttribute("mProduit") Produit pProduit, ModelMap model, BindingResult result,
			MultipartFile file) throws Exception {

		if (result.hasErrors()) {
			return "afficheCreateProduitForm";
		} else {
			if (!file.isEmpty()) {
				pProduit.setPhoto(file.getBytes());
			}

			if (pProduit.getIdProduit() == 0) {

				produitService.createProduit(pProduit);
			}else{
				
				produitService.updateProduit(pProduit);
			}
			List<Produit> listeProduits = produitService.getAllProduit();
			model.addAttribute("pListe", listeProduits);
			return "produits";
		}
	}

	/**
	 * modifier un produit à liste de produits
	 */

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String affichFormEdit(ModelMap model, @RequestParam("idProduit") int id) {

		model.addAttribute("mProduit", produitService.getOneProduit(id));
		model.addAttribute("pListe", categorieService.getAllCategorie());

		return "afficheCreateProduitForm";
	}

	@RequestMapping(value = "/delete/{idProduit}", method = RequestMethod.GET)
	public String supprimerProduit(ModelMap model, @PathVariable("idProduit") int id) {

		produitService.deleteProduit(id);
		model.addAttribute("pListe", produitService.getAllProduit());

		return "produits";
	}

	@RequestMapping(value = "/produit/submit", method = RequestMethod.POST)
	public ModelAndView doSubmit(@ModelAttribute Produit mProduit, MultipartFile file) throws Exception {
		if (!file.isEmpty()) {
			mProduit.setPhoto(file.getBytes());
		}
		if (mProduit.getIdProduit() == 0) {
			produitService.createProduit(mProduit);
		} else {
			produitService.updateProduit(mProduit);
		}
		return new ModelAndView("produits", "pListe", produitService.getAllProduit());
	}

}
