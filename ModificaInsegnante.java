package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class ModificaInsegnante: mostra le informazioni dell'utente insegnante, e ne salva eventuali modifiche.
 */
public class ModificaInsegnante extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The txt stud. */
	private JTextField txtStud;
	
	/** The text field 2. */
	private JTextField textField_2;
	
	/** The controller 2. */
	static Controller controller2;

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
					ModificaInsegnante frame1 = new ModificaInsegnante(controller2, frame, toString(), toString(), toString());
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame: mostra le informazioni dell'utente insegnante, e ne salva eventuali modifiche.
	 *
	 * @param controller1 the controller 1
	 * @param frame the frame
	 * @param username the username
	 * @param password the password
	 * @param identificativo the identificativo
	 */

public ModificaInsegnante(Controller controller1, Window frame, String username, String password, String identificativo) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 452, 415);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.RED);
	panel.setBounds(0, 10, 436, 61);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Benevenuti nella sezione Insegnante");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
	lblNewLabel.setBounds(0, 10, 436, 41);
	panel.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Inserire i dati richiesti");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblNewLabel_1.setBounds(103, 81, 244, 24);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_5 = new JLabel("Old Username");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_5.setBackground(Color.RED);
	lblNewLabel_5.setBounds(30, 134, 156, 24);
	contentPane.add(lblNewLabel_5);
	
	JLabel lblNewLabel_5_1 = new JLabel("Old Password");
	lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_5_1.setBackground(Color.RED);
	lblNewLabel_5_1.setBounds(30, 168, 156, 24);
	contentPane.add(lblNewLabel_5_1);
	
	JLabel lblNewLabel_6_1 = new JLabel("");
	lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNewLabel_6_1.setBounds(133, 307, 200, 22);
	contentPane.add(lblNewLabel_6_1);
	
	JLabel lblNewLabel_5_2 = new JLabel("");
	lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_5_2.setBackground(Color.RED);
	lblNewLabel_5_2.setBounds(196, 134, 212, 24);
	contentPane.add(lblNewLabel_5_2);
	
	JLabel lblNewLabel_5_4 = new JLabel("");
	lblNewLabel_5_4.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNewLabel_5_4.setBackground(Color.RED);
	lblNewLabel_5_4.setBounds(196, 168, 212, 24);
	contentPane.add(lblNewLabel_5_4);
	lblNewLabel_5_2.setText(username);
	lblNewLabel_5_4.setText(password);
	JButton btnCliccaPerProseguire = new JButton("SALVA");
	btnCliccaPerProseguire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				LocalDate todaysDate = LocalDate.now();
				
				controller1.modificaInsegnante(username,password,txtStud.getText(),textField_2.getText(),todaysDate);
				Access accesso=new Access(controller1);
				dispose();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				lblNewLabel_6_1.setText("Username o Password errata");
				e1.printStackTrace();
				
			}
			
		}
	});
	btnCliccaPerProseguire.setForeground(Color.BLACK);
	btnCliccaPerProseguire.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnCliccaPerProseguire.setBackground(Color.ORANGE);
	btnCliccaPerProseguire.setBounds(220, 339, 200, 24);
	contentPane.add(btnCliccaPerProseguire);
	
	txtStud = new JTextField();
	txtStud.setFont(new Font("Times New Roman", Font.BOLD, 18));
	txtStud.setColumns(10);
	txtStud.setBounds(237, 203, 171, 25);
	contentPane.add(txtStud);
	
	JLabel lblNewLabel_5_3 = new JLabel("New Username");
	lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_5_3.setBackground(Color.RED);
	lblNewLabel_5_3.setBounds(30, 202, 156, 24);
	contentPane.add(lblNewLabel_5_3);
	
	JLabel lblNewLabel_6 = new JLabel("New Password");
	lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblNewLabel_6.setBounds(30, 242, 136, 22);
	contentPane.add(lblNewLabel_6);
	
	textField_2 = new JTextField();
	textField_2.setHorizontalAlignment(SwingConstants.CENTER);
	textField_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
	textField_2.setColumns(10);
	textField_2.setBounds(196, 242, 212, 25);
	contentPane.add(textField_2);
	
	JLabel lblNewLabel_2 = new JLabel("ins_");
	lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
	lblNewLabel_2.setBounds(196, 204, 49, 22);
	contentPane.add(lblNewLabel_2);
	
	Label label = new Label("Username e Password 8-50 caratteri");
	label.setAlignment(Label.CENTER);
	label.setBounds(0, 280, 372, 21);
	contentPane.add(label);
	
	JButton btnEsci = new JButton("ESCI");
	btnEsci.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			HomeInsegnante ti= new HomeInsegnante(controller1,identificativo, username, password);
			ti.show();
			dispose();
		}
	});
	btnEsci.setForeground(Color.BLACK);
	btnEsci.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnEsci.setBackground(Color.ORANGE);
	btnEsci.setBounds(10, 339, 200, 24);
	contentPane.add(btnEsci);
	

	
	
}
}