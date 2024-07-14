package database;

import java.sql.*;

public class Myclass {
	 private static final String URL = "jdbc:mysql://localhost:3301/Hotel";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Divya@273";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }

}
