package co.simplon.DAO;

import java.util.List;

import co.simplon.model.*;

public interface BibliothecaireDAO {
	
	void inscrire(Abonnes abonnes);
	void desinscrire(Abonnes abonnes);
	void ajouterLivre(Livre livre);
	List<Livre> listerLivre();
	List<Abonnes>listerAbonne();
	List<Exemplaire> listerexemplaire();
	public Abonnes findbyId(int matricule);
	void modifier(Abonnes abonne);
	

}
