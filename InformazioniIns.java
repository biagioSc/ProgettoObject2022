package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Informazioni Insegnante: mostra nome,cognome,usernem,password,identificativo dell'utente insegnante.
 */
public class InformazioniIns extends JFrame {
	
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
					InformazioniIns  frame1= new InformazioniIns(controller, frame, toString(), toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiates a new informazioni Insegnante: mostra nome,cognome,usernem,password,identificativo dell'utente insegnante..
	 *
	 * @param controller the controller
	 * @param frame the frame
	 * @param string2 the string 2
	 * @param string3 the string 3
	 * @throws Exception the exception
	 */
	public InformazioniIns(Controller controller, Window frame, String string2, String string3) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JFrame f =new JFrame();    
	   
	         		    
		table = new JTable();
		table.setEnabled(false);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    table.setBounds(30,40,200,300);          
	    table.setRowHeight(30);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Informazioni Profilo",}//	"Nome", "Cognome","Matricola","Username", "Password"}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(220);

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList info = controller.getInfoInsegnante(string2,string3);

		if (info!=null)
			for(int i=0;i<info.size();i++) {
				model.addRow(new Object[]{info.get(i)});
		
		//contentPane.add(table);
		}
		 f.getContentPane().setLayout(null);
		 JScrollPane sp=new JScrollPane(table);    
		 sp.setBounds(0, 72, 286, 207);
		    f.getContentPane().add(sp);
		    
		    JPanel panel_2 = new JPanel();
		    panel_2.setLayout(null);
		    panel_2.setBackground(Color.ORANGE);
		    panel_2.setBounds(0, 10, 286, 44);
		    f.getContentPane().add(panel_2);
		    
		    JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
		    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		    lblNewLabel_1.setForeground(Color.WHITE);
		    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		    lblNewLabel_1.setBounds(0, 5, 286, 29);
		    panel_2.add(lblNewLabel_1);
		    f.setSize(300,316);    
		    f.setVisible(true); 
		    
	}
	}
