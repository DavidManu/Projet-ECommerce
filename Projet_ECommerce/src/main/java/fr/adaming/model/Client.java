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
@Table(name="clients")
public class Client {

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cl")
	private Long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;
	
	//associations
	@OneToMany(mappedBy="client",cascade=CascadeType.REMOVE)
	private List<Commande> listCommandes;
}
