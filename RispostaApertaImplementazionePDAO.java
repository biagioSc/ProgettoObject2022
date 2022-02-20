package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.RispostaApertaDAO;
import Database.ConnessioneDB;
import Model.RispostaAperta;
import Model.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class RispostaApertaImplementazionePDAO.
 */
public class RispostaApertaImplementazionePDAO implements  RispostaApertaDAO {
	
	/** The connection. */
	private Connection connection;
	
	/** The tc. */
	private ArrayList<RispostaAperta> tc=new ArrayList<RispostaAperta>();
	
	/** The k. */
	private int k;
	
	/** The risposta. */
	ArrayList<RispostaAperta> risposta=new ArrayList<RispostaAperta>();


	/**
	 * Instantiates a new risposta aperta implementazione PDAO.
	 */
	public RispostaApertaImplementazionePDAO() {
		try {
			
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Ritorna tutti i test da correggere.
	 *
	 * @param i the i
	 * @param mat the mat
	 * @return the test correggere btn
	 * @throws Exception the exception
	 */
	public ArrayList getTestCorreggereBtn(String i, String mat) throws Exception {
		int j=Integer.valueOf(i);
		try {
			PreparedStatement leggiup;
			
				leggiup = connection.prepareStatement(
			
				"select * from rispostaaperta join quizaperta on rispostaaperta.idqa=quizaperta.idqa\r\n"
				+ " where identificativo='"+j+"' and punteggioassegnato is null and matricola='"+Integer.valueOf(mat)+"' and current_date>=date(dataconsegna)");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					RispostaAperta d = new RispostaAperta(rs.getInt("idqa"),rs.getInt("matricola"),rs.getString("testodomanda"),rs.getString("testorisposta"),rs.getInt("punteggiomin"),rs.getInt("punteggiomax"),rs.getString("correzioni"),rs.getInt("punteggioassegnato"));
					tc.add(d);

						connection.close();
					}
				rs.close();

				return tc;
			}catch(Exception e) {

				throw new Exception(e.getMessage());
				}
	}	
	
	/**
	 * Update R: salva le correzioni e il punteggioassegnato dell'utente insegnante ai quiz del test.
	 *
	 * @param mat the mat
	 * @param data the data
	 * @param idqa the idqa
	 * @param punt the punt
	 * @param correz the correz
	 * @throws Exception the exception
	 */
	public void UpdateR(String mat,Timestamp data, String idqa, String punt, String correz) throws Exception {
		
		System.out.println(data+idqa+punt+correz);
			try	{PreparedStatement nuovaReg = connection.prepareStatement(
		
					"UPDATE rispostaaperta SET punteggioassegnato='"+Integer.valueOf(punt)+"',correzioni='"+correz+"' where date(dataconsegna)=date('"+data+"') and idqa='"+idqa+"' and matricola='"+mat+"'");
	nuovaReg.executeUpdate();
	connection.close();
			} catch(Exception e) { throw new Exception("Errore");
			}

	}
	
	/**
	 * Ritorna il numero di quiz aperti da rispondere per quel test.
	 *
	 * @param data the data
	 * @param mat the mat
	 * @return the n test da rispondere
	 * @throws Exception the exception
	 */
	public int getNTestDaRispondere(String data, String mat) throws Exception {
		int j=Integer.valueOf(mat);
		
		try {
			
			PreparedStatement leggiup;

				leggiup = connection.prepareStatement(
			
				"select count(*) as c from rispostaaperta\r\n"
				+ " where matricola='"+j+"' and date(dataconsegna)='"+Date.valueOf(data)+"'");

				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					k=rs.getInt("c");

						connection.close();
					}
				rs.close();

				return k;
			}catch(Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
				}
	}	
	
	/**
	 * Ritorna i quiz da rispondere per quel test.
	 *
	 * @param data the data
	 * @param mat the mat
	 * @return the test da rispondere
	 * @throws Exception the exception
	 */
	public ArrayList<RispostaAperta> getTestDaRispondere(String data, String mat) throws Exception {
		int j=Integer.valueOf(mat);

		try {
			PreparedStatement leggiup;

				leggiup = connection.prepareStatement(
			
				"select * from rispostaaperta natural join quizaperta\r\n"
				+ " where matricola='"+j+"' and date(dataconsegna)='"+Date.valueOf(data)+"'");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					RispostaAperta ra= new RispostaAperta(rs.getInt("idqa"),rs.getInt("matricola"),rs.getString("testodomanda"),rs.getInt("maxcaratteri"),rs.getString("materia"));
					risposta.add(ra);

						connection.close();
					}

				rs.close();
				return risposta;
			}catch(Exception e) {

				throw new Exception(e.getMessage());
				}
	}

	/**
	 * Update rispost aperta: salva le risposte date ad un quiz di un test.
.
	 *
	 * @param matricola the matricola
	 * @param idqa the idqa
	 * @param risposta2 the risposta 2
	 * @throws Exception the exception
	 */
	public void UpdateRispostAperta(String matricola, int idqa, String risposta2) throws Exception {

		try	{PreparedStatement nuovaReg = connection.prepareStatement(
				"UPDATE rispostaaperta SET testorisposta='"+risposta2+"',dataconsegna=current_timestamp where idqa='"+idqa+"' and matricola='"+Integer.valueOf(matricola)+"'and date(dataconsegna)=date(current_date)");
		nuovaReg.executeUpdate();
		connection.close();
		} catch(Exception e) { throw new Exception("Errore");
		}

	}	
}

