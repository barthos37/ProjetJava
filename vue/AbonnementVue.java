package vue;
import modele.*;
import controlleur.AbonnementControlleur;
import controlleur.Controlleur;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbonnementVue extends JFrame {

	private JPanel contentPane;
	private AbonnementControlleur controle;
	private DefaultListModel contenuLst = new DefaultListModel ();
	private JList list;
	
	
	public AbonnementVue(AbonnementControlleur controle, ArrayList<Abonnement> lstAbonnement) {
		this.controle=controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Abbonement actuel : ");
		lblNewLabel.setBounds(5, 5, 145, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 62, 375, 128);
		contentPane.add(scrollPane);
		
		for (Abonnement a : lstAbonnement) {
			contenuLst.addElement(a.getNom()+ " : "+a.getDescprition());
		}
		list = new JList(contenuLst);
		scrollPane.setViewportView(list);
		
		JLabel lblAbonnement;
		if (controle.getAbonnement()!=null) lblAbonnement = new JLabel(controle.getAbonnement().getNom());
		else lblAbonnement = new JLabel("Aucun");
		lblAbonnement.setBounds(5, 24, 300, 14);
		contentPane.add(lblAbonnement);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()!=-1)
					controle.retour(list.getSelectedIndex());
			}
		});
		btnConfirmer.setBounds(10, 201, 89, 23);
		contentPane.add(btnConfirmer);
	}
}
