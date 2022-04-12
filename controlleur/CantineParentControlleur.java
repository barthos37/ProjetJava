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
		new AbonnementControlleur (this,p,id,cantine.getLstAbonnement());
		
	}
	public void endSetAbonnement() { //la fenetre de modification d'abonnement est finie, on met a jour la vue et on l'a réaffiche
		frm.majLst(p.getEnfants());
		frm.setVisible(true);
	}
	
	public void beginCalendrier() {//on commence la fenetre calendrier
		frm.setVisible(false);
		new CalendrierControlleur (this,cantine,false);
	}
	
	public String getLieu () {
		return cantine.getLieu();
	}
	
	public String[] getHoraires () {
		String[] horaires= new String[2];
		horaires[0]=(cantine.getHeureOuverture()/100)+"h"+(cantine.getHeureOuverture()%100);
		horaires[1]=(cantine.getHeureFermeture()/100)+"h"+(cantine.getHeureFermeture()%100);
		return horaires;
	}
	
	public Abonnement getAbonnement(int idAbonnement) {
		return cantine.getLstAbonnement().get(idAbonnement);
	}
	
	public String getNomPrenom () {
		return p.toString();
	}
	
	public void retour() {//on ferme la fenetre et on appelle controle.end qui réaffiche la fenetre d'accueil
		frm.setVisible(false);
		controle.end();
	}
	public void end () {
		frm.setVisible(true);
	}
}