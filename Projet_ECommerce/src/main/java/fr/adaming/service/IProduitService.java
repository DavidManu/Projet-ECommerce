package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Produit;

public interface IProduitService {

	public List<Produit> getAllProduit();

	public Produit getOneProduit(Produit p);

	public Produit createProduit(Produit p);

	public String deleteProduit(long id);

	public Produit updateProduit(long id);


}
