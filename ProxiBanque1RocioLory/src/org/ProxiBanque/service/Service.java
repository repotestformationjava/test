package org.ProxiBanque.service;
/**
 * CLASSE SERVICE
 * La classe service rejoins l'ensemble de fonctions de ProxiBanqueSI:
 * - création d'une agence et déclaration de son gerant
 * - fonctions propres du conseiller pour la gestion de ses clients
 * - le lancement des audits des comptes et leurs conditions, ainsi que 
 *   la création de "clients test" par défaut pour la simulation des audits 
 */
import java.util.List;
import java.util.Map;

import org.ProxiBanque.dao.MemDAO;
import org.ProxiBanque.model.Agence;
import org.ProxiBanque.model.Client;
import org.ProxiBanque.model.ClientEntreprise;
import org.ProxiBanque.model.ClientParticulier;
import org.ProxiBanque.model.CompteBancaire;
import org.ProxiBanque.model.CompteCourant;
import org.ProxiBanque.model.CompteEpargne;
import org.ProxiBanque.model.Conseiller;
import org.ProxiBanque.model.Gerant;

public class Service {

	MemDAO dao = new MemDAO();
	

	//Méthodes de la classe Conseiller
	public void addClient (Client client){
		dao.addClient(client);
	};
	
	public void updateClient (Client c, String nomClient, String prenomClient, String adresse, int codepostal, String ville, String telephone){
		dao.updateClient(c, nomClient, prenomClient, adresse, codepostal, ville, telephone);
	};
	public Client getClient (Integer idClient){
		return dao.getClient(idClient);
	}; 
	public CompteBancaire getCompte (Integer idCompte){
		return dao.getCompte(idCompte);
	}; 
	public void delClient (Integer idClient){
		dao.delClient(idClient);
	};
	public void virementCompte1Compte2 (Integer idCompte1, Integer idCompte2, double montant) {
		dao.virementCompte1Compte2(idCompte1, idCompte2, montant);
	}
	
	public void simulationCreditConsommation (Client client) {
		dao.simulationCreditConsommation(client);
	}
		
	public void simulationCreditImmobilier (Client client) {
		dao.simulationCreditImmobilier(client);
	}
	
	public void gestionPatrimoine (Client client) {
		dao.gestionPatrimoine(client);
	}
	
// Déclaration client fortuné oui/non
	public void clientFortune(Integer idClient) {
		dao.clientFortune(idClient);
	}

// Partie audit
	public List<CompteBancaire> getListCompteParticuliers() {
		return dao.getListCompteParticuliers();
		
	}
	public List<CompteBancaire> getListCompteEntreprises() {
		return dao.getListCompteEntreprises();
		
	}
	public List<CompteBancaire> verifierListCompteParticuliers() {
		return dao.verifierListCompteParticuliers();
		
	}
	public List<CompteBancaire> verifierListCompteEntreprises() {
		return dao.verifierListCompteEntreprises();
		
	}

// Agence
	public void addAgence (Agence a, Gerant g) {
		dao.addAgence(a, g);
	}

	public void addConseiller (Conseiller...c) {
		dao.addConseiller(c);
	}

	//getter dao:
	public Map<Integer, Client> getDbClient () {
	return dao.getDbClient();
	}
	
	public Map<Integer, CompteBancaire> getDbCompte () {
	return dao.getDbCompteBancaire();
	}
	
	public Map<Integer, Conseiller> getDbAgence() {
	return dao.getDbAgence();
	}
	
	//Valeur par défaut de la base de données:
	private Conseiller conseillerTest = new Conseiller("nomConseiller", "prenomConseiller");
	private Client clientTest1 = new ClientParticulier("MonNom", "MonPrénom", "somewhere in France", 00000, "Ville", "06.06.06.06.06", conseillerTest, true);
	private Client clientTest2 = new ClientParticulier("MonNom2", "MonPrénom2", "somewhere in France", 00000, "Ville", "06.06.06.06.06", conseillerTest, true);
	private Client clientTest3 = new ClientEntreprise("MonEntreprise", "MaRaisonSociale", "somewhere in France", 00000, "Ville", "06.06.06.06.06", conseillerTest, true);
	
	private CompteCourant co1 = new CompteCourant(80000, "today");
	private CompteEpargne co2 = new CompteEpargne(200.0, "today");
	private CompteCourant co3 = new CompteCourant(250.0, "today");
	private CompteEpargne co4 = new CompteEpargne( 25.0, "today");
	private CompteCourant co5 = new CompteCourant(110.0, "today");
	private CompteEpargne co6 = new CompteEpargne(0.0, "today");
	
	
	
	public void insererValeurParDefaut(){
		clientTest1.setCompteCourant(co1);
		clientTest1.setCompteEpargne(co2);
		clientTest2.setCompteCourant(co3);
		clientTest2.setCompteEpargne(co4);
		clientTest3.setCompteCourant(co5);
		clientTest3.setCompteEpargne(co6);
		
		addConseiller(conseillerTest);
		addClient(clientTest1);
		addClient(clientTest2);
		addClient(clientTest3);
		
	}
	
	
}
