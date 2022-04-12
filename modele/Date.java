package modele;

import java.util.Objects;

public class Date {
	private int annee;
	private int mois;
	private int jour;
	public Date(int annee, int mois, int jour) {
		this.annee = annee;
		this.mois = mois;
		this.jour = jour;
	}
	
	public String toString () {
		String ligne = "";
		ligne+=jour;
		switch(mois) {
			case 1 : ligne+=" Janvier ";break;
			case 2 : ligne+=" Fevrier ";break;
			case 3 : ligne+=" Mars ";break;
			case 4 : ligne+=" Avril ";break;
			case 5 : ligne+=" Mai ";break;
			case 6 : ligne+=" Juin ";break;
			case 7 : ligne+=" Juillet ";break;
			case 8 : ligne+=" Aout ";break;
			case 9 : ligne+=" Septembre ";break;
			case 10 : ligne+=" Octobre ";break;
			case 11 : ligne+=" Novembre ";break;
			case 12 : ligne+=" Décembre ";break;
		}
		ligne+=annee;
		return ligne;
	}
	
	
	public int getAnnee() {
		return annee;
	}

	public int getMois() {
		return mois;
	}

	public int getJour() {
		return jour;
	}

	@Override
	public int hashCode() {
		return Objects.hash(annee, jour, mois);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return annee == other.annee && jour == other.jour && mois == other.mois;
	}
	
}
