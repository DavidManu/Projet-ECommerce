package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.model.LigneCommande;

/**
 * Definition de la classe Service de LigneCommande
 *
 */
@Service
@Transactional
public class LigneCommandeServiceImpl implements ILigneCommandeService {
	

	/**
	 * Injection de Dao
	 *
	 */
	@Autowired
	private ILigneCommandeDao ligneCommandeDao;

	/**
	 * @return the ligneCommandeDao
	 */
	public ILigneCommandeDao getLigneCommandeDao() {
		return ligneCommandeDao;
	}

	/**
	 * @param ligneCommandeDao the ligneCommandeDao to set
	 */
	public void setLigneCommandeDao(ILigneCommandeDao ligneCommandeDao) {
		this.ligneCommandeDao = ligneCommandeDao;
	}

	/**
	 * rend une ligne de commande
	 */
	@Override
	public LigneCommande getOneLigneCommande(Long id) {
		return ligneCommandeDao.getOneLigneCommande(id);
	}

	/**
	 * créé une ligne de commande
	 */
	@Override
	public LigneCommande createLigneCommande(LigneCommande lc) {
		return ligneCommandeDao.createLigneCommande(lc);
	}

	/**
	 * supprime une ligne de commande
	 */
	@Override
	public String deleteLigneCommande(long id) {
		return ligneCommandeDao.deleteLigneCommande(id);
	}

}
