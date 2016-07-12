package org.ProxiBanque.dao;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ProxiBanque.model.Agence;
import org.ProxiBanque.model.Client;
import org.ProxiBanque.model.CompteBancaire;
import org.ProxiBanque.model.Conseiller;
import org.ProxiBanque.model.Gerant;

public class MemDAO implements DAO {

	// Attribut Base de Données
	private Map<Integer, Client> dbClient = new HashMap<>();
	private Map<Integer, Conseiller> dbAgence = new HashMap<>();
	private Map<Integer, CompteBancaire> dbCompteBancaire = new HashMap<>();

	// Méthodes
	@Override
	public void addClient(Client client) {
		// TODO Auto-generated method stub
		client.setIdClient(dbClient.size());
		client.getCompteCourant().setIdclient(dbClient.size());
		client.getCompteEpargne().setIdclient(dbClient.size());
		dbClient.put(dbClient.size(), client);

		client.getCompteCourant().setIdCompte(dbCompteBancaire.size());
		dbCompteBancaire.put(dbCompteBancaire.size(), client.getCompteCourant());
		client.getCompteEpargne().setIdCompte(dbCompteBancaire.size());
		dbCompteBancaire.put(dbCompteBancaire.size(), client.getCompteEpargne());

	}

	@Override
	public void updateClient(Client c, String nomClient, String prenomClient, String adresse, int codepostal,
			String ville, String telephone) {
		// TODO Auto-generated method stub
		if (nomClient.isEmpty()) {
		} else {
			c.setNomClient(nomClient);
		}

		if (prenomClient != null) {
		} else {
			c.setPrenomClient(prenomClient);
		}
		if (adresse.isEmpty()) {
		} else {
			c.setAdresse(adresse);
		}
		if (codepostal == 0) {
		} else {
			c.setCodePostal(codepostal);
		}
		if (ville.isEmpty()) {
		} else {
			c.setVille(ville);
		}
		if (telephone.isEmpty()) {
		} else {
			c.setTelephone(telephone);
		}
	}

	@Override
	public Client getClient(Integer idClient) {
		// TODO Auto-generated method stub
		Client c1 = dbClient.get(idClient);
		return c1;
	}
	
	@Override
	public CompteBancaire getCompte(Integer idCompte) {
		// TODO Auto-generated method stub
		CompteBancaire c = dbCompteBancaire.get(idCompte);
		return c;
	}

	@Override
	public void delClient(Integer idClient) {
		// TODO Auto-generated method stub
		Client c = getClient(idClient);
		long idCompteCourant = c.getCompteCourant().getIdCompte();
		long idCompteEpargne = c.getCompteEpargne().getIdCompte();
		
		dbClient.remove(idClient);
		dbCompteBancaire.remove(idCompteCourant);
		dbCompteBancaire.remove(idCompteEpargne);
		
	}

	@Override
	public void virementCompte1Compte2(Integer idCompte1, Integer idCompte2, double montant) {
		// TODO Auto-generated method stub

		CompteBancaire c1 = dbCompteBancaire.get(idCompte1);
		CompteBancaire c2 = dbCompteBancaire.get(idCompte2);

		if ((c1.getSoldeCompte() + c1.getAutorisationDecouvert()) >= montant) {
			c2.setSoldeCompte(c2.getSoldeCompte() + montant);
			c1.setSoldeCompte(c1.getSoldeCompte() - montant);
		} else {
			System.out.println("Solde insuffisant");
		}
		clientFortune(c1.getIdclient());
		clientFortune(c2.getIdclient());
	}

	// ------------- Fonction non définit dans le cahier des charges -----
	@Override
	public void simulationCreditConsommation(Client client) {
		// TODO Auto-generated method stub
		System.out.println("je simule vôtre crédit");
	}

	@Override
	public void simulationCreditImmobilier(Client client) {
		// TODO Auto-generated method stub

		System.out.println("je simule vôtre crédit");
	}

