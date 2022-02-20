package Database;

import java.sql.*;

// TODO: Auto-generated Javadoc
/**
 * La classe ConnessioneDB.
 */
public class ConnessioneDB {

	/** The instance. */
	// ATTRIBUTI
	private static ConnessioneDB instance;
	
	/** The connection. */
	private Connection connection = null;
	
	/** Nome dell'owner. */
	private String nome = "postgres";
	
	/** Password per accedere al database. */
	private String password = "BobbySolo20";
	
	/** Url del database. */
	private String url = "jdbc:postgresql://localhost:5432/PIATTAFORMA";
	
	/** Il driver. */
	private String driver = "org.postgresql.Driver";

	/**
	 * Instantiates a new connessione DB.
	 *
	 * @throws SQLException the SQL exception
	 */
	// COSTRUTTORE
	public ConnessioneDB() throws SQLException {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, nome, password);

		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
			return connection;
	}
	
	/**
	 * Gets the single instance of ConnessioneDB.
	 *
	 * @return single instance of ConnessioneDB
	 * @throws SQLException the SQL exception
	 */
	public static ConnessioneDB getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConnessioneDB();
		} else if (instance.getConnection().isClosed()) {
			instance = new ConnessioneDB();
		}
		return instance;
	}

}