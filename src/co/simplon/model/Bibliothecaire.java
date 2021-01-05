package co.simplon.model;

public class Bibliothecaire {
	
	public String nom; 
	public String prenom;
	
	
	public Bibliothecaire() {
		super();
	}


	public Bibliothecaire(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	@Override
	public String toString() {
		return "Bibliothecaire [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	

}
