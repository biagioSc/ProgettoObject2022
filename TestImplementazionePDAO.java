package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import DAO.TestDAO;
import DAO.TestSceltiDAO;
import Database.ConnessioneDB;
import Model.Correzione;
import Model.Insegnante;
import Model.Studente;
import Model.Test;
import Model.TestScelti;

// TODO: Auto-generated Javadoc
/**
 * The Class TestImplementazionePDAO.
 */
public class TestImplementazionePDAO implements TestDAO{

		/** The connection. */
		private Connection connection;
		
		/** The a. */
		private String a;
		
		/** The k. */
		private String k;
		
		/** The e. */
		private String e;
		
		/** The h. */
		private String h;
		
		/** The o. */
		private String o;
		
		/** The p. */
		private String p;
		
		/** The g. */
		private String g;
		
		/** The q. */
		private String q;
		
		/** The w. */
		private String w;
		
		/** The x. */
		private String x;
		
		/** The v. */
		private String v;
		
		/** The j. */
		private int j;
		
		/** The b. */
		private int b;
		
		/** The z. */
		public String z = null;
		
		/** The l. */
		public ArrayList l = new ArrayList();
		
		/** The d. */
		public TestScelti d;
		
		/** The c. */
		public ArrayList c = new ArrayList();
		
		/** The scelta. */
		public ArrayList<Test> scelta= new ArrayList<Test>();
		
		/** The testcreati. */
		private ArrayList<Test> testcreati= new ArrayList<Test>();
		
		/** The prossimi. */
		private ArrayList<Test> prossimi= new ArrayList<Test>();
		
		/** The se. */
		private ArrayList<Correzione> se= new ArrayList<Correzione>();
		
		/** The t. */
		private ArrayList<Test> t= new ArrayList<Test>();

		
		/**
		 * Instantiates a new test implementazione PDAO.
		 */
		public TestImplementazionePDAO() {
			try {
				connection = ConnessioneDB.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * Ritorna tutti i test a cui si si può prenotare.
		 *
		 * @return the scelta
		 * @throws Exception the exception
		 */
		public ArrayList getScelta() throws Exception {
			
			try {
			PreparedStatement leggiup;
			
				leggiup = connection.prepareStatement(
						
				"SELECT * FROM  test  where date(datainizioiscr)<=current_date and date(datafineiscr)>=current_date and date(datatest)<>current_date order by datatest");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
						Test d = new Test(rs.getInt("idt"),rs.getString("nometest"),rs.getTimestamp("datatest"),rs.getTimestamp("datainizioiscr"),rs.getTimestamp("datafineiscr"),rs.getTime("Temposvolgimento"),rs.getInt("punteggiominpos"));
					scelta.add(d);

						connection.close();
					}
				rs.close();

				return scelta;
			}catch(Exception e) {
				throw new Exception("Non ci sono info2");
				}
			}
		
		/**
		 * Ritorna tutti i test disponibili.
		 *
		 * @return the disponibili
		 * @throws Exception the exception
		 */
		public ArrayList getDisponibili() throws Exception {
			
			try {
			PreparedStatement leggiup;
			
				leggiup = connection.prepareStatement(
						
				"SELECT * FROM  test  where date(datatest)>current_date order by datatest");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
						Test d = new Test(rs.getInt("idt"),rs.getString("nometest"),rs.getTimestamp("datatest"),rs.getTimestamp("datainizioiscr"),rs.getTimestamp("datafineiscr"),rs.getTime("Temposvolgimento"),rs.getInt("punteggiominpos"));
					scelta.add(d);

						connection.close();
					}
				rs.close();

				return scelta;
			}catch(Exception e) {
				throw new Exception("Non ci sono info2");
				}
			}
		
