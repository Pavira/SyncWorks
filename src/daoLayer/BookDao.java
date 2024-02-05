package daoLayer;

import java.sql.SQLException;
import java.util.List;

import entity.Books;

public interface BookDao {

	int addBook(Books books) throws SQLException;

	int updateBook(Books books);

	boolean deleteBook(int bId);

	Books viewoneBook(int bId);

	List<Books> getListOfBooks();

	boolean dropWholeTable();

	
}
