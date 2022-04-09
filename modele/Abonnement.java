package modele;

public class Abonnement {
	private String nom;
	private String descprition;
	public Abonnement(String nom, String descprition) {
		this.nom = nom;
		this.descprition = descprition;
	}
	public String getNom() {
		return nom;
	}
	public void setType(String nom) {
		this.nom = nom;
	}
	public String getDescprition() {
		return descprition;
	}
	public void setDescprition(String descprition) {
		this.descprition = descprition;
	}
}
