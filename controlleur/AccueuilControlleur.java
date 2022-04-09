package controlleur;
import vue.AccueuilVue;

import java.util.ArrayList;

import modele.*;

public class AccueuilControlleur implements Controlleur{
	
	private AccueuilVue frm;
	private Cantine cantine = new Cantine (0,0,"");
	private Parent p = new Parent("Martin", "Rodolphe", new ArrayList<Eleve>());
	
	public void beginCantineParent () { //lance le controlleur cantineParent
		frm.setVisible(false);
		new CantineParentControlleur(this,p,cantine);
	}

	public void beginCantineEmploye () { //lance le controlleur calendrier en mode employe
		frm.setVisible(false);
		new CalendrierControlleur(this,cantine,true);
	}
	public void end () {  //lorsqu'un controlleur fils est fini
		frm.setVisible(true);
	}
	public AccueuilControlleur () {
		frm = new AccueuilVue(this);
		frm.setVisible(true);
		
		
		//on déclare la base de donnée sous forme de variable
		Responsable r1 = new Responsable("nr1","pr1");
		Responsable r2 = new Responsable("nr2","pr2");
		
		Eleve e1 = new Eleve("ne1","pe1",0,new ArrayList<Activite>(),null);
		Eleve e2 = new Eleve("ne2","pe2",0,new ArrayList<Activite>(),null);
		
		Activite acti= new Activite ("hand","gymnase",20, new ArrayList<Responsable>(), new ArrayList<Eleve>());
		
		acti.addResponsables(r1);
		acti.addResponsables(r2);
		acti.addEleve(e2);
		acti.addEleve(e1);
		
		p.addEnfant(e1);
		p.addEnfant(e2);
		
		//cantine
		Aliment boeuf = new Aliment ("Boeuf Haché",new ArrayList<Allergene>());
		Aliment haricot = new Aliment ("Haricots rouges",new ArrayList<Allergene>());
		Aliment saucetomate = new Aliment ("Sauce tomate", new ArrayList<Allergene>());
		Aliment pate = new Aliment("Pate", new ArrayList<Allergene>());
		
		Menu chili = new Menu("Chili con carne",new ArrayList<Aliment>());
		chili.addAliment(boeuf);
		chili.addAliment(haricot);
		
		Menu bolo = new Menu("Pates bolo",new ArrayList<Aliment>());
		bolo.addAliment(boeuf);
		bolo.addAliment(saucetomate);
		bolo.addAliment(pate);
		
		ArrayList<Jour<Date,Menu>> calendrier = new ArrayList<Jour<Date,Menu>>();
		calendrier.add(new Jour(new Date(2022,8,9),bolo));
		calendrier.add(new Jour(new Date(2022,8,10),bolo));
		cantine.setCalendrier(calendrier);
	}

}
