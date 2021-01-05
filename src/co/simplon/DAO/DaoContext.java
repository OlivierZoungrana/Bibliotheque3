package co.simplon.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DaoContext {
	static String db_url = "jdbc:mysql://localhost:3306/Biblio";
	static String db_username= "root";
	static String db_password= "Amour1988";
	
	
	
	      
	public static Connection get_Connection() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		Connection connexion = DriverManager.getConnection(db_url,db_username,db_password);
				return connexion;
	}
	
	public BibliothecaireDAO getBibliothecaireDAO() {
		
		//PaysDAO paysDaoobjet = new PaysDaoImpl(this);
		//return paysDaoobjet;
		return new BibliothecaireDaoImpl(this);
	}

	public AbonneDAO getAbonneDAO() {
		// TODO Auto-generated method stub
		return new AbonnesDAOimpl(this);
	}
	

}
