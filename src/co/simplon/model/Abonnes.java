package co.simplon.model;

import java.time.LocalDate;

public class Abonnes {
	public int matricule;
	public String nom;
	public String prenom;
	public String email;
	public String adresse;
	public LocalDate dateNaissance;
	public LocalDate dateAdhesion;
	public String telephone;
	public String categoriPro;
	
	
	public Abonnes() {
	
	}


	public Abonnes(int matricule,String nom, String prenom, String email, String adresse, LocalDate dateNaissance,
			LocalDate dateAdhesion, String telephone, String categoriPro) {
		this.matricule= matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.dateAdhesion = dateAdhesion;
		this.telephone = telephone;
		this.categoriPro = categoriPro;
	}


	public int getMatricule() {
		return matricule;
	}


	public void setMatricule(int matricule) {
		this.matricule = matricule;
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

	
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public LocalDate getDateAdhesion() {
		return dateAdhesion;
	}


	public void setDateAdhesion(LocalDate dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getCategoriPro() {
		return categoriPro;
	}


	public void setCategoriPro(String categoriPro) {
		this.categoriPro = categoriPro;
	}


	@Override
	public String toString() {
		return this.getMatricule()
				+" Abonnes [nom=" + nom 
				+ ", prenom=" + prenom 
				+ ", email=" + email 
				+ ", adresse=" + adresse
				+ ", dateNaissance=" + dateNaissance 
				+ ", dateAdhesion=" + dateAdhesion 
				+ ", telephone=" + telephone
				+ ", categoriPro=" + categoriPro + "]";
	}


	
	

}


