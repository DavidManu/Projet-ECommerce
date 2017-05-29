package fr.adaming.service;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;

public class AdminServiceImpl implements IAdminService {

	private IAdminDao admindao;
	
	

	/**
	 * @return the admindao
	 */
	public IAdminDao getAdmindao() {
		return admindao;
	}



	/**
	 * @param admindao the admindao to set
	 */
	public void setAdmindao(IAdminDao admindao) {
		this.admindao = admindao;
	}



	@Override
	public Admin createAdmin(Admin a) {

		return admindao.createAdmin(a);
	}

}
