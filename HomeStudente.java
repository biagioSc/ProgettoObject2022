package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import ImplementazionePDAO.TestSceltiImplementazionePDAO;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import Model.Studente;
import Model.Test;
import Model.TestScelti;
import java.awt.ScrollPane;


// TODO: Auto-generated Javadoc
/**
 * The Class HomeStudente: pagina principale che collega a tutte le altre funzioni che l'utente studente..
 */
public class HomeStudente extends JFrame {
	
	/** The s. */
	private Studente s;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The controller. */
	static Controller controller;
	
	/** The table. */
	private JTable table;
	
	/** The table 2. */
	private JTable table2;
	
	/** The datatest. */
	private Timestamp datatest;
	
	/** The t. */
	private Timestamp t;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeStudente frame = new HomeStudente(controller, toString(), toString(), toString());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Instantiates a new home studente: pagina principale che collega a tutte le altre funzioni che l'utente studente..
	 *
	 * @param controller1 the controller 1
	 * @param matricola the matricola
	 * @param username the username
	 * @param password the password
	 */
	/*Viene creata una nuova Home di studente che sarà il corpo principale dove si muoverà l'utente studente*/
	public HomeStudente(Controller controller1, String matricola, String username, String password) {
		setTitle(username.substring(5)+ " è online ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 531);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 155, 736, 44);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 49, 736, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 735, 44);
		panel_1.add(menuBar);
		menuBar.setForeground(Color.ORANGE);
		menuBar.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(0, 10, 553, 24);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(151, 121, 294, 24);
		contentPane.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Inizia Test");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(563, 13, 145, 21);
		panel.add(btnNewButton);
		
		JMenu mnNewMenu = new JMenu("Impostazioni");
		mnNewMenu.setBackground(Color.ORANGE);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setForeground(Color.RED);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Modifica Login");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				JFrame frameModifica;
				try {
					frameModifica = new ModificaStudente(controller1,frame, username, password,matricola);
					frameModifica.show();
					dispose();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Logout");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmInfopiattaforma = new JMenuItem("InfoPiattaforma");
		mntmInfopiattaforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				JFrame frameInfoPiatt;
				try {
					frameInfoPiatt = new InfoPiattaformaStu();
					frameInfoPiatt.show();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmInfopiattaforma);
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Test");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.setForeground(Color.RED);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Prenota Test");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				JFrame framePrenota;
				try {
					framePrenota = new PrenotaTest(controller1,frame,matricola,username,password);
					dispose();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Risultati test");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				JFrame frameTC;
				try {
					frameTC = new TestCompletati(controller1,frame,username,password);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Test Disponibili");
		mntmNewMenuItem_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				JFrame frameTD;
				try {
					frameTD = new TestDisponibili(controller1,frame,username,password);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_3_1);
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Test prenotati");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				JFrame frameTP;
				try {
					frameTP = new TestPrenotati(controller1,frame,username,password);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Risultati");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_2.setForeground(Color.RED);
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Risultati ottenuti");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				JFrame frameRisultati;
				try {
					frameRisultati = new Risultati(controller1,frame,username,password);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_3 = new JMenu("Profilo");
		mnNewMenu_3.setForeground(Color.RED);
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_3);
		
	
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Informazioni");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				JFrame frameInfromazioni;
				try {
					frameInfromazioni = new InformazioniStu(controller1,frame,username,password);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JButton btnNewButton_1_1 = new JButton("Logout");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1_1.setForeground(Color.RED);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBackground(Color.WHITE);
		menuBar.add(btnNewButton_1_1);
	
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(0, 0, 736, 44);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 5, 736, 39);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Matricola:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(0, 92, 74, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setText(matricola);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(74, 92, 74, 19);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel = new JLabel("Prossimo Test:");
		lblNewLabel.setBounds(0, 121, 153, 24);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	
		JScrollPane sp= new JScrollPane();
		sp.setBounds(0, 364, 738, 89);
		getContentPane().add(sp, BorderLayout.NORTH);
		
		final JTable table = new JTable();
		sp.setViewportView(table);

		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				case 6:
					return String.class;				
				case 7:
					return 	Boolean.class;
				default:
					return String.class;
					
				}
			}
		};
		
		table.setModel(model);
		model.addColumn("IDTest");
		model.addColumn("Nome Test");
		model.addColumn("Data Test");
		model.addColumn("Inizio Iscrizioni");
		model.addColumn("Fine Iscrizione");
		model.addColumn("Tempo Prova");
		model.addColumn("Soglia");
		model.addColumn("Scelta");

		
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);

		
		
		ArrayList<Test> scelta = new ArrayList();
		try {
			scelta = controller1.getScelta();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		if (scelta!=null)
		for (int i=0;i<scelta.size();i++) { 
			model.addRow(new Object[0]);
			model.setValueAt(scelta.get(i).getIdt(),i,0);
			model.setValueAt(scelta.get(i).getNome(),i,1);
			model.setValueAt(scelta.get(i).getD(),i,2);
			model.setValueAt(scelta.get(i).getDI(),i,3);
			model.setValueAt(scelta.get(i).getDF(),i,4);
			model.setValueAt(scelta.get(i).getT(),i,5);
			model.setValueAt(scelta.get(i).getPM(),i,6);
			model.setValueAt(false,i,7);
			//model.isCellEditable(i, 7);
		
		}

		JButton btn=new JButton("Prenota");
		btn.setBackground(Color.ORANGE);
		btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				TestSceltiImplementazionePDAO T=new TestSceltiImplementazionePDAO();
				for(int i=0;i<table.getRowCount();i++) {
					Boolean checked=Boolean.valueOf(table.getValueAt(i,7).toString());
					if(checked) {
						try {
							T.InsertTS(matricola,table.getValueAt(i,0).toString());
							HomeStudente homestudente= new HomeStudente(controller1, matricola, username, password);
							homestudente.show();
							dispose();	
						} catch (Exception e) {
							JOptionPane.showMessageDialog(contentPane, "Errore1: non puoi fare due test nella stessa giornata\nErrore2: iscrizioni non aperte/chiuse");
							e.printStackTrace();
						}
					}
				
				}
			}				
		});
		btn.setBounds(282,460,174,24);
		getContentPane().add(btn);
		
	    
	    
