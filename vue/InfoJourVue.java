package vue;
import controlleur.InfoJourControlleur;
import modele.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class InfoJourVue extends JFrame {

	private JPanel contentPane;
	private InfoJourControlleur controle;
	private Jour jour;
	
	public InfoJourVue(InfoJourControlleur controle) {
		this.controle=controle;
		jour=controle.getJour();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("Date : "+jour.getDate().toString());
		lblDate.setBounds(10, 11, 265, 14);
		contentPane.add(lblDate);
		
		JLabel lblMenu = new JLabel("Menu : "+jour.getMenu().getNom());
		lblMenu.setBounds(10, 36, 162, 14);
		contentPane.add(lblMenu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 279, 130);
		contentPane.add(scrollPane);
		
		DefaultListModel contenuLst = new DefaultListModel ();
		for (Aliment ingredient : jour.getMenu().getAliments()) {
			contenuLst.addElement(ingredient.getNom());
		}
		
		JList list = new JList(contenuLst);
		scrollPane.setViewportView(list);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.retour();
			}
		});
		btnRetour.setBounds(20, 227, 89, 23);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel = new JLabel("Ingrédients :");
		lblNewLabel.setBounds(10, 61, 99, 14);
		contentPane.add(lblNewLabel);
	}
}
