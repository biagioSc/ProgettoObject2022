package Model;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class QuizMultipla.
 */
public class QuizMultipla {

	/** The idqm. */
	private int idqm;
	
	/** The pmalus. */
	private int pmalus;
	
	/** The dmd. */
	private String dmd;
	
	/** The materia. */
	private String materia;
	
	/** The pbonus. */
	private int pbonus;
	
	/** The r1. */
	private String R1;
	
	/** The r2. */
	private String R2;
	
	/** The r3. */
	private String R3;
	
	/** The rg. */
	private String RG;
	
	/** The idqa. */
	private int idqa;
	
	/** The pmx. */
	private int pmx;
	
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
	
	/** The matricola. */
	private int matricola;
	
	/** The pum. */
	private int pum;
	
	
	/**
	 * Instantiates a new quiz multipla.
	 *
	 * @param id the id
	 * @param td the td
	 * @param pb the pb
	 * @param pm the pm
	 * @param mat the mat
	 * @param R1S the r1s
	 * @param R2S the r2s
	 * @param R3S the r3s
	 * @param RGG the rgg
	 */
	public QuizMultipla(int id, String td, int pb, int pm,String mat, String R1S, String R2S, String R3S, String RGG ){
		idqm=id;
		dmd=td;
		pbonus=pb;
		pmalus=pm;
		materia=mat;
		R1=R1S;
		R2=R2S;
		R3=R3S;
		RG=RGG;
	}
	
	/**
	 * Instantiates a new quiz multipla.
	 *
	 * @param int1 the int 1
	 * @param string the string
	 * @param date the date
	 * @param int2 the int 2
	 * @param string2 the string 2
	 * @param int3 the int 3
	 * @param int4 the int 4
	 */
	public QuizMultipla(int int1, String string, Date date, int int2, String string2, int int3, int int4) {
		idt=int1;
		nometest=string;
		datatest=date;
		idqa=int2;
		dmd=string2;
		pmx=int3;
		pmn=int4;
		
	}
	
	
	
	/**
	 * Instantiates a new quiz multipla.
	 *
	 * @param int1 the int 1
	 * @param int2 the int 2
	 * @param string the string
	 * @param int3 the int 3
	 * @param int4 the int 4
	 * @param string2 the string 2
	 * @param string3 the string 3
	 * @param string4 the string 4
	 * @param string5 the string 5
	 * @param string6 the string 6
	 */
	public QuizMultipla(int int1, int int2, String string, int int3, int int4, String string2, String string3,
			String string4, String string5, String string6) {
		idqm=int1;
		matricola=int2;
		dmd=string;
		pbonus=int3;
		pmalus=int4;
		materia=string2;
		RG=string3;	
		R1=string4;	
		R2=string5;	
		R3=string6;	

	}

	/**
	 * Gets the idqm.
	 *
	 * @return the idqm
	 */
	public int getIdqm() {return idqm ;}
	
	/**
	 * Gets the mat.
	 *
	 * @return the mat
	 */
	public int getMat() {return matricola ;}
	
	/**
	 * Gets the p bonus.
	 *
	 * @return the p bonus
	 */
	public int getPBonus() {return pbonus ;}
	
	/**
	 * Gets the p malus.
	 *
	 * @return the p malus
	 */
	public int getPMalus() {return pmalus ;}

	/**
	 * Gets the r1.
	 *
	 * @return the r1
	 */
	public String getR1() {return R1;} 
	
	/**
	 * Gets the r2.
	 *
	 * @return the r2
	 */
	public String getR2() {return R2;} 
	
	/**
	 * Gets the r3.
	 *
	 * @return the r3
	 */
	public String getR3() {return R3;}
	
	/**
	 * Gets the rg.
	 *
	 * @return the rg
	 */
	public String getRG() {return RG;} 
	
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
