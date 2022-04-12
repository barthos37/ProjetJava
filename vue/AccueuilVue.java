package vue;
import modele.*;
import controlleur.AccueuilControlleur;
import controlleur.Controlleur;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AccueuilVue extends JFrame {

	private JPanel contentPane;
	private AccueuilControlleur controle;
	private JTextField textId;
	private JTextField textMdp;


	public AccueuilVue(Controlleur c) {
		controle=(AccueuilControlleur) c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setBounds(10, 11, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Identifiant");
		lblNewLabel_1.setBounds(10, 69, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe");
		lblNewLabel_2.setBounds(10, 117, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		textId = new JTextField();
		textId.setBounds(95, 66, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textMdp = new JTextField();
		textMdp.setBounds(95, 114, 86, 20);
		contentPane.add(textMdp);
		textMdp.setColumns(10);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.connexion(textId.getText(), textMdp.getText());
			}
		});
		btnConnexion.setBounds(92, 168, 89, 23);
		contentPane.add(btnConnexion);
	}
}
