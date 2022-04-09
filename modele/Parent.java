package modele;
import java.util.ArrayList;


public class Parent extends Personne {
	private ArrayList<Facture> factures;
	private ArrayList<Eleve> enfants;
	
	public Parent(String nom, String prenom, ArrayList<Eleve> enfants) {
		super(nom,prenom);
		this.enfants=enfants;
	}
	
	public boolean addEnfant(Eleve enfant) {
		return this.enfants.add(enfant);
	}
	
	public boolean removeEnfant(Eleve enfant) {
		return this.enfants.remove(enfant);
	}
	
	public boolean addFacture(Facture facture) {
		return this.factures.add(facture);
	}
	
	public boolean removeFacture(Facture facture) {
		return this.factures.remove(facture);
	}
	
	public ArrayList<Eleve> getEnfants(){
		return enfants;
	}

	public void setEnfants(int idEnfant,Eleve enfant){
		this.enfants.set(idEnfant, enfant);
	}
	
}