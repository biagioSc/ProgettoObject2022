package GUI;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import Controller.Controller;
import ImplementazionePDAO.TestSceltiImplementazionePDAO;
import Model.Acquisto;
import Model.Test;
import Model.TestScelti;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
// TODO: Auto-generated Javadoc

/**
 * The Class PrenotaTest: mostra tutti i test prenotabili(con iscrizioni aperte o in corso) e permette la scelta di un nuovo test.
 */
public class PrenotaTest extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
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
					PrenotaTest  frame1= new PrenotaTest(controller, frame, toString(), toString(), toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame: mostra tutti i test prenotabili(con iscrizioni aperte o in corso) e permette la scelta di un nuovo test..
	 *
	 * @param controller1 the controller 1
	 * @param frame the frame
	 * @param matricola the matricola
	 * @param username the username
	 * @param password the password
	 * @throws Exception the exception
	 */
	public PrenotaTest(Controller controller1, Window frame, String matricola, String username, String password) throws Exception {
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
		scelta = controller1.getScelta();
		
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

		//AGGIUNGI CHECKBOX
		//Aggiungi lista 
		}

		JButton btn=new JButton("Prenota");
		JLabel lblNewLabel_1_1_1 = new JLabel();
	    lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1_1_1.setForeground(Color.BLACK);
	    lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
	    lblNewLabel_1_1_1.setBounds(-1, 320, 737, 24);
	    getContentPane().add(lblNewLabel_1_1_1);
	    
	    JLabel lblNewLabel_1_1_1_1 = new JLabel();
	    lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
	    lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
	    lblNewLabel_1_1_1_1.setBounds(-1, 343, 737, 24);
	    getContentPane().add(lblNewLabel_1_1_1_1);
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
							HomeStudente ti= new HomeStudente(controller1, matricola, username, password);
							ti.show();
							dispose();	
						} catch (Exception e) {
							lblNewLabel_1_1_1.setText("Errore1: non puoi fare due test nella stessa giornata");
						    lblNewLabel_1_1_1_1.setText("Errore2: iscrizioni non aperte/chiuse");

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
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Prenota Test");
	    lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1_1.setForeground(Color.RED);
	    lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 30));
	    lblNewLabel_1_1.setBounds(-1, 41, 737, 37);
	    getContentPane().add(lblNewLabel_1_1);
	    
	    JButton btnEsci = new JButton("Esci");
	    btnEsci.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		HomeStudente ti= new HomeStudente(controller1, matricola, username, password);
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
