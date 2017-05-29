package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
	public Produit getOneProduit(Long id) {
		Session s = sf.getCurrentSession();

		Produit produit_rec = (Produit) s.get(Produit.class, id);
		return produit_rec;
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
	public String deleteProduit(long id) {
		Session s = sf.getCurrentSession();
		Produit produit_rec = (Produit) s.get(Produit.class, id);
		s.delete(produit_rec);
		return null;

	}

	/**
	 * Modifier un produit
	 */
	@Override
	public Produit updateProduit(long id) {
		Session s = sf.getCurrentSession();
		Produit produit_rec = (Produit) s.get(Produit.class, id);
		s.merge(produit_rec);
		return produit_rec;
	}

}
