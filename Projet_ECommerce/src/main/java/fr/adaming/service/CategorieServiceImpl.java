package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Categorie;

/**
 * Definition de la classe Service de Categorie
 *
 */
@Service
@Transactional
public class CategorieServiceImpl implements ICategorieService {

	/**
	 * Injection de Dao
	 *
	 */
	@Autowired
	private ICategorieDao categorieDao;

	/**
	 * Definition des Getters Setters
	 */

	/**
	 * @return the categorieDao
	 */
	public ICategorieDao getCategorieDao() {
		return categorieDao;
	}

	/**
	 * @param categorieDao
	 *            the categorieDao to set
	 */
	public void setCategorieDao(ICategorieDao categorieDao) {
		this.categorieDao = categorieDao;
	}

	/**
	 * Definition des methodes
	 * 
	 */

	@Override
	public List<Categorie> getAllCategorie() {
		List<Categorie> listeCategorie = categorieDao.getAllCategorie();
		return listeCategorie;
	}

	@Override
	public Categorie getOneCategorie(int id) {
		return categorieDao.getOneCategorie(id);
	}

	@Override
	public Categorie createCategorie(Categorie c) {
		return categorieDao.createCategorie(c);
	}

	@Override
	public String deleteCategorie(long id) {
		return categorieDao.deleteCategorie(id);
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		return categorieDao.updateCategorie(c);
	}


}
