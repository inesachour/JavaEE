

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Produit;
import modele.ProduitModele;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControleurServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public static ProduitModele pmodele=new ProduitModele();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produit product1=new Produit("RTX3060",62420);
		Produit product2=new Produit("GTX1080",5248);
		List<Produit> products=new ArrayList<>();
		products.add(product1);
		products.add(product2);
		pmodele.setMotCle("GPU");
		pmodele.setProduits(products);
		request.setAttribute("modele", pmodele);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProduitsView.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
