//This is the main class
//Requires e(fx)clipse plugin from marketplace
package ie.wit.assignment;

import ie.wit.assignment.collections.*;
import ie.wit.assignment.gui.AlertBox;
import ie.wit.assignment.gui.MainMenu;
import ie.wit.assignment.implementableObjects.*;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application
{
	private static Manager testMan02 = new Manager("mn1", "Jason", "Bloggs", "0567744334", "Pipe Street", "Thomastown", "u-12");
	private static Manager testMan01 = new Manager("mn2", "Joe", "Bloggs", "0567744334", "Low Street", "Thomastown", "u-12");
	
	public static void main(String [] args) 
	{
		boolean check = ManagerCollector.addManager(testMan01);
		check = ManagerCollector.addManager(testMan02);
		
		System.out.println(check);
		launch(args);
	}


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		MainMenu.display();
	}

}
