package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class AccessoPrincipale: viene aperto un frame dove l'utente può accedere con le proprie credenziali, oppure registrarsi.
.
 */
public class AccessoPrincipale extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The text field (username). */
	private JTextField textField;
	
	/** The controller. */
	static Controller controller;
	
	/** The password field. */
	private JPasswordField passwordField;

		/**
		 * The main method.
		 *
		 * @param args the arguments
		 */
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessoPrincipale frame = new AccessoPrincipale(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Instantiates a new accesso principale: viene aperto un frame dove l'utente può accedere con le proprie credenziali, oppure registrarsi.
	 * Se l'utente accede viene effettuato un controllo sulla consistenza dei dati; se si registra, l'utente verrà reindirizzato alla pagina di registrazione;
	 * @param controller the controller
	 */
	public AccessoPrincipale(Controller controller) {
		setTitle("Benvenuto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 359);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 10, 497, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Piattaforma di e-Learning ErBi");
		lblNewLabel.setBounds(0, 0, 494, 51);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pagina di accesso alla piattaforma");
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 71, 487, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(25, 144, 124, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(25, 187, 124, 22);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(186, 144, 294, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2_1.setBounds(25, 227, 462, 22);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Registrati");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrazione reg= new Registrazione(controller);
				reg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(186, 289, 112, 22);
		contentPane.add(btnNewButton);
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 187, 294, 26);
		contentPane.add(passwordField);
		
		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String stud = username.substring(0,5);
				String ins= username.substring(0,4);

				if(stud.equals("stud_")) {
				try {
					controller.accediStudente(username, passwordField.getText());
					HomeStudente homestudente=new HomeStudente(controller, controller.getIdStudente(username, passwordField.getText()),controller.getUsernameStudente(),controller.getPasswordStudente());
					controller.getIdStudente(username, passwordField.getText());

					String usernameS;
					usernameS=controller.getUsernameStudente();
					homestudente.setTitle(usernameS.substring(5)+ " è online");
					homestudente.show();
					dispose();
				} catch (Exception e1) {
					lblNewLabel_2_1.setText("Username o Password errata");
					e1.printStackTrace();
					
				}
				
				} else 	if(ins.equals("ins_")) {
					try {
						controller.accediInsegnante(username, passwordField.getText());
						HomeInsegnante homeinsegnante=new HomeInsegnante(controller, controller.getIdInsegnante(username, passwordField.getText()),controller.getUsernameInsegnante(),controller.getPasswordInsegnante());
						String usernameI;
						usernameI=controller.getUsernameInsegnante();
						homeinsegnante.setTitle(usernameI.substring(4)+ " è online ");
						homeinsegnante.show();
						dispose();
					} catch (Exception e1) {
						lblNewLabel_2_1.setText("Username o Password errata");
						e1.printStackTrace();
					}
					
					}else {
						lblNewLabel_2_1.setText("Username o Password errata");
					
					}
				}

		});
		btnAccedi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAccedi.setBackground(Color.ORANGE);
		btnAccedi.setBounds(186, 257, 112, 22);
		contentPane.add(btnAccedi);


	}
}
