package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="lignecommandes")
public class LigneCommande {

	//attributs
	private int quantite;
	private int prix;
	

}
