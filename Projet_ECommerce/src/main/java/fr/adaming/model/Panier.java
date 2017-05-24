package fr.adaming.model;

public class Panier {

	// attributs
	private double total;

	// association
	private LigneCommande ligneCommandes;

	// contructeurs
	/**
	 * constructeur vide
	 */
	public Panier() {
		super();
	}

	/**
	 * constructeur avec params
	 * 
	 * @param total
	 */
	public Panier(double total) {
		super();
		this.total = total;
	}

	// getters setters

	/**
	 * @return the ligneCommandes
	 */
	public LigneCommande getLigneCommandes() {
		return ligneCommandes;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @param ligneCommandes
	 *            the ligneCommandes to set
	 */
	public void setLigneCommandes(LigneCommande ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	// toString
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Panier [total=" + total + ", ligneCommandes=" + ligneCommandes + "]";
	}

}