	/**
	 * Ritorna tutti i test creati.
	 *
	 * @param s the s
	 * @return the test creati
	 * @throws Exception the exception
	 */
	public ArrayList getTestCreati(Insegnante s) throws Exception {
		InsegnanteImplementazionePDAO S=new InsegnanteImplementazionePDAO();
		b=S.getIdInt(s);
		
		try {
			PreparedStatement leggiup;
			
				leggiup = connection.prepareStatement(
						
				"SELECT * FROM  test where identificativo='"+b+"' order by datatest");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					Test d = new Test(rs.getInt("idt"),rs.getString("nometest"),rs.getTimestamp("datatest"),rs.getTimestamp("datainizioiscr"),rs.getTimestamp("datafineiscr"),rs.getTime("Temposvolgimento"),rs.getInt("punteggiominpos"),rs.getInt("identificativo"),rs.getDate("dataoperazione"));
					testcreati.add(d);

						connection.close();
					}
				rs.close();

				return testcreati;
			}catch(Exception e) {

				throw new Exception(e.getMessage());
				}
	
	}
	
	/**
	 * Ritorna i test prossimi che saranno svolti.
	 *
	 * @param s the s
	 * @return the prossimi
	 * @throws Exception the exception
	 */
	public ArrayList getProssimi(Insegnante s) throws Exception {
		InsegnanteImplementazionePDAO S=new InsegnanteImplementazionePDAO();
		b=S.getIdInt(s);
		
		try {
			PreparedStatement leggiup;
			
				leggiup = connection.prepareStatement(
						
				"SELECT * FROM  test where identificativo='"+b+"'and datatest>=current_date order by datatest");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					Test d = new Test(rs.getInt("idt"),rs.getString("nometest"),rs.getTimestamp("datatest"),rs.getTimestamp("datainizioiscr"),rs.getTimestamp("datafineiscr"),rs.getTime("Temposvolgimento"),rs.getInt("punteggiominpos"),rs.getInt("identificativo"),rs.getDate("dataoperazione"));
					prossimi.add(d);

						connection.close();
					}
				rs.close();

				return prossimi;
			}catch(Exception e) {

				throw new Exception(e.getMessage());
				}
	
		
	}
	
	/**
	 * Ritorna tutti gli studenti esaminati.
	 *
	 * @param j the j
	 * @return the se
	 * @throws Exception the exception
	 */
	public ArrayList getStudentiEsaminati(Insegnante j) throws Exception {
		InsegnanteImplementazionePDAO S=new InsegnanteImplementazionePDAO();
		b=S.getIdInt(j);
		
		try {
			PreparedStatement leggiup;
			
				leggiup = connection.prepareStatement(
						
						" SELECT test.idt,test.nometest, datatest, correzione.matricola, esito, punteggiotot FROM (correzione join test on correzione.idt =test.idt) join testscelti on correzione.matricola=testscelti.matricola where test.identificativo='"+b+"' order by datatest");		
						ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					Correzione d = new Correzione(rs.getInt("idt"),rs.getString("nometest"),rs.getDate("datatest"),rs.getInt("matricola"),rs.getString("esito"),rs.getInt("punteggiotot"));
					se.add(d);

						connection.close();
					}
				rs.close();

				return se;
			}catch(Exception e) {

				throw new Exception(e.getMessage());
				}
	}
	
	/**
	 * Insert T: inserisce il nuovo test creato nel database.
	 *
	 * @param idins the idins
	 * @param nome the nome
	 * @param pmpos the pmpos
	 * @param dt the dt
	 * @param tempo the tempo
	 * @param di the di
	 * @param df the df
	 * @throws Exception the exception
	 */
	public void InsertT(String idins, String nome, String pmpos, String dt, String tempo, String di, String df) throws Exception {
		if(Integer.valueOf(tempo)>480 )throw new Exception("Errore");
				else {
		try	{PreparedStatement nuovaReg = connection.prepareStatement(
				
				" INSERT INTO TEST(identificativo,nometest,datatest,datainizioiscr,datafineiscr,temposvolgimento,punteggiominpos,dataoperazione)\r\n"
				+ "values('"+Integer.valueOf(idins)+"',"+"'"+nome+"','"+Timestamp.valueOf(dt)+"',"+"'"+Timestamp.valueOf(di)+"',"+"'"+Timestamp.valueOf(df)+"','"+Integer.valueOf(tempo)+"minute',"+"'"+Integer.valueOf(pmpos)+"', current_date);");
			nuovaReg.executeUpdate();
			connection.close();
					} catch(Exception e) { throw new Exception("Errore");
					}
		
	}}
	
	/**
	 * Ritorna le informazioni di un test.
	 *
	 * @param i the i
	 * @return the test
	 * @throws Exception the exception
	 */
	public ArrayList getTest(String i) throws Exception {
		int j=Integer.valueOf(i);
		try {
			PreparedStatement leggiup;
			
				leggiup = connection.prepareStatement(
						
						" SELECT * FROM test where idt='"+j+"'");		
						ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					Test d = new Test(rs.getInt("idt"),rs.getString("nometest"),rs.getTimestamp("datatest"),rs.getTimestamp("datainizioiscr"),rs.getTimestamp("datafineiscr"),rs.getTime("Temposvolgimento"),rs.getInt("punteggiominpos"));
					t.add(d);

						connection.close();
					}
				rs.close();

				return t;
			}catch(Exception e) {

				throw new Exception(e.getMessage());
				}}
	
	
	/**
	 * Ritorna i test modificabili.
	 *
	 * @param s the s
	 * @return the test modificabili
	 * @throws Exception the exception
	 */
	public ArrayList getTestModificabili(Insegnante s) throws Exception {
		InsegnanteImplementazionePDAO S=new InsegnanteImplementazionePDAO();
		b=S.getIdInt(s);
		
		try {
			PreparedStatement leggiup;
			
				leggiup = connection.prepareStatement(
						
				"SELECT * FROM  test where identificativo='"+b+"' and datainizioiscr>current_date order by datatest");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					Test d = new Test(rs.getInt("idt"),rs.getString("nometest"),rs.getTimestamp("datatest"),rs.getTimestamp("datainizioiscr"),rs.getTimestamp("datafineiscr"),rs.getTime("Temposvolgimento"),rs.getInt("punteggiominpos"),rs.getInt("identificativo"),rs.getDate("dataoperazione"));
					testcreati.add(d);

						connection.close();
					}
				rs.close();

				return testcreati;
			}catch(Exception e) {

				throw new Exception(e.getMessage());
				}
	
	}

	/**
	 * Update T: update su un test modificato.
	 *
	 * @param idt the idt
	 * @param nome the nome
	 * @param pm the pm
	 * @param data the data
	 * @param tempo the tempo
	 * @param di the di
	 * @param df the df
	 * @throws Exception the exception
	 */
	public void UpdateT(String idt, String nome, String pm, String data, String tempo, String di, String df) throws Exception {
		if(Integer.valueOf(tempo)>480)throw new Exception("Errore");
		else {
			try	{PreparedStatement nuovaReg = connection.prepareStatement(
		
			"UPDATE test SET nometest='"+nome+"',datatest='"+Timestamp.valueOf(data)+"',"
			+ "datainizioiscr='"+Timestamp.valueOf(di)+"',datafineiscr='"+Timestamp.valueOf(df)+"',"
			+ "		temposvolgimento='"+Integer.valueOf(tempo)+" minute',punteggiominpos='"+Integer.valueOf(pm)+"',"
			+ "	dataoperazione= current_date where idt='"+Integer.valueOf(idt)+"'");
			nuovaReg.executeUpdate();
	connection.close();
			} catch(Exception e) { throw new Exception("Errore");
			}

}}
}



