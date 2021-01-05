package co.simplon.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.simplon.model.Abonnes;
import co.simplon.model.Exemplaire;
import co.simplon.model.Livre;


public class BibliothecaireDaoImpl implements BibliothecaireDAO {

	
private DaoContext daoContext;
	
	private Connection connexion;
	private PreparedStatement preparedStatement;
	private ResultSet result;
	private final String AJOUTE_ABONNES = "INSERT INTO Biblio.Abonnes(nom, prenom,email, adresse, Datenaissance, dateadhesion, telephone, categoriePro) VALUES(?,?,?,?,?,?,?,?)" ;
	private final String AJOUTER_LIVRE = "INSERT INTO Biblio.livre(titre) values (?)";
	private final String Modifier_ABONNES= "UPDATE Biblio.Abonnes set nom=?, prenom=?, email=?, adresse=?, dateNaissance=?, dateAdhesion=?, telephone=?, categoriePro=? WHERE matricule=?";
	
	
	public BibliothecaireDaoImpl(DaoContext daoContext) {
		super();
	}

	
	public void inscrire(Abonnes abonnes) {
try {
			
			connexion = DaoContext.get_Connection();
			preparedStatement = connexion.prepareStatement(this.AJOUTE_ABONNES);
			preparedStatement.setString(1, abonnes.getNom());
			preparedStatement.setString(2, abonnes.getPrenom());
			preparedStatement.setString(3, abonnes.getEmail());
			preparedStatement.setString(4, abonnes.getAdresse());
			preparedStatement.setString(5, abonnes.getDateNaissance().toString());
			preparedStatement.setString(6, abonnes.getDateAdhesion().toString());
			preparedStatement.setString(7, abonnes.getTelephone());
			preparedStatement.setString(8, abonnes.getCategoriPro());
		int nombre = preparedStatement.executeUpdate();
			System.out.println(nombre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void desinscrire(Abonnes abonnes) {
try {
			
			connexion = DaoContext.get_Connection();
			preparedStatement = connexion.prepareStatement("DELETE FROM Biblio.Abonnes where matricule=?");
			preparedStatement.setInt(1, abonnes.getMatricule());
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	
	
	public void modifier(Abonnes abonne) {
		
		try {
			
			connexion = DaoContext.get_Connection();
			preparedStatement = connexion.prepareStatement(this.Modifier_ABONNES);
			preparedStatement.setString(1, abonne.getNom());
			preparedStatement.setString(2, abonne.getPrenom());
			preparedStatement.setString(3, abonne.getEmail());
			preparedStatement.setString(4, abonne.getAdresse());
			preparedStatement.setString(5, abonne.getDateNaissance().toString());
			preparedStatement.setString(6, abonne.getDateAdhesion().toString());
			preparedStatement.setString(7, abonne.getTelephone());
			preparedStatement.setString(8, abonne.getCategoriPro());
			preparedStatement.setInt(9, abonne.getMatricule());
			preparedStatement.executeUpdate();
			
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				if(this.connexion !=null) {
					connexion.close();
				}
				
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
	} 
		
		
// ajouter et supprimer et lister les livres
	public void ajouterLivre(Livre livre) {
		
		try {
			
			connexion = DaoContext.get_Connection();
			preparedStatement = connexion.prepareStatement(this.AJOUTER_LIVRE);
			preparedStatement.setString(1, livre.getTitre());
			int nombre = preparedStatement.executeUpdate();
			System.out.println(nombre);
			
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
}

	
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


	public List<Abonnes> listerAbonne() {
		
			List<Abonnes> LAbonnes = new ArrayList<Abonnes>();
			
			try {
				 
				 connexion= DaoContext.get_Connection();
				 PreparedStatement st  =  connexion.prepareStatement("select * from Biblio.Abonnes");
				 result = st.executeQuery();
				
				while (result.next()) {
					
					int matricule = result.getInt(1);
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					String email = result.getString("email");
					String adresse = result.getString("adresse");
					LocalDate dateNaissance = LocalDate.parse(result.getString("datenaissance"));
					LocalDate dateAdhesion = LocalDate.parse(result.getString("dateAdhesion"));
					String telephone = result.getString("telephone");
					String categoriPro = result.getString("categoriePro");
					
					Abonnes abonne = new Abonnes();
					abonne.setMatricule(matricule);
					abonne.setNom(nom);
					abonne.setPrenom(prenom);
					abonne.setEmail(email);
					abonne.setAdresse(adresse);
					abonne.setDateNaissance(dateNaissance);
					abonne.setDateAdhesion(dateAdhesion);
					abonne.setTelephone(telephone);
					abonne.setCategoriPro(categoriPro);
					LAbonnes.add(abonne);
					
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
		} finally {
			
			try {
				

				if (connexion!= null) {
					connexion.close();
				}
					
			}catch(SQLException ignore) {
				ignore.printStackTrace();
			}
		}
			
			return LAbonnes;
		}
		// TODO Auto-generated method stub
	

	
	public List<Exemplaire> listerexemplaire() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Abonnes findbyId(int matricule) {
		
		Abonnes abonne = null;
		
		
		try {
			 
			 connexion= DaoContext.get_Connection();
			 PreparedStatement etat = connexion.prepareStatement("select * from Abonnes where matricule=?");
			 etat.setInt(1, matricule);
			 result = etat.executeQuery();
			 
			 if(result.next()) {
				 
				 abonne = new Abonnes();
				 abonne.setMatricule(matricule);
				 abonne.setNom(result.getString("nom"));
				 abonne.setPrenom(result.getString("prenom"));
				 abonne.setEmail(result.getString("Email"));
				 abonne.setAdresse(result.getString("adresse"));
				 abonne.setDateNaissance(LocalDate.parse(result.getString("dateNaissance")));
				 abonne.setDateAdhesion(LocalDate.parse(result.getString("dateAdhesion")));
				 abonne.setTelephone(result.getString("telephone"));
				 abonne.setCategoriPro(result.getString("categoriePro"));
				 
			 }else {
				 
				 System.out.println("aucun abonné");
			 }
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		
		{
		
			try 
			{
				
				if (connexion!= null)
				{
					
					connexion.close();
				}
					
			}
			catch(SQLException ignore)
			
			{
				ignore.printStackTrace();
			}
		}
		
		return abonne;
	}
		
}

	


