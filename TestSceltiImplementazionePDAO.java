package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import org.postgresql.util.PSQLException;

import DAO.StudenteDAO;
import DAO.TestSceltiDAO;
import Database.ConnessioneDB;
import Model.Borsa;
import Model.Listino;
import Model.Societa;
import Model.Studente;
import Model.TestScelti;

// TODO: Auto-generated Javadoc
/**
 * The Class TestSceltiImplementazionePDAO.
 */
public class TestSceltiImplementazionePDAO implements TestSceltiDAO{

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
	
	/** The z. */
	public String z = null;
	
	/** The l. */
	public ArrayList l = new ArrayList();
	
	/** The d. */
	public TestScelti d;
	
	/** The c. */
	public ArrayList c = new ArrayList();
	
	/** The risultati. */
	public ArrayList<TestScelti> risultati= new ArrayList<TestScelti>();
	
	/** The testprenotati. */
	public ArrayList<TestScelti> testprenotati=new ArrayList<TestScelti>();
	
	/** The testdafare. */
	public ArrayList<TestScelti> testdafare=new ArrayList<TestScelti>();

	/** The mat. */
	private int mat;
	
	/** The testnull. */
	private ArrayList<TestScelti> testnull=null;
	
	/**
	 * Instantiates a new test scelti implementazione PDAO.
	 */
	public TestSceltiImplementazionePDAO() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Ritorna tutti i risultati ottenuti ai test.
	 *
	 * @param s the s
	 * @return the result
	 * @throws Exception the exception
	 */
	public ArrayList getResult(Studente s) throws Exception {
		a=s.getPassword();
		k=s.getUsername();
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT c.idt,c.matricola,esito,dataiscrizione,punteggiotot,test.nometest \r\n"
			+ "FROM (studente natural join testscelti)as c join test on test.idt=c.idt where username='"+k+"'"+"AND password='"+a+"'");
			ResultSet rs = leggiup.executeQuery();

			while (rs.next()) {
					TestScelti d = new TestScelti(rs.getInt("idt"),rs.getInt("matricola"),rs.getString("esito"),rs.getDate("dataiscrizione"),rs.getInt("punteggiotot"),rs.getString("nometest"));
				risultati.add(d);

					connection.close();
				}
			rs.close();

			return risultati;
		}catch(Exception e) {
			throw new Exception("Non ci sono info2");
			}
		}

	/**
	 * Ritorna tutti i test prenotati.
	 *
	 * @param s the s
	 * @return the tp
	 * @throws Exception the exception
	 */
	public ArrayList<TestScelti> getTestPrenotati(Studente s) throws Exception {
		a=s.getPassword();
		k=s.getUsername();
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT c.idt,test.datatest,c.matricola,dataiscrizione,test.nometest \r\n"
			+ "FROM (studente natural join testscelti)as c join test on test.idt=c.idt where username='"+k+"'"+"AND password='"+a+"'");
			ResultSet rs = leggiup.executeQuery();

			while (rs.next()) {
					TestScelti d = new TestScelti(rs.getInt("idt"),rs.getDate("datatest"),rs.getInt("matricola"),rs.getDate("dataiscrizione"),rs.getString("nometest"));
					testprenotati.add(d);

					connection.close();
				}
			rs.close();

			return testprenotati;
		}catch(Exception e) {
			throw new Exception("Non ci sono info2");
			}
	}

	/**
	 * Ritorna tutti i test completati.
	 *
	 * @param s the s
	 * @return the tc
	 * @throws Exception the exception
	 */
	public ArrayList<TestScelti> getTestCompletati(Studente s) throws Exception {
		a=s.getPassword();
		k=s.getUsername();
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT test.idt,test.datatest,c.matricola,dataiscrizione,test.nometest,esito, punteggiotot \r\n"
			+ "FROM (studente natural join testscelti)as c join test on test.idt=c.idt where username='"+k+"'"+"AND password='"+a+"'"+"AND esito<>'Non disponibile'");
			ResultSet rs = leggiup.executeQuery();

			while (rs.next()) {
					TestScelti d = new TestScelti(rs.getInt("idt"),rs.getDate("datatest"),rs.getInt("matricola"),rs.getDate("dataiscrizione"),rs.getString("nometest"),rs.getInt("punteggiotot"),rs.getString("esito"));
					testprenotati.add(d);

					connection.close();
				}
			rs.close();

			return testprenotati;
		}catch(Exception e) {
			throw new Exception("Non ci sono info2");
			}
	}
	
	/**
	 * Ritorna i test ancora da svolgere.
	 *
	 * @param s the s
	 * @return the test da fare
	 * @throws Exception the exception
	 */
	/*Selezione test da svolgere*/
	public ArrayList<TestScelti> getTestDaFare(Studente s) throws Exception {
		a=s.getPassword();
		k=s.getUsername();
		StudenteImplementazionePDAO S=new StudenteImplementazionePDAO();
		
		mat=S.getIdIntS(s);
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * FROM  testscelti join test on test.idt=testscelti.idt where matricola='"+mat+"'"+"AND datatest>=current_date order by datatest");
			ResultSet rs = leggiup.executeQuery();

			if(rs==null)return testnull;
			while (rs.next()) {
					TestScelti d = new TestScelti(rs.getInt("idt"),rs.getString("nometest"),rs.getTimestamp("datatest"),rs.getTime("temposvolgimento"),rs.getInt("punteggiominpos"),rs.getInt("matricola"));
					testdafare.add(d);

					connection.close();
				}
			rs.close();

			return testdafare;
		}catch(Exception e) {
			return testnull;
			}
	}
	
	/**
	 * Insert TS: inserisce in testscelti il nuovo test a cui si è prenotato l'utente studente.
	 *
	 * @param string the string
	 * @param idt the idt
	 * @throws Exception the exception
	 */
	/*Inserimento in testScelti*/
	public void InsertTS(String string, String idt) throws Exception {
		try	{PreparedStatement nuovaReg = connection.prepareStatement(
				"INSERT INTO testscelti (idt,matricola,dataiscrizione) values('"+Integer.valueOf(idt)+"',"+"'"+Integer.valueOf(string)+"',current_date);");
				nuovaReg.executeUpdate();
				connection.close();
						} catch(Exception e){ throw new Exception("Errore");
			}
	}
}
