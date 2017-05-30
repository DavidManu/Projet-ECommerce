package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService {

	public List<Produit> getAllProduit();

	public Produit getOneProduit(int id);

	public Produit createProduit(Produit p);

	public String deleteProduit(int id);

	public Produit updateProduit(Produit p);

	public List<Produit> getProduitsParCategorie(int id);

	public List<Produit> getProduitsParMotCle(String motcle);

	public List<Produit> getAllProduitsSelectionnes();

}// Commit
