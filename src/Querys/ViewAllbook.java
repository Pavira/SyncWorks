package Querys;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import daoLayer.BookDao;
import daoLayer.BookDaoImpl;
import entity.Books;

public class ViewAllbook {
	public void viewAllBook() {
		Scanner s = new Scanner(System.in);
		
		try {
			BookDao bookdao = new BookDaoImpl();
			List<Books> booksList = bookdao.getListOfBooks();
			
			 System.out.println("Do you want ascending or descending list (asc/desc) : ");
             String inputStr = s.nextLine();
             if(inputStr.equalsIgnoreCase("asc")) {
            	System.out.println("Ascending List :"+ booksList);
            	System.out.println("---X---X---X---X---X---X---");
             	
             }else if(inputStr.equalsIgnoreCase("desc")) {
             	Collections.sort(booksList);
             	System.out.println("Descending Books List :"+ booksList);
             	System.out.println("---X---X---X---X---X---X---");
             }
             else {
            	 System.out.println("Input Correct Value");
            	 System.out.println("---X---X---X---X---X---X---");
             }
			
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid Input.");
			System.out.println("---X---X---X---X---X---X---");
            s.nextLine();
		}
		
	}

}
