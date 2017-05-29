package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Produit;

public interface IProduitDao {

	public List<Produit> getAllProduit();

	public Produit getOneProduit(Long id);

	public Produit createProduit(Produit p);

	public String deleteProduit(long id);

	public Produit updateProduit(long id);
	
	
}
