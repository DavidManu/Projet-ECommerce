package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lignecommandes")
public class LigneCommande {

	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lc")
	private Long idCommande;
	private int quantite;
	private int prix;

	// associations
	@ManyToOne
	@JoinColumn(name = "produit_id", referencedColumnName = "id_p")
	private Produit produit;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commande_id", referencedColumnName = "id_co")
	private Commande commande;

	// constructeurs
	/**
	 * constructeur vide
	 */
	public LigneCommande() {
		super();
	}

	/**
	 * constructeur sans id
	 * 
	 * @param quantite
	 * @param prix
	 */
	public LigneCommande(int quantite, int prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	/**
	 * constructeur avec id
	 * 
	 * @param idCommande
	 * @param quantite
	 * @param prix
	 */
	public LigneCommande(Long idCommande, int quantite, int prix) {
		super();
		this.idCommande = idCommande;
		this.quantite = quantite;
		this.prix = prix;
	}

	// getters setters
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
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite
	 *            the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}

	/**
	 * @param produit
	 *            the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	/**
	 * @return the commande
	 */
	public Commande getCommande() {
		return commande;
	}

	/**
	 * @param commande
	 *            the commande to set
	 */
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	// toString
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LigneCommande [idCommande=" + idCommande + ", quantite=" + quantite + ", prix=" + prix + "]";
	}

}
