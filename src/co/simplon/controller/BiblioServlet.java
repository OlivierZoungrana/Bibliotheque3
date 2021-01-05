
package co.simplon.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.DAO.BibliothecaireDAO;
import co.simplon.DAO.DaoContext;

import co.simplon.model.Abonnes;

import java.io.IOException;
import java.time.LocalDate;
/**
 * Servlet implementation class BiblioServlet
 */
@WebServlet(urlPatterns = "/BiblioServlet", loadOnStartup=1)
public class BiblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BibliothecaireDAO bibliothecaireDAO;
	
	   
	   public void init() throws ServletException{
		   DaoContext daoContext = new DaoContext();
		   this.bibliothecaireDAO = daoContext.getBibliothecaireDAO();
	   }
	   
	   
	   
    public BiblioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("LAbonnes", bibliothecaireDAO.listerAbonne());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/inscription.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("dateNaissance");
		System.out.println(date);
		
		if(!request.getParameter("matricule").equals("")||
				!request.getParameter("nom").equals("")|| 
				!request.getParameter("prenom").equals("")||
				!request.getParameter("email").equals("")|| 
				!request.getParameter("adresse").equals("")||
				!request.getParameter("dateNaissance").equals("")||
				!request.getParameter("dateAdhesion").equals("")||
				!request.getParameter("telephone").equals("")||
				!request.getParameter("categoriePro").equals("")) 
		{

			if(!request.getParameter("matricule").equals(""))
			
			{
				Abonnes abonne = new Abonnes();
				abonne.setNom(request.getParameter("nom"));
				abonne.setPrenom(request.getParameter("prenom"));
				abonne.setEmail(request.getParameter("email"));
				abonne.setAdresse(request.getParameter("adresse"));
				abonne.setDateNaissance(LocalDate.parse(date));//on peut utliser la ligne 58 à la place de la date
				abonne.setDateAdhesion(LocalDate.parse(request.getParameter("dateAdhesion")));
				abonne.setTelephone(request.getParameter("telephone"));
				abonne.setCategoriPro(request.getParameter("categoriePro"));
				abonne.setMatricule(Integer.parseInt(request.getParameter("matricule")));
				System.out.println(request.getParameter("matricule"));
				bibliothecaireDAO.modifier(abonne);
				
			}
			
			else
			
			{

				Abonnes abonne = new Abonnes();
				abonne.setNom(request.getParameter("nom"));
				abonne.setPrenom(request.getParameter("prenom"));
				abonne.setEmail(request.getParameter("email"));
				abonne.setAdresse(request.getParameter("adresse"));
				abonne.setDateNaissance(LocalDate.parse(date));//on peut utliser la ligne 58 à la place de la date
				abonne.setDateAdhesion(LocalDate.parse(request.getParameter("dateAdhesion")));
				abonne.setTelephone(request.getParameter("telephone"));
				abonne.setCategoriPro(request.getParameter("categoriePro"));
				bibliothecaireDAO.inscrire(abonne);

			} 

			request.setAttribute("LAbonnes", bibliothecaireDAO.listerAbonne());
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/ListeAbonnes.jsp").forward(request, response);

		}else {
			
			System.out.println("données manquantes");
		}

	}

}
