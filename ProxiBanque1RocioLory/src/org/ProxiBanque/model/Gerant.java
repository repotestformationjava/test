package org.ProxiBanque.model;

/**
 * @author adminl
 *
 */

/**
 * 
 * CLASSE GERANT
 * Déclaration des attributs et foncitons du gerant.
 * Il y a un gerant par agence et a l'acces à une classe Service spécifique.
 *
 */

public class Gerant {

	
	//Attributs
	private long idGerant;
	private String nomGerant;
	private String prenomGerant;
	private Agence agence;
	private String motPasse = "JeSuisRiche";
	
	// Getters et setters - tous les attributs parce que le gerant peut changer
	public long getIdGerant() {
		return idGerant;
	}
	public void setIdGerant(long idGerant) {
		this.idGerant = idGerant;
	}
	public String getNomGerant() {
		return nomGerant;
	}
	public void setNomGerant(String nomGerant) {
		this.nomGerant = nomGerant;
	}
	public String getPrenomGerant() {
		return prenomGerant;
	}
	public void setPrenomGerant(String prenomGerant) {
		this.prenomGerant = prenomGerant;
	}
	
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	public String getMotPasse() {
		return motPasse;
	}
	// Constructeurs
	public Gerant(long idGerant, String nomGerant, String prenomGerant) {
		super();
		this.idGerant = idGerant;
		this.nomGerant = nomGerant;
		this.prenomGerant = prenomGerant;
	}
	@Override
	public String toString() {
		return "Gerant [idGerant=" + idGerant + ", nomGerant=" + nomGerant + ", prenomGerant=" + prenomGerant
				+ ", agence=" + agence + "]";
	}
	

	
	
	
	
	
}
