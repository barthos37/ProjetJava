package vue;
import controlleur.CantineParentControlleur;

import modele.*;

import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CantineParentVue extends JFrame {

	private JPanel contentPane;
	private CantineParentControlleur controle;
	private DefaultListModel contenuLst = new DefaultListModel ();
	private JList listEnfants;

	/**
	 * Create the frame.
	 */
	
	public void majLst(ArrayList<Eleve> enfants) {
		contenuLst.clear();
		for (Eleve e : enfants) {
			String ligne = e.getNom()+" "+e.getPrenom()+ " : ";
			if (e.getAbonnement() == null){
				ligne+="Aucun abbonement";
			}else {
				ligne+=e.getAbonnement().getNom();
			}
			contenuLst.addElement(ligne);
		}
	}
	
	public CantineParentVue(CantineParentControlleur controle) {
		this.controle=controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelEnfants = new JLabel("Enfants :");
		labelEnfants.setBounds(10, 32, 55, 20);
		contentPane.add(labelEnfants);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 283, 135);
		contentPane.add(scrollPane);
		
		listEnfants = new JList(contenuLst);
		scrollPane.setViewportView(listEnfants);
		
		JButton btnMenu = new JButton("Afficher menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.beginCalendrier();
			}
		});
		btnMenu.setBounds(303, 51, 126, 23);
		contentPane.add(btnMenu);
		
		JButton btnMod = new JButton("Modifier Abonnement");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.beginSetAbonnement(listEnfants.getSelectedIndex());
			}
		});
		btnMod.setBounds(303, 85, 126, 23);
		contentPane.add(btnMod);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.retour();
			}
		});
		btnRetour.setBounds(303, 119, 126, 23);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel = new JLabel("La cantine se situe 12 Rue Victor Hugo");
		lblNewLabel.setBounds(10, 199, 315, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Elle ouvre de 12h à 13h30 du lundi au vendredi");
		lblNewLabel_1.setBounds(10, 230, 315, 14);
		contentPane.add(lblNewLabel_1);
	}
}
