package modele;
import java.util.ArrayList;

public class Aliment {
	private String nom;
	private ArrayList<Allergene> allergenes;

	public Aliment(String nom, ArrayList<Allergene> allergenes) {
		this.nom = nom;
		this.allergenes = allergenes;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Allergene> getAllergenes() {
		return allergenes;
	}
	public void setAllergenes(ArrayList<Allergene> allergenes) {
		this.allergenes = allergenes;
	}
	
}