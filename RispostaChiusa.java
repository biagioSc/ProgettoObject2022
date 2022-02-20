package Model;

// TODO: Auto-generated Javadoc
/**
 * The Class RispostaChiusa.
 */
public class RispostaChiusa {


	/** The idqm. */
	private int idqm;
	
	/** The matricola. */
	private int matricola;
	
	/** The testodomanda. */
	private String testodomanda;
	
	/** The testorisposta. */
	private String testorisposta;
	
	/** The materia. */
	private String materia;

	
	/**
	 * Instantiates a new risposta chiusa.
	 *
	 * @param int1 the int 1
	 * @param i the i
	 * @param string the string
	 * @param string2 the string 2
	 */
	public RispostaChiusa(int int1, int i, String string, String string2) {
		idqm=int1;
		matricola=i;
		testodomanda=string;
		testorisposta=string2;
		
	}
	
	/**
	 * Instantiates a new risposta chiusa.
	 *
	 * @param int1 the int 1
	 * @param i the i
	 * @param string the string
	 * @param int2 the int 2
	 * @param string3 the string 3
	 */
	public RispostaChiusa(int int1, int i, String string, int int2, String string3) {
		idqm=int1;
		matricola=i;
		testodomanda=string;
		materia=string3;
		
	}


	/**
	 * Gets the domanda.
	 *
	 * @return the domanda
	 */
	public String getDomanda() {return testodomanda;}
	
	/**
	 * Gets the idqm.
	 *
	 * @return the idqm
	 */
	public int getIdqm() {return idqm ;}
	
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
	public int getMat() {return matricola ;}
	
	/**
	 * Gets the materia.
	 *
	 * @return the materia
	 */
	public String getMateria() {return materia;}
	
}
