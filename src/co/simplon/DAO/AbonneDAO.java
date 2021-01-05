package co.simplon.DAO;

import java.util.List;

import co.simplon.model.Abonnes;
import co.simplon.model.Exemplaire;
import co.simplon.model.Motcles;

public interface AbonneDAO {
	
	void rechercherLivre(Motcles motcles);
	void inscrire(Abonnes abonnes);
	void desinscrire(Abonnes abonnes);
	List<Exemplaire> listerexemplaire();
	

}
