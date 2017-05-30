package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Admin;

public interface IAdminService {
	
	public List<Admin> getAllAdmin();
	
	public Admin createAdmin(Admin a);
	// Commit
}
