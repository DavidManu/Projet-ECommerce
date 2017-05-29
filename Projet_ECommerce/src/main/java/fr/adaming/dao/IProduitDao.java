package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitDao {

	public List<Produit> getAllProduit();

	public Produit getOneProduit(int id);

	public Produit createProduit(Produit p);

	public String deleteProduit(long id);

	public Produit updateProduit(Produit p);

	public List<Produit> getProduitsParCategorie(int id);

	public List<Produit> getProduitsParMotCle(String motcle);

	public List<Produit> getAllProduitsSelectionnes();

}
