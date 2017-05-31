package fr.adaming.model;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	// Commit
	// attributs
	private double total;

	// association
	private List<LigneCommande> listLigneCommandes=new ArrayList<>();

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
	 * @return the listLigneCommandes
	 */
	public List<LigneCommande> getListLigneCommandes() {
		return listLigneCommandes;
	}

	/**
	 * @param listLigneCommandes
	 *            the listLigneCommandes to set
	 */
	public void setListLigneCommandes(List<LigneCommande> listLigneCommandes) {
		this.listLigneCommandes = listLigneCommandes;
	}

	// toString
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Panier [total=" + total + "]";
	}

}
