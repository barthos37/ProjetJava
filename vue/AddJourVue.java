package vue;

import modele.*;
import controlleur.AddJourControlleur;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AddJourVue extends JFrame {

	private JPanel contentPane;
	private AddJourControlleur controle;
	private JTextField textAnnee;
	private JTextField textMois;
	private JTextField textJour;
	private JTextField textNom;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	public AddJourVue(AddJourControlleur controle) {
		this.controle=controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAnnee = new JTextField();
		textAnnee.setBounds(244, 48, 80, 20);
		contentPane.add(textAnnee);
		textAnnee.setColumns(10);
		
		textMois = new JTextField();
		textMois.setBounds(244, 29, 80, 20);
		contentPane.add(textMois);
		textMois.setColumns(10);
		
		textJour = new JTextField();
		textJour.setBounds(244, 11, 80, 20);
		contentPane.add(textJour);
		textJour.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 85, 225, 165);
		contentPane.add(scrollPane);
		
		DefaultListModel contenuLst = new DefaultListModel ();
		for (Aliment ingredient : controle.getLstIngredients()) {
			contenuLst.addElement(ingredient.getNom());
		}
		JList list = new JList(contenuLst);
		scrollPane.setViewportView(list);
		
		JButton btnValider = new JButton("Confirmer");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.confirme(textNom.getText(),list.getSelectedIndices(),
						new Date(Integer.valueOf(textAnnee.getText()),Integer.valueOf(textMois.getText()),Integer.valueOf(textJour.getText())));
			}
		});
		btnValider.setBounds(258, 124, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.annule();
			}
		});
		btnAnnuler.setBounds(258, 158, 89, 23);
		contentPane.add(btnAnnuler);
		
		textNom = new JTextField();
		textNom.setBounds(20, 29, 86, 20);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		lblNewLabel = new JLabel("Nom menu :");
		lblNewLabel.setBounds(20, 14, 122, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Ingrédients :");
		lblNewLabel_1.setBounds(20, 70, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Jour :");
		lblNewLabel_2.setBounds(188, 14, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mois :");
		lblNewLabel_3.setBounds(188, 32, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Année :");
		lblNewLabel_4.setBounds(188, 51, 46, 14);
		contentPane.add(lblNewLabel_4);
	}
}
