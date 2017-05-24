package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Panier {

	//association
	private LigneCommande ligneCommandes;
	
}
