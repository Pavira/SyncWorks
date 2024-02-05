package Querys;

import java.util.InputMismatchException;
import java.util.Scanner;

import daoLayer.BookDao;
import daoLayer.BookDaoImpl;
import entity.Books;

public class DeleteBook {
	public void deleteBook() {
		Scanner s = new Scanner(System.in);

		try{
			System.out.println("Enter Book Id : ");
			int id = s.nextInt();
			
			Books books = new Books();
			books.setbId(id);
			
			BookDao bookdao = new BookDaoImpl();
			boolean result = bookdao.deleteBook(id);
			
			System.out.println(result?"\n Data Deleted Successfully":"\n Data Deleted Unsuccessfull");
			System.out.println("---X---X---X---X---X---X---");
			
		}catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid Input.");
			System.out.println("---X---X---X---X---X---X---");
            s.nextLine();
		}
		
	}
	
}
