package org.ProxiBanque.presentation;
/**
 * CLASSE PRESENTATION CONSEILLER
 *  Cette classe permet aux conseillers de chaque agence la cr�ation et la gestion de ses clients.
 *  Les diff�rentes options permetten de changer les donn�es du client, de faire de vierments, de faire de
 *  simulations de cr�dit et de r�aliser la gestion du patrimoine du client. 
 *  Le conseiller a aussi l'acc�s � l'�tat des comptes du client, pour v�rifier son d�bit et lui
 *  signaler comme client fortun�.
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

public class Presentation {

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

		System.out.println(
				"Le gerant de l'agence N� " + a.getNumAgence() + "est " + g.getNomGerant() + " " + g.getPrenomGerant());

		System.out.println("-------------------------------------------------------------------------");
		System.out.println("--------------------------------Menu-------------------------------------");
		System.out.println("-------------------------------------------------------------------------");
		// cr�ation conseillers

		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("--Veuillez selectionner le num�ro de l'action souhait�e------------------");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("--1: Ajouter un client    -----------------------------------------------");
		System.out.println("--2: Modifier un client    ----------------------------------------------");
		System.out.println("--3: Supprimer un client    ---------------------------------------------");
		System.out.println("--4: Consulter un client    ---------------------------------------------");
		System.out.println("--5: Effectuer un virement sur un compte---------------------------------");
		System.out.println("--6: Effectuer un virement compte � compte-------------------------------");
		System.out.println("--7: Simulation cr�dit consommation    ----------------------------------");
		System.out.println("--8: Simulation cr�dit mobilier    --------------------------------------");
		System.out.println("--9: Gestion du patrimoine   --------------------------------------------");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Mon Choix: ");
		int reponseMenu = sc.nextInt();
		System.out.println("-------------------------------------------------------------------------");
		System.out.println();

		switch (reponseMenu) {
		case 1:

			// Ajouter un client
			System.out.println("Veuillez choisir le type de client: (p)Particulier/(e)Entreprise");
			System.out.print("-->");
			String typeClient = sc.next();
			if (typeClient.equals("p")) {
				Client c = new ClientParticulier();
				CompteCourant co = new CompteCourant(0, "today");
				CompteEpargne ce = new CompteEpargne(0, "today");
				c.setCompteCourant(co);
				c.setCompteEpargne(ce);
				System.out.print("Nom:");
				String nomclient = sc.next();
				System.out.print("Prenom:");
				String prenomclient = sc.next();
				System.out.print("Adresse:");
				String adresse = sc.next();
				System.out.print("Code Postal:");
				int cp = sc.nextInt();
				System.out.print("Ville:");
				String ville = sc.next();
				System.out.print("Telephone:");
				String telephone = sc.next();
				/*
				 * System.out.print("Conseiller:"); String nomclient =
				 * sc.next();
				 */

			

				service.addClient(c);
				service.updateClient(c, nomclient, prenomclient, adresse, cp, ville, telephone);
				System.out.println("liste des clients actualis�e: ");
				for (Client c2 : service.getDbClient().values()) {
					System.out.println("----------------------------------");
					System.out.println("|| Nom: " +c2.getNomClient());
					System.out.println("|| Pr�nom: " +c2.getPrenomClient());
					System.out.println("|| Adresse: " +c2.getAdresse());
					System.out.println("|| Ville: " +c2.getVille());
					System.out.println("|| Cp: " +c2.getCodePostal());
					System.out.println("|| Telephone: " +c2.getTelephone());
					System.out.println("|| CompteCourant: " +c2.getCompteCourant());
					System.out.println("|| CompteEpargne: " +c2.getCompteEpargne());
					System.out.println("----------------------------------");
				}
			
				
			} else if (typeClient.equals("e")) {
				Client c = new ClientEntreprise();
				CompteCourant co = new CompteCourant(0, "today");
				CompteEpargne ce = new CompteEpargne(0, "today");
				c.setCompteCourant(co);
				c.setCompteEpargne(ce);

				System.out.print("Nom:");
				String nomclient = sc.next();
				System.out.print("Prenom:");
				String prenomclient = sc.next();
				System.out.print("Adresse:");
				String adresse = sc.next();
				System.out.print("Code Postal:");
				int cp = sc.nextInt();
				System.out.print("Ville:");
				String ville = sc.next();
				System.out.print("Telephone:");
				String telephone = sc.next();
				/*
				 * System.out.print("Conseiller:"); String nomclient =
				 * sc.next();
				 */
				service.addClient(c);
				service.updateClient(c, nomclient, prenomclient, adresse, cp, ville, telephone);
				System.out.println("liste des clients actualis�e: ");

				for (Client c2 : service.getDbClient().values()) {
					System.out.println("----------------------------------");
					System.out.println("|| Nom: " +c2.getNomClient());
					System.out.println("|| Pr�nom: " +c2.getPrenomClient());
					System.out.println("|| Adresse: " +c2.getAdresse());
					System.out.println("|| Ville: " +c2.getVille());
					System.out.println("|| Cp: " +c2.getCodePostal());
					System.out.println("|| Telephone: " +c2.getTelephone());
					System.out.println("|| CompteCourant: " +c2.getCompteCourant());
					System.out.println("|| CompteEpargne: " +c2.getCompteEpargne());
					System.out.println("----------------------------------");
					
				}
			} else {
				System.out.println("Erreur de saisie");
			}

			break;
		case 2:
			// Modifier un client:
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Selectionner l'identifiant du client � modifier:");
			System.out.println("-------------------------------------------------------------------------");
			int idClient = sc.nextInt();
			System.out.println("Vous souhaitez modifier le client suivant:");
		
			Client c = service.getClient(idClient);
			
			System.out.print("Le client � modifi� est le suivant:");
			System.out.println("|| Nom: " +c.getNomClient());
			System.out.println("|| Pr�nom: " +c.getPrenomClient());
			System.out.println("|| Adresse: " +c.getAdresse());
			System.out.println("|| Ville: " +c.getVille());
			System.out.println("|| Cp: " +c.getCodePostal());
			System.out.println("|| Telephone: " +c.getTelephone());
			
			System.out.println("Que souhaitez vouz modifier:");
			System.out.println("(Attention!!! ... si vous ne souhaitez rien modifier inserez   '' ''  merci.)");
			System.out.print("Nouveau nom:");
			String nomclient = sc.next();
			System.out.print("Nouveau prenom:");
			String prenomclient = sc.next();
			System.out.print("Nouvelle adresse:");
			String adresse = sc.next();
			System.out.print("Nouveau code Postal:");
			int cp = sc.nextInt();
			System.out.print("Nouvelle ville:");
			String ville = sc.next();
			System.out.print("Nouveau telephone:");
			String telephone = sc.next();
			
		
			service.updateClient(c, nomclient,prenomclient, adresse, cp, ville, telephone);
			
			
			System.out.print("Le client modifi� est le suivant:");
			System.out.println("|| Nom: " +c.getNomClient());
			System.out.println("|| Pr�nom: " +c.getPrenomClient());
			System.out.println("|| Adresse: " +c.getAdresse());
			System.out.println("|| Ville: " +c.getVille());
			System.out.println("|| Cp: " +c.getCodePostal());
			System.out.println("|| Telephone: " +c.getTelephone());

			break;
		case 3:
			// Supprimer un client:
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Selectionner l'identifiant du client � supprimer:");
			System.out.println("-------------------------------------------------------------------------");
			int idClientSuppression = sc.nextInt();
			System.out.println("Vous souhaitez supprimer le client suivant:");
		
			Client cSuppresion = service.getClient(idClientSuppression);
			
			System.out.print("Le client � modifi� est le suivant:");
			System.out.println("|| Nom: " + cSuppresion.getNomClient());
			System.out.println("|| Pr�nom: " + cSuppresion.getPrenomClient());
			System.out.println("|| Adresse: " + cSuppresion.getAdresse());
			System.out.println("|| Ville: " + cSuppresion.getVille());
			System.out.println("|| Cp: " + cSuppresion.getCodePostal());
			System.out.println("|| Telephone: " + cSuppresion.getTelephone());
			
			service.delClient(idClientSuppression);
			System.out.println("le client et tous ses comptes associ�s ont bien �t� supprim�s:");
			
			
			break;
		
		case 4:

			// Consulter un client:
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Selectionner l'identifiant du client � consulter:");
			System.out.println("-------------------------------------------------------------------------");
			int idClientConsultation = sc.nextInt();
			System.out.println("Vous souhaitez consulter le client suivant:");
		
			Client cConsultation = service.getClient(idClientConsultation);
			
			System.out.print(" client:");
		
			
			System.out.println("|| Nom: " + cConsultation.getNomClient());
			System.out.println("|| Pr�nom: " + cConsultation.getPrenomClient());
			System.out.println("|| Adresse: " + cConsultation.getAdresse());
			System.out.println("|| Ville: " + cConsultation.getVille());
			System.out.println("|| Cp: " + cConsultation.getCodePostal());
			System.out.println("|| Telephone: " + cConsultation.getTelephone());
			System.out.println("---------------------------------------------");
			System.out.println("|| CompteCourant: " + cConsultation.getCompteCourant());
			System.out.println("|| CompteEpargne: " + cConsultation.getCompteEpargne());
			break;
		case 5:
			// Effectuer un Virement (sur un compte):
			System.out.println("----------------------------------------------");
			System.out.println("Selectionner le num�ro de compte b�n�ficiaire:");
			System.out.println("----------------------------------------------");
			System.out.print("num�ro:");
			int idCompteB = sc.nextInt();
			System.out.println(service.getCompte(idCompteB));
			System.out.println("---------------------------------");
			System.out.println("Selectionner le montant � verser:");
			System.out.println("---------------------------------");
			double montantv = sc.nextDouble();
			service.getCompte(idCompteB).setSoldeCompte(service.getCompte(idCompteB).getSoldeCompte()+montantv);
			System.out.println("transaction valid�e: ");
			System.out.println("nouveau solde:" + service.getCompte(idCompteB).getSoldeCompte());
				
						
			break;
		case 6:
			// Effectuer un Virement (compte � compte):
			System.out.println("------------------------------------------");
			System.out.println("Selectionner le num�ro de compte d�biteur:");
			System.out.println("------------------------------------------");
			System.out.print("num�ro:");
			int idCompteDebiteur = sc.nextInt();
			
			System.out.println("----------------------------------------------");
			System.out.println("Selectionner le num�ro de compte b�n�ficiaire:");
			System.out.println("----------------------------------------------");
			System.out.print("num�ro:");
			int idCompteBeneficiaire = sc.nextInt();
			
			System.out.println("-------------------------------------");;
			System.out.println("Introduisez le montant � transf�rer: ");
			System.out.println("-------------------------------------");
			System.out.print("montant:");
			double montant = sc.nextDouble();
			
			System.out.println("------------------------------------------------------");;
			System.out.println("R�sum�: vous souhaitez op�rer la transaction suivante ");
			System.out.println("Compte d�biteur " + service.getCompte(idCompteDebiteur) );
			System.out.print("montant: " + montant);
			System.out.println("Compte b�n�ficiaire " + service.getCompte(idCompteBeneficiaire) );
			System.out.println("Valider la transaction (O/N)?" );
			String reponseTransaction = sc.next();
			if (reponseTransaction.equals("O")){
				service.virementCompte1Compte2(idCompteDebiteur, idCompteBeneficiaire, montant);
				System.out.println("nouvel �tat :");
				System.out.println("Compte d�biteur " + service.getCompte(idCompteDebiteur) );
				System.out.println("Compte b�n�ficiaire " + service.getCompte(idCompteBeneficiaire) );
			}else{
				System.out.println("transaction annul�e");
			}

		
			break;
		case 7:
			//Simulation cr�dit consomation
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Selectionner l'identifiant du client � consulter:");
			System.out.println("-------------------------------------------------------------------------");
			int idClientConsommation = sc.nextInt();
			Client cConso = service.getClient(idClientConsommation);
			service.simulationCreditConsommation(cConso );
			System.out.println("systeme en construction......");
			break;
		case 8:
			//Simulation cr�dit Immobilier
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Selectionner l'identifiant du client � consulter:");
			System.out.println("-------------------------------------------------------------------------");
			int idClientImmo = sc.nextInt();
			Client cImmo= service.getClient(idClientImmo);
			service.simulationCreditImmobilier(cImmo );
			System.out.println("systeme en construction......");
			break;
		case 9:
			//Gestion du patrimoine Client
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Selectionner l'identifiant du client � consulter:");
			System.out.println("-------------------------------------------------------------------------");
			int idClientPatrimoine = sc.nextInt();
			Client cPatrimoine = service.getClient(idClientPatrimoine);
			service.gestionPatrimoine(cPatrimoine);
			System.out.println("systeme en construction......");
			break;
		default:
			System.out.println("Pour tout autre choix, merci de contacter v�tre directeur...");
			break;

		}
sc.close();
	}

}
