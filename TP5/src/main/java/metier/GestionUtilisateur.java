package metier;

import java.util.Vector;
import dao.GestUsersDAO;

/**
 *
 * @author USER
 */
public class GestionUtilisateur {
	GestUsersDAO dao;

	public GestionUtilisateur() {
		dao = new GestUsersDAO();
	}

	public Utilisateur Chercher(String login, String pass) {
		return dao.loadUser(login, pass);
	}

	public void ajouter(Utilisateur u) {
		dao.addUser(u.getLogin(), u.getPass(), u.getEmail(), u.getVille());
	}

	public Vector lister() {
		return dao.selectAll();
	}
	
	public void supprimer(Utilisateur u) {
		dao.deleteUser(u.getLogin(), u.getPass());
	}
	
	public void modifier(int id,Utilisateur u) {
		dao.modifierUser(id,u.getLogin(), u.getPass(), u.getEmail(), u.getVille());
	}
}
