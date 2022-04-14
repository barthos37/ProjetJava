package controlleur;

import java.util.ArrayList;

import modele.*;
import vue.AbonnementVue;

public class AbonnementControlleur {
	private AbonnementVue frm;
	private Parent p;
	private CantineParentControlleur controle;
	private int idEnfant;
	
	private ArrayList<Abonnement> lstAbonnement; //liste des abonnements possibles
	
	
	public AbonnementControlleur(CantineParentControlleur controle, Parent p, int idEnfant,ArrayList<Abonnement> lstAbonnement) {
		
		this.p=p;
		this.controle=controle;
		this.idEnfant=idEnfant;
		this.lstAbonnement=lstAbonnement;
		
		frm= new AbonnementVue (this,lstAbonnement);
		frm.setVisible(true);
	}
	public Abonnement getAbonnement () {
		return lstAbonnement.get(p.getEnfants().get(idEnfant).getAbonnement());
	}
	public void retour (int idAbonnement) { //fermeture de la fenetre, on met à jour l'abonnement dans p.enfants
		Eleve enfant = p.getEnfants().get(idEnfant);
		enfant.setAbonnement(idAbonnement);
		p.setEnfants(idEnfant, enfant);
		
		frm.setVisible(false);
		controle.endSetAbonnement();
	}
}
