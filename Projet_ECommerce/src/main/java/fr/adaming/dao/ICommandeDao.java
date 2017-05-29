package fr.adaming.dao;

import fr.adaming.model.Commande;

public interface ICommandeDao {

	public Commande getOneCommande(Commande c);

	public Commande createLigneCommande(Commande c);

	public String deleteCommande(long id);
}
