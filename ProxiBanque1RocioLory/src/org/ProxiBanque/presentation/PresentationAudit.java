package org.ProxiBanque.presentation;
/**
 * CLASSE PRSENTATION AUDIT
 * Fonction réservée au gerant de chaque agence, protegée par un mot de passe.
 * Elle permet d'accéder à la liste de comptes audités et aux résultats de cette audit.
 */
import java.util.Scanner;

import org.ProxiBanque.model.Agence;
import org.ProxiBanque.model.Client;
import org.ProxiBanque.model.ClientEntreprise;
import org.ProxiBanque.model.ClientParticulier;
import org.ProxiBanque.model.CompteBancaire;
import org.ProxiBanque.model.CompteCourant;
import org.ProxiBanque.model.CompteEpargne;
import org.ProxiBanque.model.Gerant;
import org.ProxiBanque.service.Service;

public class PresentationAudit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Service service = new Service();
		Agence a = Agence.getINSTANCE();
		Gerant g = new Gerant(0, "ROCIO", "Lory");
		service.addAgence(a, g);
		service.insererValeurParDefaut();

		Scanner sc = new Scanner(System.in);

		// Création agence

		System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
		System.out.println("........................................................................");
		System.out.println("......................Bienvenue dans ProxiBanqueSI......................");
		System.out.println("........................................................................");
		System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");

		System.out.println();

		System.out.println("veuillez saisir vôtre identifiant");
		System.out.print("-->");
		String nomIdentifiant = sc.next();
		System.out.println("veuillez saisir vôtre motdePasse");
		System.out.print("-->");
		String motdePasse = sc.next();

		if (nomIdentifiant.equals(g.getNomGerant())) {
			if (motdePasse.equals(g.getMotPasse())) {

				
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("--------------------------------Menu-------------------------------------");
				System.out.println("-------------------------------------------------------------------------");
				// création conseillers

				System.out.println();
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("--Veuillez selectionner le numéro de l'action souhaitée------------------");
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("--1: Verifier liste des comptes des Particuliers-------------------------");
				System.out.println("--2: Verifier liste des comptes des Entreprises-------------------------");
				System.out.println();
				System.out.print("Mon Choix: ");
				int reponseMenu = sc.nextInt();
				System.out.println("-------------------------------------------------------------------------");
				System.out.println();

				switch (reponseMenu) {
				case 1:					
					// Verifier liste des comptes des Particuliers:
					System.out.println(service.verifierListCompteParticuliers());
				
					break;
				case 2:
					// Verifier liste des comptes des Entreprises:
					System.out.println(service.verifierListCompteEntreprises());
					break;
				
				default:
					System.out.println("Pour tout autre choix, merci de contacter Yann Creac'h...");
					break;				

				}
				
				
				
			} else {
				System.out.println("mot de passe érroné");
			}

		} else {
			System.out.println("identifiant érroné");
		}
		sc.close();
	}

}