		table2 = new JTable();
		table2.setBounds(38, 281, 1, 1);
		table2.setEnabled(false);
		table2.setForeground(Color.BLACK);
		table2.setBackground(Color.WHITE);
		table2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	    table2.setBounds(30,40,200,300);          
	    table2.setRowHeight(25);
	   
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome Test", "IDTest", "Matricola", "Data Iscrizione", "Esito", "Punteggio"
			}
		));
		table2.getColumnModel().getColumn(0).setPreferredWidth(220);
		table2.getColumnModel().getColumn(1).setPreferredWidth(45);
		table2.getColumnModel().getColumn(2).setPreferredWidth(55);
		table2.getColumnModel().getColumn(3).setPreferredWidth(100);
		table2.getColumnModel().getColumn(4).setPreferredWidth(100);
		table2.getColumnModel().getColumn(5).setPreferredWidth(56);
		DefaultTableModel model2 = (DefaultTableModel) table2.getModel();

		ArrayList<TestScelti> risultati = new ArrayList();
		try {
			risultati = controller1.getResult(username, password);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (risultati!=null)
		

				for (int i=0;i<risultati.size();i++) { 
					model2.addRow(new Object[]{risultati.get(i).getNomeTest(),risultati.get(i).getIdt(),risultati.get(i).getMat(),risultati.get(i).getDT(),risultati.get(i).getEsito(),risultati.get(i).getPT()});
				}
		JScrollPane scrollPane = new JScrollPane(table2);
		scrollPane.setBounds(-2, 237, 738, 89);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Risultati Test Completati");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(0, 213, 736, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Test disponibili per la prenotazione");
		lblNewLabel_3_1_2.setForeground(Color.RED);
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3_1_2.setBounds(0, 337, 736, 24);
		contentPane.add(lblNewLabel_3_1_2);

		try {
			ArrayList<TestScelti> settaggio = new ArrayList();
			settaggio=controller1.getTestDaFare(username, password);
			
			if (settaggio.size()!=0) {
				String idt=String.valueOf(settaggio.get(0).getIdt());
				lblNewLabel_3.setText(settaggio.get(0).getNomeTest());
				lblNewLabel_3_1.setText(settaggio.get(0).getD2());
				datatest=settaggio.get(0).getDt2();
				t= settaggio.get(0).getDt2();
				Time tempo=settaggio.get(0).getT();
				int t2 = t.getMinutes()+tempo.getMinutes();
				int t3 = t.getHours()+tempo.getHours();
			
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Timestamp dat=Timestamp.from(Instant.now());

						if(dat.after(datatest)) {
							t.setMinutes(t2);
							t.setHours(t3);
							
								if(dat.before(t) ){
										Window frame = null;
										JFrame frameSvolgi;
										try {
											frameSvolgi=new SvolgiTest(controller1, frame, matricola, username,password,idt);
											frameSvolgi.show();
											dispose();
										} catch (Exception e1) {
											e1.printStackTrace();
										}	
					}}else {	
							JOptionPane.showMessageDialog(contentPane, "Non è oggi il test!!");

					}
				}});
			}else {
					lblNewLabel_3.setText("Non hai test prenotati");
					lblNewLabel_3_1.setText("");
					btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
					btnNewButton.setText("Prenota un test");

					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame framePrenota;
							try {
								framePrenota = new PrenotaTest(controller1,frame,matricola,username,password);

							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});				}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
