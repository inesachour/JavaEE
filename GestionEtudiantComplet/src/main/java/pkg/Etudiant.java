package pkg;

public class Etudiant {
	static int idGenerator = 0;
	public int id;
	public String nom;
	public String prenom;
	public String filiere;
	public String niveau;
	public int cin;
	
	public Etudiant(String nom, String prenom, String filiere, String niveau,int cin) {
		this.id = idGenerator++;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.niveau = niveau;
		this.cin = cin;
	}
	
}
