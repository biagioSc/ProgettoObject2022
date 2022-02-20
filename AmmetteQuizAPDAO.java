package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.AmmetteQuizADAO;
import DAO.AmmetteQuizMDAO;
import Database.ConnessioneDB;

// TODO: Auto-generated Javadoc
/**
 * The Class AmmetteQuizAPDAO.
 */
public class AmmetteQuizAPDAO implements AmmetteQuizADAO{

	/** The connection. */
	private Connection connection;
	
	/**
	 * Instantiates a new ammette quiz APDAO.
	 */
	public AmmetteQuizAPDAO() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Insert AQA: inserisce il quiz aperto nel test .
	 *
	 * @param idt the idt
	 * @param idqa the idqa
	 * @throws Exception the exception
	 */
	public void InsertAQA(String idt, String idqa) throws Exception {
		
		try	{PreparedStatement nuovaReg = connection.prepareStatement(
		"INSERT INTO ammettequiza(idt,idqa,dataoperazione) values('"+Integer.valueOf(idt)+"','"+Integer.valueOf(idqa)+"',current_date)");
		nuovaReg.executeUpdate();
		connection.close();
			} catch(Exception e) { throw new Exception("Errore");
		}
	}
}
