package ma.projet.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	Connection conn;

	public Connexion() {
		String url = "jdbc:mysql://localhost:3306/demojdbc";
		try {
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("Connected to data base");

		} catch (SQLException e) {
			System.err.println("Error opening SQL connection:" + e.getMessage());
		}
	}

	public Connection getConnection() {
		return conn;
	}
	

}
