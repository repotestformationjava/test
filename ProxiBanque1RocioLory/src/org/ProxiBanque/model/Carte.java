package org.ProxiBanque.model;

/**
 * @author adminl
 *
 *CLASSE CARTE
 *Classe qui contient les attributs pourla création d'une nouvelle carte bancaire associée
 *au client.Deux options, Carte Visa Electron et Carte Visa Premier, sont offertes aux clients.
 *
 */
public class Carte {

	// Attributs
	protected int nbCarte;
	protected Client client;

	// Getters et setters
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

	public int getNbCarte() {
		return nbCarte;
	}

	public void setNbCarte(int nbCarte) {
		this.nbCarte = nbCarte;
	}

	// Constructeur
	public Carte(int nbCarte, Client client) {
		super();
		this.nbCarte = nbCarte;
		this.client = client;
	}

	@Override
	public String toString() {
		return "Carte [client=" + client + "]";
	}



	
}
