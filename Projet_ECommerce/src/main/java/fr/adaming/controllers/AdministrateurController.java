package fr.adaming.controllers;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.service.IAdminService;

public class AdministrateurController {

	private IAdminService adminService;

	/**
	 * @return the adminService
	 */
	public IAdminService getAdminService() {
		return adminService;
	}

	/**
	 * @param adminService
	 *            the adminService to set
	 */
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(value = "/afficheCreateAdminForm", method = RequestMethod.GET)
	public ModelAndView afficheCreateAdminForm() {
		String viewName = "afficheCreateAdminForm";

		return new ModelAndView(viewName, "mAdmin", new Admin());
	}

	@RequestMapping(value = "/insererAdmin", method = RequestMethod.POST)
	public String ajouterCategorie(@ModelAttribute("mAdmin") Admin pAdmin, ModelMap model, BindingResult result)
			throws Exception {

		if (result.hasErrors()) {
			return "afficheCreateAdminForm";
		} else {
			adminService.createAdmin(pAdmin);
			return "welcome";
		}
	}
}
