package org.ProxiBanque.model;

/**
 * @author adminl
 *
 *CLASSE COMPTE EPARGNE
 *Classe qui h�rite du Compte Bancaire.
 *Elle est r�d�finie pour afficher un taux de r�muneration du 3%.
 *
 */


public class CompteEpargne extends CompteBancaire {
	
	//attribut
	private double tauxRemuneration = 0.03;
	
	//getter et setter:
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	public CompteEpargne(double soldeCompte, String dateCreation) {
		super(soldeCompte, dateCreation, 0.0);
		// TODO Auto-generated constructor stub
	}

	//constructeur:	







}
