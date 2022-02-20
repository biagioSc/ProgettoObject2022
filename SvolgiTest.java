package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import ImplementazionePDAO.InsegnanteImplementazionePDAO;
import ImplementazionePDAO.RispostaApertaImplementazionePDAO;
import ImplementazionePDAO.RispostaChiusaImplementazionePDAO;
import ImplementazionePDAO.TestImplementazionePDAO;
import Model.Insegnante;
import Model.Test;
import Model.TestScelti;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class SvolgiTest: crea frame con tutte le informazioni sul test che si andrà a svolgere.
 */
public class SvolgiTest extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The controller. */
	static Controller controller;
	
	/** The n 1. */
	public int n1 = 0;
	
	/** The n 2. */
	public int n2 = 0;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = null;
					SvolgiTest frame1 = new SvolgiTest(controller, frame, toString(), toString(), toString(), toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Instantiates a new svolgi test: crea frame con tutte le informazioni sul test che si andrà a svolgere.
	 *
	 * @param controller2 the controller 2
	 * @param frame the frame
	 * @param matricola the matricola
	 * @param username the username
	 * @param password the password
	 * @param idtest the idtest
	 * @throws Exception the exception
	 */
	public SvolgiTest(Controller controller2, Window frame, String matricola, String username, String password, String idtest) throws Exception {
		setTitle(username.substring(5)+ " è online ");
		ArrayList<TestScelti> settaggio = new ArrayList();
		settaggio=controller2.getTestDaFare(username, password);
		int idt=settaggio.get(0).getIdt();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 309);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(0, 20, 436, 44);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("IDTest: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(243, 0, 71, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(0, 10, 431, 29);
		panel_2.add(lblNewLabel_1);
	
		
		
		
		JLabel lblNomeTest = new JLabel("Nome Test:");
		lblNomeTest.setForeground(Color.RED);
		lblNomeTest.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNomeTest.setBounds(0, 75, 106, 19);
		contentPane.add(lblNomeTest);
		
		JLabel lblTempoProva = new JLabel("-Tempo Prova:");
		lblTempoProva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTempoProva.setBounds(0, 105, 106, 19);
		contentPane.add(lblTempoProva);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData.setBounds(0, 0, 55, 19);
		contentPane.add(lblData);
		
		RispostaApertaImplementazionePDAO k2= new RispostaApertaImplementazionePDAO();
		try {
			n2 = k2.getNTestDaRispondere(String.valueOf(LocalDate.now()),matricola);
			System.out.println(n2);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		RispostaChiusaImplementazionePDAO k=new RispostaChiusaImplementazionePDAO();

		try {
			n1 = k.getNTestDaRispondere(String.valueOf(LocalDate.now()),matricola);
			System.out.println(n1);

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Inizia Test");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Window frame = null;
				JFrame frameRisultati;
				try {
					frameRisultati = new RispondiA(controller2,frame,matricola,username,password,String.valueOf(n2),String.valueOf(n1),idtest);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(181, 219, 133, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblStudente = new JLabel("Studente:");
		lblStudente.setForeground(Color.BLUE);
		lblStudente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudente.setBounds(0, 244, 88, 19);
		contentPane.add(lblStudente);
		
		JLabel lblNewLabel_2_1 = new JLabel("-Insegnante:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(0, 135, 87, 19);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("-Punteggio minimo:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(0, 165, 132, 19);
		contentPane.add(lblNewLabel_2_2);
		
		
		
		JLabel lblNomeTest_1 = new JLabel("");
		lblNomeTest_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeTest_1.setBounds(93, 75, 343, 19);
		contentPane.add(lblNomeTest_1);
		
		JLabel lblNomeTest_1_1 = new JLabel("");
		lblNomeTest_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeTest_1_1.setBounds(103, 105, 114, 19);
		contentPane.add(lblNomeTest_1_1);
		
		JLabel lblNomeTest_1_2 = new JLabel("");
		lblNomeTest_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeTest_1_2.setBounds(83, 244, 343, 19);
		contentPane.add(lblNomeTest_1_2);
		
		lblNomeTest_1_2.setText("Matricola: "+matricola+" Username: "+username);
		
		JLabel lblNomeTest_1_1_1 = new JLabel("");
		lblNomeTest_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeTest_1_1_1.setBounds(90, 135, 336, 19);
		contentPane.add(lblNomeTest_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(142, 165, 48, 19);
		contentPane.add(lblNewLabel_2_1_1);
		
		
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1.setBounds(93, 194, 77, 19);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("-N.Domande:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(0, 195, 97, 19);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNomeTest_1_1_2 = new JLabel("");
		lblNomeTest_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeTest_1_1_2.setBounds(305, 0, 55, 19);
		contentPane.add(lblNomeTest_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_2.setBounds(44, 0, 173, 19);
		contentPane.add(lblNewLabel_2_1_1_2);
		lblNewLabel_2_1_1_2.setText(String.valueOf(LocalDate.now()));
		
		lblNewLabel_2_1_1_1.setText(String.valueOf(n1+n2));

		TestImplementazionePDAO S= new TestImplementazionePDAO();
		ArrayList<Test> test= new ArrayList<Test>();
		test=S.getTest(idtest);
		
		try {					
			if (test.size()!=0) {
				lblNomeTest_1.setText(test.get(0).getNome());
				lblNomeTest_1_1.setText(String.valueOf(test.get(0).getT()));
				lblNewLabel_2_1_1.setText(String.valueOf(test.get(0).getPM()));
				lblNomeTest_1_1_2.setText(String.valueOf(test.get(0).getIdt()));
			}
			
		
		}catch(Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayList<Insegnante> ins=new ArrayList<Insegnante>();

		InsegnanteImplementazionePDAO o= new InsegnanteImplementazionePDAO();
		ins=o.getIns(idtest);
		try {					
			if (ins.size()!=0) {
				lblNomeTest_1_1_1.setText(ins.get(0).getNome()+" "+ins.get(0).getCognome());

			}
			
		
		}catch(Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
