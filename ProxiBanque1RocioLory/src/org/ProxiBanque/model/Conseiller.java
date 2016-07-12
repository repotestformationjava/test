package org.ProxiBanque.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adminl
 *
 *CLASSE CONSEILLER
 *Déclaration des attributs et fonctions du Conseiller par rapport à la
 *gestion des clients.
 *Chaque conseiller peut travailler avec un maximum de 10 clients.
 */
public class Conseiller {

	// Attributs
	private Integer idConseiller;
	private String nomConseiller;
	private String prenomConseiller;
	private Client[] listeClients = new Client[10];
	private Agence agence;

	// Getters et setters
	public Integer getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(Integer idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getNomConseiller() {
		return nomConseiller;
	}

	public void setNomConseiller(String nomConseiller) {
		this.nomConseiller = nomConseiller;
	}

	public String getPrenomConseiller() {
		return prenomConseiller;
	}

	public void setPrenomConseiller(String prenomConseiller) {
		this.prenomConseiller = prenomConseiller;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Client[] getListeClients() {
		return listeClients;
	}

	public void setListeClients(Client[] listeClients) {
		this.listeClients = listeClients;
	}

	// Constructeur
	public Conseiller(Integer idConseiller, String nomConseiller, String prenomConseiller) {
		super();
		this.idConseiller = idConseiller;
		this.nomConseiller = nomConseiller;
		this.prenomConseiller = prenomConseiller;
	}

	// constr. pour conseiller en periode d'essai
	public Conseiller(String nomConseiller, String prenomConseiller) {
		super();
		this.nomConseiller = nomConseiller;
		this.prenomConseiller = prenomConseiller;
	}

	@Override
	public String toString() {
		return "Conseiller [idConseiller=" + idConseiller + ", nomConseiller=" + nomConseiller + ", prenomConseiller="
				+ prenomConseiller + ", listeClients=" + listeClients + ", agence=" + agence + "]";
	}
	
	
}
