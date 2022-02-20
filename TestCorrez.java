package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import ImplementazionePDAO.CorrezionImplementazionePDAO;
import ImplementazionePDAO.RispostaApertaImplementazionePDAO;
import ImplementazionePDAO.TestImplementazionePDAO;
import ImplementazionePDAO.TestSceltiImplementazionePDAO;
import Model.Correzione;
import Model.RispostaAperta;
import Model.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCorrez: crea tabella con tutti i test di una matricola da correggere dall'utente insegnante propietario di quel test.
 */
public class TestCorrez extends JFrame {
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The table. */
	private JTable table;
	
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
					TestCorrez frame1 = new TestCorrez(controller, frame, toString(),toString(), toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Class TestCorrez: crea tabella con tutti i test di una matricola da correggere dall'utente insegnante propietario di quel test.
	 * .
	 *
	 * @param controller1 the controller 1
	 * @param frame the frame
	 * @param identificativo the identificativo
	 * @param username the username
	 * @param password the password
	 * @throws Exception the exception
	 */
	public TestCorrez(Controller controller1, Window frame,String identificativo, String username, String password) throws Exception {
	setTitle(username.substring(4)+ " è online ");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(200, 200, 750, 450);
	setVisible(true);
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
	model.addColumn("Matricola");
	model.addColumn("Select");

	table.getColumnModel().getColumn(0).setPreferredWidth(50);
	table.getColumnModel().getColumn(1).setPreferredWidth(220);
	table.getColumnModel().getColumn(2).setPreferredWidth(120);
	table.getColumnModel().getColumn(3).setPreferredWidth(80);
	table.getColumnModel().getColumn(4).setPreferredWidth(50);

	ArrayList<Correzione> r=new ArrayList<Correzione>();
	CorrezionImplementazionePDAO tc= new CorrezionImplementazionePDAO();
	r = tc.getTestCorrez(identificativo);
	if (r!=null)
		
		for (int i=0;i<r.size();i++) { 
		model.addRow(new Object[0]);
		model.setValueAt(r.get(i).getIdTest(),i,0);
		model.setValueAt(r.get(i).getNomeTest(),i,1);
		model.setValueAt(r.get(i).getDataTest(),i,2);
		model.setValueAt(r.get(i).getMatricola(),i,3);
	
		model.setValueAt(false,i,4);

	//AGGIUNGI CHECKBOX
	//Aggiungi lista 
	}

	JButton btn=new JButton("Apri Test");
	btn.setBackground(Color.ORANGE);
	btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			TestImplementazionePDAO T=new TestImplementazionePDAO();
			for(int i=0;i<table.getRowCount();i++) {
				Boolean checked=Boolean.valueOf(table.getValueAt(i,4).toString());
				if(checked) {
					try {
						//T.(string,table.getValueAt(i,0).toString());
						TestCorreggere ti= new TestCorreggere(controller1, frame,String.valueOf(table.getValueAt(i,0)), identificativo, username, password,String.valueOf(table.getValueAt(i,3)));
						dispose();
					} catch (Exception e) {
						
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
    
    JLabel lblNewLabel_1_1 = new JLabel("Scegli Test");
    lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_1_1.setForeground(Color.RED);
    lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 30));
    lblNewLabel_1_1.setBounds(-1, 41, 737, 37);
    getContentPane().add(lblNewLabel_1_1);
    
    JButton btnEsci = new JButton("Esci");
    btnEsci.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		setVisible(false);
    		HomeInsegnante ti= new HomeInsegnante(controller1,identificativo, username, password);
			ti.show();
			dispose();
			}
    });
    btnEsci.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnEsci.setBackground(Color.ORANGE);
    btnEsci.setBounds(222, 377, 150, 30);
    getContentPane().add(btnEsci);
    
	
}
}
