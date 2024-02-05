package Querys;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import daoLayer.BookDao;
import daoLayer.BookDaoImpl;
import entity.Books;

public class AddBook {

	public void addBook() throws SQLException {
		Scanner s = new Scanner(System.in);

		try{
			System.out.println("Enter Book Name : ");
			String bName = s.nextLine();
			
			System.out.println("Enter Book Price : ");
			double bPrice = s.nextDouble();
			
			System.out.println("Enter Author Name : ");
			s.nextLine();
			String bAuthor = s.nextLine();
			
			
			Books books = new Books();
			
			books.setbName(bName);
			books.setbPrice(bPrice);
			books.setbAuthor(bAuthor);
			
			BookDao bookdao = new BookDaoImpl();
			int result = bookdao.addBook(books);
			
			if(result == 1) {
				System.out.println("\n Data Added Successfully" + "\n");
				System.out.println("---X---X---X---X---X---X---");
			}else {
				System.out.println("\n Could not able to Add Data"+ "\n");
				System.out.println("---X---X---X---X---X---X---");
			}
		}catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid Input.");
			System.out.println("---X---X---X---X---X---X---");
            s.nextLine();
		}
	
	}

}