	@Override
	public void gestionPatrimoine(Client client) {
		// TODO Auto-generated method stub
		System.out.println("je gère vôtre patrimoine");
	}

	// --------------------- ClientFortuné ------------------------------
	@Override
	public void clientFortune(Integer idClient) {
		Client c = dbClient.get(idClient);

		double soldeCourant = c.getCompteCourant().getSoldeCompte();
		double soldeEpargne = c.getCompteEpargne().getSoldeCompte();

		// TODO Auto-generated method stub
		if (soldeCourant + soldeEpargne > 500000.0) {
			c.setClientFortune(true);
		} else {
			c.setClientFortune(false);
		}

	}

	// --------------------- Audit ------------------------------

	@Override
	public List<CompteBancaire> getListCompteParticuliers() {
		// TODO Auto-generated method stub
		List<CompteBancaire> listCompteParticulier = new ArrayList<>();
		for (Client c : dbClient.values()) {

			if (c.particulier == true) {

				for (CompteBancaire compteBancaire : dbCompteBancaire.values()) {

					if (compteBancaire.getIdclient() == c.getIdClient()) {

						listCompteParticulier.add(compteBancaire);
					}

				}

			}
		}

		return listCompteParticulier;
	}

	@Override
	public List<CompteBancaire> getListCompteEntreprises() {
		// TODO Auto-generated method stub
		List<CompteBancaire> listCompteEntreprise = new ArrayList<>();
		for (Client c : dbClient.values()) {

			if (c.particulier == false) {

				for (CompteBancaire compteBancaire : dbCompteBancaire.values()) {

					if (compteBancaire.getIdclient() == c.getIdClient()) {

						listCompteEntreprise.add(compteBancaire);
					}

				}

			}
		}
		return listCompteEntreprise;
	}

	@Override
	public List<CompteBancaire> verifierListCompteParticuliers() {
		// TODO Auto-generated method stub
		List<CompteBancaire> listauditParticulier = new ArrayList<>();
		
		for (CompteBancaire compteBancaire : getListCompteParticuliers()) {
			
			if(compteBancaire.getSoldeCompte()<(-5000.0)){
				listauditParticulier.add(compteBancaire);				
			}
			
		}
		return listauditParticulier;
	}

	@Override
	public List<CompteBancaire> verifierListCompteEntreprises() {
		// TODO Auto-generated method stub
		List<CompteBancaire> listauditEntreprise = new ArrayList<>();
		
		for (CompteBancaire compteBancaire : getListCompteEntreprises()) {
			
			if(compteBancaire.getSoldeCompte()<(-50000.0)){
				listauditEntreprise.add(compteBancaire);				
			}
			
		}
		return listauditEntreprise;
	
	}

	@Override
	public void addAgence(Agence a, Gerant g){
		// TODO Auto-generated method stub
		a.setGerant(g);

	}
	


	@Override
	public void addConseiller(Conseiller...c) {
		// TODO Auto-generated method stub
		for (Conseiller conseiller : c) {
	conseiller.setIdConseiller(dbAgence.size());
	dbAgence.put(dbAgence.size(), conseiller);
	
		}
	}

	// Getters etc...
	public Map<Integer, Client> getDbClient() {
		return dbClient;
	}

	public void setDbClient(Map<Integer, Client> dbClient) {
		this.dbClient = dbClient;
	}

	public Map<Integer, Conseiller> getDbAgence() {
		return dbAgence;
	}

	public void setDbAgence(Map<Integer, Conseiller> dbAgence) {
		this.dbAgence = dbAgence;
	}

	public Map<Integer, CompteBancaire> getDbCompteBancaire() {
		return dbCompteBancaire;
	}

	public void setDbCompteBancaire(Map<Integer, CompteBancaire> dbCompteBancaire) {
		this.dbCompteBancaire = dbCompteBancaire;
	}

}
