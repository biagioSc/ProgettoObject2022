package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

// TODO: Auto-generated Javadoc
/**
 * The Class Registrazione: apre frame per scegliere ruolo all'interno del sistema in fase di registrazione.
 */
public class Registrazione extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The controller. */
	public static Controller controller;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione frame = new Registrazione(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Registrazione: apre frame per scegliere ruolo all'interno del sistema in fase di registrazione.
	 *
	 * @param controller the controller
	 */
	public Registrazione(Controller controller) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 255);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 10, 447, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Benvenuto nella sezione Registrazione");
		lblNewLabel.setBounds(0, 0, 437, 51);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserire i dati richiesti");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(38, 69, 390, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Sono un");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(38, 125, 82, 24);
		contentPane.add(lblNewLabel_4);
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Insegnante"}));
		comboBox.setBounds(130, 125, 243, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Clicca per proseguire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = (String) comboBox.getSelectedItem();
				String obj = "Studente";
				String obj2 = "Insegnante";

				if (x.equals(obj)) {
					Studente stu=new Studente(controller);
					stu.setVisible(true);
					dispose();
				} else if (x.equals(obj2)) {
					Insegnante ins=new Insegnante(controller);
					ins.setVisible(true);
					dispose();
				}
			}});
		
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(130, 188, 200, 24);
		contentPane.add(btnNewButton);
		

	}
}
