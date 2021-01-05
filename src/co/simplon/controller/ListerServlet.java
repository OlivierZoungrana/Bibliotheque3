package co.simplon.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.DAO.AbonneDAO;
import co.simplon.DAO.BibliothecaireDAO;
import co.simplon.DAO.DaoContext;
import co.simplon.model.Abonnes;

/**
 * Servlet implementation class ListerServlet
 */
@WebServlet( urlPatterns= "/ListerServlet", loadOnStartup=1 )
public class ListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BibliothecaireDAO bibliothecaireDAO;
	   
	   public void init() throws ServletException{
		   DaoContext daoContext = new DaoContext();
		   this.bibliothecaireDAO = daoContext.getBibliothecaireDAO();
	   }
	   
	
	
	
    public ListerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("LAbonnes", bibliothecaireDAO.listerAbonne());
		
			for(Abonnes a:bibliothecaireDAO.listerAbonne()) {
				
				System.out.println(a+"toto");
		}
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/ListeAbonnes.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Abonnes abonne=null;
		String action = request.getParameter("action");
		int matricule = Integer.parseInt(request.getParameter("matricule"));
			System.out.println(action);
			request.setAttribute("LAbonnes", bibliothecaireDAO.listerAbonne());
		if(action.equals("modifier")) {
			
			abonne= bibliothecaireDAO.findbyId(matricule);
			System.out.println(abonne);
			System.out.println("je modifie l'abonne");
			request.setAttribute("abonne", abonne);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/inscription.jsp").forward(request, response);
		}else {
			abonne = new Abonnes();
			
			abonne.setMatricule(matricule);
			bibliothecaireDAO.desinscrire(abonne);
		}
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/ListeAbonnes.jsp").forward(request, response);
		}
		
}
