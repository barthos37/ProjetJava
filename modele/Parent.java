package modele;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Parent extends Personne {
	private String id;
	private ArrayList<Facture> factures;
	private ArrayList<Eleve> enfants = new ArrayList<Eleve>();
	private String mdp;

	public Parent(String id,String mdp) throws Exception { //envoie Exception si les identifiants ne correspondent pas
		super("","");
		this.id=id;
		FileInputStream fis;

			fis = new FileInputStream("src/bdd/parent/"+id+".bdd"); //envoie IOException si le fichier n'existe pas
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			String ligne=reader.readLine();
			this.setNom(ligne.split("\t")[0]);
			this.setPrenom(ligne.split("\t")[1]);
			
			if (mdp.equals(reader.readLine())) {
				this.mdp=mdp;
			}
			else {
				reader.close();
				fis.close();
				throw new Exception();
			}
			
			while ((ligne = reader.readLine())!=null) {
				enfants.add(new Eleve(ligne.split("\t")[0],ligne.split("\t")[1],0,Integer.parseInt(ligne.split("\t")[2])));
			}
			
			reader.close();
			fis.close();

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
	
	public void majParent () {//mise a jour de la bdd en réecrivant toutes les données
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
