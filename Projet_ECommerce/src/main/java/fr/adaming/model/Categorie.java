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
@Table(name="categories")
public class Categorie {

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ca")
	private Long idCategorie;
	private String nomCategorie;
	private byte[] photo;
	private String description;
	
	//association
	@OneToMany(mappedBy="categorie",cascade=CascadeType.REMOVE)
	private List<Produit> listProduits;
}
