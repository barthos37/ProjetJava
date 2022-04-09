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

public class AccueuilVue extends JFrame {

	private JPanel contentPane;
	private AccueuilControlleur controle;


	public AccueuilVue(Controlleur c) {
		controle=(AccueuilControlleur) c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCantineParent = new JButton("Cantine Parent");
		btnCantineParent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.beginCantineParent();
			}
		});
		btnCantineParent.setBounds(5, 5, 215, 256);
		contentPane.add(btnCantineParent);
		
		JButton btnCantineEmploye = new JButton("Cantine Employe");
		btnCantineEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.beginCantineEmploye();
			}
		});
		btnCantineEmploye.setBounds(219, 5, 215, 256);
		contentPane.add(btnCantineEmploye);
	}
}
