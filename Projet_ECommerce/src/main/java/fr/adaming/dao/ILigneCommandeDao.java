package fr.adaming.dao;

import fr.adaming.model.LigneCommande;

public interface ILigneCommandeDao {

	/**
	 * rend une ligne de commande
	 */
	public LigneCommande getOneLigneCommande(LigneCommande lc);

	/**
	 * créé une ligne de commande
	 */
	public LigneCommande createLigneCommande(LigneCommande lc);

	/**
	 * supprime une ligne de commande
	 */
	public String deleteLigneCommande(long id);
}
