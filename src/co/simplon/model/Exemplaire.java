package co.simplon.model;

public class Exemplaire extends Livre {
	String editeur;
	int annee_edition;
	
	
	public Exemplaire() {
		super();
	}


	public Exemplaire(String editeur, int annee_edition) {
		super();
		this.editeur = editeur;
		this.annee_edition = annee_edition;
	}
	
	
	

}
