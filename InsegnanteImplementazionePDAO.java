package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.InsegnanteDAO;
import Database.ConnessioneDB;
import Model.Insegnante;
import Model.Studente;
import Model.TestScelti;

// TODO: Auto-generated Javadoc
/**
 * The Class InsegnanteImplementazionePDAO.
 */
public class InsegnanteImplementazionePDAO implements InsegnanteDAO {

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
	
	/** The ins. */
	private ArrayList<Insegnante> ins=	new ArrayList<Insegnante>();
;
	

	/**
	 * Instantiates a new insegnante implementazione PDAO.
	 */
	public InsegnanteImplementazionePDAO()
	{
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {e.printStackTrace();
		 }
	}
	
	/**
	 * Registra: inserisce nel database il nuovo insegnante .
	 *
	 * @param s the s
	 * @throws Exception the exception
	 */
	@Override

	public void Registra(Insegnante s) throws Exception 
	{
		q=s.getPassword();
		w=s.getUsername();
		x=s.getNome();
		v=s.getCognome();
		try	{PreparedStatement nuovaReg = connection.prepareStatement(
				"INSERT INTO insegnante (username,password,nome,cognome)values('"+w+"',"+"'"+q+"',"+"'"+x+"',"+"'"+v+"');");
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
	public void Controlla(Insegnante s) throws Exception {
		a=s.getPassword();
		k=s.getUsername();

		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * FROM insegnante where username='"+k+"'"+"AND password='"+a+"'");

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
			e.printStackTrace();
			throw new Exception("Username o password sbagliate!");
			}
		}
	
	
	/**
	 * Gets the identificativo.
	 *
	 * @param s the s
	 * @return the id
	 */
	public String getId(Insegnante s) {
		a=s.getPassword();
		k=s.getUsername();
		PreparedStatement leggiID;
		try {
			leggiID = connection.prepareStatement(
					"SELECT identificativo FROM insegnante where username='"+k+"'"+"AND password='"+a+"'");
		ResultSet rs = leggiID.executeQuery();

		while (rs.next()) {
			s.identificativo = (rs.getInt("identificativo"));
			connection.close();
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return String.valueOf(s.identificativo);		
	}

	/**
	 * Gets the id int.
	 *
	 * @param s the s
	 * @return the id int
	 */
	public int getIdInt(Insegnante s) {
		a=s.getPassword();
		k=s.getUsername();
		PreparedStatement leggiID;
		try {
			leggiID = connection.prepareStatement(
					"SELECT identificativo FROM insegnante where username='"+k+"'"+"AND password='"+a+"'");
		ResultSet rs = leggiID.executeQuery();

		while (rs.next()) {
			s.identificativo = (rs.getInt("identificativo"));
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s.identificativo;		
	}
	
	
	/**
	 * Gets the info I.
	 *
	 * @param s the s
	 * @return the info I
	 * @throws Exception the exception
	 */
	public ArrayList getInfoI(Insegnante s) throws Exception {
		
		a=s.getPassword();
		k=s.getUsername();
		try {
		PreparedStatement leggiup;
			leggiup = connection.prepareStatement(
					
			"SELECT * FROM insegnante where username='"+k+"'"+"AND password='"+a+"'");
			ResultSet rs = leggiup.executeQuery();
			
			while (rs.next()) {
				if (rs.getString("username").equals(s.getUsername()) && rs.getString("password").equals(s.getPassword()))
				e=("Nome: ")+rs.getString("nome");
				l.add(e);
				
				o=("Cognome: ")+rs.getString("cognome");
				l.add(o);

				g=("Identificativo: ")+rs.getString("identificativo");
				l.add(g);

				h=("Username: ")+rs.getString("username");
				l.add(h);

				p=("Password: ")+rs.getString("password");
				l.add(p);
					connection.close();}
			rs.close();
			return l;
		}catch(Exception e) {
			throw new Exception("Non ci sono info2");
			}
		}

	/**
	 * Modifica I.
	 *
	 * @param s the s
	 * @throws Exception the exception
	 */
	public void ModificaI(Insegnante s) throws Exception {
		q=s.getPassword();
		w=s.getUsername();
		p=s.getPasswordOld();
		o=s.getUsernameOld();
		

	try	{
		if(q.equals(p) && w.equals(o)) {
			throw new Exception("Username o password già usate!");
		}
		PreparedStatement nuovaReg = connection.prepareStatement(
				
			"UPDATE insegnante set username='"+o+"'"+", password='"+p+"' where username='"+w+"'"+"AND password='"+q+"'");

		
		//System.out.println(" ('"+s.getUsername()+"','"+s.getPassword()+"', '"+s.getNome()+"','"+s.getCognome()+"');");

	nuovaReg.executeUpdate();

		connection.close();
	} catch(Exception e) { throw new Exception("Username o password troppo corte!");
	}
	}
	
	/**
	 * Gets the ins.
	 *
	 * @param i2 the i 2
	 * @return the ins
	 */
	public ArrayList getIns(String i2) {
		int h=Integer.valueOf(i2);
		PreparedStatement leggiID;
		try {
			leggiID = connection.prepareStatement(
					"SELECT * FROM insegnante natural join test where idt='"+h+"'");
		ResultSet rs = leggiID.executeQuery();

		while (rs.next()) {
			Insegnante i=new Insegnante(rs.getString("username"),rs.getString("password"),rs.getString("nome"),rs.getString("cognome"));
			ins.add(i);
		}
		rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ins;		
	}



}