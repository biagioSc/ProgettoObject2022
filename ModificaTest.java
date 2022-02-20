package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import ImplementazionePDAO.TestImplementazionePDAO;
import Model.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class ModificaTest: mostra le informazioni del test che si vuole modificare, e registra eventuali modifiche.
 */
public class ModificaTest extends JFrame {

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
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = null;
					ModificaTest frame1 = new ModificaTest(controller,frame, toString(), toString(), toString(), toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame: mostra le informazioni del test che si vuole modificare, e registra eventuali modifiche.
	 *
	 * @param controller1 the controller 1
	 * @param frame the frame
	 * @param idtest the idtest
	 * @param username the username
	 * @param password the password
	 * @param identificativo the identificativo
	 */
	public ModificaTest(Controller controller1, Window frame, String idtest, String username, String password, String identificativo) {
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
		lblNewLabel_1.setBounds(0, 0, 736, 39);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Identificativo insegnante:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 64, 198, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeTest = new JLabel("Nome Test:");
		lblNomeTest.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeTest.setBounds(20, 167, 87, 19);
		contentPane.add(lblNomeTest);
		
		JLabel lblTempoProva = new JLabel("Durata (minuti):");
		lblTempoProva.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTempoProva.setBounds(20, 251, 142, 19);
		contentPane.add(lblTempoProva);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData.setBounds(0, 0, 56, 19);
		contentPane.add(lblData);
		
		JLabel lblCliccaPerContinuare = new JLabel("");
		lblCliccaPerContinuare.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliccaPerContinuare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliccaPerContinuare.setBounds(165, 337, 561, 19);
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
		textField_2.setBounds(233, 222, 493, 19);
		contentPane.add(textField_2);
		
		txtHhmmss = new JTextField();
		txtHhmmss.setToolTipText("");
		txtHhmmss.setColumns(10);
		txtHhmmss.setBounds(165, 252, 561, 19);
		contentPane.add(txtHhmmss);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(319, 280, 407, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(319, 309, 407, 19);
		contentPane.add(textField_5);
		
		TestImplementazionePDAO q=new TestImplementazionePDAO();
		ArrayList<Test> t= new ArrayList<Test>();
		try {
			t=q.getTest(idtest);
			for(int i=0;i<t.size();i++) {
				textField.setText(t.get(i).getNome());
				textField_1.setText(String.valueOf(t.get(i).getPM()));
				textField_2.setText(String.valueOf(t.get(i).getD()));
				textField_4.setText(String.valueOf(t.get(i).getDI()));
				textField_5.setText(String.valueOf(t.get(i).getDF()));
				txtHhmmss.setText(String.valueOf(t.get(i).getT()));

			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		
		
		JButton btnNewButton = new JButton("Modifica Test");
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
		btnNewButton.setBounds(467, 366, 166, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton2.setBackground(Color.ORANGE);
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton2.setBounds(272, 366, 166, 21);
		contentPane.add(btnNewButton2);
		//btnNewButton2.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TestImplementazionePDAO q=new TestImplementazionePDAO();
				try {
					q.UpdateT(idtest,textField.getText(),textField_1.getText(),textField_2.getText(),txtHhmmss.getText(),textField_4.getText(),textField_5.getText());
					lblCliccaPerContinuare.setText("Clicca per continuare");
					btnNewButton.setText("Test Modificato");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							HomeInsegnante ti= new HomeInsegnante(controller1, identificativo, username, password);
							ti.show();
							dispose();
						}
					});
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
		lblNewLabel_2_2_1.setBounds(20, 222, 203, 19);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblDataInizioIscrizioni = new JLabel("Data inizio iscrizioni (yyyy-mm-dd hh:mm:ss):");
		lblDataInizioIscrizioni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataInizioIscrizioni.setBounds(20, 280, 289, 19);
		contentPane.add(lblDataInizioIscrizioni);
		
		JLabel lblDataFineIscrizioni = new JLabel("Data fine iscrizioni (yyyy-mm-dd hh:mm:ss):");
		lblDataFineIscrizioni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataFineIscrizioni.setBounds(20, 309, 289, 19);
		contentPane.add(lblDataFineIscrizioni);
		
		JLabel lblData_1 = new JLabel("");
		lblData_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData_1.setBounds(48, 0, 166, 19);
		contentPane.add(lblData_1);
		
		JLabel lblData_2 = new JLabel("");
		lblData_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData_2.setBounds(199, 64, 56, 19);
		contentPane.add(lblData_2);
		
		lblData_1.setText(String.valueOf(LocalDate.now()));
		lblData_2.setText(identificativo);
	
	}
}
