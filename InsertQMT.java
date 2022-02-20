package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import ImplementazionePDAO.AmmetteQuizMPDAO;
import ImplementazionePDAO.QuizApertiImplementazionePDAO;
import ImplementazionePDAO.QuizMultipliImplementazionePDAO;
import ImplementazionePDAO.TestImplementazionePDAO;
import ImplementazionePDAO.TestSceltiImplementazionePDAO;
import Model.Insegnante;
import Model.QuizMultipla;
import Model.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertQMT: permette l'inserimento in un test di svariati quiz.
 */
public class InsertQMT extends JFrame {
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The table. */
	private JTable table;
	
	/** The controller. */
	static Controller controller;
	
	/** The table 1. */
	private JTable table_1;
	
	/** The table 2. */
	private JTable table_2;

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
					InsertQMT  frame1= new InsertQMT(controller, frame, toString(), toString(), toString(),toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiates a new insert QMT: permette l'inserimento in un test di svariati quiz.
	 *
	 * @param controller1 the controller 1
	 * @param frame the frame
	 * @param idtest the idtest
	 * @param username the username
	 * @param password the password
	 * @param identificativo the identificativo
	 * @throws Exception the exception
	 */
	public InsertQMT(Controller controller1, Window frame, String idtest, String username, String password, String identificativo) throws Exception {
		setTitle(username.substring(4)+ " è online ");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 750, 450);
	
		getContentPane().setLayout(null);
		
		
		JScrollPane scroll= new JScrollPane();
		scroll.setBounds(0,77,736,243);
		getContentPane().add(scroll, BorderLayout.NORTH);
		
		final JTable table = new JTable();
		scroll.setViewportView(table);

		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 9:

					return 	Boolean.class;
				default:
					return String.class;
					
				}
			}
		};
		
		table.setModel(model);
		model.addColumn("IDQuiz");
		model.addColumn("Domanda");
		model.addColumn("PuntBonus");
		model.addColumn("PuntMalus");
		model.addColumn("Materia");
		model.addColumn("RispEsatta");
		model.addColumn("RispErrata");
		model.addColumn("RispErrata");
		model.addColumn("RispErrata");
		model.addColumn("Scelta");


		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(700);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(500);
		table.getColumnModel().getColumn(6).setPreferredWidth(500);
		table.getColumnModel().getColumn(7).setPreferredWidth(500);
		table.getColumnModel().getColumn(8).setPreferredWidth(500);
		table.getColumnModel().getColumn(9).setPreferredWidth(50);

		
		ArrayList<QuizMultipla> qa = new ArrayList();
		QuizMultipliImplementazionePDAO S=new QuizMultipliImplementazionePDAO();
		qa= S.getQMOther(idtest);
		if (qa!=null)
			for (int i=0;i<qa.size();i++) { 
						model.addRow(new Object[0]);
						model.setValueAt(qa.get(i).getIdqm(),i,0);
						model.setValueAt(qa.get(i).getDomanda(),i,1);
						model.setValueAt(qa.get(i).getPBonus(),i,2);
						model.setValueAt(qa.get(i).getPMalus(),i,3);
						model.setValueAt(qa.get(i).getMateria(),i,4);
						model.setValueAt(qa.get(i).getRG(),i,5);
						model.setValueAt(qa.get(i).getR1(),i,6);
						model.setValueAt(qa.get(i).getR2(),i,7);
						model.setValueAt(qa.get(i).getR3(),i,8);
						model.setValueAt(false,i,9);
	
			}




		JButton btn=new JButton("Inserisci");
			    
	    JLabel lblNewLabel_1_1_1_1 = new JLabel();
	    lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
	    lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
	    lblNewLabel_1_1_1_1.setBounds(0, 330, 737, 24);
	    getContentPane().add(lblNewLabel_1_1_1_1);
		btn.setBackground(Color.ORANGE);
		btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				TestSceltiImplementazionePDAO T=new TestSceltiImplementazionePDAO();
				for(int i=0;i<table.getRowCount();i++) {
					Boolean checked=Boolean.valueOf(table.getValueAt(i,9).toString());
					if(checked) {
						AmmetteQuizMPDAO a= new AmmetteQuizMPDAO();
						try {
							a.InsertAQM(idtest, String.valueOf(table.getValueAt(i,0).toString()));
							lblNewLabel_1_1_1_1.setText("Inserimento avvenuto con successo");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					}
				
				}
							
		});
		btn.setBounds(382,377,150,30);
		getContentPane().add(btn);
		JPanel panel_2 = new JPanel();
	    panel_2.setLayout(null);
	    panel_2.setBackground(Color.ORANGE);
	    panel_2.setBounds(0, -1, 736, 44);
	    getContentPane().add(panel_2);
	   
	    JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
	    lblNewLabel_1.setBounds(0, 0, 737, 44);
	    panel_2.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Scegli quiz");
	    lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1_1.setForeground(Color.RED);
	    lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 30));
	    lblNewLabel_1_1.setBounds(-1, 41, 737, 37);
	    getContentPane().add(lblNewLabel_1_1);
	    
	    JButton btnEsci = new JButton("Esci");
	    btnEsci.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		HomeInsegnante ti= new HomeInsegnante(controller1,identificativo, username, password);
				ti.show();
				dispose();
	    	}
	    });
	    btnEsci.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btnEsci.setBackground(Color.ORANGE);
	    btnEsci.setBounds(222, 377, 150, 30);
	    getContentPane().add(btnEsci);
	    
	    
		setVisible(true);
		
		
		
}
		
}
