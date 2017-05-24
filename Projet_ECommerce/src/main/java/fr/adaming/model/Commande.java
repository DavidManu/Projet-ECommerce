package fr.adaming.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="commandes")
public class Commande {

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_co")
	private Long idCommande;
	@Temporal(TemporalType.DATE)
	private Calendar dateCommande;
	
	//association
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id",referencedColumnName="id_cl")
	private Client client;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="table_co_pr",
	joinColumns=@JoinColumn(name="commande_id"),
	inverseJoinColumns=@JoinColumn(name="produit_id"))
	private List<Produit> listProduits;
	
}
