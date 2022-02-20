package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import ImplementazionePDAO.RispostaApertaImplementazionePDAO;
import ImplementazionePDAO.TestImplementazionePDAO;
import Model.RispostaAperta;
import Model.Test;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.Window;

// TODO: Auto-generated Javadoc
/**
 * The Class RispondiA: frame che mostra domanda aperta, e registra risposta.
 */
public class RispondiA extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The controller. */
	static Controller controller;
	
	/** The idqa. */
	public int idqa=0;
	
	/** The tempo. */
	private String tempo;
	
	/** The datatest. */
	private String datatest;
	
	/** The restant. */
	private String restant;
	
	/** The restant 2. */
	private String restant2;


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
					RispondiA frame1 = new RispondiA(controller, frame, toString(), toString(), toString(), toString(), toString(), toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame: : frame che mostra domanda aperta, e registra risposta..
	 *
	 * @param controller2 the controller 2
	 * @param frame the frame
	 * @param matricola the matricola
	 * @param username the username
	 * @param password the password
	 * @param numeroA the numero A
	 * @param numeroM the numero M
	 * @param idtest the idtest
	 */
	public RispondiA(Controller controller2, Window frame, String matricola, String username, String password,  String numeroA, String numeroM, String idtest) {

		setVisible(true);
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
		
		JButton btnNewButton_1 = new JButton("Prosegui");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(391, 382, 107, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblMaxchar = new JLabel("MaxChar:");
		lblMaxchar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaxchar.setBounds(0, 384, 80, 19);
		contentPane.add(lblMaxchar);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(213, 0, 523, 19);
		contentPane.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setText(username+" "+password);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setBounds(0, 191, 736, 191);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(47, 0, 80, 19);
		contentPane.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setText(String.valueOf(LocalDate.now()));
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.add(textArea);
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea.setBounds(0, 186, 732, 187);
		
		
		JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 0, 736, 39);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("IDT: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 64, 47, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeTest = new JLabel("Nome Test:");
		lblNomeTest.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNomeTest.setBounds(169, 64, 96, 19);
		contentPane.add(lblNomeTest);
		
		JLabel lblTempoProva = new JLabel("Tempo Prova:");
		lblTempoProva.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTempoProva.setBounds(0, 99, 107, 19);
		contentPane.add(lblTempoProva);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData.setBounds(0, 0, 47, 19);
		contentPane.add(lblData);
		
		JLabel lblStudente = new JLabel("Studente:");
		lblStudente.setForeground(Color.BLUE);
		lblStudente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudente.setBounds(137, 0, 80, 19);
		contentPane.add(lblStudente);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(37, 64, 50, 19);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setText(idtest);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(263, 64, 463, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(112, 99, 74, 19);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(273, 99, 128, 19);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(79, 384, 153, 19);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblTempoRimasto = new JLabel("Materia:");
		lblTempoRimasto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTempoRimasto.setBounds(196, 99, 80, 19);
		contentPane.add(lblTempoRimasto);
		
		JTextArea txtarea = new JTextArea();
		txtarea.setEditable(false);
		txtarea.setForeground(Color.RED);
		txtarea.setFont(new Font("Arial", Font.PLAIN, 15));
		txtarea.setBounds(0, 141, 736, 44);
		contentPane.add(txtarea);
		txtarea.setLineWrap(true);
		
		
		JButton btnNewButton_1_1 = new JButton("Aggiorna MaxChar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RispostaApertaImplementazionePDAO risposta1= new RispostaApertaImplementazionePDAO();
					ArrayList<RispostaAperta> risp1=new ArrayList<RispostaAperta>();
					
					String risposta2=textArea.getText();

					risp1=risposta1.getTestDaRispondere(String.valueOf(LocalDate.now()),matricola);

					if(risp1!=null && Integer.valueOf(numeroA)!=0 ) {
						for(int i=0;i<Integer.valueOf(numeroA);i++) {
								if(Integer.valueOf(risp1.get(Integer.valueOf(numeroA)-1).getMaxChar())>risposta2.length())
								lblNewLabel_6.setText(risp1.get(Integer.valueOf(numeroA)-1).getMaxChar()+"/"+String.valueOf(risposta2.length()));
								else {
									lblNewLabel_6.setText("Troppi Caratteri: "+risp1.get(Integer.valueOf(numeroA)-1).getMaxChar()+"/"+risposta2.length());
									throw new Exception();
								}
							
						}
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(253, 382, 128, 21);
		contentPane.add(btnNewButton_1_1);
		
		
		RispostaApertaImplementazionePDAO risposta= new RispostaApertaImplementazionePDAO();
		ArrayList<RispostaAperta> risp=new ArrayList<RispostaAperta>();
		try {
			String risposta2=textArea.getText();

			risp=risposta.getTestDaRispondere(String.valueOf(LocalDate.now()),matricola);

			if(risp!=null && Integer.valueOf(numeroA)!=0 ) {
				for(int i=0;i<Integer.valueOf(numeroA);i++) {
					txtarea.setText(risp.get(Integer.valueOf(numeroA)-1).getDomanda());
					idqa=risp.get(Integer.valueOf(numeroA)-1).getIdqa();
					lblNewLabel_5.setText(risp.get(Integer.valueOf(numeroA)-1).getMateria());
					lblNewLabel_6.setText(risp.get(Integer.valueOf(numeroA)-1).getMaxChar()+"/"+String.valueOf(risposta2.length()));

				}
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		TestImplementazionePDAO test= new TestImplementazionePDAO();
		ArrayList<Test> t= new ArrayList<Test>();
		try {
			t=test.getTest(idtest);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if(test!=null) {
			for(int i=0;i<t.size();i++) {
				lblNewLabel_3.setText(t.get(i).getNome());
				lblNewLabel_4.setText(String.valueOf(t.get(i).getT()));
				tempo=String.valueOf(t.get(i).getT());
				datatest=String.valueOf(t.get(i).getD());
			}
			}
	

		JButton btnNewButton_1_1_1 = new JButton("Aggiorna Tempo");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				Timestamp datat = Timestamp.valueOf(datatest);
				Timestamp dat=Timestamp.from(Instant.now());
				int t2=Integer.valueOf(tempo);
				datat.setMinutes(datat.getMinutes()+t2);
				String fine2= String.valueOf(datatest);
				LocalDateTime local=LocalDateTime.now();
				int minutisvolti= datat.getHours()*60+datat.getMinutes() ;
				int minutisvolti2= local.getHour()*60+local.getMinute() ;
				restant=String.valueOf(minutisvolti-minutisvolti2);

				lblNewLabel_4.setText(restant);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(-1, 117, 128, 19);
		contentPane.add(btnNewButton_1_1_1);

		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Timestamp datat = Timestamp.valueOf(datatest);
				Timestamp dat=Timestamp.from(Instant.now());
				int t2=Integer.valueOf(tempo);
				datat.setMinutes(datat.getMinutes()+t2);
				String fine2= String.valueOf(datatest);
				LocalDateTime local=LocalDateTime.now();
				int minutisvolti= datat.getHours()*60+datat.getMinutes() ;
				int minutisvolti2= local.getHour()*60+local.getMinute() ;
				restant2=String.valueOf(minutisvolti-minutisvolti2);
				if(Integer.valueOf(restant2)<=0) {
					JOptionPane.showMessageDialog (null, "Tempo Prova Scaduto");
					System.exit(0);
				}
				String risposta=textArea.getText();
				RispostaApertaImplementazionePDAO risp= new RispostaApertaImplementazionePDAO();
				try {
					risp.UpdateRispostAperta(matricola, idqa, risposta);
					
				} catch (Exception e2) {
				JOptionPane.showMessageDialog (null, "Tempo Prova Scaduto");
				System.exit(0);
					e2.printStackTrace();
				}
				if(Integer.valueOf(numeroA)==1) {
					Window frame = null;
					JFrame frameRisultati;
					try {
						setVisible(false);
						frameRisultati = new RispondiM(controller2,frame,matricola,username,password,numeroM,idtest);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else{
				Window frame = null;
				JFrame frameRisultati;
				try {
					setVisible(false);
					frameRisultati = new RispondiA(controller2,frame,matricola,username,password,String.valueOf(Integer.valueOf(numeroA)-1),numeroM,idtest);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}}
		});

	
	}
}
