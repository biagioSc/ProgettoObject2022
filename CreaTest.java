package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import ImplementazionePDAO.QuizMultipliImplementazionePDAO;
import ImplementazionePDAO.TestImplementazionePDAO;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

// TODO: Auto-generated Javadoc
/**
 * The Class CreaTest.
 */
public class CreaTest extends JFrame {

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
					CreaTest frame = new CreaTest(controller, toString(), toString(), toString());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Apre il frame dove l'utente insegnante può creare nuovi test.
	 *
	 * @param controller1 the controller 1
	 * @param identificativo the identificativo
	 * @param username the username
	 * @param password the password
	 */
	public CreaTest(Controller controller1, String identificativo, String username, String password) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 459);
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
		lblNewLabel_1.setBounds(0, 0, 736, 39);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Identificativo insegnante:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 64, 214, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeTest = new JLabel("Nome Test:");
		lblNomeTest.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeTest.setBounds(20, 167, 87, 19);
		contentPane.add(lblNomeTest);
		
		JLabel lblTempoProva = new JLabel("Durata(minuti):");
		lblTempoProva.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTempoProva.setBounds(20, 251, 142, 19);
		contentPane.add(lblTempoProva);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData.setBounds(0, 0, 87, 19);
		contentPane.add(lblData);
		
		JLabel lblCliccaPerContinuare = new JLabel("");
		lblCliccaPerContinuare.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliccaPerContinuare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliccaPerContinuare.setBounds(175, 393, 561, 19);
		contentPane.add(lblCliccaPerContinuare);
		
		textField = new JTextField();
		textField.setBounds(165, 168, 561, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 193, 561, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(251, 222, 475, 19);
		contentPane.add(textField_2);
		
		txtHhmmss = new JTextField();
		txtHhmmss.setToolTipText("");
		txtHhmmss.setColumns(10);
		txtHhmmss.setBounds(251, 252, 475, 19);
		contentPane.add(txtHhmmss);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(339, 280, 387, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(339, 309, 387, 19);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Crea Test");
		JButton btnNewButton2 = new JButton("Esci");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				HomeInsegnante ti= new HomeInsegnante(controller1,identificativo, username, password);
				ti.show();
				dispose();		
				}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(469, 362, 214, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton2.setBackground(Color.ORANGE);
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton2.setBounds(269, 362, 166, 21);
		contentPane.add(btnNewButton2);
		//btnNewButton2.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				TestImplementazionePDAO q=new TestImplementazionePDAO();
				try {
					q.InsertT(identificativo,textField.getText(),textField_1.getText(),textField_2.getText(),txtHhmmss.getText(),textField_4.getText(),textField_5.getText());
					lblCliccaPerContinuare.setText("Test Creato");
					btnNewButton.setEnabled(false);
					Window frame = null;
					JFrame frameRisultati;
					JFrame frameRisultati2;
					try {
						setVisible(false);
						frameRisultati = new AmmQMT(controller1,frame,username,password,identificativo);
						frameRisultati2 = new AmmQAT(controller1,frame,username,password,identificativo);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} catch (Exception e1) {
					lblCliccaPerContinuare.setText("Controllare informazioni");
					
					
					btnNewButton.setText("Riprova");
					
					e1.printStackTrace();
				}
			}
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("Informazioni test");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(165, 111, 561, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Soglia superamento:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(20, 193, 134, 19);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Data (yyyy-mm-dd hh:mm:ss):");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(20, 222, 221, 19);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblDataInizioIscrizioni = new JLabel("Data inizio iscrizioni (yyyy-mm-dd hh:mm:ss):");
		lblDataInizioIscrizioni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataInizioIscrizioni.setBounds(20, 280, 292, 19);
		contentPane.add(lblDataInizioIscrizioni);
		
		JLabel lblDataFineIscrizioni = new JLabel("Data fine iscrizioni (yyyy-mm-dd hh:mm:ss):");
		lblDataFineIscrizioni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataFineIscrizioni.setBounds(20, 309, 272, 19);
		contentPane.add(lblDataFineIscrizioni);
		
		JLabel lblData_1 = new JLabel("");
		lblData_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData_1.setBounds(46, 0, 134, 19);
		contentPane.add(lblData_1);
		lblData_1.setText(String.valueOf(LocalDate.now()));
		
		JLabel lblData_1_1 = new JLabel("");
		lblData_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData_1_1.setBounds(201, 64, 63, 19);
		contentPane.add(lblData_1_1);
		lblData_1_1.setText(identificativo);
	
	}
}
