package Model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.postgresql.util.PGInterval;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public class Test {
	
	/** The idt. */
	private int idt;
	
	/** The puntmp. */
	private int puntmp;
	
	/** The nome. */
	private String nome;
	
	/** The dfi. */
	private Timestamp dfi;
	
	/** The dii. */
	private Timestamp dii;
	
	/** The datatest. */
	private Timestamp datatest;
	
	/** The tempo. */
	private Time tempo;
	
	/** The operazione. */
	private String operazione;
	
	/** The datamodifica. */
	private Date datamodifica;
	
	/** The identificativo. */
	private int identificativo;

	
	
	/**
	 * Instantiates a new test.
	 *
	 * @param id the id
	 * @param n the n
	 * @param dt the dt
	 * @param di the di
	 * @param df the df
	 * @param t the t
	 * @param pm the pm
	 */
	public Test(int id, String n,Timestamp dt, Timestamp di, Timestamp df,  Time t, int pm){
		idt=id;
		puntmp=pm;
		nome=n;
		dfi=df;
		dii=di;
		datatest=dt;
		tempo=t;
	}

	/**
	 * Test.
	 *
	 * @param s the s
	 * @return the array list
	 */
	public ArrayList<Test> Test(Test s) {
		ArrayList<Test> test= new ArrayList<Test>();
		test.add(s);		
		return test;
	}
		
				
	/**
	 * Instantiates a new test.
	 *
	 * @param id the id
	 * @param n the n
	 * @param dt the dt
	 * @param di the di
	 * @param df the df
	 * @param t the t
	 * @param pm the pm
	 * @param idi the idi
	 * @param dm the dm
	 */
	public Test(int id, String n,Timestamp dt, Timestamp di, Timestamp df,  Time t, int pm, int idi, Date dm){
		idt=id;
		puntmp=pm;
		nome=n;
		dfi=df;
		dii=di;
		datatest=dt;
		tempo=t;
		datamodifica=dm;
		identificativo=idi;
	}
		
		

		/**
		 * Gets the nome.
		 *
		 * @return the nome
		 */
		public String getNome() {
			
			return nome;
		}
		
		/**
		 * Gets the idt.
		 *
		 * @return the idt
		 */
		public int getIdt() {
			
			return idt ;
		}
		
		/**
		 * Gets the pm.
		 *
		 * @return the pm
		 */
		public int getPM() {
			
			return puntmp ;
		}
		
		/**
		 * Gets the t.
		 *
		 * @return the t
		 */
		public int getT() {
			
			return tempo.getHours()*60+tempo.getMinutes() ;
		}
		
		/**
		 * Gets the df.
		 *
		 * @return the df
		 */
		public Timestamp getDF() {
			
			return dfi ;
		}
		
		/**
		 * Gets the di.
		 *
		 * @return the di
		 */
		public Timestamp getDI() {
			
			return dii ;
		}
		
		/**
		 * Gets the d.
		 *
		 * @return the d
		 */
		public Timestamp getD() {
			
			return datatest ;
		}
		
		/**
		 * Gets the do.
		 *
		 * @return the do
		 */
		public Date getDO() {return datamodifica;}
		
		/**
		 * Gets the id ins.
		 *
		 * @return the id ins
		 */
		public int getIdIns() {return identificativo ;}
		
		/**
		 * Gets the op.
		 *
		 * @return the op
		 */
		public String getOp() {return operazione;}
		
}