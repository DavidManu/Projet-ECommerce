package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;

public interface ICategorieDao {
	
	public List<Categorie> getAllCategorie();
	
	public Categorie getOneCategorie(Categorie c);
	
	public Categorie createCategorie(Categorie c);
	
	public String deleteCategorie(long id);
	
	public Categorie updateCategorie(long id);

}
