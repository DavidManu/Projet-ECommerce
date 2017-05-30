package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieDao {

	public List<Categorie> getAllCategorie();

	public Categorie getOneCategorie(int id);

	public Categorie createCategorie(Categorie c);

	public String deleteCategorie(int id);

	public Categorie updateCategorie(Categorie c);

}
