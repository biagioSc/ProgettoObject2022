package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.QuizMultiplaDAO;
import Database.ConnessioneDB;
import Model.QuizAperta;
import Model.QuizMultipla;

// TODO: Auto-generated Javadoc
/**
 * The Class QuizMultipliImplementazionePDAO.
 */
public class QuizMultipliImplementazionePDAO implements QuizMultiplaDAO{
	
	/** The qm. */
	private ArrayList<QuizMultipla> qm=new ArrayList<QuizMultipla>();
	
	/** The qmt. */
	private ArrayList<QuizMultipla> qmt=new ArrayList<QuizMultipla>();

	/** The connection. */
	private Connection connection;

	/**
	 * Instantiates a new quiz multipli implementazione PDAO.
	 */
	public QuizMultipliImplementazionePDAO() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Ritorna tutti i quiz multipli presenti nel sistema.
	 *
	 * @return the qm
	 * @throws Exception the exception
	 */
	public ArrayList getQM() throws Exception {
		
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * FROM quizmultipla");

			ResultSet rs = leggiup.executeQuery();

			while (rs.next()) {
				QuizMultipla q = new QuizMultipla(rs.getInt("idqm"),rs.getString("domanda"),rs.getInt("punteggiobonus"),rs.getInt("punteggiomalus"),rs.getString("materia"),rs.getString("rispostagiusta"),rs.getString("rispostasbagliata1"),rs.getString("rispostasbagliata2"),rs.getString("rispostasbagliata3"));
				qm.add(q);

					connection.close();
				}
			rs.close();

			return qm;
		}catch(Exception e) {
			throw new Exception("Non ci sono info");
			}
		}
	
	/**
	 * Ritorna tutti i quiz multipli presenti nel sistema che non sono nel test.
	 * @param idtest 
	 *
	 * @return the qa
	 * @throws Exception the exception
	 */
	public ArrayList getQMOther(String idtest) throws Exception {
		
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * \r\n"
			+ "FROM quizmultipla \r\n"
			+ "where quizmultipla.idqm not in (\r\n"
			+ "\r\n"
			+ "	SELECT ammettequizm.idqm \r\n"
			+ "	FROM quizmultipla join ammettequizm on ammettequizm.idqm=quizmultipla.idqm\r\n"
			+ "	where idt='"+Integer.valueOf(idtest)+"'\r\n"
			+ ")");
			ResultSet rs = leggiup.executeQuery();
			while (rs.next()) {

				QuizMultipla q = new QuizMultipla(rs.getInt("idqm"),rs.getString("domanda"),rs.getInt("punteggiobonus"),rs.getInt("punteggiomalus"),rs.getString("materia"),rs.getString("rispostagiusta"),rs.getString("rispostasbagliata1"),rs.getString("rispostasbagliata2"),rs.getString("rispostasbagliata3"));
				qm.add(q);

					connection.close();
				}
			rs.close();

			return qm;
		}catch(Exception e) {
			throw new Exception("Non ci sono info");
			}
		}
	
	/**
	 * Insert QM: inserisce nuovo quiz multiplo nel database..
	 *
	 * @param domanda the domanda
	 * @param pbonus the pbonus
	 * @param pmalus the pmalus
	 * @param materia the materia
	 * @param rg the rg
	 * @param rs1 the rs 1
	 * @param rs2 the rs 2
	 * @param rs3 the rs 3
	 * @throws Exception the exception
	 */
	public void InsertQM(String domanda, String pbonus, String pmalus, String materia, String rg, String rs1,
			String rs2, String rs3) throws Exception {
		try	{PreparedStatement nuovaReg = connection.prepareStatement(
				
				"INSERT INTO quizmultipla (punteggiobonus,punteggiomalus, domanda,materia,rispostagiusta,rispostasbagliata1,rispostasbagliata2,rispostasbagliata3)\r\n"
				+ "values('"+Integer.valueOf(pbonus)+"','"+Integer.valueOf(pmalus)+"',"+"'"+domanda+"',"+"'"+materia+"',"+"'"+rg+"',"+"'"+rs1+"',"+"'"+rs2+"',"+"'"+rs3+"');");
			nuovaReg.executeUpdate();
					connection.close();
					} catch(Exception e) { throw new Exception("Errore");
					}
		
	}
	
	/**
	 * Ritorna tutti i quiz multipli presenti nei test di un insegnante.
	 *
	 * @param identificativo the identificativo
	 * @return the QM test
	 * @throws Exception the exception
	 */
	public ArrayList<QuizMultipla> getQMTest(String identificativo) throws Exception {

	try {
	PreparedStatement leggiup;
	
		leggiup = connection.prepareStatement(
				
		"select distinct  test.idt,nometest, datatest, quizmultipla.idqm, domanda, punteggiobonus, punteggiomalus from ammettequizm join quizmultipla on quizmultipla.idqm=ammettequizm.idqm join test on test.idt=ammettequizm.idt where identificativo='"+Integer.valueOf(identificativo)+"'");

		ResultSet r = leggiup.executeQuery();

		while (r.next()) {

			QuizMultipla q = new QuizMultipla(r.getInt("idt"),r.getString("nometest"),r.getDate("datatest"),r.getInt("idqm"),r.getString("domanda"),r.getInt("punteggiobonus"),r.getInt("punteggiomalus"));
			qmt.add(q);

				connection.close();
			}
		r.close();

		return qmt;
	}catch(Exception e) {
		throw new Exception("Non ci sono info");
		}
	}
}
