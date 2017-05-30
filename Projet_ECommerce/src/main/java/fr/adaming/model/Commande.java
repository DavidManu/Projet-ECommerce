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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commandes")
public class Commande {
	// Commit
	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_co")
	private Long idCommande;
	@Temporal(TemporalType.DATE)
	private Calendar dateCommande;

	// association
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", referencedColumnName = "id_cl")
	private Client client;
	@OneToMany(mappedBy = "commande", cascade = CascadeType.REMOVE)
	private List<LigneCommande> listLignesCommandes;

	// constructeurs
	/**
	 * constructeur vide
	 */
	public Commande() {
		super();
	}

	/**
	 * constructeur sans id
	 * 
	 * @param dateCommande
	 */
	public Commande(Calendar dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	/**
	 * constructeur avec id
	 * 
	 * @param idCommande
	 * @param dateCommande
	 */
	public Commande(Long idCommande, Calendar dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	// getters settres
	/**
	 * @return the idCommande
	 */
	public Long getIdCommande() {
		return idCommande;
	}

	/**
	 * @param idCommande
	 *            the idCommande to set
	 */
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	/**
	 * @return the dateCommande
	 */
	public Calendar getDateCommande() {
		return dateCommande;
	}

	/**
	 * @param dateCommande
	 *            the dateCommande to set
	 */
	public void setDateCommande(Calendar dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the listLignesCommandes
	 */
	public List<LigneCommande> getListLignesCommandes() {
		return listLignesCommandes;
	}

	/**
	 * @param listLignesCommandes
	 *            the listLignesCommandes to set
	 */
	public void setListLignesCommandes(List<LigneCommande> listLignesCommandes) {
		this.listLignesCommandes = listLignesCommandes;
	}

	// toString
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}

}
