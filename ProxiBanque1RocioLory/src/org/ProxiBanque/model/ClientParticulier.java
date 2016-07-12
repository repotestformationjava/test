package org.ProxiBanque.model;

/**
 * @author adminl
 *
 *CLASSE CLIENT PARTICULIER
 *Classe qui h�rite de la Classe Client. Elle permet de d�clarer le client come particulier ou entreprise.
 *
 */
public class ClientParticulier extends Client {

	public ClientParticulier(String nomClient, String prenomClient, String adresse, int codePostal, String ville,
			String telephone, Conseiller conseiller, boolean particulier) {
		super(nomClient, prenomClient, adresse, codePostal, ville, telephone, conseiller,  true);
		// TODO Auto-generated constructor stub
	}

	public ClientParticulier() {
		super();
		// TODO Auto-generated constructor stub
	
		this.setParticulier(true);
	}

}
