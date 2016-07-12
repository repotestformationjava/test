package org.ProxiBanque.model;

/**
 * @author adminl
 *
 *CLASSE COMPTE COURANT
 *Classe qui h�rite de la classe Compte Bancaire.
 *Elle est r�d�finie pour d�clarer une autorisation de d�couvert de 1000 euros.
 *
 */
public class CompteCourant extends CompteBancaire {

	public CompteCourant(double soldeCompte, String dateCreation) {
		super(soldeCompte, dateCreation, 1000.0);
		// TODO Auto-generated constructor stub
	}







}
