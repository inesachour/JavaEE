package webmvc;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.GestionUtilisateur;
import metier.Utilisateur;

/**
 * Servlet implementation class ServletAffichage
 */
@WebServlet("/ServletAffichage")
public class ServletAffichage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAffichage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession maSession = request.getSession(false);
		if (maSession == null) {
			response.sendRedirect("Login.jsp");
		} else {
			Utilisateur user = (Utilisateur) maSession.getAttribute("user");
			if(user !=null) {
				GestionUtilisateur g = new GestionUtilisateur();
					Vector users = g.lister();
					request.setAttribute("users", users);
					getServletContext().getRequestDispatcher("/affichage.jsp").forward(request, response);
			
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
