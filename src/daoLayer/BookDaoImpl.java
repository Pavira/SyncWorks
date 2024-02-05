package daoLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Books;
import utils.DbUtils;

public class BookDaoImpl implements BookDao {

	final String INSERT_QUERY= "INSERT INTO books"
			+ "(name,price,author)"
			+ "VALUES (?,?,?);";
	
	final String UPDATE_QUERY= "UPDATE books "
			+ "SET name = ?, price = ?, author = ? WHERE _id = ?";
	
	final String DELETE_QUERY="DELETE FROM books WHERE _id = ?";
	
	final String GET_QUERY="SELECT * FROM books WHERE _id = ?";
	
	final String GET_ALL_QUERY = "SELECT * FROM books";
	
	final String DROP_TABLE = "DROP TABLE books";

	@Override
	public int addBook(Books books)throws SQLException  {
		int result = 0;
		
		try(Connection connection = DriverManager.getConnection(DbUtils.URL,DbUtils.USERNAME ,DbUtils.PASSWORD );
				PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);
				)
		{
			pstmt.setString(1, books.getbName());
			pstmt.setDouble(2, books.getbPrice());
			pstmt.setString(3, books.getbAuthor());
			
			result = pstmt.executeUpdate();
		}
		return result;
	}

	@Override
	public int updateBook(Books books) {
		int result=0;
		
		try(Connection connection = DriverManager.getConnection(DbUtils.URL,DbUtils.USERNAME ,DbUtils.PASSWORD );
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY);
				 ){
			
			pstmt.setString(1, books.getbName());
			pstmt.setDouble(2, books.getbPrice());
			pstmt.setString(3, books.getbAuthor());
			pstmt.setInt(4, books.getbId());
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean deleteBook(int id) {
		boolean result  = false;
		
		try(
				Connection connection=DriverManager.getConnection(DbUtils.URL,DbUtils.USERNAME,DbUtils.PASSWORD);
				PreparedStatement pStmt=connection.prepareStatement(DELETE_QUERY);
				){
			
			pStmt.setInt(1,id);
			result = pStmt.executeUpdate() > 0;
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Books viewoneBook(int bId) {
		Books books = new Books();
		try(
				Connection connection=DriverManager.getConnection(DbUtils.URL,DbUtils.USERNAME,DbUtils.PASSWORD);
				PreparedStatement pStmt=connection.prepareStatement(GET_QUERY);
			)
		{
			pStmt.setInt(1,bId);
			
			ResultSet rset = pStmt.executeQuery();
			
			if(rset.next()) {
					int bid = rset.getInt("_id");
					String bName = rset.getString("name");
					double bPrice = rset.getDouble("price");
					String bAuthor = rset.getString("author");
					
					books.setbId(bid);
					books.setbName(bName);
					books.setbPrice(bPrice);
					books.setbAuthor(bAuthor);
						
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return books;
}

	@Override
	public List<Books> getListOfBooks() {
		
		List<Books> booksList = new ArrayList<Books>();
		
		try( Connection connection = DriverManager.getConnection(DbUtils.URL,DbUtils.USERNAME,DbUtils.PASSWORD);
				Statement stmt = connection.createStatement();	
				)
		{
			
			ResultSet rset = stmt.executeQuery(GET_ALL_QUERY);
			
			while(rset.next()) {
				Books books = new Books();
				int bid = rset.getInt("_id");
				String bName = rset.getString("name");
				double bPrice = rset.getDouble("price");
				String bAuthor = rset.getString("author");
				
				books.setbId(bid);
				books.setbName(bName);
				books.setbPrice(bPrice);
				books.setbAuthor(bAuthor);
				
				booksList.add(books);
				
			}
			
		}catch (Exception e) {
			
		}
		
		return booksList;
	}

	@Override
	public boolean dropWholeTable() {
		
		boolean result = false;
		try( Connection connection = DriverManager.getConnection(DbUtils.URL,DbUtils.USERNAME,DbUtils.PASSWORD);
				Statement stmt = connection.prepareStatement(DROP_TABLE);	
				)
		{
			result = stmt.executeUpdate(DROP_TABLE) > 0;
			
		}catch (Exception e) {
			
		}
		return result;
	}

	
}
