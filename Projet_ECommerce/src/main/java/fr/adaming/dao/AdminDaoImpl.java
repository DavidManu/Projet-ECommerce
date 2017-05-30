package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;

public class AdminDaoImpl implements IAdminDao {
	// Commit
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

	@Override
	public List<Admin> getAllAdmin() {
		Session s = sf.getCurrentSession();
		String reqGetAll = "FROM Admin";
		Query query = s.createQuery(reqGetAll);
		return query.list();
	}

	/**
	 * Definition des méthodes
	 */

	@Override
	public Admin createAdmin(Admin a) {
		Session s = sf.getCurrentSession();
		s.save(a);
		return a;

	}
}
