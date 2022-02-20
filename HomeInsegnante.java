package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import ImplementazionePDAO.QuizApertiImplementazionePDAO;
import Model.Studente;
import Model.Test;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeInsegnante: pagina principale che collega a tutte le altre funzioni che l'utente insegnante.
 */
public class HomeInsegnante extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The controller 2. */
	static Controller controller2;
	
	/** The s. */
	private Insegnante s;
	
	/** The table. */
	private JTable table;
	
	/** The table 2. */
	private JTable table2;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeInsegnante frame = new HomeInsegnante(controller2, toString(), toString(), toString());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Instantiates a new home insegnante.: pagina principale che collega a tutte le altre funzioni che l'utente insegnante.
	 *
	 * @param controller the controller
	 * @param identificativo the identificativo
	 * @param username the username
	 * @param password the password
	 */
	/*Viene creata una nuova Home di insegnante che sarà il corpo principale dove si muoverà l'utente insegnante*/

	public HomeInsegnante(Controller controller, String identificativo, String username, String password) {
		setTitle(username.substring(4)+ " è online ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(0, 0, 736, 44);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(0, 5, 736, 39);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 57, 736, 44);
		contentPane.add(panel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.ORANGE);
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 734, 44);
		panel_1.add(menuBar);
		
		/*Menu di impostazioni*/
		JMenu mnNewMenu = new JMenu("Impostazioni");
		mnNewMenu.setForeground(Color.RED);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setBackground(Color.ORANGE);
		menuBar.add(mnNewMenu);
		
				JMenuItem mntmNewMenuItem = new JMenuItem("Modifica Login");
					mntmNewMenuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Window frame = null;
						JFrame frameModifica;
						try {
							frameModifica = new ModificaInsegnante(controller,frame, username, password,identificativo);
							frameModifica.show();
							dispose();

						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				mnNewMenu.add(mntmNewMenuItem);
		
				JMenuItem mntmInfopiattaforma = new JMenuItem("InfoPiattaforma");
					mntmInfopiattaforma.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Window frame = null;
						JFrame frameInfoPiattaforma;
						try {
							frameInfoPiattaforma = new InfoPiattaformaIns();
							frameInfoPiattaforma.show();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				mnNewMenu.add(mntmInfopiattaforma);
		
				JMenuItem mntmNewMenuItem_2 = new JMenuItem("Logout");
					mnNewMenu.add(mntmNewMenuItem_2);
		
		
				
		/*Menu di gestione test*/
		JMenu mnNewMenu_1 = new JMenu("GestisciTest");
		mnNewMenu_1.setForeground(Color.RED);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1);
		
				JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crea Test");
					mntmNewMenuItem_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							CreaTest ct= new CreaTest(controller, identificativo, username, password);
							dispose();

						}
					});
					mnNewMenu_1.add(mntmNewMenuItem_3);
		
				JMenuItem mntmNewMenuItem_4 = new JMenuItem("Modifica Test");
					mntmNewMenuItem_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameTestCreati;
							try {
					frameTestCreati = new TestCreatiBtn(controller,frame,identificativo,username,password);
					dispose();
							} catch (Exception e1) {
					e1.printStackTrace();
							}
						}
					});
					mnNewMenu_1.add(mntmNewMenuItem_4);
		
				JMenuItem mntmNewMenuItem_8 = new JMenuItem("Test creati");
					mntmNewMenuItem_8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameTestCreati;
							try {
								frameTestCreati = new TestCreati(controller,frame,username,password);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
					mnNewMenu_1.add(mntmNewMenuItem_8);
					
					
					
		/*Menu di info test*/
		JMenu mnNewMenu_2 = new JMenu("InfoTest");
		mnNewMenu_2.setForeground(Color.RED);
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);
		
				JMenuItem mntmNewMenuItem_6 = new JMenuItem("Test Creati");
					mntmNewMenuItem_6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameTestCreati;
							try {
								frameTestCreati = new TestCreati(controller,frame,username,password);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
					mnNewMenu_2.add(mntmNewMenuItem_6);
					
				JMenuItem mntmNewMenuItem_9 = new JMenuItem("Test da correggere");
					mntmNewMenuItem_9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameCorrezione;
							try {
								frameCorrezione = new TestCorrez(controller,frame,identificativo,username,password);
									dispose();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
					mnNewMenu_2.add(mntmNewMenuItem_9);
		
				JMenuItem mntmNewMenuItem_16 = new JMenuItem("QuizMultipla in Test");
					mntmNewMenuItem_16.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameQMT;
							try {
								frameQMT = new QMinTest(controller,frame,identificativo,username,password);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
					mnNewMenu_2.add(mntmNewMenuItem_16);
		
				JMenuItem mntmNewMenuItem_13 = new JMenuItem("Prossimi test");
					mntmNewMenuItem_13.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameProssimi;
							try {
								frameProssimi = new Prossimi(controller,frame,username,password);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}});
		
				JMenuItem mntmNewMenuItem_16_1 = new JMenuItem("QuizAperta in Test");
					mntmNewMenuItem_16_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameQAT;
							try {
								frameQAT = new QAinTest(controller,frame,identificativo,username,password);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
					mnNewMenu_2.add(mntmNewMenuItem_16_1);
		
					mnNewMenu_2.add(mntmNewMenuItem_13);
		
				JMenuItem mntmNewMenuItem_10 = new JMenuItem("Studenti esaminati");
					mntmNewMenuItem_10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameEsaminati;
							try {
								frameEsaminati = new StudEsaminati(controller,frame,username,password);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
					mnNewMenu_2.add(mntmNewMenuItem_10);
		
					
					
		
		/*Menu dei quiz*/
		JMenu mnNewMenu_3 = new JMenu("Quiz");
		mnNewMenu_3.setForeground(Color.RED);
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_3);
		
				JMenuItem mntmNewMenuItem_7 = new JMenuItem("Inserisci quiz multiplo");
					mntmNewMenuItem_7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								CreaQuizM qm= new CreaQuizM( controller, identificativo, username, password );
								qm.show();
								dispose();
							}
					});
					mnNewMenu_3.add(mntmNewMenuItem_7);
		
				JMenuItem mntmNewMenuItem_11 = new JMenuItem("Inserisci quiz aperto");
					mntmNewMenuItem_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CreaQuizA qa= new CreaQuizA(controller, identificativo, username, password);
						qa.show();
					dispose();
					}
				});
				mnNewMenu_3.add(mntmNewMenuItem_11);
		
				JMenuItem mntmNewMenuItem_12 = new JMenuItem("Inserisci quiz Multiplo in test");
					mntmNewMenuItem_12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						Window frame = null;
						JFrame frameInserisci;
						try {
							frameInserisci = new AmmQMT(controller,frame,username,password,identificativo);
							dispose();
						} catch (Exception e1) {
							e1.printStackTrace();
								}
							}
						});
					mnNewMenu_3.add(mntmNewMenuItem_12);

				JMenuItem mntmNewMenuItem_12_1 = new JMenuItem("Inserisci quiz Aperto in test");
					mntmNewMenuItem_12_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameInserisci;
							try {
								frameInserisci = new AmmQAT(controller,frame,username,password,identificativo);
								dispose();
							} catch (Exception e1) {
								e1.printStackTrace();
								}
							}
						});
					
					mnNewMenu_3.add(mntmNewMenuItem_12_1);
		
				JMenuItem mntmNewMenuItem_15 = new JMenuItem("Visualizza Quiz aperti");
					mntmNewMenuItem_15.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameQA;
							try {
								frameQA = new QuizAperti(controller,frame,username,password);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
					
							JMenuItem mntmNewMenuItem_14 = new JMenuItem("Visualizza Quiz multipli");
							mntmNewMenuItem_14.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									Window frame = null;
									JFrame frameQM;
									try {
										frameQM = new QuizMultipli(controller,frame,username,password);
									} catch (Exception e1) {
										e1.printStackTrace();
									}
								}
							});
							mnNewMenu_3.add(mntmNewMenuItem_14);
					mnNewMenu_3.add(mntmNewMenuItem_15);
		
		
					
		/*Menu profilo*/			
		JMenu mnNewMenu_3_1 = new JMenu("Profilo");
		mnNewMenu_3_1.setForeground(Color.RED);
		mnNewMenu_3_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_3_1);
		
				JMenuItem mntmNewMenuItem_7_1 = new JMenuItem("Informazioni");
					mntmNewMenuItem_7_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Window frame = null;
							JFrame frameInfromazioni;
							try {
								frameInfromazioni = new InformazioniIns(controller,frame,username,password);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
					mnNewMenu_3_1.add(mntmNewMenuItem_7_1);
		
					
					
		/*Bottone di uscita*/			
		JButton btnNewButton_1_1 = new JButton("Logout");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			btnNewButton_1_1.setForeground(Color.RED);
			btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton_1_1.setBackground(Color.WHITE);
			menuBar.add(btnNewButton_1_1);
		
			
			
		/*Panel con tabelle*/	
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.ORANGE);
		panel_3.setBounds(-5, 148, 741, 44);
		contentPane.add(panel_3);
		
		JLabel lblTestDaCorreggere = new JLabel("Test da correggere:");
		lblTestDaCorreggere.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTestDaCorreggere.setBounds(10, 10, 218, 24);
		panel_3.add(lblTestDaCorreggere);
		
		JButton btnApriTest_1 = new JButton("apri correzione");
		btnApriTest_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window frame = null;
				JFrame frameCorrezione;
				try {
					frameCorrezione = new TestCorrez(controller,frame,identificativo,username,password);
					dispose();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnApriTest_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnApriTest_1.setBackground(Color.WHITE);
		btnApriTest_1.setBounds(457, 13, 274, 21);
		panel_3.add(btnApriTest_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setText(identificativo);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(104, 103, 100, 19);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Identificativo:");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(0, 103, 116, 19);
		contentPane.add(lblNewLabel_2_1_1);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    table.setBounds(30,40,200,300);          
	    table.setRowHeight(25);
	   
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome Test","IDTest", "Data Test", 
				"Inizio Iscrizioni","Fine Iscrizione","Durata",
				"Soglia","DataOperazione"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(45);
		table.getColumnModel().getColumn(7).setPreferredWidth(120);


		DefaultTableModel model = (DefaultTableModel) table.getModel();

		ArrayList<Test> testCreati = new ArrayList();
		try {
			testCreati = controller.getTestCreati(username, password);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (testCreati!=null)
		

				for (int i=0;i<testCreati.size();i++) { 
					model.addRow(new Object[]{testCreati.get(i).getNome(),testCreati.get(i).getIdt(),testCreati.get(i).getD(),testCreati.get(i).getDI(),testCreati.get(i).getDF(),testCreati.get(i).getT(),testCreati.get(i).getPM(),testCreati.get(i).getDO(),testCreati.get(i).getOp()});
				}
		 JScrollPane sp=new JScrollPane(table);    
		 sp.setBounds(0, 228, 736, 102);
		 getContentPane().add(sp);
		 
		 table2 = new JTable();
			table2.setForeground(Color.BLACK);
			table2.setBackground(Color.WHITE);
			table2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		    table2.setBounds(30,40,200,300);          
		    table2.setRowHeight(25);
		   
			table2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome Test","IDTest", "Data Test", 
					"Inizio Iscrizioni","Fine Iscrizione","Durata",
					"Soglia","DataOperazione"
				}
			));
			table2.getColumnModel().getColumn(0).setPreferredWidth(220);
			table2.getColumnModel().getColumn(1).setPreferredWidth(45);
			table2.getColumnModel().getColumn(2).setPreferredWidth(100);
			table2.getColumnModel().getColumn(3).setPreferredWidth(100);
			table2.getColumnModel().getColumn(4).setPreferredWidth(100);
			table2.getColumnModel().getColumn(5).setPreferredWidth(100);
			table2.getColumnModel().getColumn(6).setPreferredWidth(45);
			table2.getColumnModel().getColumn(7).setPreferredWidth(100);


			DefaultTableModel model2 = (DefaultTableModel) table2.getModel();

			ArrayList<Test> prossimi = new ArrayList();
			try {
				prossimi = controller.getProssimi(username, password);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (prossimi!=null)
			

					for (int i=0;i<prossimi.size();i++) { 
						model2.addRow(new Object[]{prossimi.get(i).getNome(),prossimi.get(i).getIdt(),prossimi.get(i).getD(),prossimi.get(i).getDI(),prossimi.get(i).getDF(),prossimi.get(i).getT(),prossimi.get(i).getPM(),prossimi.get(i).getDO()});
					}
			 JScrollPane sp2=new JScrollPane(table2);
			 sp2.setBounds(0, 355, 736, 108);
			 getContentPane().add(sp2);
			 
			 JLabel lblNewLabel_3_1_1 = new JLabel("Test Creati");
			 lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			 lblNewLabel_3_1_1.setForeground(Color.RED);
			 lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 20));
			 lblNewLabel_3_1_1.setBounds(0, 202, 736, 24);
			 contentPane.add(lblNewLabel_3_1_1);
			 
			 JLabel lblNewLabel_3_1_1_1 = new JLabel("Prossimi Test");
			 lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			 lblNewLabel_3_1_1_1.setForeground(Color.RED);
			 lblNewLabel_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
			 lblNewLabel_3_1_1_1.setBounds(0, 331, 736, 24);
			 contentPane.add(lblNewLabel_3_1_1_1);
	}
}
