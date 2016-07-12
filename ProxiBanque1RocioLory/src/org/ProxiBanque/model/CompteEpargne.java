package org.ProxiBanque.model;

/**
 * @author adminl
 *
 *CLASSE COMPTE EPARGNE
 *Classe qui hérite du Compte Bancaire.
 *Elle est rédéfinie pour afficher un taux de rémuneration du 3%.
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
