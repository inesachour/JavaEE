package webmvc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.GestionUtilisateur;
import metier.Utilisateur;

/**
 * Servlet implementation class ServletAjout
 */
@WebServlet("/ServletAjout")
public class ServletAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjout() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession maSession = request.getSession(false);
		if (maSession == null) {
			response.sendRedirect("Login.jsp");
		} else {
			Utilisateur user = (Utilisateur) maSession.getAttribute("user");
			if (user != null) {
				GestionUtilisateur g = new GestionUtilisateur();
				Utilisateur u = new Utilisateur();
				String email = (String) request.getParameter("email");
				u.setEmail(email);
				String login = (String) request.getParameter("login"); 
				u.setLogin(login);
				String pass = (String) request.getParameter("password");
				u.setPass(pass);
				String ville = (String) request.getParameter("ville");
				u.setVille(ville);
				g.ajouter(u);
				response.sendRedirect("ServletAffichage");

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
