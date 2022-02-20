package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.postgresql.util.PSQLException;

import DAO.StudenteDAO;
import Database.ConnessioneDB;
import Model.Borsa;
import Model.Insegnante;
import Model.Listino;
import Model.Societa;
import Model.Studente;
import Model.TestScelti;


// TODO: Auto-generated Javadoc
/**
 * The Class StudenteImplementazionePDAO.
 */
public class StudenteImplementazionePDAO implements StudenteDAO {

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

	/**
	 * Instantiates a new studente implementazione PDAO.
	 */
	public StudenteImplementazionePDAO() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Registra: inserisce nel database il nuovo Studente .
	 *
	 * @param s the s
	 * @throws Exception the exception
	 */
	@Override


	public void Registra(Studente s) throws Exception {
		q=s.getPassword();
		w=s.getUsername();
		x=s.getNome();
		v=s.getCognome();
	try	{PreparedStatement nuovaReg = connection.prepareStatement(
				
	"INSERT INTO studente (username,password,nome,cognome)values('"+w+"',"+"'"+q+"',"+"'"+x+"',"+"'"+v+"');");

		
		//System.out.println(" ('"+s.getUsername()+"','"+s.getPassword()+"', '"+s.getNome()+"','"+s.getCognome()+"');");

	nuovaReg.executeUpdate();

		connection.close();
	} catch(Exception e) { throw new Exception("Username o password troppo corte!");
	}
	}
	
	/**
	 * Controlla: controlla che le credenziali inserite siano giuste.
	 *
	 * @param s the s
	 * @throws Exception the exception
	 */
	public void Controlla(Studente s) throws Exception {
		a=s.getPassword();
		k=s.getUsername();

		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * FROM studente where username='"+k+"'"+"AND password='"+a+"'");

			ResultSet rs = leggiup.executeQuery();
			if(rs.next()) {
			}
			else {
				throw new Exception("Username o password sbagliate!");
			}
			while (rs.next()) {
				if (rs.getString("username").equals(s.getUsername()) && rs.getString("password").equals(s.getPassword()))
				connection.close();
	        } 
			
			rs.close();
			
		}catch(Exception e) {
			throw new Exception("Username o password sbagliate!");
			}
		}
	

	/**
	 * Gets the matricola.
	 *
	 * @param s the s
	 * @return the id
	 */
	public String getId(Studente s) {
		a=s.getPassword();
		k=s.getUsername();
		PreparedStatement leggiID;
		try {
			leggiID = connection.prepareStatement(
					"SELECT matricola FROM studente where username='"+k+"'"+"AND password='"+a+"'");
		ResultSet rs = leggiID.executeQuery();

		while (rs.next()) {
			s.matricola = (rs.getInt("matricola"));
			connection.close();
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return String.valueOf(s.matricola);		
	}
	
	/**
	 * Gets the id int S.
	 *
	 * @param s the s
	 * @return the id int S
	 */
	public int getIdIntS(Studente s) {
		a=s.getPassword();
		k=s.getUsername();
		PreparedStatement leggiID;
		try {
			leggiID = connection.prepareStatement(
					"SELECT matricola FROM studente where username='"+k+"'"+"AND password='"+a+"'");
		ResultSet rs = leggiID.executeQuery();

		while (rs.next()) {
			s.matricola = (rs.getInt("matricola"));
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s.matricola;		
	}

	/**
	 * Gets the info.
	 *
	 * @param s the s
	 * @return the info
	 * @throws Exception the exception
	 */
	public ArrayList getInfo(Studente s) throws Exception {
		a=s.getPassword();
		k=s.getUsername();
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * FROM studente where username='"+k+"'"+"AND password='"+a+"'");
			ResultSet rs = leggiup.executeQuery();

			while (rs.next()) {
				if (rs.getString("username").equals(s.getUsername()) && rs.getString("password").equals(s.getPassword()))
					z=("Nome: "+rs.getString("Nome")+"\nCognome: "+rs.getString("Cognome")+"\nMatricola: "+rs.getString("Matricola")+"\nUsername: "+rs.getString("Username")+"\nPassword: "+rs.getString("Password"));
				e=("Nome: ")+rs.getString("Nome");
				l.add(e);
				
				o=("Cognome: ")+rs.getString("Cognome");
				l.add(o);

				g=("Matricola: ")+rs.getString("Matricola");
				l.add(g);

				h=("Username: ")+rs.getString("Username");
				l.add(h);

				p=("Password: ")+rs.getString("Password");
				l.add(p);
					connection.close();}
			rs.close();
			return l;
		}catch(Exception e) {
			throw new Exception("Non ci sono info2");
			}
		}

	/**
	 * Modifica.
	 *
	 * @param s the s
	 * @throws Exception the exception
	 */
	public void Modifica(Studente s) throws Exception {
		q=s.getPassword();
		w=s.getUsername();
		p=s.getPasswordo();
		o=s.getUsernameo();
		

	try	{
		if(q.equals(p) && w.equals(o)) {
			throw new Exception("Username o password già usate!");
		}
		PreparedStatement nuovaReg = connection.prepareStatement(
				
			"UPDATE studente set username='"+o+"'"+", password='"+p+"' where username='"+w+"'"+"AND password='"+q+"'");

		
		//System.out.println(" ('"+s.getUsername()+"','"+s.getPassword()+"', '"+s.getNome()+"','"+s.getCognome()+"');");

	nuovaReg.executeUpdate();

		connection.close();
	} catch(Exception e) { throw new Exception("Username o password troppo corte!");
	}
	}
	

	
	}



