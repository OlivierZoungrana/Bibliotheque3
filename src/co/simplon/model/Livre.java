package co.simplon.model;

public class Livre {
	int id_catalogue;
	String titre;
	Auteur auteur;
	Editeur editeur;
	
	
	public Livre() {
		super();
	}
	
	public int getId_catalogue() {
		return id_catalogue;
	}

	public void setId_catalogue(int id_catalogue) {
		this.id_catalogue = id_catalogue;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [titre=" + titre + ", auteur=" + auteur + "]";
	}
	
	

}
