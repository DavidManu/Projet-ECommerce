package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;

public class AdminServiceImpl implements IAdminService {
	// Commit
	private IAdminDao admindao;

	/**
	 * @return the admindao
	 */
	public IAdminDao getAdmindao() {
		return admindao;
	}

	/**
	 * @param admindao
	 *            the admindao to set
	 */
	public void setAdmindao(IAdminDao admindao) {
		this.admindao = admindao;
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> listeAdmins = admindao.getAllAdmin();
		return listeAdmins;
	}

	@Override
	public Admin createAdmin(Admin a) {

		return admindao.createAdmin(a);
	}

}
