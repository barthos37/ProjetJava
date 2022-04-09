package controlleur;

import modele.*;
import modele.Parent;
import vue.InfoJourVue;

public class InfoJourControlleur {
	private InfoJourVue frm;
	private Jour jour;
	private CalendrierControlleur controle;
	
	public InfoJourControlleur(CalendrierControlleur controle, Jour jour) {
		this.jour=jour;
		this.controle = controle;
		frm = new InfoJourVue(this);
		frm.setVisible(true);
	}

	public Jour getJour () {
		return jour;
	}
	
	public void retour() {//on ferme la fenetre et on appelle controle.end qui réaffiche la fenetre d'accueil
		frm.setVisible(false);
		controle.end();
	}
}
