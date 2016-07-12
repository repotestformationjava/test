package org.ProxiBanque.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adminl
 *
 *CLASSE CLIENT
 *Classe abstraite pour la définition des attributsz de chaque client qui
 *va être ajouté au SI.
 *
 */
public abstract class  Client {

	// Attributs
	private Integer idClient;
	private String nomClient;
	private String prenomClient;
	private String adresse;
	private int codePostal;
	private String ville;
	private String telephone;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private List<Carte> listeCartes = new ArrayList<>();
	private Conseiller conseiller;
	/*private double autorisationDecouvert = 1000.0 ;*/
	private boolean clientFortune = false;
	public boolean particulier;

	// Getters et setters - pour id, seulement getter, pour qu'il ne puisse pas
	// être changé
	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public List<Carte> getListeCartes() {
		return listeCartes;
	}

	public void setListeCartes(List<Carte> listeCartes) {
		this.listeCartes = listeCartes;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
/*	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}

	public void setAutorisationDecouvert(double autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}*/
	
	public boolean isClientFortune() {
		return clientFortune;
	}

	public void setClientFortune(boolean clientFortune) {
		this.clientFortune = clientFortune;
	}
	public boolean isParticulier() {
		return particulier;
	}

	public void setParticulier(boolean particulier) {
		this.particulier = particulier;
	}

	// Constructeur



	public Client(String nomClient, String prenomClient, String adresse, int codePostal, String ville, String telephone,
			Conseiller conseiller, /*double autorisationDecouvert,*/ boolean particulier) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.conseiller = conseiller;		
		/*setAutorisationDecouvert(autorisationDecouvert);*/
		this.particulier = particulier;
		/*this.autorisationDecouvert = autorisationDecouvert;*/
	}

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", telephone="
				+ telephone + ", compteCourant=" + compteCourant + ", compteEpargne=" + compteEpargne + ", listeCartes="
				+ listeCartes + ", conseiller=" + conseiller /*+ ", autorisationDecouvert=" + autorisationDecouvert*/
				+ ", clientFortune=" + clientFortune + "]";
	}



	
}
