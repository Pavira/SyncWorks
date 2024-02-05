package Querys;

import java.util.InputMismatchException;
import java.util.Scanner;

import daoLayer.BookDao;
import daoLayer.BookDaoImpl;
import entity.Books;


public class UpdateBook {
	public void updateBook() {
		Scanner s = new Scanner(System.in);
		
			try {
				System.out.println("Enter Book Name : ");
				String bName = s.nextLine();
				
				System.out.println("Enter Book Price : ");
				double bPrice = s.nextDouble();
				
				System.out.println("Enter Author Name : ");
				s.nextLine();
				String bAuthor = s.nextLine();
				
				System.out.println("Enter Book Id : ");
				int _id = s.nextInt();
				

				Books books = new Books();
				
				books.setbName(bName);
				books.setbPrice(bPrice);
				books.setbAuthor(bAuthor);
				books.setbId(_id);
				
				BookDao bookdao = new BookDaoImpl();
				int result = bookdao.updateBook(books);
				
				System.out.println(result>0?"\n Updated Successfully"+ "\n":"\n Updation Unsuccessfull"+ "\n");
				System.out.println("---X---X---X---X---X---X---");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid Input.");
				System.out.println("---X---X---X---X---X---X---");
	            s.nextLine();
			}
	}
}
