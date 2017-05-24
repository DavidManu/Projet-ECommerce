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
	public Categorie getOneCategorie(Categorie c) {
		return categorieDao.getOneCategorie(c);
	}

	@Override
	public Categorie createCategorie(Categorie c) {
		return categorieDao.createCategorie(c);
	}

	@Override
	public void deleteCategorie(Categorie c) {
		categorieDao.deleteCategorie(c);
	}

	@Override
	public void updateCategorie(Categorie c) {
		categorieDao.updateCategorie(c);
	}

}
