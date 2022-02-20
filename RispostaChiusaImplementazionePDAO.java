package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import DAO.RispostaApertaDAO;
import DAO.RispostaChiusaDAO;
import Database.ConnessioneDB;
import Model.QuizMultipla;
import Model.RispostaAperta;
import Model.RispostaChiusa;

// TODO: Auto-generated Javadoc
/**
 * The Class RispostaChiusaImplementazionePDAO.
 */
public class RispostaChiusaImplementazionePDAO 	implements  RispostaChiusaDAO {
		
		/** The connection. */
		private Connection connection;
		
		/** The k. */
		private int k;
		
		/** The risposta. */
		ArrayList<QuizMultipla> risposta=new ArrayList<QuizMultipla>();

		
		/**
		 * Instantiates a new risposta chiusa implementazione PDAO.
		 */
		public RispostaChiusaImplementazionePDAO() {
			try {
				connection = ConnessioneDB.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	/**
	 * Ritorna il numero di quiz multipli da rispondere per quel test.
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
			
				"select count(*) as c from rispostachiusa\r\n"
				+ " where matricola='"+j+"' and date(dataconsegna)='"+Date.valueOf(data)+"'");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					k=rs.getInt("c");

						connection.close();
					}
				rs.close();

				return k;
			}catch(Exception e) {

				throw new Exception(e.getMessage());
				}
	}
	
	/**
	 * Ritorna i quiz multipli da rispondere per quel test.
	 *
	 * @param data the data
	 * @param mat the mat
	 * @return the test da rispondere
	 * @throws Exception the exception
	 */
	public ArrayList<QuizMultipla> getTestDaRispondere(String data, String mat) throws Exception {
		int j=Integer.valueOf(mat);

		try {
			PreparedStatement leggiup;

				leggiup = connection.prepareStatement(
			
				"select * from rispostachiusa natural join quizmultipla\r\n"
				+ " where matricola='"+j+"' and date(dataconsegna)='"+Date.valueOf(data)+"'");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					QuizMultipla ra= new QuizMultipla(rs.getInt("idqm"),rs.getInt("matricola"),rs.getString("domanda"),rs.getInt("punteggiobonus"),rs.getInt("punteggiomalus"),rs.getString("materia"),rs.getString("rispostagiusta"),rs.getString("rispostasbagliata1"),rs.getString("rispostasbagliata2"),rs.getString("rispostasbagliata3"));
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
	 * Update risposta chiusa: salva le risposte date ad un quiz di un test.
	 *
	 * @param matricola the matricola
	 * @param idqm the idqm
	 * @param risposta2 the risposta 2
	 * @throws Exception the exception
	 */
	public void UpdateRispostaChiusa(String matricola, int idqm, String risposta2) throws Exception {
		try	{PreparedStatement nuovaReg = connection.prepareStatement(
				
				"UPDATE rispostachiusa SET testorisposta='"+risposta2+"',dataconsegna=current_timestamp where idqm='"+idqm+"' and matricola='"+Integer.valueOf(matricola)+"'and date(dataconsegna)=date(current_date)");
		nuovaReg.executeUpdate();
		connection.close();
		} catch(Exception e) { throw new Exception("Errore");
		}
	}
	
	
}
