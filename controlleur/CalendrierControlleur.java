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
		frm.setVisible(true);
	}
	public DefaultListModel getJours () {
		DefaultListModel l = new DefaultListModel();
		ArrayList<Jour<Date,Menu>> calendrier = cantine.getCalendrier();
		for (Jour<Date,Menu> jour : calendrier) {
			l.addElement(jour.getDate().toString()+ " : "+jour.getMenu().getNom());
		}
		
		return l;
	}
	public void retour () {
		frm.setVisible(false);
		controle.end();
	}
}
