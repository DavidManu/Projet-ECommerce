package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieService {
	// Commit
	public List<Categorie> getAllCategorie();

	public Categorie getOneCategorie(int id);

	public Categorie createCategorie(Categorie c);

	public String deleteCategorie(int id);

	public Categorie updateCategorie(Categorie c);

}
