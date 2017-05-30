package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

/**
 * 
 * @author David Mavaut, Emmanuel Lilette
 *
 */
@Repository
public class LigneCommandeDaoImpl implements ILigneCommandeDao {

	/**
	 * Definition d'une session
	 */
	@Autowired
	private SessionFactory sf;

	/**
	 * Definition des getters et setters de la sessions
	 */

	/**
	 * @return the sf
	 */
	public SessionFactory getSf() {
		return sf;
	}

	/**
	 * @param sf
	 *            the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * Definition des méthodes
	 */

	/**
	 * rend une ligne de commande
	 */
	@Override
	public LigneCommande getOneLigneCommande(LigneCommande lc) {
		Session s = sf.getCurrentSession();
		return (LigneCommande) s.get(LigneCommande.class, lc.getIdCommande());
	}

	/**
	 * créé une ligne de commande
	 */
	@Override
	public LigneCommande createLigneCommande(LigneCommande lc) {
		Session s = sf.getCurrentSession();
		s.save(lc);
		return lc;
	}

	/**
	 * supprime une ligne de commande
	 */
	@Override
	public String deleteLigneCommande(long id) {
		Session s = sf.getCurrentSession();
		LigneCommande ligneCommande_rec = (LigneCommande) s.get(LigneCommande.class, id);
		s.delete(ligneCommande_rec);
		return null;
	}

}// Commit
