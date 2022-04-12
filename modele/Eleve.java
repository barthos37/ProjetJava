package modele;
import java.util.ArrayList;


public class Eleve extends Personne {
	private int solde;
	private ArrayList<Activite> activites;
	private int abonnement; //null si pas d'abonnement
	public Eleve(String nom, String prenom, int solde, int abonnement) {
		super(nom,prenom);
		this.solde=solde;
		this.activites=activites;
		this.abonnement=abonnement;
	}
	public int getSolde() {
		return solde;
	}
	public void setSolde(int solde) {
		this.solde = solde;
	}
	
	public ArrayList<Activite> getActivites(){
		return activites;
	}
	public int getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(int abonnement) {
		this.abonnement = abonnement;
	}
	public boolean addActivite(Activite activite) {
		if (activites.contains(activite)) {return false;}
		activites.add(activite);
		activite.addEleve(this);
		return true;
	}
	
	public boolean removeActivite(Activite activite) {
		if (!activites.contains(activite)) {return false;}
		activites.remove(activite);
		activite.removeEleve(this);
		return true;
	}
}
