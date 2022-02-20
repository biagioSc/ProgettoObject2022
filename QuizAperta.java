package Model;

import java.sql.Date;
import java.sql.Time;

// TODO: Auto-generated Javadoc
/**
 * The Class QuizAperta.
 */
public class QuizAperta {

	/** The idqa. */
	private int idqa;
	
	/** The pmx. */
	private int pmx;
	
	/** The dmd. */
	private String dmd;
	
	/** The materia. */
	private String materia;
	
	/** The mx. */
	private int mx;
	
	/** The pmn. */
	private int pmn;
	
	/** The idt. */
	private int idt;
	
	/** The nometest. */
	private String nometest;
	
	/** The datatest. */
	private Date datatest;
	
	/**
	 * Instantiates a new quiz aperta.
	 *
	 * @param id the id
	 * @param td the td
	 * @param pm the pm
	 * @param pi the pi
	 * @param mchar the mchar
	 * @param mat the mat
	 */
	public QuizAperta(int id, String td, int pm, int pi,  int mchar,String mat){
		idqa=id;
		dmd=td;
		pmx=pm;
		pmn=pi;
		materia=mat;
		mx=mchar;
	}
	
	/**
	 * Instantiates a new quiz aperta.
	 *
	 * @param int1 the int 1
	 * @param string the string
	 * @param date the date
	 * @param int2 the int 2
	 * @param string2 the string 2
	 * @param int3 the int 3
	 * @param int4 the int 4
	 */
	public QuizAperta(int int1, String string, Date date, int int2, String string2, int int3, int int4) {
		idt=int1;
		nometest=string;
		datatest=date;
		idqa=int2;
		dmd=string2;
		pmx=int3;
		pmn=int4;
	}

	/**
	 * Gets the domanda.
	 *
	 * @return the domanda
	 */
	public String getDomanda() {return dmd;}
	
	/**
	 * Gets the idqa.
	 *
	 * @return the idqa
	 */
	public int getIdqa() {return idqa ;}
	
	/**
	 * Gets the p max.
	 *
	 * @return the p max
	 */
	public int getPMax() {return pmx ;}
	
	/**
	 * Gets the p min.
	 *
	 * @return the p min
	 */
	public int getPMin() {return pmn ;}

	/**
	 * Gets the mchar.
	 *
	 * @return the mchar
	 */
	public int getMchar() {return mx ;}
	
	/**
	 * Gets the materia.
	 *
	 * @return the materia
	 */
	public String getMateria() {return materia;} 
	
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
	public int getIdTest() {return idt ;}
	
	/**
	 * Gets the data test.
	 *
	 * @return the data test
	 */
	public Date getDataTest() {return datatest ;}
	
}
