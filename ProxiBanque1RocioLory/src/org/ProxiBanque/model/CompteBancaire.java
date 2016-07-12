package org.ProxiBanque.model;

/**
 * @author adminl
 *
 *
 *CLASSE COMPTE BANCAIRE
 *Définition des attributs du compte bancaire
 */
public class CompteBancaire {

	// Attributs
	private long idCompte;
	private double soldeCompte;
	private String dateCreation;
	private Integer idClient;
	private double autorisationDecouvert;

	// Getters et setters
	public double getSoldeCompte() {
		return soldeCompte;
	}

	public long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(long idCompte) {
		this.idCompte = idCompte;
	}

	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public Integer getIdclient() {
		return idClient;
	}

	public void setIdclient(Integer idclient) {
		this.idClient = idclient;
	}
	

	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}

	public void setAutorisationDecouvert(double autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}

	// Constructeur

	public CompteBancaire(double soldeCompte, String dateCreation, double autorisationDecouvert) {
		super();
		this.soldeCompte = soldeCompte;
		this.dateCreation = dateCreation;
		this.autorisationDecouvert = autorisationDecouvert;
	}

	@Override
	public String toString() {
		return "CompteBancaire [idCompte=" + idCompte + ", soldeCompte=" + soldeCompte + ", dateCreation="
				+ dateCreation + ", idClient=" + idClient + ", autorisationDecouvert=" + autorisationDecouvert + "]";
	}



}
