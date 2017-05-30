package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
public class ImageCOntroller {

	@Autowired
	private ICategorieService categorieService;
	@Autowired
	private IProduitService produitService;
	
	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}
	
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
	
	//blablab
	@RequestMapping(value = "/img/produit/{idP}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getImgProduit(@PathVariable("idP") int pId) throws IOException {
		Produit p = produitService.getOneProduit(pId);
		if (p.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
	}
	
	@RequestMapping(value = "/img/categorie/{idP}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getImgCategorie(@PathVariable("idP") int pId) throws IOException {
		Categorie c = categorieService.getOneCategorie(pId);
		if (c.getPhoto() == null)
			return new byte[0];
		else
			return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}
	
}
