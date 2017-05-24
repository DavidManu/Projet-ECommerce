package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProduitDao;
import fr.adaming.model.Produit;

/**
 * Definition de la classe Service de Produit
 *
 */
@Service
@Transactional
public class ProduitServiceImpl implements IProduitService {

	/**
	 * Injection de Dao
	 *
	 */
	@Autowired
	private IProduitDao produitDao;

	/**
	 * Definition des Getters Setters
	 */

	/**
	 * @return the produitDao
	 */
	public IProduitDao getProduitDao() {
		return produitDao;
	}

	/**
	 * @param produitDao
	 *            the produitDao to set
	 */
	public void setProduitDao(IProduitDao produitDao) {
		this.produitDao = produitDao;
	}

	/**
	 * Definition des methodes
	 * 
	 */
	@Override
	public List<Produit> getAllProduit() {
		List<Produit> listeProduit = produitDao.getAllProduit();
		return listeProduit;
	}

	@Override
	public Produit getOneProduit(Produit p) {
		return produitDao.getOneProduit(p);
	}

	@Override
	public Produit createProduit(Produit p) {
		return produitDao.createProduit(p);
	}

	@Override
	public void deleteProduit(Produit p) {
		produitDao.deleteProduit(p);

	}

	@Override
	public void updateProduit(Produit p) {
		produitDao.updateProduit(p);

	}

}