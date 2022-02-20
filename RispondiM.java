package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import ImplementazionePDAO.RispostaApertaImplementazionePDAO;
import ImplementazionePDAO.RispostaChiusaImplementazionePDAO;
import ImplementazionePDAO.TestImplementazionePDAO;
import Model.QuizMultipla;
import Model.RispostaAperta;
import Model.RispostaChiusa;
import Model.Test;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

// TODO: Auto-generated Javadoc
/**
 * The Class RispondiM: frame che mostra domanda multipla, e registra risposta.
 */
public class RispondiM extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The idqm. */
	public int idqm;
	
	/** The datatest. */
	private Timestamp datatest;
	
	/** The tempo. */
	private int tempo;
	
	/** The tempo 2. */
	private String tempo2;
	
	/** The datatest 2. */
	private String datatest2;
	
	/** The restant. */
	private String restant;
	
	/** The restant 2. */
	private String restant2;


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
					Window frame = null;
					RispondiM frame1 = new RispondiM(controller, frame, toString(), toString(), toString(), toString(), toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame: frame che mostra domanda multipla, e registra risposta.
	 *
	 * @param controller2 the controller 2
	 * @param frame the frame
	 * @param matricola the matricola
	 * @param username the username
	 * @param password the password
	 * @param numeroM the numero M
	 * @param idtest the idtest
	 */
	


	public RispondiM(Controller controller2, Window frame, String matricola, String username, String password, String numeroM, String idtest) {
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
		
		JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(0, 0, 736, 39);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("IDT: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 64, 38, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeTest = new JLabel("Nome Test:");
		lblNomeTest.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNomeTest.setBounds(96, 64, 96, 19);
		contentPane.add(lblNomeTest);
		
		JLabel lblTempoProva = new JLabel("Tempo Prova:");
		lblTempoProva.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTempoProva.setBounds(0, 99, 111, 19);
		contentPane.add(lblTempoProva);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblData.setBounds(0, 0, 55, 19);
		contentPane.add(lblData);
		
		JLabel lblStudente = new JLabel("Studente:");
		lblStudente.setForeground(Color.BLUE);
		lblStudente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudente.setBounds(156, 0, 96, 19);
		contentPane.add(lblStudente);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(81, 218, 583, 154);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBackground(Color.WHITE);
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radioButton.setBounds(46, 5, 519, 21);
		panel.add(radioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(46, 40, 519, 21);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(46, 75, 519, 21);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_2.setBounds(46, 110, 519, 21);
		panel.add(rdbtnNewRadioButton_2);
		
		ButtonGroup group= new ButtonGroup();
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton);
		group.add(radioButton);
		
		JLabel lblNewLabel_2 = new JLabel("A:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(15, 5, 21, 19);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("B:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(15, 40, 21, 19);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("C:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(15, 75, 21, 19);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("D:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(15, 110, 21, 19);
		panel.add(lblNewLabel_2_4);
		
		
		JLabel lblTempoRimasto = new JLabel("Materia:");
		lblTempoRimasto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTempoRimasto.setBounds(203, 99, 80, 19);
		contentPane.add(lblTempoRimasto);
		
		JTextArea txtarea = new JTextArea();
		txtarea.setLineWrap(true);
		txtarea.setForeground(Color.RED);
		txtarea.setFont(new Font("Arial", Font.PLAIN, 15));
		txtarea.setEditable(false);
		txtarea.setBounds(0, 146, 736, 57);
		contentPane.add(txtarea);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(185, 64, 463, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(36, 64, 50, 19);
		contentPane.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setText(idtest);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(106, 99, 89, 19);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(269, 99, 128, 19);
		contentPane.add(lblNewLabel_5);
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(252, 0, 463, 19);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(53, 0, 96, 19);
		contentPane.add(lblNewLabel_4_1);
		
		lblNewLabel_3_1.setText(username+" "+password);
		lblNewLabel_4_1.setText(String.valueOf(LocalDate.now()));
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(467, 99, 66, 19);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_2.setBounds(623, 99, 66, 19);
		contentPane.add(lblNewLabel_5_2);
		
		
		
		RispostaChiusaImplementazionePDAO risposta= new RispostaChiusaImplementazionePDAO();
		ArrayList<QuizMultipla> risp=new ArrayList<QuizMultipla>();
		try {

			risp=risposta.getTestDaRispondere(String.valueOf(LocalDate.now()),matricola);

			if(risp!=null && Integer.valueOf(numeroM)!=0 ) {
				for(int i=0;i<Integer.valueOf(numeroM);i++) {
					txtarea.setText(risp.get(Integer.valueOf(numeroM)-1).getDomanda());
					idqm=risp.get(Integer.valueOf(numeroM)-1).getIdqm();
					lblNewLabel_5.setText(risp.get(Integer.valueOf(numeroM)-1).getMateria());
					rdbtnNewRadioButton_2.setText(risp.get(Integer.valueOf(numeroM)-1).getR3());
					rdbtnNewRadioButton_1.setText(risp.get(Integer.valueOf(numeroM)-1).getR2());
					rdbtnNewRadioButton.setText(risp.get(Integer.valueOf(numeroM)-1).getR1());
					radioButton.setText(risp.get(Integer.valueOf(numeroM)-1).getRG());
					lblNewLabel_5_1.setText(String.valueOf(risp.get(Integer.valueOf(numeroM)-1).getPBonus()));
					lblNewLabel_5_2.setText(String.valueOf(risp.get(Integer.valueOf(numeroM)-1).getPMalus()));

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
				tempo=t.get(i).getT();
				datatest=t.get(i).getD();
				tempo2=String.valueOf(t.get(i).getT());
				datatest2=String.valueOf(t.get(i).getD());
			}
			}
	

		    
		JButton btnNewButton_1 = new JButton("Prosegui");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timestamp datat = Timestamp.valueOf(datatest2);
				Timestamp dat=Timestamp.from(Instant.now());
				int t2=Integer.valueOf(tempo);
				datat.setMinutes(datat.getMinutes()+t2);
				String fine2= String.valueOf(datatest2);
				LocalDateTime local=LocalDateTime.now();
				int minutisvolti= datat.getHours()*60+datat.getMinutes() ;
				int minutisvolti2= local.getHour()*60+local.getMinute() ;
				restant2=String.valueOf(minutisvolti-minutisvolti2);
				if(Integer.valueOf(restant2)<=0) {
					JOptionPane.showMessageDialog (null, "Tempo Prova Scaduto");
					System.exit(0);
				}
				
				String risposta=getSelectedButtonText(group);
				RispostaChiusaImplementazionePDAO risp= new RispostaChiusaImplementazionePDAO();
				try {
					risp.UpdateRispostaChiusa(matricola, idqm, risposta);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(Integer.valueOf(numeroM)==1) {
					btnNewButton_1.setText("Chiudi Test");
					btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HomeStudente ti= new HomeStudente(controller2,matricola, username, password);
						ti.show();
						dispose();	
					}});
				}
				else{
				Window frame = null;
				JFrame frameRisultati;
				try {
					setVisible(false);
					frameRisultati = new RispondiM(controller2,frame,matricola,username,password,String.valueOf(Integer.valueOf(numeroM)-1),idtest);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(269, 382, 188, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblBonus = new JLabel("Bonus:");
		lblBonus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBonus.setBounds(407, 99, 80, 19);
		contentPane.add(lblBonus);
		
		JLabel lblMalus = new JLabel("Malus:");
		lblMalus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMalus.setBounds(568, 99, 55, 19);
		contentPane.add(lblMalus);
		
		JButton btnNewButton_1_1_1 = new JButton("Aggiorna Tempo");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timestamp datat = Timestamp.valueOf(datatest2);
				Timestamp dat=Timestamp.from(Instant.now());
				int t2=Integer.valueOf(tempo);
				datat.setMinutes(datat.getMinutes()+t2);
				String fine2= String.valueOf(datatest2);
				LocalDateTime local=LocalDateTime.now();
				int minutisvolti= datat.getHours()*60+datat.getMinutes() ;
				int minutisvolti2= local.getHour()*60+local.getMinute() ;
				restant=String.valueOf(minutisvolti-minutisvolti2);

				lblNewLabel_4.setText(restant);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(0, 117, 128, 19);
		contentPane.add(btnNewButton_1_1_1);
		
		
		
		

	}
	
	/**
	 * Gets the selected button text.
	 *
	 * @param buttonGroup the button group
	 * @return the selected button text
	 */
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}


