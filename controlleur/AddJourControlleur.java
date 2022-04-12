package controlleur;

import java.util.ArrayList;

import modele.*;
import vue.AddJourVue;

public class AddJourControlleur {
	private AddJourVue frm;
	private CalendrierControlleur controle;
	private Cantine cantine;
	
	private ArrayList<Aliment> lstIngredients;; //liste des ingredients possibles
	
	public AddJourControlleur(CalendrierControlleur controle, Cantine cantine) { 
		this.cantine=cantine;
		this.controle = controle;
		lstIngredients = cantine.getLstIngredient();
		
		frm = new AddJourVue(this);
		frm.setVisible(true);
		
	}
	
	public void annule() {//on ferme la fenetre et on appelle controle.end qui r�affiche la fenetre d'accueil
		frm.setVisible(false);
		controle.end();
	}
	
	public ArrayList<Aliment> getLstIngredients (){
		return lstIngredients;
	}
	
	public void confirme (String nom, int[] ingredients,Date date) { //on ajoute le jour et on ferme la fenetre
		Menu menu = new Menu(nom,new ArrayList<Aliment>());
		for (int i : ingredients) {
			menu.addAliment(lstIngredients.get(i));
		}
		cantine.addJour(new Jour (date,menu));
		
		frm.setVisible(false);
		controle.end();
	}
}
