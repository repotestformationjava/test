package org.ProxiBanque.presentation;
/**
 * CLASSE PRSENTATION AUDIT
 * Fonction r�serv�e au gerant de chaque agence, proteg�e par un mot de passe.
 * Elle permet d'acc�der � la liste de comptes audit�s et aux r�sultats de cette audit.
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

		// Cr�ation agence

		System.out.println("������������������������������������������������������������������������");
		System.out.println("........................................................................");
		System.out.println("......................Bienvenue dans ProxiBanqueSI......................");
		System.out.println("........................................................................");
		System.out.println("������������������������������������������������������������������������");

		System.out.println();

		System.out.println("veuillez saisir v�tre identifiant");
		System.out.print("-->");
		String nomIdentifiant = sc.next();
		System.out.println("veuillez saisir v�tre motdePasse");
		System.out.print("-->");
		String motdePasse = sc.next();

		if (nomIdentifiant.equals(g.getNomGerant())) {
			if (motdePasse.equals(g.getMotPasse())) {

				
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("--------------------------------Menu-------------------------------------");
				System.out.println("-------------------------------------------------------------------------");
				// cr�ation conseillers

				System.out.println();
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("--Veuillez selectionner le num�ro de l'action souhait�e------------------");
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
				System.out.println("mot de passe �rron�");
			}

		} else {
			System.out.println("identifiant �rron�");
		}
		sc.close();
	}

}
