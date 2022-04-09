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

	public void beginSetAbonnement(int id) {
		frm.setVisible(false);
		new AbonnementControlleur (this,p,id);
		
	}
	public void endSetAbonnement() {
		frm.majLst(p.getEnfants());
		frm.setVisible(true);
	}
	
	public void beginCalendrier() {
		frm.setVisible(false);
		new CalendrierControlleur (this,cantine,false);
	}
	
	public void retour() {
		frm.setVisible(false);
		controle.end();
	}
	public void end () {
		frm.setVisible(true);
	}
}
