package Model;

import java.sql.Date;
import java.sql.Time;

// TODO: Auto-generated Javadoc
/**
 * The Class RispostaAperta.
 */
public class RispostaAperta {

	/** The idqa. */
	private int idqa;
	
	/** The matricola. */
	private int matricola;
	
	/** The testodomanda. */
	private String testodomanda;
	
	/** The testorisposta. */
	private String testorisposta;
	
	/** The punteggiomin. */
	private int punteggiomin;
	
	/** The punteggiomax. */
	private int punteggiomax;
	
	/** The punteggioassegnato. */
	private int punteggioassegnato;
	
	/** The correzioni. */
	private String correzioni;
	
	/** The maxchar. */
	private int maxchar;
	
	/** The materia. */
	private String materia;

	
	/**
	 * Instantiates a new risposta aperta.
	 *
	 * @param int1 the int 1
	 * @param i the i
	 * @param string the string
	 * @param string2 the string 2
	 * @param int2 the int 2
	 * @param int3 the int 3
	 * @param string3 the string 3
	 * @param int4 the int 4
	 */
	public RispostaAperta(int int1, int i, String string, String string2, int int2, int int3, String string3, int int4) {
		idqa=int1;
		matricola=i;
		testodomanda=string;
		testorisposta=string2;
		punteggiomin=int2;
		punteggiomax=int3;
		correzioni=string3;
		punteggioassegnato=int4;
	}
	
	/**
	 * Instantiates a new risposta aperta.
	 *
	 * @param int1 the int 1
	 * @param i the i
	 * @param string the string
	 * @param int2 the int 2
	 * @param string3 the string 3
	 */
	public RispostaAperta(int int1, int i, String string, int int2, String string3) {
		idqa=int1;
		matricola=i;
		testodomanda=string;
		maxchar=int2;
		materia=string3;

	}


	/**
	 * Gets the domanda.
	 *
	 * @return the domanda
	 */
	public String getDomanda() {return testodomanda;}
	
	/**
	 * Gets the idqa.
	 *
	 * @return the idqa
	 */
	public int getIdqa() {return idqa;}
	
	/**
	 * Gets the risposta.
	 *
	 * @return the risposta
	 */
	public String getRisposta() {return testorisposta;}
	
	/**
	 * Gets the mat.
	 *
	 * @return the mat
	 */
	public int getMat() {return matricola;}
	
	/**
	 * Gets the pmin.
	 *
	 * @return the pmin
	 */
	public int getPmin() {return punteggiomin;}
	
	/**
	 * Gets the pmax.
	 *
	 * @return the pmax
	 */
	public int getPmax() {return punteggiomax;}
	
	/**
	 * Gets the correz.
	 *
	 * @return the correz
	 */
	public String getCorrez() {return correzioni;}
	
	/**
	 * Gets the pass.
	 *
	 * @return the pass
	 */
	public int getPass() {return punteggioassegnato;}
	
	/**
	 * Gets the materia.
	 *
	 * @return the materia
	 */
	public String getMateria() {return materia;}
	
	/**
	 * Gets the max char.
	 *
	 * @return the max char
	 */
	public String getMaxChar() {return String.valueOf(maxchar);}
}
