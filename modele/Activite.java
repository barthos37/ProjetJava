package modele;
import java.util.ArrayList;

public class Activite {
	private String nom;
	private String lieu;
	private int capacite;
	private ArrayList<Responsable> responsables;
	private ArrayList<Eleve> eleves;
	
	public Activite (String nom, String lieu, int capacite, ArrayList<Responsable> responsables, ArrayList<Eleve> eleves) {
		this.nom=nom;
		this.lieu=lieu;
		this.capacite=capacite;
		this.responsables=responsables;
		this.eleves=eleves;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public ArrayList<Responsable> getResponsables() {
		return responsables;
	}

	public boolean addResponsables(Responsable respo) {
		return this.responsables.add(respo);
	}
	
	public boolean removeReponsables(Responsable respo) {
		return this.responsables.remove(respo);
	}
	
	public ArrayList<Eleve> getEleves() {
		return eleves;
	}

	public boolean addEleve(Eleve eleve) {
		if (eleves.contains(eleve)) {return false;}
		eleves.add(eleve);
		eleve.addActivite(this);
		return true;
	}
	
	public boolean removeEleve(Eleve eleve) {
		if (!eleves.contains(eleve)) {return false;}
		eleves.remove(eleve);
		eleve.removeActivite(this);
		return true;
	}
}
