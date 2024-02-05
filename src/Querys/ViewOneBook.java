package Querys;

import java.util.InputMismatchException;
import java.util.Scanner;

import daoLayer.BookDao;
import daoLayer.BookDaoImpl;
import entity.Books;

public class ViewOneBook {
	public void viewoneBook() {
		Scanner s = new Scanner(System.in);

		try{
			System.out.println("Enter Id to retrieve :");
			int id = s.nextInt();
			
			BookDao bookdao = new BookDaoImpl();
			Books result = bookdao.viewoneBook(id);
			
			if(result.getbId() !=0) {
				System.out.println(result);		
			}
			else{
				System.out.println("\n There is no Data in this ID"+ "\n");
				System.out.println("---X---X---X---X---X---X---");
			}
			}catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid ID.");
				System.out.println("---X---X---X---X---X---X---");
	            s.nextLine();
			}
			
		}
}
