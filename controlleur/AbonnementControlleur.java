package controlleur;

import java.util.ArrayList;

import modele.*;
import vue.AbonnementVue;

public class AbonnementControlleur {
	private AbonnementVue frm;
	private Parent p;
	private CantineParentControlleur controle;
	private int idEnfant;
	
	private ArrayList<Abonnement> lstAbonnement = new ArrayList<Abonnement>(); //liste des abonnements possibles
	
	
	public AbonnementControlleur(CantineParentControlleur controle, Parent p, int idEnfant) {
		lstAbonnement.add(new Abonnement("Demi-Pensionnaire", "Mange juste le midi"));
		lstAbonnement.add(new Abonnement("Pensionnaire", "Mange le midi et le soir"));
		lstAbonnement.add(new Abonnement("A la carte", "Payer à chaque repas"));
		
		this.p=p;
		this.controle=controle;
		this.idEnfant=idEnfant;
		
		frm= new AbonnementVue (this,lstAbonnement);
		frm.setVisible(true);
	}
	public Abonnement getAbonnement () {
		return p.getEnfants().get(idEnfant).getAbonnement();
	}
	public void retour (int idAbonnement) { //fermeture de la fenetre, on met à jour l'abonnement dans p.enfants
		Eleve enfant = p.getEnfants().get(idEnfant);
		enfant.setAbonnement(lstAbonnement.get(idAbonnement));
		p.setEnfants(idEnfant, enfant);
		frm.setVisible(false);
		controle.endSetAbonnement();
	}
}
