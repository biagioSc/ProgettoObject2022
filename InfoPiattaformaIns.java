package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class InfoPiattaformaIns: informazioni di utilizzo piattaforma (insegnante).
 */
public class InfoPiattaformaIns extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoPiattaformaIns frame = new InfoPiattaformaIns();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame: informazioni di utilizzo piattaforma (insegnante)..
	 */
	public InfoPiattaformaIns() {
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
		txtrBenevenutiNellaSezione.setText("Benevenuti nella sezione 'Manuale d'uso Piattaforma'. In questa sezione troverete tutte le informazioni sull'utilizzo del sistema  di e-learning. Nella barra dei menu \u00E8 possibile modificare il proprio login (username e password).  \r\nInoltre \u00E8 possibile gestire (creazione, modifica e visualizzazione) i test che si sono creati o che si vuole creare.  \r\nPer ogni test possiamo vedere i quiz che contiene, gli studenti che hanno svolto il test, correggere i compiti \r\ndegli studenti per ogni test, e vedere i test che devono ancora essere svolti. Inoltre \u00E8 possibile creare i quiz e \r\ncollegarli ad un test (non \u00E8 possibile modificarli), ed \u00E8 possibile vedere tutti i quiz creati e disponibili nella \r\npiattaforma.\r\nInfine \u00E8 importante sapere che: \r\n-ogni test e quiz ha un id unico creato automaticamente dal sistema\r\n-ogni test non pu\u00F2 essere modificato dopo l'inizio delle iscrizioni\r\n-ogni test pu\u00F2 avere una durata massima di svolgimento di 8 ore (480 minuti)\r\n-i quiz sono entit\u00E0 scorrelate dai test\r\n-non \u00E8 possibile inserire quiz ad un test dopo l'inizio delle iscrizioni\r\n-una volta corretto il test non sar\u00E0 possibile modificare la correzione");
		txtrBenevenutiNellaSezione.setFont(new Font("Cambria", Font.PLAIN, 14));
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
