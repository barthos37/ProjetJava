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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalendrierVue extends JFrame {

	private JPanel contentPane;
	private CalendrierControlleur controle;
	
	public CalendrierVue(CalendrierControlleur controle, boolean employe) {
		this.controle=controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 271, 183);
		contentPane.add(scrollPane);
		
		JList list = new JList(controle.getJours());
		scrollPane.setViewportView(list);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.retour();
			}
		});
		btnRetour.setBounds(10, 227, 89, 23);
		contentPane.add(btnRetour);
		
		if (employe) {
			JButton btnModifier = new JButton("Modifier");
			btnModifier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnModifier.setBounds(293, 19, 89, 23);
			contentPane.add(btnModifier);
			
			JButton btnAjouter = new JButton("Ajouter");
			btnAjouter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAjouter.setBounds(293, 57, 89, 23);
			contentPane.add(btnAjouter);
			
			JButton btnSupprimer = new JButton("Supprimer");
			btnSupprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSupprimer.setBounds(293, 99, 89, 23);
			contentPane.add(btnSupprimer);
		}
	}

}
