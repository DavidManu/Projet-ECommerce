package fr.adaming.model;

import java.util.Arrays;
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
@Table(name = "categories")
public class Categorie {

	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ca")
	private Long idCategorie;
	private String nomCategorie;
	private byte[] photo;
	private String description;

	// association
	@OneToMany(mappedBy = "categorie", cascade = CascadeType.REMOVE)
	private List<Produit> listProduits;

	// contructeur
	/**
	 * 
	 */
	public Categorie() {
		super();
	}

	/**
	 * @param nomCategorie
	 * @param photo
	 * @param description
	 */
	public Categorie(String nomCategorie, byte[] photo, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
	}

	/**
	 * @param idCategorie
	 * @param nomCategorie
	 * @param photo
	 * @param description
	 * @param listProduits
	 */
	public Categorie(Long idCategorie, String nomCategorie, byte[] photo, String description,
			List<Produit> listProduits) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
		this.description = description;
		this.listProduits = listProduits;
	}

	// getters setters
	/**
	 * @return the idCategorie
	 */
	public Long getIdCategorie() {
		return idCategorie;
	}

	/**
	 * @param idCategorie
	 *            the idCategorie to set
	 */
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	/**
	 * @return the nomCategorie
	 */
	public String getNomCategorie() {
		return nomCategorie;
	}

	/**
	 * @param nomCategorie
	 *            the nomCategorie to set
	 */
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the listProduits
	 */
	public List<Produit> getListProduits() {
		return listProduits;
	}

	/**
	 * @param listProduits
	 *            the listProduits to set
	 */
	public void setListProduits(List<Produit> listProduits) {
		this.listProduits = listProduits;
	}

	// toString
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", photo="
				+ Arrays.toString(photo) + ", description=" + description + "]";
	}


}
