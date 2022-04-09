package controlleur;
import java.util.Set;

import modele.*;
import vue.CantineParentVue;
import controlleur.AccueuilControlleur;
import controlleur.CalendrierControlleur;

public class CantineParentControlleur implements Controlleur{
	private CantineParentVue frm;
	private Parent p;
	private AccueuilControlleur controle;
	private Cantine cantine;
	
	public CantineParentControlleur(AccueuilControlleur controle, Parent p, Cantine cantine) {
		this.cantine=cantine;
		this.p=p;
		this.controle = controle;
		frm = new CantineParentVue(this);
		frm.majLst(p.getEnfants());
		frm.setVisible(true);
	}

	public void beginSetAbonnement(int id) {//on commence la fenetre de modification d'abonnement
		frm.setVisible(false);
		new AbonnementControlleur (this,p,id);
		
	}
	public void endSetAbonnement() { //la fenetre de modification d'abonnement est finie, on met a jour la vue et on l'a r�affiche
		frm.majLst(p.getEnfants());
		frm.setVisible(true);
	}
	
	public void beginCalendrier() {//on commence la fenetre calendrier
		frm.setVisible(false);
		new CalendrierControlleur (this,cantine,false);
	}
	
	public void retour() {//on ferme la fenetre et on appelle controle.end qui r�affiche la fenetre d'accueil
		frm.setVisible(false);
		controle.end();
	}
	public void end () {
		frm.setVisible(true);
	}
}