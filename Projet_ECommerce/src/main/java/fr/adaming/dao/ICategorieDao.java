package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieDao {

	public List<Categorie> getAllCategorie();

	public Categorie getOneCategorie(long id);

	public Categorie createCategorie(Categorie c);

	public String deleteCategorie(long id);

	public Categorie updateCategorie(Categorie c);

}
//Commit