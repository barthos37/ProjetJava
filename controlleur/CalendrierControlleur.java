package controlleur;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.DefaultListModel;

import modele.*;
import vue.CalendrierVue;

public class CalendrierControlleur {
	private CalendrierVue frm;	
	private Controlleur controle;
	private Cantine cantine;
	private boolean employe;
	
	
	public CalendrierControlleur(Controlleur c, Cantine cantine, boolean employe) {
		if (employe) this.controle=(AccueuilControlleur) c;
		else this.controle=(CantineParentControlleur) c;
		this.cantine=cantine;
		this.employe=employe;
		frm= new CalendrierVue (this, employe);
		frm.majLst(cantine.getCalendrier());
		frm.setVisible(true);
	}

	public void retour () {//on ferme la fenetre et on appelle controle.end qui réaffiche la fenetre précédente
		frm.setVisible(false);
		controle.end();
	}
	
	public void delete (int id) { //on supprimer le jour d'index id dans la liste et on met a jour la liste
		cantine.deleteJour(id);
		frm.majLst(cantine.getCalendrier());
	}
	public void end(){ //lorsqu'un controleur fils est fini
		frm.setVisible(true);
		frm.majLst(cantine.getCalendrier());
	}
	
	public void beginAddJour() {
		frm.setVisible(false);
		new AddJourControlleur(this,cantine);
	}
	
	public void beginInfoJour(int index) { //commence le controlleur infojour
		frm.setVisible(false);
		new InfoJourControlleur (this, cantine.getCalendrier().get(index));
	}
}
