package Model;

import java.sql.Date;
import java.sql.Time;

// TODO: Auto-generated Javadoc
/**
 * The Class Correzione.
 */
public class Correzione {
	
	/** The idtest. */
	private int idtest;
	
	/** The matricola. */
	private int matricola;
	
	/** The nometest. */
	private String nometest;
	
	/** The datatest. */
	private Date datatest;
	
	/** The esito. */
	private String esito;
	
	/** The punteggiotot. */
	private int punteggiotot;

	/**
	 * Instantiates a new correzione.
	 *
	 * @param idtest the idtest
	 * @param nometest the nometest
	 * @param datatest the datatest
	 * @param matricola the matricola
	 * @param esito the esito
	 * @param punteggiotot the punteggiotot
	 */
	public Correzione(int idtest, String nometest, Date datatest, int matricola, String esito, int punteggiotot) {
		this.idtest=idtest;
		this.nometest=nometest;
		this.datatest=datatest;
		this.matricola=matricola;
		this.esito=esito;
		this.punteggiotot=punteggiotot;
	}
	
	/**
	 * Instantiates a new correzione.
	 *
	 * @param idtest the idtest
	 * @param nometest the nometest
	 * @param datatest the datatest
	 * @param matricola the matricola
	 */
	public Correzione(int idtest, String nometest, Date datatest, int matricola) {
		this.idtest=idtest;
		this.nometest=nometest;
		this.datatest=datatest;
		this.matricola=matricola;
	}
	
	/**
	 * Gets the nome test.
	 *
	 * @return the nome test
	 */
	public String getNomeTest() {return nometest;}
	
	/**
	 * Gets the id test.
	 *
	 * @return the id test
	 */
	public int getIdTest() {return idtest ;}
	
	/**
	 * Gets the punteggio tot.
	 *
	 * @return the punteggio tot
	 */
	public int getPunteggioTot() {return punteggiotot ;}
	
	/**
	 * Gets the data test.
	 *
	 * @return the data test
	 */
	public Date getDataTest() {return datatest ;}
	
	/**
	 * Gets the matricola.
	 *
	 * @return the matricola
	 */
	public int getMatricola() {return matricola ;}

	/**
	 * Gets the esito.
	 *
	 * @return the esito
	 */
	public String getEsito() {return esito;}
}
