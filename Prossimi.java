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
import Model.Test;
import Model.TestScelti;
// TODO: Auto-generated Javadoc

/**
 * The Class Prossimi: mostra gli esami prossimi di un utente insegnante.
 */
public class Prossimi extends JFrame {
	
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
						Prossimi  frame1= new Prossimi(controller, frame, toString(), toString());
						frame1.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Instantiates a new prossimi: mostra gli esami prossimi di un utente insegnante..
		 *
		 * @param controller the controller
		 * @param frame the frame
		 * @param username the username
		 * @param password the password
		 * @throws Exception the exception
		 */
		public Prossimi(Controller controller, Window frame, String username, String password) throws Exception {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JFrame f =new JFrame();    
		   
			f.setTitle(username.substring(4)+ " è online ");

			table = new JTable();
			table.setEnabled(false);
			table.setForeground(Color.BLACK);
			table.setBackground(Color.WHITE);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		    table.setBounds(30,40,200,300);          
		    table.setRowHeight(25);
		   
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome Test","IDTest", "Data Test", 
					"Inizio Iscrizioni","Fine Iscrizione","Durata",
					"Soglia","IdIns","DataOperazione"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(220);
			table.getColumnModel().getColumn(1).setPreferredWidth(45);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(45);
			table.getColumnModel().getColumn(7).setPreferredWidth(55);
			table.getColumnModel().getColumn(8).setPreferredWidth(100);


			DefaultTableModel model = (DefaultTableModel) table.getModel();

			ArrayList<Test> prossimi = new ArrayList();
			prossimi = controller.getProssimi(username, password);
			if (prossimi!=null)
			

					for (int i=0;i<prossimi.size();i++) { 
						model.addRow(new Object[]{prossimi.get(i).getNome(),prossimi.get(i).getIdt(),prossimi.get(i).getD(),prossimi.get(i).getDI(),prossimi.get(i).getDF(),prossimi.get(i).getT(),prossimi.get(i).getPM(),prossimi.get(i).getIdIns(),prossimi.get(i).getDO(),prossimi.get(i).getOp()});
					}
			//contentPane.add(table);
			 f.getContentPane().setLayout(null);
			 JScrollPane sp=new JScrollPane(table);    
			 sp.setBounds(0, 72, 581, 207);
			    f.getContentPane().add(sp);
			    int AUTO_RESIZE_ALL_COLUMN = 0;
			   	table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMN) ;
			    JPanel panel_2 = new JPanel();
			    panel_2.setLayout(null);
			    panel_2.setBackground(Color.ORANGE);
			    panel_2.setBounds(0, 10, 581, 44);
			    f.getContentPane().add(panel_2);
			    
			    JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
			    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			    lblNewLabel_1.setForeground(Color.WHITE);
			    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			    lblNewLabel_1.setBounds(0, 5, 589, 29);
			    panel_2.add(lblNewLabel_1);
			    f.setSize(596,316);    
			    f.setVisible(true); 
			    
		}
		}
