package co.simplon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.DAO.BibliothecaireDAO;
import co.simplon.DAO.DaoContext;
import co.simplon.model.Livre;

/**
 * Servlet implementation class LivreAddServlet
 */
@WebServlet(urlPatterns = "/LivreAddServlet", loadOnStartup=1)
public class LivreAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BibliothecaireDAO bibliothecaireDAO;
	
	   
	   public void init() throws ServletException{
		   DaoContext daoContext = new DaoContext();
		   this.bibliothecaireDAO = daoContext.getBibliothecaireDAO();
	   }
	   
	   
    public LivreAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/AjouterLivre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Livre livre = new Livre();
		livre.setTitre(request.getParameter("titre"));
		System.out.println(livre);
		bibliothecaireDAO.ajouterLivre(livre);
		request.setAttribute("LLivre", bibliothecaireDAO.listerLivre());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vues/ListeLivre.jsp").forward(request, response);
	}

}
