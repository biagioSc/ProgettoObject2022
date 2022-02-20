package Model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class TestScelti.
 */
public class TestScelti {

	/** The idt. */
	private int idt;
	
	/** The matricola. */
	private int matricola;
	
	/** The esito. */
	private String esito;
	
	/** The dataiscrizione. */
	private Date dataiscrizione;
	
	/** The datatest. */
	private Date datatest;

	/** The punteggiotot. */
	public int punteggiotot;
	
	/** The nome test. */
	private String nomeTest;
	
	/** The errore P. */
	private String erroreP;
	
	/**
	 * Instantiates a new test scelti.
	 *
	 * @param id the id
	 * @param mat the mat
	 * @param esi the esi
	 * @param dt the dt
	 * @param pt the pt
	 * @param nt the nt
	 */
	public TestScelti(int id, int mat, String esi, Date dt, int pt, String nt){
		idt=id;
		matricola=mat;
		esito=esi;
		dataiscrizione=dt;
		punteggiotot=pt;
		nomeTest=nt;
		
	}
		
		/** The risultati. */
		private ArrayList<TestScelti> risultati;

		/**
		 * Instantiates a new test scelti.
		 */
		public TestScelti() {}
		
		/**
		 * Test scelti.
		 *
		 * @param s the s
		 * @return the array list
		 */
		public ArrayList<TestScelti> TestScelti(TestScelti s) {
			ArrayList<TestScelti> risultati= new ArrayList<TestScelti>();
			risultati.add(s);		
			return risultati;
		}
		
		
		
		/**
		 * Instantiates a new test scelti.
		 *
		 * @param id the id
		 * @param dt the dt
		 * @param mat the mat
		 * @param di the di
		 * @param nt the nt
		 */
		public TestScelti(int id, Date dt , int mat, Date di, String nt){
			idt=id;
			matricola=mat;
			dataiscrizione=di;
			datatest=dt;
			nomeTest=nt;
			
		}
			
			/** The testprenotati. */
			private ArrayList<TestScelti> testprenotati;
			
			/** The datatest 2. */
			private Timestamp datatest2;
			
			/** The tempo. */
			private Time tempo;

			/**
			 * Test scelti 2.
			 *
			 * @param s the s
			 * @return the array list
			 */
			public ArrayList<TestScelti> TestScelti2(TestScelti s) {
				ArrayList<TestScelti> testprenotati= new ArrayList<TestScelti>();
				testprenotati.add(s);		
				return testprenotati;
			}
		
		
			/**
			 * Instantiates a new test scelti.
			 *
			 * @param id the id
			 * @param dt the dt
			 * @param mat the mat
			 * @param di the di
			 * @param nt the nt
			 * @param pt the pt
			 * @param esi the esi
			 */
			public TestScelti(int id, Date dt, int mat, Date di, String nt,int pt, String esi){
				idt=id;
				matricola=mat;
				esito=esi;
				dataiscrizione=di;
				datatest=dt;
				punteggiotot=pt;
				nomeTest=nt;
				
			}
				
				/**
				 * Instantiates a new test scelti.
				 *
				 * @param id the id
				 * @param n the n
				 * @param dt the dt
				 * @param t the t
				 * @param pm the pm
				 * @param mat the mat
				 */
				public TestScelti (int id, String n, Timestamp dt,  Time t, int pm, int mat){
					idt=id;
					matricola=mat;
					datatest2=dt;
					punteggiotot=pm;
					nomeTest=n;
					tempo=t;
					}
				
				/** The testcompletati. */
				private ArrayList<TestScelti> testcompletati;

				/**
				 * Test scelti 3.
				 *
				 * @param s the s
				 * @return the array list
				 */
				public ArrayList<TestScelti> TestScelti3(TestScelti s) {
					ArrayList<TestScelti> testcompletati= new ArrayList<TestScelti>();
					testcompletati.add(s);		
					return testcompletati;
				}
				
		/**
		 * Gets the result.
		 *
		 * @return the result
		 */
		public ArrayList<TestScelti> getResult() {
			return risultati;
		}

		/**
		 * Adds the test scelti.
		 *
		 * @param s the s
		 */
		public void addTestScelti(TestScelti s) {
			risultati.add(s);		
		}
		
		/**
		 * Gets the esito.
		 *
		 * @return the esito
		 */
		public String getEsito() {
			
			return esito;
		}
		
		/**
		 * Gets the nome test.
		 *
		 * @return the nome test
		 */
		public String getNomeTest() {
			
			return nomeTest;
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
		 * Gets the mat.
		 *
		 * @return the mat
		 */
		public int getMat() {
			
			return matricola ;
		}
		
		/**
		 * Gets the pt.
		 *
		 * @return the pt
		 */
		public int getPT() {
			
			return punteggiotot ;
		}
		
		/**
		 * Gets the dt.
		 *
		 * @return the dt
		 */
		public Date getDT() {
			
			return dataiscrizione ;
		}
		
		/**
		 * Gets the d.
		 *
		 * @return the d
		 */
		public Date getD() {
			
			return datatest ;
		}
		
		/**
		 * Gets the t.
		 *
		 * @return the t
		 */
		public Time getT() {
			
			return tempo ;
		}

		/**
		 * Gets the d2.
		 *
		 * @return the d2
		 */
		public String getD2() {
			
			return String.valueOf(datatest2) ;
		}
		
		/**
		 * Gets the dt 2.
		 *
		 * @return the dt 2
		 */
		public Timestamp getDt2() {
			
			return datatest2 ;
		}
	}

