package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import ImplementazionePDAO.QuizMultipliImplementazionePDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class CreaQuizM.
 */
public class CreaQuizM extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The text field. */
	private JTextField textField;
	
	/** The text field 1. */
	private JTextField textField_1;
	
	/** The text field 2. */
	private JTextField textField_2;
	
	/** The txt hhmmss. */
	private JTextField txtHhmmss;
	
	/** The text field 4. */
	private JTextField textField_4;
	
	/** The text field 5. */
	private JTextField textField_5;
	
	/** The text field 3. */
	private JTextField textField_3;
	
	/** The text field 6. */
	private JTextField textField_6;
	
	/** The controller. */
	static Controller controller;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					CreaQuizM frame = new CreaQuizM(controller, toString(), toString(), toString());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Apre il frame dove l'utente insegnante può creare nuovi quiz multipli.
	 *
	 * @param controller1 the controller 1
	 * @param identificativo the identificativo
	 * @param username the username
	 * @param password the password
	 */
	public CreaQuizM(Controller controller1, String identificativo, String username, String password) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(0, 20, 736, 44);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 0, 736, 44);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Identificativo insegnante:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 64, 214, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeTest = new JLabel("Domanda:");
		lblNomeTest.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeTest.setBounds(20, 151, 87, 19);
		contentPane.add(lblNomeTest);
		
		JLabel lblTempoProva = new JLabel("Materia:");
		lblTempoProva.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTempoProva.setBounds(20, 209, 142, 19);
		contentPane.add(lblTempoProva);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData.setBounds(0, 0, 87, 19);
		contentPane.add(lblData);
		
		textField = new JTextField();
		textField.setBounds(166, 152, 538, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(166, 181, 124, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(449, 181, 124, 19);
		contentPane.add(textField_2);
		
		txtHhmmss = new JTextField();
		txtHhmmss.setToolTipText("");
		txtHhmmss.setColumns(10);
		txtHhmmss.setBounds(165, 210, 539, 19);
		contentPane.add(txtHhmmss);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(165, 239, 539, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(165, 268, 539, 19);
		contentPane.add(textField_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 297, 539, 19);
		contentPane.add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(165, 326, 539, 19);
		contentPane.add(textField_6);
		
		JLabel lblCliccaPerContinuare = new JLabel("");
		lblCliccaPerContinuare.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliccaPerContinuare.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCliccaPerContinuare.setBounds(166, 355, 527, 19);
		contentPane.add(lblCliccaPerContinuare);
		JButton btnNewButton = new JButton("Crea Quiz Multiplo");
		JButton btnNewButton2 = new JButton("Esci");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				HomeInsegnante ti= new HomeInsegnante(controller1, identificativo, username, password);
				ti.show();
				dispose();
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(471, 384, 166, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton2.setBackground(Color.ORANGE);
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton2.setBounds(280, 384, 166, 21);
		contentPane.add(btnNewButton2);
		//btnNewButton2.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				QuizMultipliImplementazionePDAO q=new QuizMultipliImplementazionePDAO();
				try {
					q.InsertQM(textField.getText(),textField_1.getText(),textField_2.getText(),txtHhmmss.getText(),textField_4.getText(),textField_5.getText(),textField_3.getText(),textField_6.getText());
					lblCliccaPerContinuare.setText("Clicca ESCI per continuare");
					btnNewButton.setEnabled(false);
					btnNewButton.setText("Quiz Creato");
					
				} catch (Exception e1) {
					lblCliccaPerContinuare.setText("Inserire informazioni");
					btnNewButton2.setText("Esci");
					btnNewButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							HomeInsegnante ti= new HomeInsegnante(controller1, identificativo, username, password);
							ti.show();
							dispose();
						}
					});
					
					btnNewButton.setText("Riprova");
					
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("Informazioni quiz multiplo");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(166, 93, 538, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Punteggio bonus");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(20, 180, 124, 19);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Punteggio malus:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(304, 180, 142, 19);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblDataInizioIscrizioni = new JLabel("Risposta giusta");
		lblDataInizioIscrizioni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataInizioIscrizioni.setBounds(20, 238, 142, 19);
		contentPane.add(lblDataInizioIscrizioni);
		
		JLabel lblDataFineIscrizioni = new JLabel("Risposta Sbagliata");
		lblDataFineIscrizioni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataFineIscrizioni.setBounds(20, 267, 142, 19);
		contentPane.add(lblDataFineIscrizioni);
		
		
		
		JLabel lblDataFineIscrizioni_1 = new JLabel("Risposta Sbagliata");
		lblDataFineIscrizioni_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataFineIscrizioni_1.setBounds(20, 296, 142, 19);
		contentPane.add(lblDataFineIscrizioni_1);
		
		JLabel lblDataFineIscrizioni_2 = new JLabel("Risposta Sbagliata");
		lblDataFineIscrizioni_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataFineIscrizioni_2.setBounds(20, 325, 142, 19);
		contentPane.add(lblDataFineIscrizioni_2);
		
		
		
		
	}
}