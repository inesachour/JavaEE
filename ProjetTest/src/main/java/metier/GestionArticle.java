package metier;

import java.util.Vector;
import dao.GestArticleDAO;

/**
 *
 * @author USER
 */
public class GestionArticle {
	GestArticleDAO dao;

	public GestionArticle() {
		dao = new GestArticleDAO();
	}

	public Vector<Article> ChercherArticle(String code,String nom) {
		return dao.rechercheArticle(code,nom);
	}
	
}