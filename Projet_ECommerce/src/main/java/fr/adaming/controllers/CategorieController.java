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
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@Controller
@RequestMapping("/categorie")
public class CategorieController {

	/**
	 * Injection de la classeService dans le controller
	 */

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
	 * Definition des methodes
	 */

	/**
	 * Redirection sur la page de gestion des categories
	 */
	@RequestMapping(value = "/categorieAdmin", method = RequestMethod.GET)
	public String gestionProduits(ModelMap model) {

		model.addAttribute("msg2", "Gestionnaire des categories");

		return "categorieAdmin";
	}

	/**
	 * Generation de la liste des categories
	 */
	@RequestMapping(value = "/listeCategorie", method = RequestMethod.GET)
	public String afficherListeCategories(ModelMap model) {

		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		return "categories";
	}

	/**
	 * Ajout d'un produit à liste de categories
	 */

	@RequestMapping(value = "/afficheCreateCategorieForm", method = RequestMethod.GET)
	public ModelAndView afficheCreateProduitForm() {
		String viewName = "afficheCreateCategorieForm";

		return new ModelAndView(viewName, "mCategorie", new Categorie());
	}

	@RequestMapping(value = "/insererCategorie", method = RequestMethod.POST)
	public String ajouterCategorie(@ModelAttribute("mCategorie") Categorie pCategorie, ModelMap model,
			BindingResult result) throws Exception {

		if (result.hasErrors()) {
			return "afficheCreateCategorieForm";
		} else {
			categorieService.createCategorie(pCategorie);
			List<Categorie> listeCategories = categorieService.getAllCategorie();
			model.addAttribute("cListe", listeCategories);
			return "categories";
		}
	}

	/**
	 * modifier une categorie à liste de categories
	 */

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView affichFormEdit(@RequestParam("idCategorie") long id) {

		String viewName = "afficheCreateCategorieForm";
		return new ModelAndView(viewName, "mCategorie", categorieService.getOneCategorie(id));
	}

	@RequestMapping(value = "/delete/{idCategorie}", method = RequestMethod.GET)
	public String supprimerCategorie(ModelMap model, @PathVariable("idCategorie") long id) {

		Categorie c_rec = categorieService.getOneCategorie(id);
		categorieService.deleteCategorie(c_rec.getIdCategorie());
		model.addAttribute("cListe", categorieService.getAllCategorie());

		return "categories";
	}

}
