package org.ProxiBanque.model;

/**
 * @author adminl
 *
 *CLASSE COMPTE COURANT
 *Classe qui hérite de la classe Compte Bancaire.
 *Elle est rédéfinie pour déclarer une autorisation de découvert de 1000 euros.
 *
 */
public class CompteCourant extends CompteBancaire {

	public CompteCourant(double soldeCompte, String dateCreation) {
		super(soldeCompte, dateCreation, 1000.0);
		// TODO Auto-generated constructor stub
	}







}
