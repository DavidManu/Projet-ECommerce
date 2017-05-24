package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitDao {

	public List<Produit> getAllProduit();

	public Produit getOneProduit(Produit p);

	public Produit createProduit(Produit p);

	public void deleteProduit(Produit p);

	public void updateProduit(Produit p);
}
