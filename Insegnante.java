package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.postgresql.util.PSQLException;

import Controller.Controller;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Label;

// TODO: Auto-generated Javadoc
/**
 * The Class Insegnante: Apre il frame di registrazione utente insegnante.
 */
public class Insegnante extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The text field 3. */
	private JTextField textField_3;
	
	/** The txt stud. */
	private JTextField txtStud;
	
	/** The text field 1. */
	private JTextField textField_1;
	
	/** The text field 2. */
	private JTextField textField_2;
	
	/** The controller. */
	static Controller controller1;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studente frame = new Studente(controller1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiates a new Insegnante: Apre il frame di registrazione utente insegnante.
	 *
	 * @param controller the controller
	 */

public Insegnante(Controller controller) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 750, 450);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.RED);
	panel.setBounds(0, 10, 736, 61);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Benevenuti nella sezione insegnante");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblNewLabel.setBounds(0, 10, 736, 41);
	panel.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Inserire i dati richiesti");
	lblNewLabel_1.setForeground(Color.BLACK);
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
	lblNewLabel_1.setBounds(93, 81, 547, 36);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_5 = new JLabel("Nome");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_5.setBackground(Color.RED);
	lblNewLabel_5.setBounds(126, 134, 115, 24);
	contentPane.add(lblNewLabel_5);
	
	JLabel lblNewLabel_5_1 = new JLabel("Cognome");
	lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_5_1.setBackground(Color.RED);
	lblNewLabel_5_1.setBounds(126, 168, 115, 24);
	contentPane.add(lblNewLabel_5_1);
	
	JLabel lblNewLabel_6_1 = new JLabel("");
	lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_6_1.setBounds(126, 312, 514, 22);
	contentPane.add(lblNewLabel_6_1);
	
	JButton btnCliccaPerProseguire = new JButton("Clicca per registrarti");
	btnCliccaPerProseguire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				controller.nuovoInsegnante(txtStud.getText(),textField_2.getText(),textField_3.getText(),textField_1.getText());
				Messaggio mes=new Messaggio(controller);
				mes.show();
				dispose();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				lblNewLabel_6_1.setText("Username o Password errata");
				e1.printStackTrace();
				btnCliccaPerProseguire.setText("Riprova");
				
				e1.printStackTrace();
			}
			
		}
	});
	btnCliccaPerProseguire.setForeground(Color.BLACK);
	btnCliccaPerProseguire.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnCliccaPerProseguire.setBackground(Color.ORANGE);
	btnCliccaPerProseguire.setBounds(295, 357, 214, 24);
	contentPane.add(btnCliccaPerProseguire);
	
	textField_3 = new JTextField();
	textField_3.setHorizontalAlignment(SwingConstants.CENTER);
	textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	textField_3.setColumns(10);
	textField_3.setBounds(324, 136, 316, 25);
	contentPane.add(textField_3);
	
	txtStud = new JTextField();
	txtStud.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	txtStud.setColumns(10);
	txtStud.setBounds(364, 204, 276, 25);
	contentPane.add(txtStud);
	
	textField_1 = new JTextField();
	textField_1.setHorizontalAlignment(SwingConstants.CENTER);
	textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	textField_1.setColumns(10);
	textField_1.setBounds(324, 170, 316, 25);
	contentPane.add(textField_1);
	
	JLabel lblNewLabel_5_3 = new JLabel("Username");
	lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_5_3.setBackground(Color.RED);
	lblNewLabel_5_3.setBounds(126, 202, 115, 24);
	contentPane.add(lblNewLabel_5_3);
	
	JLabel lblNewLabel_6 = new JLabel("Password");
	lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_6.setBounds(126, 242, 97, 22);
	contentPane.add(lblNewLabel_6);
	
	textField_2 = new JTextField();
	textField_2.setHorizontalAlignment(SwingConstants.CENTER);
	textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	textField_2.setColumns(10);
	textField_2.setBounds(324, 243, 316, 25);
	contentPane.add(textField_2);
	
	JLabel lblNewLabel_2 = new JLabel("ins_");
	lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblNewLabel_2.setBounds(324, 204, 45, 22);
	contentPane.add(lblNewLabel_2);
	
	Label label = new Label("Username e Password 8-50 caratteri");
	label.setBounds(295, 285, 229, 21);
	contentPane.add(label);
	
	
}
}