package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

/**
 * 
 * @author David Mavaut, Emmanuel Lilette
 *
 */
@Repository
public class CategorieDaoImpl implements ICategorieDao {

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
	 * Recuperation de la liste des categories existantes
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getAllCategorie() {
		Session s = sf.getCurrentSession();
		String reqGetAll = "FROM Categorie";
		Query query = s.createQuery(reqGetAll);
		return query.list();
	}

	/**
	 * Recuperation d'une categorie
	 */
	@Override
	public Categorie getOneCategorie(long id) {
		Session s = sf.getCurrentSession();

		Categorie cat_rec = (Categorie) s.get(Categorie.class, id);
		return cat_rec;
	}

	/**
	 * Creer une categorie
	 */
	@Override
	public Categorie createCategorie(Categorie c) {
		Session s = sf.getCurrentSession();
		s.save(c);
		return c;
	}

	/**
	 * Supprimer une categorie
	 */
	@Override
	public String deleteCategorie(long id) {
		Session s = sf.getCurrentSession();
		Categorie c_rec = (Categorie) s.get(Categorie.class, id);
		s.delete(c_rec);
		return null;

	}

	/**
	 * Modifier une categorie
	 */
	@Override
	public Categorie updateCategorie(Categorie c) {
		Session s = sf.getCurrentSession();
		Categorie cat_rec = (Categorie) s.get(Categorie.class, c.getIdCategorie());
		cat_rec.setNomCategorie(c.getNomCategorie());
		cat_rec.setDescription(c.getDescription());
		cat_rec.setPhoto(c.getPhoto());
		s.merge(cat_rec);
		return cat_rec;
	}

}
