package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Admin;

public interface IAdminDao {
	
	public List<Admin> getAllAdmin();

	public Admin createAdmin(Admin a);
}
//Commit