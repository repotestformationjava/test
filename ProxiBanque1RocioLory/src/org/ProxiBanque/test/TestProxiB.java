package org.ProxiBanque.test;

import org.ProxiBanque.dao.MemDAO;
import org.ProxiBanque.model.Client;
import org.ProxiBanque.model.ClientEntreprise;
import org.ProxiBanque.model.ClientParticulier;
import org.ProxiBanque.model.CompteCourant;
import org.ProxiBanque.model.CompteEpargne;

public class TestProxiB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("************test1***************");

		// Simulation de la base de données:

		MemDAO dao = new MemDAO();

		System.out.println(dao.getDbClient().size());

		// création du premier client
		Client c1 = new ClientParticulier();

		CompteCourant co1 = new CompteCourant(80000, "today");
		CompteEpargne co2 = new CompteEpargne(200.0, "today");
		// création des comptes du 1er client
		c1.setCompteCourant(co1);
		c1.setCompteEpargne(co2);

		// création du second client
		Client c2 = new ClientParticulier();

		CompteCourant co3 = new CompteCourant(250.0, "today");
		CompteEpargne co4 = new CompteEpargne( 25.0, "today");

		// création des comptes du 2nd client
		c2.setCompteCourant(co3);
		c2.setCompteEpargne(co4);
		// création du 3eme client
		Client c3 = new ClientEntreprise();

		// création des comptes du 3eme client
		CompteCourant co5 = new CompteCourant(110.0, "today");
		CompteEpargne co6 = new CompteEpargne(0.0, "today");

		c3.setCompteCourant(co5);
		c3.setCompteEpargne(co6);
		// ajout dans la base de données:
		dao.addClient(c1);
		dao.addClient(c2);
		dao.addClient(c3);
		System.out.println(dao.getDbClient().size());

		// test2
		System.out.println("************test2***************");

		System.out.println(c1.getNomClient());
		System.out.println(c1.getPrenomClient());
		System.out.println(c1.getAdresse());

		String nomClient = "L'eponge";
		String prenomClient = "Bob";
		String adresse = "Saint Quentin";

		dao.updateClient(c1, nomClient, prenomClient, adresse, 0, "", "");
		System.out.println(c1.getNomClient());
		System.out.println(c1.getPrenomClient());
		System.out.println(c1.getAdresse());

		System.out.println("************test3***************");

		System.out.println(dao.getClient(0));

		System.out.println("************test4***************");

		/*
		 * System.out.println(dao.getClient(0)); dao.delClient(0);
		 * System.out.println(dao.getClient(0));
		 */

		System.out.println("************test5***************");

		System.out.println(dao.getDbCompteBancaire().size());

		System.out.println(dao.getDbCompteBancaire().get(0));
		System.out.println(dao.getDbCompteBancaire().get(1));
		System.out.println(dao.getDbCompteBancaire().get(2));
		System.out.println(dao.getDbCompteBancaire().get(3));
		System.out.println(dao.getDbCompteBancaire().get(4));
		System.out.println(dao.getDbCompteBancaire().get(5));
		System.out.println();

		dao.virementCompte1Compte2(0, 1, 50);
		dao.virementCompte1Compte2(0, 2, 50000);
		dao.virementCompte1Compte2(5, 4, 1000000);

		System.out.println(dao.getDbCompteBancaire().get(0));
		System.out.println(dao.getDbCompteBancaire().get(1));
		System.out.println(dao.getDbCompteBancaire().get(2));
		System.out.println(dao.getDbCompteBancaire().get(3));
		System.out.println(dao.getDbCompteBancaire().get(4));
		System.out.println(dao.getDbCompteBancaire().get(5));
		System.out.println();

		System.out.println("************test6***************");
		
		dao.clientFortune(0);
		dao.clientFortune(1);
		System.out.println(dao.getDbClient().get(0));
		System.out.println(dao.getDbClient().get(1));
		dao.virementCompte1Compte2(0, 3, 700000);
		dao.clientFortune(0);
		dao.clientFortune(1);
		System.out.println(dao.getDbClient().get(0));
		System.out.println(dao.getDbClient().get(1));
		System.out.println();
		
	

		System.out.println("************test7***************");
		
		System.out.println(dao.getListCompteParticuliers());
		
		System.out.println("************test7***************");
		System.out.println(dao.getListCompteEntreprises());
		
		System.out.println();
		
		

		System.out.println("************test8***************");
		
		
		System.out.println(dao.verifierListCompteParticuliers());
		System.out.println(dao.verifierListCompteEntreprises());
		// création d'un client
				Client c8 = new ClientParticulier();

				CompteCourant co8 = new CompteCourant(-8000, "today");
				CompteEpargne co10 = new CompteEpargne( 25.0, "today");
				Client c9 = new ClientEntreprise();

				CompteCourant co9 = new CompteCourant(-80000, "today");
				CompteEpargne co11 = new CompteEpargne( 25.0, "today");
				
				// création des comptes du 1er client
				c8.setCompteCourant(co8);
				c8.setCompteEpargne(co10);
				
				c9.setCompteCourant(co9);
				c9.setCompteEpargne(co11);
				
				dao.addClient(c8);
				dao.addClient(c9);
				System.out.println(dao.verifierListCompteParticuliers());
				System.out.println(dao.verifierListCompteEntreprises());
				
				System.out.println("************test9***************");
				System.out.println(dao.getClient(2));
				System.out.println(dao.getClient(2).getCompteCourant());
				System.out.println(dao.getClient(2).getCompteEpargne());
				dao.delClient(2);
				System.out.println(dao.getClient(2));
				System.out.println(dao.getClient(2).getCompteCourant());
				System.out.println(dao.getClient(2).getCompteEpargne());
		
		System.out.println("************testfin***************");
		dao.getDbClient().clear();
		dao.getDbCompteBancaire().clear();
		dao.getDbAgence().clear();

	}

}
