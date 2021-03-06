package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	// Commit
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String affichePageLogin() {
		return "adminCatProd";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutMethode() {
		return "adminCatProdPage";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String deniedMethode() {
		return "adminCatProdPage";
	}

	@RequestMapping(value = "/echec", method = RequestMethod.GET)
	public String echecLogin(ModelMap model) {
		model.addAttribute("erreur", "true");
		return "login";
	}

	public String get() {
		return null;

	}

	
}
