package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.AmmetteQuizMDAO;
import Database.ConnessioneDB;

// TODO: Auto-generated Javadoc
/**
 * The Class AmmetteQuizMPDAO.
 */
public class AmmetteQuizMPDAO implements AmmetteQuizMDAO{

	/** The connection. */
	private Connection connection;
	
	/**
	 * Instantiates a new ammette quiz MPDAO.
	 */
	public AmmetteQuizMPDAO() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert AQM: inserisce il quiz multiplo nel test.
	 *
	 * @param idt the idt
	 * @param idqm the idqm
	 * @throws Exception the exception
	 */
	public void InsertAQM(String idt, String idqm) throws Exception {
		try	{PreparedStatement nuovaReg = connection.prepareStatement(
		"INSERT INTO ammettequizm(idt,idqm,dataoperazione) values('"+Integer.valueOf(idt)+"','"+Integer.valueOf(idqm)+"',current_date)");
		nuovaReg.executeUpdate();
		connection.close();
			} catch(Exception e) { throw new Exception("Errore");
		}
	}
}
