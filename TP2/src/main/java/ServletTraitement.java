

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTraitement
 */
@WebServlet("/ServletTraitement")
public class ServletTraitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTraitement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String sexe;
		if(request.getParameter("sexe").equals("F")) {
			sexe = "madame" ;
		}
		else {
			sexe = "monsieur";
		}
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Bonjour "+sexe+" "+prenom+" "+nom+"</h2>");
		out.println("<h4>Votre Fonction: "+request.getParameter("fonction")+"</h4>");
		out.println("Loisirs :");
		if(request.getParameterValues("loisirs") !=null) {
			for(int i=0; i< request.getParameterValues("loisirs").length;i++) {
				out.println(request.getParameterValues("loisirs")[i]+"   ");
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
