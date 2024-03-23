package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO {
	
	private Connection connection=null;
	
	private static String url="jdbc:mysql://localhost:3306/english";
	private static String user="root";
	private static String password="";
	
	public DAO() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection=DriverManager.getConnection(url, user, password);
			 
		} catch (ClassNotFoundException e) {
			System.out.println("Driver "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("Connexion bdd");
		}
		
	}

	public Connection getConnection() {
		return connection;
	}
	
	

}
