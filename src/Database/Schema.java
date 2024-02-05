package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DbUtils;

public class Schema {
	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			//Load Driver
			Class.forName(DbUtils.DRIVER);
			
			//Connect to database 
			connection = DriverManager.getConnection(DbUtils.URL,DbUtils.USERNAME,DbUtils.PASSWORD);
			
			//Create an SQL Query
			String sqlQuery = "CREATE SCHEMA BooksDatabase";
			
			//Create Statement 
			statement = connection.createStatement();
			
			int result = statement.executeUpdate(sqlQuery);
			
			if(result > 0) {
				System.out.println("\n Schema Created Sucessfully");
			}
			else {
				System.out.println("\n Schema Created Sucessfully");
			}
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(connection != null && statement != null)
				connection.close();
				statement.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	

}
