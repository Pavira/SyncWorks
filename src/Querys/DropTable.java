package Querys;

import java.util.Scanner;

import daoLayer.BookDao;
import daoLayer.BookDaoImpl;

public class DropTable {
 
	public void dropTable() {
		Scanner s = new Scanner(System.in);
		String strin = null;
				
		System.out.println("Do you really want to delete the Database (y/n):");
		strin = s.next();
		if(strin.equals("y")) {
			System.out.println("Sucessfully DataBase Droped"+ "\n");
			System.out.println("---X---X---X---X---X---X---");
			BookDao bookdao = new BookDaoImpl();
			bookdao.dropWholeTable();
		}
		else {
		}
	}

}
