package dao;

import java.sql.*;
import java.util.Vector;

import metier.Article;

public class GestArticleDAO {
	public Vector<Article> rechercheArticle(String code,String nom) {
		Connection conn = Utilitaire.getConnection();
		Article u = null;
		Vector<Article> articles = new Vector<Article>() ;
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from Articles WHERE CODE=? OR NOM=?");
			ps.setString(1, code);
			ps.setString(2, nom);
			ResultSet rsProduit = ps.executeQuery();
			
			System.out.println(rsProduit);
			while (rsProduit.next()) {
				u = new Article();
				u.setCode(rsProduit.getString("CODE"));
				u.setNom(rsProduit.getString("NOM"));
				u.setDescription(rsProduit.getString("DESCRIPTION"));
				u.setPrix(rsProduit.getInt("PRIX"));
				u.setQuantite(rsProduit.getInt("QUANTITE"));
				articles.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}
	
}