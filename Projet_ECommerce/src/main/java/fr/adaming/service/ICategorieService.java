package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {
	// Commit
	public List<Categorie> getAllCategorie();

	public Categorie getOneCategorie(long id);

	public Categorie createCategorie(Categorie c);

	public String deleteCategorie(long id);

	public Categorie updateCategorie(Categorie c);

}
