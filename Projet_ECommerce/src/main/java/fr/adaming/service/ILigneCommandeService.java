package fr.adaming.service;

import fr.adaming.model.LigneCommande;

public interface ILigneCommandeService {

	/**
	 * rend une ligne de commande
	 */
	public LigneCommande getOneLigneCommande(Long id);

	/**
	 * cr�� une ligne de commande
	 */
	public LigneCommande createLigneCommande(LigneCommande lc);

	/**
	 * supprime une ligne de commande
	 */
	public String deleteLigneCommande(long id);

}
