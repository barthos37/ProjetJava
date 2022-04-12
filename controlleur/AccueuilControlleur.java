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
	
	public void beginCantineEmploye () { //lance le controlleur calendrier en mode employe
		frm.setVisible(false);
		new CalendrierControlleur(this,cantine,true);
	}
	
	public void connexion (String id, String mdp) {
		//test parent
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/bdd/parent/"+id+".bdd");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			reader.readLine();
			if (mdp.equals(reader.readLine())) {
				new CantineParentControlleur(this,new Parent(id),cantine);
				frm.setVisible(false);
			}
				
			fis.close();
		} catch (IOException e) {}
		//test employe
		try {
			fis = new FileInputStream("src/bdd/employe.bdd");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			String ligne;
			while((ligne=reader.readLine())!=null) {
				if(id.equals(ligne.split("\t")[0]) && mdp.equals(ligne.split("\t")[1])){
					frm.setVisible(false);
					new CalendrierControlleur(this,cantine,true);
				}
			}
				
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void end () {  //lorsqu'un controlleur fils est fini
		frm.setVisible(true);
	}
	public AccueuilControlleur () {
		frm = new AccueuilVue(this);
		frm.setVisible(true);
	}
}
