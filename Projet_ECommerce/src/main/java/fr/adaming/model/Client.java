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
@Table(name = "clients")
public class Client {

	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private Long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;

	// associations
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
	private List<Commande> listCommandes;

	// constructeurs
	/**
	 * constructeur vide
	 */
	public Client() {
		super();
	}

	/**
	 * constructeur sans id
	 * 
	 * @param nomClient
	 * @param adresse
	 * @param email
	 * @param tel
	 */
	public Client(String nomClient, String adresse, String email, String tel) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	/**
	 * constructeur avec id
	 * 
	 * @param idClient
	 * @param nomClient
	 * @param adresse
	 * @param email
	 * @param tel
	 */
	public Client(Long idClient, String nomClient, String adresse, String email, String tel) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	// getters setters
	/**
	 * @return the idClient
	 */
	public Long getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient
	 *            the idClient to set
	 */
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/**
	 * @param nomClient
	 *            the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the listCommandes
	 */
	public List<Commande> getListCommandes() {
		return listCommandes;
	}

	/**
	 * @param listCommandes
	 *            the listCommandes to set
	 */
	public void setListCommandes(List<Commande> listCommandes) {
		this.listCommandes = listCommandes;
	}

	// toString
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresse=" + adresse + ", email=" + email
				+ ", tel=" + tel + "]";
	}

}
