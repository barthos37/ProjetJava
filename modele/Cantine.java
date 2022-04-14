package modele;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cantine {
	private ArrayList<Jour<Date,Menu>> calendrier=new ArrayList<Jour<Date,Menu>>(); 
	private int heureOuverture;
	private int heureFermeture;
	private String lieu;
	public Cantine() { //charge le fichier cantine.bdd
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/bdd/cantine.bdd");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			String heures[] = reader.readLine().split("\t");
			heureOuverture = Integer.parseInt(heures[0]);
			heureFermeture = Integer.parseInt(heures[1]);
			
			lieu = reader.readLine();
			
			String ligne;
			while ((ligne = reader.readLine())!=null) {
				String elements[] = ligne.split("\t");
				Date date = new Date(Integer.parseInt(elements[0]),Integer.parseInt(elements[1]),Integer.parseInt(elements[2]));
				ArrayList<Aliment> ingredients = new ArrayList<Aliment>();
				for (int i=4;i<elements.length;i++) {
					ingredients.add(new Aliment(elements[i],new ArrayList<Allergene>()));
				}
				calendrier.add(new Jour(date,new Menu(elements[3],ingredients)));
			}
			reader.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getHeureOuverture() {
		return heureOuverture;
	}
	public int getHeureFermeture() {
		return heureFermeture;
	}
	public String getLieu() {
		return lieu;
	}
	public ArrayList<Jour<Date,Menu>> getCalendrier (){
		return calendrier;
	}

	public void deleteJour(int index) {
		calendrier.remove(index);
		majBdd();
	}
	public Jour getJour(int index) {
		return calendrier.get(index);
	}
	public void addJour (Jour jour) {
		calendrier.add(jour);
		majBdd();
	}
	
	public ArrayList<Abonnement> getLstAbonnement (){ //retourn liste de abonnement.bdd
		ArrayList<Abonnement>l =new ArrayList<Abonnement>();
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("src/bdd/abonnement.bdd");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			String ligne;
			while((ligne=reader.readLine())!=null) {
				l.add(new Abonnement(ligne.split("\t")[0],ligne.split("\t")[1]));
			}
			
			fis.close();
			reader.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}
	
	public ArrayList<Aliment> getLstIngredient (){//retourne la liste de aliment.bdd
		ArrayList<Aliment>l =new ArrayList<Aliment>();
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("src/bdd/aliment.bdd");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			String ligne;
			while((ligne=reader.readLine())!=null) {
				l.add(new Aliment(ligne,new ArrayList<Allergene>()));
			}
			
			fis.close();
			reader.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}
	
	public boolean testConnexionEmploye (String id, String mdp) {
		try {
			FileInputStream fis = new FileInputStream("src/bdd/employe.bdd");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			
			String ligne;
			while((ligne=reader.readLine())!=null) {
				if(id.equals(ligne.split("\t")[0]) && mdp.equals(ligne.split("\t")[1])){
					return true;
				}
			}
				
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void majBdd () { //actualise le fichier cantine.bdd en réécrivant tout
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/bdd/cantine.bdd"));
			
			writer.write(heureOuverture+"\t"+heureFermeture+"\n");
			writer.write(lieu);			
			for (Jour jour : calendrier) {
				writer.write("\n");
				Date date=jour.getDate();
				Menu menu=jour.getMenu();
				writer.write(date.getAnnee()+"\t"+date.getMois()+"\t"+date.getJour()+"\t"+menu.getNom());
				for (Aliment ingredient : menu.getAliments()) {
					writer.write("\t"+ingredient.getNom());
				}
				
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
