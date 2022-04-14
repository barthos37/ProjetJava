package controlleur;
import vue.AccueuilVue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modele.*;

public class AccueuilControlleur implements Controlleur{
	
	private AccueuilVue frm;
	private Cantine cantine = new Cantine ();
	
	public AccueuilControlleur () {
		frm = new AccueuilVue(this);
		frm.setVisible(true);
	}
	
	public void beginCantineEmploye () { //lance le controlleur calendrier en mode employe
		frm.setVisible(false);
		new CalendrierControlleur(this,cantine,true);
	}
	
	public void connexion (String id, String mdp) {
		//test parent
		try {
			Parent p = new Parent(id,mdp); //si un compte n'existe pas, soulève Exception
			new CantineParentControlleur(this,p,cantine);
			frm.setVisible(false);
		} catch (Exception e) {}
		//test employe
		if (cantine.testConnexionEmploye(id, mdp)){
			frm.setVisible(false);
			new CalendrierControlleur(this,cantine,true);
		}
	}
	public void end () {  //appelé lorsqu'un controlleur fils est fini
		frm.setVisible(true);
	}

}
