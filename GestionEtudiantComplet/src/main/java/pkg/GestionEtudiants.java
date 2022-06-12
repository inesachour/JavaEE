package pkg;
import java.util.ArrayList;
import java.util.List;

public class GestionEtudiants {

	public static List<Etudiant> etudiants = new ArrayList<Etudiant> ();
	
	public static void add(Etudiant e) {
		etudiants.add(e);
	}
	
	public static void remove(int cin) {
		for(int i=0;i<etudiants.size();i++) {
			if(etudiants.get(i).cin == cin) {
				etudiants.remove(i);
				break;
			}
		}
	}
}
