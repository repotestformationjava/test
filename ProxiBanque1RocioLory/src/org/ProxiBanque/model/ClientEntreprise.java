package org.ProxiBanque.model;

/**
 * @author adminl
 *
 *CLASSE CLIENT ENTREPRISE
 *Classe qui h�rite de la classe Client.  
 *
 */
public class ClientEntreprise extends Client {


	
	// Constructeurs h�rit�s
	public ClientEntreprise() {
		super();
		// TODO Auto-generated constructor stub
		this.setParticulier(false);
	}

	public ClientEntreprise(String nomClient, String prenomClient, String adresse, int codePostal, String ville,
			String telephone, Conseiller conseiller, boolean particulier) {
		super(nomClient, prenomClient, adresse, codePostal, ville, telephone, conseiller, false);
		// TODO Auto-generated constructor stub
	}



	
}
