import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleurServlet() {
		// TODO Auto-generated constructor stub
	}

	public static ProduitModele pmodele = new ProduitModele();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CatalogueImpl metier = new CatalogueImpl();
		List<Produit> prods = metier.getProduitsParMotCle(request.getParameter("motCle"));
		pmodele.setMotCle(request.getParameter("motCle"));
		pmodele.setProduits(prods);
		request.setAttribute("modele", pmodele);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProduitsView.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}