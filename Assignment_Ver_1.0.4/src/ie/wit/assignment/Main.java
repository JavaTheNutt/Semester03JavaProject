package ie.wit.assignment;

import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectors.ManagerCollector;
import ie.wit.assignment.controllers.ManagerController;

public class Main
{
	private static Manager testMan02 = new Manager(2, "Jason", "Bloggs","Pipe Street", "Thomastown","0567734343","example@test.ie", "mn01", "u-12");
	private static Manager testMan01 = new Manager(1, "Joe", "Bloggs", "Low Street", "Thomastown","0567734343","example@test.ie", "mn02",  "u-12");
	
	public static void main(String[] args) 
	{
		System.out.println(ManagerController.addManager(testMan01));
	}

}
