package modele;
import java.util.ArrayList;


public class Menu {
	private String nom;
	private ArrayList<Aliment> aliments;
	public Menu(String nom, ArrayList<Aliment> aliments) {
		this.nom = nom;
		this.aliments = aliments;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<Aliment> getAliments() {
		return aliments;
	}
	public void setAliments(ArrayList<Aliment> aliments) {
		this.aliments = aliments;
	}
	
	public void addAliment(Aliment aliment) {
		this.aliments.add(aliment);
	}
}
