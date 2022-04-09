package modele;
import java.util.ArrayList;

public class Cantine {
	private ArrayList<Jour<Date,Menu>> calendrier=new ArrayList<Jour<Date,Menu>>(); 
	private int heureOuverture;
	private int heureFermeture;
	private String lieu;
	public Cantine(int heureOuverture, int heureFermeture, String lieu) {
		this.heureOuverture = heureOuverture;
		this.heureFermeture = heureFermeture;
		this.lieu = lieu;
	}
	public int getHeureOuverture() {
		return heureOuverture;
	}
	public void setHeureOuverture(int heureOuverture) {
		this.heureOuverture = heureOuverture;
	}
	public int getHeureFermeture() {
		return heureFermeture;
	}
	public void setHeureFermeture(int heureFermeture) {
		this.heureFermeture = heureFermeture;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	public void setCalendrier (ArrayList<Jour<Date,Menu>> calendrier) {
		this.calendrier=calendrier;
	}
	
	public ArrayList<Jour<Date,Menu>> getCalendrier (){
		return calendrier;
	}
}
