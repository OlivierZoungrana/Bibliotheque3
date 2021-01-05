package co.simplon.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.simplon.model.Abonnes;
import co.simplon.model.Exemplaire;
import co.simplon.model.Livre;
import co.simplon.model.Motcles;

public class AbonnesDAOimpl implements AbonneDAO, BibliothecaireDAO {
	
	
	
	private Connection connexion;
	private PreparedStatement preparedStatement;
	private ResultSet result;

	public AbonnesDAOimpl(DaoContext daoContext) {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void rechercherLivre(Motcles motcles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inscrire(Abonnes abonnes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desinscrire(Abonnes abonnes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Exemplaire> listerexemplaire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  void ajouterLivre(Livre livre) {
	
	}
	
	
	@Override
	public List<Livre> listerLivre() {
		
		List<Livre> LLivres = new ArrayList<Livre>();
				
				try {
					connexion = DaoContext.get_Connection();
					PreparedStatement st  =  connexion.prepareStatement("select * from Biblio.Livre");
					result = st.executeQuery();
					
					while(result.next()){
						
						int id_catalogue= result.getInt(1);
						String titre = result.getString("titre");
						
						Livre livre = new Livre();
						livre.setId_catalogue(id_catalogue);
						livre.setTitre(titre);
						
						LLivres.add(livre);
					}
				}catch(SQLException e) {
					
					e.printStackTrace();
				} finally{
					
					try {
						
						if(connexion!= null) {
							
							connexion.close();
						}
					}catch(SQLException ignore) {
						
						ignore.printStackTrace();
					}
					
				}
				
				return LLivres;
				
			}
	

	@Override
	public List<Abonnes> listerAbonne() {
		return null;
	}

	@Override
	public Abonnes findbyId(int matricule) {
		return null;
	}

	@Override
	public void modifier(Abonnes abonne) {
		// TODO Auto-generated method stub
		
	}

	
}
