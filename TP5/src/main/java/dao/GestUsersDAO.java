package dao;

import java.sql.*;
import java.util.Vector;

import metier.Utilisateur;

public class GestUsersDAO {
	public Utilisateur loadUser(String login, String pass) {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from utilisateurs WHERE LOGIN=? AND PASS=?");
			ps.setString(1, login);
			ps.setString(2, pass);
			ResultSet rsUser = ps.executeQuery();
			if (rsUser.next()) {
				u = new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setLogin(rsUser.getString("LOGIN"));
				u.setPass(rsUser.getString("PASS"));
				u.setEmail(rsUser.getString("EMAIL"));
				u.setVille(rsUser.getString("VILLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public void addUser(String l, String p, String e, String v) {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into utilisateurs (LOGIN,PASS,EMAIL,VILLE) values(?,?,?,?)");
			ps.setString(1, l);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.setString(4, v);
			ps.executeUpdate();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	public Vector selectAll() {
		Connection conn = Utilitaire.getConnection();
		Vector users = new Vector();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from utilisateurs");
			ResultSet rsUser = ps.executeQuery();
			while (rsUser.next()) {
				u = new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setLogin(rsUser.getString("LOGIN"));

				u.setPass(rsUser.getString("PASS"));
				u.setEmail(rsUser.getString("EMAIL"));
				u.setVille(rsUser.getString("VILLE"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public void deleteUser(String l, String p) {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		try {
			PreparedStatement ps = conn
					.prepareStatement("delete from utilisateurs where LOGIN=? and PASS=?");
			ps.setString(1, l);
			ps.setString(2, p);
			ps.executeUpdate();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public void modifierUser(int id,String l, String p, String e, String v) {
		Connection conn = Utilitaire.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("update utilisateurs set LOGIN=? , PASS=? , EMAIL=?,VILLE=? where ID_USER=?");
			ps.setString(1, l);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.setString(4, v);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
}
