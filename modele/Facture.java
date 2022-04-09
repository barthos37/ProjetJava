package modele;
import java.util.Date;

public class Facture {
	private int somme;
	private Date date;
	private String description;
	public Facture(int somme, Date date) {
		this.somme = somme;
		this.date = date;
	}
	public int getSomme() {
		return somme;
	}
	public void setSomme(int somme) {
		this.somme = somme;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}