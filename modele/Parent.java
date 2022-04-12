package modele;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Parent extends Personne {
	private String id;
	private ArrayList<Facture> factures;
	private ArrayList<Eleve> enfants = new ArrayList<Eleve>();
	private String mdp;

	public Parent(String id) {
		super("","");
		this.enfants=enfants;
		this.id=id;
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/bdd/parent/"+id+".bdd");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			String ligne=reader.readLine();
			this.setNom(ligne.split("\t")[0]);
			this.setPrenom(ligne.split("\t")[1]);
			
			mdp=reader.readLine();
			
			while ((ligne = reader.readLine())!=null) {
				enfants.add(new Eleve(ligne.split("\t")[0],ligne.split("\t")[1],0,Integer.parseInt(ligne.split("\t")[2])));
			}
			
			reader.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean addEnfant(Eleve enfant) {
		return this.enfants.add(enfant);
	}
	
	public boolean removeEnfant(Eleve enfant) {
		return this.enfants.remove(enfant);
	}
	
	public boolean addFacture(Facture facture) {
		return this.factures.add(facture);
	}
	
	public boolean removeFacture(Facture facture) {
		return this.factures.remove(facture);
	}
	
	public ArrayList<Eleve> getEnfants(){
		return enfants;
	}

	public void setEnfants(int idEnfant,Eleve enfant){
		this.enfants.set(idEnfant, enfant);
	}
	
	public void majParent () {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/bdd/parent/"+id+".bdd"));
			
			writer.write(this.getNom()+"\t"+this.getPrenom()+"\n");
			writer.write(mdp);			
			for (Eleve enfant : enfants) {
				writer.write("\n");
				writer.write(enfant.getNom()+"\t"+enfant.getPrenom()+"\t"+enfant.getAbonnement());				
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}