package org.ProxiBanque.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adminl
 *
 *CLASSE AGENCE	
 *Cet classe definit les attributs de chaque agence.
 *
 */
public class Agence {

	// Attributs

	private long numAgence = 56146982;
	private String dateCreation= "Date du jour";
	private Gerant gerant;
	private List<Conseiller> listeConseillers = new ArrayList<>();
	
	//Instance:
	
	private static Agence INSTANCE = null;

	// Getters et setters - pour num et date, seulement les getters

	public long getNumAgence() {
		return numAgence;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public List<Conseiller> getListeConseillers() {
		return listeConseillers;
	}

	public void setListeConseillers(List<Conseiller> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}
	
	//getterInstance:
	public static Agence getINSTANCE() {
		if(INSTANCE == null)
			INSTANCE = new Agence ();
		return INSTANCE;
	}

	// Constructeur

	private Agence() {
		
	}

	@Override
	public String toString() {
		return "Agence [numAgence=" + numAgence + ", dateCreation=" + dateCreation + ", gerant=" + gerant
				+ ", listeConseillers=" + listeConseillers + "]";
	}

	
}
