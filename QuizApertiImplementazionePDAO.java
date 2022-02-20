package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.QuizApertaDAO;
import Database.ConnessioneDB;
import Model.QuizAperta;
import Model.Studente;
import Model.TestScelti;

// TODO: Auto-generated Javadoc
/**
 * The Class QuizApertiImplementazionePDAO.
 */
public class QuizApertiImplementazionePDAO implements QuizApertaDAO {

	
	/** The qa. */
	private ArrayList<QuizAperta> qa=new ArrayList<QuizAperta>();
	
	/** The qat. */
	private ArrayList<QuizAperta> qat=new ArrayList<QuizAperta>();

	/** The connection. */
	private Connection connection;

	/**
	 * Instantiates a new quiz aperti implementazione PDAO.
	 */
	public QuizApertiImplementazionePDAO() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Ritorna tutti i quiz aperti presenti nel sistema.
	 *
	 * @return the qa
	 * @throws Exception the exception
	 */
	public ArrayList getQA() throws Exception {
		
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * FROM quizaperta");
			ResultSet rs = leggiup.executeQuery();
			while (rs.next()) {

				QuizAperta q = new QuizAperta(rs.getInt("idqa"),rs.getString("testodomanda"),rs.getInt("punteggiomax"),rs.getInt("punteggiomin"),rs.getInt("maxcaratteri"),rs.getString("materia"));
				qa.add(q);

					connection.close();
				}
			rs.close();

			return qa;
		}catch(Exception e) {
			throw new Exception("Non ci sono info");
			}
		}

	/**
	 * Ritorna tutti i quiz aperti presenti nel sistema che non sono nel test.
	 * @param idtest 
	 *
	 * @return the qa
	 * @throws Exception the exception
	 */
	public ArrayList getQAOther(String idtest) throws Exception {
		
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * \r\n"
			+ "FROM quizaperta \r\n"
			+ "where quizaperta.idqa not in (\r\n"
			+ "\r\n"
			+ "	SELECT ammettequiza.idqa \r\n"
			+ "	FROM quizaperta join ammettequiza on ammettequiza.idqa=quizaperta.idqa\r\n"
			+ "	where idt='"+Integer.valueOf(idtest)+"'\r\n"
			+ ")");
			ResultSet rs = leggiup.executeQuery();
			while (rs.next()) {

				QuizAperta q = new QuizAperta(rs.getInt("idqa"),rs.getString("testodomanda"),rs.getInt("punteggiomax"),rs.getInt("punteggiomin"),rs.getInt("maxcaratteri"),rs.getString("materia"));
				qa.add(q);

					connection.close();
				}
			rs.close();

			return qa;
		}catch(Exception e) {
			throw new Exception("Non ci sono info");
			}
		}
	
	/**
	 * Insert QA: inserisce nuovo quiz aperto nel database.
	 *
	 * @param domanda the domanda
	 * @param pmax the pmax
	 * @param pmin the pmin
	 * @param materia the materia
	 * @param mchar the mchar
	 * @throws Exception the exception
	 */
	public void InsertQA(String domanda, String pmax, String pmin, String materia, String mchar) throws Exception {
		
		try	{PreparedStatement nuovaReg = connection.prepareStatement(
				
				"INSERT INTO quizaperta (punteggiomax,punteggiomin, testodomanda,materia,maxcaratteri)\r\n"
				+ "values('"+Integer.valueOf(pmax)+"','"+Integer.valueOf(pmin)+"',"+"'"+domanda+"',"+"'"+materia+"',"+"'"+Integer.valueOf(mchar)+"');");
			nuovaReg.executeUpdate();
					connection.close();
					} catch(Exception e) { throw new Exception("Errore");
					}
		
	}
	
	
		/**
		 * Ritorna tutti i quiz aperti presenti nei test di un insegnante.
		 *
		 * @param identificativo the identificativo
		 * @return the QA test
		 * @throws Exception the exception
		 */
		public ArrayList<QuizAperta> getQATest(String identificativo) throws Exception {
			System.out.println("qui1");

		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"select distinct  test.idt,nometest, datatest, quizaperta.idqa, testodomanda, punteggiomax, punteggiomin from ammettequiza join quizaperta on quizaperta.idqa=ammettequiza.idqa join test on test.idt=ammettequiza.idt where identificativo='"+Integer.valueOf(identificativo)+"'");

			ResultSet r = leggiup.executeQuery();

			while (r.next()) {

				QuizAperta q = new QuizAperta(r.getInt("idt"),r.getString("nometest"),r.getDate("datatest"),r.getInt("idqa"),r.getString("testodomanda"),r.getInt("punteggiomax"),r.getInt("punteggiomin"));
				qat.add(q);

					connection.close();
				}
			r.close();

			return qat;
		}catch(Exception e) {
			throw new Exception("Non ci sono info");
			}
		
		}
		
	
}
