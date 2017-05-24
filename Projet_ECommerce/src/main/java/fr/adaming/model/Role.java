package fr.adaming.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_r")
	private Long id;
	private String roleName;
	
	//associations
	@OneToMany(mappedBy="role",cascade=CascadeType.REMOVE)
	private List<Admin> listUsers;

	/**
	 * constructeur vide
	 */
	public Role() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the listUsers
	 */
	public List<Admin> getListUsers() {
		return listUsers;
	}

	/**
	 * @param listUsers the listUsers to set
	 */
	public void setListUsers(List<Admin> listUsers) {
		this.listUsers = listUsers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

	
}
