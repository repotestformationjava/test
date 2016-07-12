package org.ProxiBanque.dao;

import java.util.List;

import org.ProxiBanque.model.Agence;
import org.ProxiBanque.model.Client;
import org.ProxiBanque.model.CompteBancaire;
import org.ProxiBanque.model.Conseiller;
import org.ProxiBanque.model.Gerant;

public interface DAO {

	//Méthodes qu'on a pris de "Conseiller"
		public void addClient (Client client);
		public void updateClient (Client c, String nomClient, String prenomClient, String adresse, int codepostal, String ville, String telephone);
		public Client getClient (Integer idClient); 
		public void delClient (Integer idClient);
		public void virementCompte1Compte2 (Integer idCompte1, Integer idCompte2, double montant);
		public void simulationCreditConsommation (Client client);
		public void simulationCreditImmobilier (Client client);
		public void gestionPatrimoine (Client client);
		public CompteBancaire getCompte(Integer idCompte);
		
	// Déclaration client fortuné oui/non
		public void clientFortune(Integer idClient);

	// Partie audit
		public List<CompteBancaire> getListCompteParticuliers();
		public List<CompteBancaire> getListCompteEntreprises();
		public List<CompteBancaire> verifierListCompteParticuliers();
		public List<CompteBancaire> verifierListCompteEntreprises();
	
	// Agence
		public void addAgence(Agence a, Gerant g) ;
		public void addConseiller (Conseiller...c);
		
	
}
