package fr.adaming.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

	@RequestMapping(method = RequestMethod.GET)
	public String goToWelcomePage() {
		return "welcome";
	}

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
