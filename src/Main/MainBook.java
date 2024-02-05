package Main;

import java.sql.SQLException;
import java.util.Scanner;

import Querys.AddBook;
import Querys.DeleteBook;
import Querys.DropTable;
import Querys.UpdateBook;
import Querys.ViewAllbook;
import Querys.ViewOneBook;

public class MainBook {

    public static void main(String[] args) throws SQLException {

    	//Objects
    	AddBook main_add = new AddBook();
    	UpdateBook main_update = new UpdateBook();
    	DeleteBook main_delete = new DeleteBook();
    	ViewOneBook main_one = new ViewOneBook();
    	ViewAllbook main_all = new ViewAllbook();
    	DropTable droptable =  new DropTable();
    	
    	
        Scanner s = new Scanner(System.in);
        String inputStr = null;
        char input = ' ';

        do {
            System.out.println("Select An Option" + "\n");
            System.out.println("1.Add a Book" + "\n" + "2.Update a Book" + "\n" + "3.Delete a Book" + "\n"
                    + "4.View a Book" + "\n" + "5.View all Book" + "\n" + "6.Exit Menu" + "\n" + "7.Drop Books Table"+"\n");
            System.out.println(">Your Option: " + "\n");
            input = s.next().charAt(0);
    
            switch (input) {
            case '1': {
                main_add.addBook();
                break;
            }
            case '2': {
                main_update.updateBook();
                break;
            }
            case '3': {
                main_delete.deleteBook();
                break;
            }
            case '4': {
                main_one.viewoneBook();
                break;
            }
            case '5': {
                main_all.viewAllBook();
                
                break;
            }
            case '6':{
            	System.out.println("Do you Really want to Exit (y/n) : ");
            	inputStr = s.next();
            	if(inputStr == "y") {
            		System.out.println("Thanks you for reading our books");
            		System.out.println("---X---X---X---X---X---X---");
            		break;
            	}else {
            		continue;
            	}
            }
            case '7':{
            	droptable.dropTable();
            }
            break;
            default:
                System.out.print("\n Input Correct Value \n" + "\n");
                System.out.println("---X---X---X---X---X---X---");
            }
            
        } while (input != '6' || inputStr.equalsIgnoreCase("n"));

        s.close();
    }
}
