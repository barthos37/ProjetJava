package vue;

import modele.*;
import controlleur.CalendrierControlleur;
import controlleur.Controlleur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class CalendrierVue extends JFrame {

	private JPanel contentPane;
	private CalendrierControlleur controle;
	private DefaultListModel contenuLst = new DefaultListModel ();
	private JList list;

	public void majLst(ArrayList<Jour<Date,Menu>> calendrier) {
		contenuLst.clear();
		for (Jour<Date,Menu> jour : calendrier) {
			contenuLst.addElement(jour.toString());
		}
	}
	

	
	public CalendrierVue(CalendrierControlleur controle, boolean employe) {
		this.controle=controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 271, 154);
		contentPane.add(scrollPane);
		
		list = new JList(contenuLst);
		scrollPane.setViewportView(list);
		
		JButton btnRetour;
		if (employe) btnRetour = new JButton("Déconnexion");
		else btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.retour();
			}
		});
		btnRetour.setBounds(10, 215, 89, 23);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel = new JLabel("Calendrier :");
		lblNewLabel.setBounds(10, 23, 107, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex()!=-1)
					controle.beginInfoJour(list.getSelectedIndex());
			}
		});
		btnInfo.setBounds(291, 19, 89, 23);
		contentPane.add(btnInfo);
		
		if (employe) {

			JButton btnAjouter = new JButton("Ajouter");
			btnAjouter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controle.beginAddJour();
				}
			});
			btnAjouter.setBounds(293, 57, 89, 23);
			contentPane.add(btnAjouter);
			
			JButton btnSupprimer = new JButton("Supprimer");
			btnSupprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (list.getSelectedIndex()!=-1)
						controle.delete(list.getSelectedIndex());
				}
			});
			btnSupprimer.setBounds(293, 99, 89, 23);
			contentPane.add(btnSupprimer);		

		}
	}

}
