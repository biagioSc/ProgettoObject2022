package ImplementazionePDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.ConnessioneDB;
import Model.Correzione;
import Model.RispostaAperta;

// TODO: Auto-generated Javadoc
/**
 * The Class CorrezionImplementazionePDAO.
 */
public class CorrezionImplementazionePDAO {
	
	/** The connection. */
	private Connection connection;
	
	/** The tc. */
	private ArrayList<Correzione> tc=new ArrayList<Correzione>();

	/**
	 * Instantiates a new correzion implementazione PDAO.
	 */
	//Apertura connessione al database
	public CorrezionImplementazionePDAO() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getTestCorrez: Restitusice tutti i test da correggere per ogni matricola.
	 *
	 * @param identificativo the identificativo
	 * @return the test correz
	 * @throws Exception the exception
	 */
	/*Query che ritorna i test da correggere solo dopo che il test si è concluso */
	public ArrayList getTestCorrez(String identificativo) throws Exception {
		int j=Integer.valueOf(identificativo);
		try {	PreparedStatement leggiup = connection.prepareStatement(
				"select  idt, nometest, datatest, matricola from correzione natural join test \r\n"
				+ " where identificativo='"+j+"' and current_date>=date(datatest)and correzionecompletata<>'1'");
				ResultSet rs = leggiup.executeQuery();

				while (rs.next()) {
					Correzione d = new Correzione(rs.getInt("idt"),rs.getString("nometest"),rs.getDate("datatest"),rs.getInt("matricola"));
					tc.add(d);
					connection.close();
				}
				rs.close();
				return tc;
			}catch(Exception e) {throw new Exception(e.getMessage());
				}
	}
	
	
	/**
	 * Update C: dopo la correzione, fa l'update su correzione per settare la correzionecompletata a 1.
	 *
	 * @param idt the idt
	 * @param idins the idins
	 * @param mat the mat
	 * @throws Exception the exception
	 */
	public void UpdateC(String idt, String idins, String mat) throws Exception {
		
		try	{PreparedStatement nuovaReg = connection.prepareStatement(
				"UPDATE correzione SET correzionecompletata='1' where identificativo='"+Integer.valueOf(idins)+"' and idt='"+Integer.valueOf(idt)+"' and matricola='"+Integer.valueOf(mat)+"'");
				nuovaReg.executeUpdate();
				connection.close();
			} catch(Exception e) { throw new Exception("Errore");
		}
	}

}
