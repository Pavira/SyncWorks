package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DbUtils;

public class Table {

	public static void main(String[] args) {
		try(
				Connection connection = DriverManager.getConnection(DbUtils.URL,DbUtils.USERNAME,DbUtils.PASSWORD);
				Statement statement = connection.createStatement();
				)
		{
			
			String createTableQuery = "CREATE TABLE books (\r\n"
					+ "  _id INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  name VARCHAR(30) NOT NULL,\r\n"
					+ "  price DECIMAL (7,0) NOT NULL,\r\n"
					+ "  author VARCHAR(30) NOT NULL,\r\n"
					+ "  PRIMARY KEY (_id));";
			
			int result = statement.executeUpdate(createTableQuery);
			
			if(result == 0) {
				System.out.println(" Table Created Sucessfully ");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
