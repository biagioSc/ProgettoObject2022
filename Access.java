package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import javax.swing.JFrame;
import Controller.Controller;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


// TODO: Auto-generated Javadoc
/**
 * The Class Access: crea una nuova pagina di accesso alla piattaforma.
 */
public class Access {
	
	/** The controller. */
	public Controller controller;
	
	/** The frame. */
	JFrame frame;

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller c=new Controller();
					Access window = new Access(c);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Instantiates a new access: crea una nuova pagina di accesso alla piattaforma.
	 *
	 * @param c the c
	 */
	public Access(Controller c) {
		controller=c;
		initialize();
		frame.setVisible(true);	}

	
	/**
	 * Initialize: viene aperto un frame di benvenuto dove l'utente può accedere alla piattaforma o uscire.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 frame.addComponentListener( new ComponentListener() {
			 @Override
           	public void componentResized(ComponentEvent e) {}
			@Override
			public void componentMoved(ComponentEvent e) {}
			@Override
			public void componentHidden(ComponentEvent e) {}
			@Override
			public void componentShown(ComponentEvent e) {
				
			}
         } );
		 
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pagina di accesso alla piattaforma di e-Learnign ErBi");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 103, 416, 72);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Benvenuto");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Toledo", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(10, 41, 416, 72);
		frame.getContentPane().add(lblNewLabel_1);
		

		JButton btnNewButton = new JButton("Accedi");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				AccessoPrincipale accesso=new AccessoPrincipale(controller);
				frame.setVisible(false);
				accesso.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessoPrincipale accesso=new AccessoPrincipale(controller);
				frame.setVisible(false);
				accesso.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(154, 185, 144, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Chiudi pagina");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        System.exit(0);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(154, 216, 144, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}
