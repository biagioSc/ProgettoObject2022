package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import Model.Correzione;
import Model.RispostaAperta;
import Model.Test;
import Model.TestScelti;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCorreggere.
 */
public class TestCorreggere extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The table. */
	private JTable table;
	
	/** The controller. */
	static Controller controller;
	
	/** The text field. */
	private JTextField textField;

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
					TestCorreggere frame1 = new TestCorreggere(controller, frame, toString(),toString(),toString(), toString(), toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 * @param controller1 the controller 1
	 * @param frame the frame
	 * @param idtest the idtest
	 * @param identificativo the identificativo
	 * @param username the username
	 * @param password the password
	 * @param matricola the matricola
	 * @throws Exception the exception
	 */
	public TestCorreggere(Controller controller1, Window frame,String idtest, String identificativo, String username, String password, String matricola) throws Exception {
	setTitle(username.substring(4)+ " è online ");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(200, 200, 750, 450);
	setVisible(true);
	getContentPane().setLayout(null);
	
	
	JScrollPane scroll= new JScrollPane();
	scroll.setBounds(0,77,736,153);
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
			case 8:
				return 	Boolean.class;
			default:
				return String.class;
				
			}
		}
	};
	

	table.setModel(model);
	model.addColumn("IdQuiz");
	model.addColumn("Matricola");
	model.addColumn("Domanda");
	model.addColumn("Risposta");
	model.addColumn("PunteggioMin");
	model.addColumn("PunteggioMax");
	model.addColumn("Correzioni");
	model.addColumn("PunteggioAssegnato");
	model.addColumn("Select");

	table.getColumnModel().getColumn(0).setPreferredWidth(50);
	table.getColumnModel().getColumn(1).setPreferredWidth(50);
	table.getColumnModel().getColumn(2).setPreferredWidth(700);
	table.getColumnModel().getColumn(3).setPreferredWidth(1200);
	table.getColumnModel().getColumn(4).setPreferredWidth(50);	
	table.getColumnModel().getColumn(5).setPreferredWidth(50);
	table.getColumnModel().getColumn(6).setPreferredWidth(700);
	table.getColumnModel().getColumn(7).setPreferredWidth(100);
	table.getColumnModel().getColumn(8).setPreferredWidth(50);


	ArrayList<RispostaAperta> r=new ArrayList<RispostaAperta>();
	RispostaApertaImplementazionePDAO tc= new RispostaApertaImplementazionePDAO();
	r = tc.getTestCorreggereBtn(identificativo, matricola);
	if (r!=null)
		
		for (int i=0;i<r.size();i++) { 
		model.addRow(new Object[0]);
		model.setValueAt(r.get(i).getIdqa(),i,0);
		model.setValueAt(r.get(i).getMat(),i,1);
		model.setValueAt(r.get(i).getDomanda(),i,2);
		model.setValueAt(r.get(i).getRisposta(),i,3);
		model.setValueAt(r.get(i).getPmin(),i,4);
		model.setValueAt(r.get(i).getPmax(),i,5);
		model.setValueAt(r.get(i).getCorrez(),i,6);
		model.setValueAt(r.get(i).getPass(),i,7);

		model.setValueAt(false,i,8);

	//AGGIUNGI CHECKBOX
	//Aggiungi lista 
	}

	JButton btn=new JButton("Salva correzione");
	btn.setBackground(Color.ORANGE);
	btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btn.addActionListener(new ActionListener(){
		private Timestamp datac;

		public void actionPerformed(ActionEvent arg0) {
			TestImplementazionePDAO T=new TestImplementazionePDAO();
			for(int i=0;i<table.getRowCount();i++) {
				Boolean checked=Boolean.valueOf(table.getValueAt(i,8).toString());
				if(checked) {

					try {
						TestImplementazionePDAO t= new TestImplementazionePDAO();
						ArrayList<Test> tst = new ArrayList<Test>();
						tst=t.getTest(idtest);
						for (int j=0;j<tst.size();j++) { 

						 datac= tst.get(j).getD();}
						RispostaApertaImplementazionePDAO up= new RispostaApertaImplementazionePDAO();
						up.UpdateR(matricola,datac,String.valueOf(table.getValueAt(i,0)), String.valueOf(table.getValueAt(i,7)),String.valueOf(table.getValueAt(i,6))); 
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			
			}
		}				
	});
	btn.setBounds(258,377,188,30);
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
    		HomeInsegnante ti= new HomeInsegnante(controller1,identificativo, username, password);
			ti.show();
			dispose();
			}
    });
    btnEsci.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnEsci.setBackground(Color.ORANGE);
    btnEsci.setBounds(64, 377, 150, 30);
    getContentPane().add(btnEsci);
    
    JButton btnCalcolaPunteggioTotale = new JButton("Calcola Punteggio Totale");
    btnCalcolaPunteggioTotale.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		for(int i=0;i<table.getRowCount();i++) {
				Boolean checked=Boolean.valueOf(table.getValueAt(i,8).toString());
				if(checked) {

    		CorrezionImplementazionePDAO c=new CorrezionImplementazionePDAO();
    		try {
				c.UpdateC(idtest,identificativo,matricola);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}else {
				JOptionPane.showMessageDialog(contentPane, "Seleziona tutti i quiz corretti prima di calcolare punteggio totale!");

			}
			}
				
    	}
    });
    btnCalcolaPunteggioTotale.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnCalcolaPunteggioTotale.setBackground(Color.ORANGE);
    btnCalcolaPunteggioTotale.setBounds(479, 377, 231, 30);
    getContentPane().add(btnCalcolaPunteggioTotale);
    
    JTextArea txtrNotaNonImmettere = new JTextArea();
    txtrNotaNonImmettere.setBackground(Color.WHITE);
    txtrNotaNonImmettere.setText("Nota: non immettere valori fuori dall'intervallo disponibile per punteggio assegnato; \r\ncalcola punteggio totale solo dopo aver corretto TUTTI i quiz di un test di una matricola;");
    txtrNotaNonImmettere.setBounds(0, 330, 726, 44);
    getContentPane().add(txtrNotaNonImmettere);
    
    textField = new JTextField();
    textField.setBounds(190, 244, 56, 19);
    getContentPane().add(textField);
    textField.setColumns(10);
    
    JTextArea textArea = new JTextArea();
    textArea.setWrapStyleWord(true);
    textArea.setBounds(260, 266, 450, 51);
    getContentPane().add(textArea);
    
    JButton btnUpdate = new JButton("Update");
    btnUpdate.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		int z=table.getSelectedRow();
    		if(z>=0) {    	
    			model.setValueAt(textField.getText(), z, 7);
    			model.setValueAt(textArea.getText(), z, 6);

    	}}
    });
    btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
    btnUpdate.setBackground(Color.WHITE);
    btnUpdate.setBounds(20, 266, 155, 48);
    getContentPane().add(btnUpdate);
    
   
    
    JLabel lblNewLabel = new JLabel("Assegna punteggio");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblNewLabel.setBounds(10, 240, 173, 22);
    getContentPane().add(lblNewLabel);
    
    JLabel lblCorrezioni = new JLabel("Correzioni");
    lblCorrezioni.setHorizontalAlignment(SwingConstants.CENTER);
    lblCorrezioni.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblCorrezioni.setBounds(258, 240, 452, 22);
    getContentPane().add(lblCorrezioni);
    
}
}
