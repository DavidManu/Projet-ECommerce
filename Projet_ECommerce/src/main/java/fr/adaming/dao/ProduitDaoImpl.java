package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;

/**
 * 
 * @author David Mavaut, Emmanuel Lilette
 *
 */
@Repository
public class ProduitDaoImpl implements IProduitDao {

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
	 * Recuperation de la liste des produits existants
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduit() {
		Session s = sf.getCurrentSession();

		String reqGetAll = "FROM Produit";

		Query query = s.createQuery(reqGetAll);

		return query.list();
	}

	/**
	 * Recuperation d'un produit
	 */
	@Override
	public Produit getOneProduit(Produit p) {
		Session s = sf.getCurrentSession();

		Produit produit_rec = (Produit) s.get(Produit.class, p.getIdProduit());
		return null;
	}

	/**
	 * Creer un produit
	 */
	@Override
	public Produit createProduit(Produit p) {
		Session s = sf.getCurrentSession();
		s.save(p);
		return p;
	}

	/**
	 * Supprimer un produit
	 */
	@Override
	public void deleteProduit(Produit p) {
		Session s = sf.getCurrentSession();
		s.delete(p);

	}

	/**
	 * Modifier un produit
	 */
	@Override
	public void updateProduit(Produit p) {
		Session s = sf.getCurrentSession();
		Produit produit_rec = (Produit) s.get(Produit.class, p.getIdProduit());
		p = produit_rec;
		s.merge(p);
	}

}
