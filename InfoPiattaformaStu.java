package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class InfoPiattaformaStu: informazioni di utilizzo piattaforma (studente).
 */
public class InfoPiattaformaStu extends JFrame {

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
				Window frame = null;
				try {
					InfoPiattaformaStu frame1 = new InfoPiattaformaStu();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame: informazioni di utilizzo piattaforma (studente).
	 */
	public InfoPiattaformaStu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(0, 10, 736, 44);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("e-Learning ErBi");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 5, 736, 39);
		panel_2.add(lblNewLabel_1);
		
		JTextArea txtrBenevenutiNellaSezione = new JTextArea();
		txtrBenevenutiNellaSezione.setText("Benevenuti nella sezione 'Manuale d'uso Piattaforma'.\r\nIn questa sezione troverete tutte le informazioni sull'utilizzo del sistema \r\ndi e-learning.\r\nNella barra dei menu \u00E8 possibile modificare il proprio \r\nlogin(username e password). \r\nInoltre \u00E8 possibile consultare i test a cui ci si pu\u00F2 prenotare,\r\n quelli a cui ci si \u00E8 prenotati e i relativi risultati ottenuti, \r\ne in pi\u00F9 ci si pu\u00F2 prenotare a nuovi test.\r\nIl giorno della prova sar\u00E0 possibile cliccare sul pulsante adibito e iniziare il test.\r\n");
		txtrBenevenutiNellaSezione.setFont(new Font("Cambria", Font.PLAIN, 22));
		txtrBenevenutiNellaSezione.setEditable(false);
		txtrBenevenutiNellaSezione.setBounds(10, 114, 716, 262);
		contentPane.add(txtrBenevenutiNellaSezione);
		txtrBenevenutiNellaSezione.setLineWrap(true);

		JLabel lblNewLabel_1_1 = new JLabel("Manuale d'uso Piattaforma");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(0, 65, 736, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnEsci = new JButton("Esci");
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnEsci.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEsci.setBackground(Color.ORANGE);
		btnEsci.setBounds(294, 386, 174, 24);
		contentPane.add(btnEsci);
	}
}
