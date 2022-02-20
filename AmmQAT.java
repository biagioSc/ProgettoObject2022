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
import ImplementazionePDAO.TestImplementazionePDAO;
import ImplementazionePDAO.TestSceltiImplementazionePDAO;
import Model.Insegnante;
import Model.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class AmmQAT (Ammette quiz aperto in test).
 */
public class AmmQAT extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The table (test a cui è possibile aggiungere quiz). */
	private JTable table;
	
	/** The controller. */
	static Controller controller;
	
	/** The insegnante j. */
	private Insegnante j;

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
					AmmQAT  frame1= new AmmQAT(controller, frame, toString(), toString(),toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiates a new amm QAT: AmmQAT (Ammette quiz aperto in test).
	 *
	 * @param controller1 the controller 1
	 * @param frame the frame
	 * @param username the username
	 * @param password the password
	 * @param identificativo the identificativo
	 * @throws Exception the exception
	 */
	public AmmQAT(Controller controller1, Window frame, String username, String password, String identificativo) throws Exception {
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

					return 	Boolean.class;
				default:
					return String.class;
					
				}
			}
		};
		
		table.setModel(model);
		model.addColumn("Nome Test");
		model.addColumn("IDTest");
		model.addColumn("Data Test");
		model.addColumn("Modifica");

		table.getColumnModel().getColumn(0).setPreferredWidth(220);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		


		ArrayList<Test> scelta = new ArrayList();
		 TestImplementazionePDAO S=new TestImplementazionePDAO();
			j=new Insegnante(username,password);

		
		scelta =S.getTestModificabili(j);

		
		if (scelta!=null)
		for (int i=0;i<scelta.size();i++) { 
			model.addRow(new Object[0]);
			model.setValueAt(scelta.get(i).getNome(),i,0);
			model.setValueAt(scelta.get(i).getIdt(),i,1);
			model.setValueAt(scelta.get(i).getD(),i,2);
			
			model.setValueAt(false,i,3);
			
		//AGGIUNGI CHECKBOX
		//Aggiungi lista 
		}

		JButton btn=new JButton("Continua");
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
					Boolean checked=Boolean.valueOf(table.getValueAt(i,3).toString());
					if(checked) {
						Window frame = null;
						JFrame frameTestCreati;
						try {
							setVisible(false);
							frameTestCreati = new InsertQAT(controller1,frame,String.valueOf(table.getValueAt(i, 1)),username,password,identificativo);
							frameTestCreati.show();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Scegli Test a cui aggiungere Quiz");
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
	