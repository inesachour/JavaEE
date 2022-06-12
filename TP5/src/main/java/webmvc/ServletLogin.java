package webmvc;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.GestionUtilisateur;
import metier.Utilisateur;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		if ((login != null) && (pass != null)) {
			Utilisateur user = new Utilisateur();
			GestionUtilisateur g = new GestionUtilisateur();
			if (g.Chercher(login, pass) != null) {
				user = g.Chercher(login, pass);
				HttpSession maSession = request.getSession(true);
				maSession.setAttribute("user", user);
				response.sendRedirect("Bienvenue.jsp");
			} else {
				request.setAttribute("erreur", "ERREUR!");
				response.sendRedirect("Login.jsp");
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
