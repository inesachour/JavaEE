package article;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Article;
import metier.GestionArticle;

/**
 * Servlet implementation class RechercheArticle
 */
@WebServlet("/RechercheArticle")
public class RechercheArticle extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		Vector<Article> a = null ;
		
		GestionArticle g = new GestionArticle();
		a = g.ChercherArticle(code.toLowerCase(), nom.toLowerCase());
		
		if(a.isEmpty()) {
			getServletContext().getRequestDispatcher("/ArticleInexistant.jsp").forward(request, response);
		}
		else {
			request.setAttribute("article", a);
			Cookie cookie = new Cookie("cookie", "l_article_recherche_existe");
			response.addCookie(cookie);
			getServletContext().getRequestDispatcher("/ListeArticleTrouver.jsp").forward(request, response);
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
