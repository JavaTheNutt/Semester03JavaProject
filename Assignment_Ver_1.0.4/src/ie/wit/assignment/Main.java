package ie.wit.assignment;

import java.io.File;
import java.util.ArrayList;

import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.controllers.Controller;
import ie.wit.assignment.controllers.IOController;
import ie.wit.assignment.fileHandling.ManagerFileHandler;
import ie.wit.assignment.gui.MainMenu;
import ie.wit.assignment.gui.PopUp;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
	private static Manager testMan02 = new Manager(2, "Jason", "Bloggs","Pipe Street", "Thomastown","0567734343","example@test.ie", "mn01", "u-12");
	private static Manager testMan01 = new Manager(1, "Joe", "Bloggs", "Low Street", "Thomastown","0567734343","example@test.ie", "mn02",  "u-12");
	private static Doctor testDoc01 = new Doctor(1, "Achim", "Shlunke", "Low Street", "Thomastown", "0567724162");
	private static Doctor testDoc02 = new Doctor(2, "James", "Drynan", "Mill Street", "Thomastown", "0567768118");
	/*This will temporarily hold the size of the lists being read in until it is
	 * passed to the collection class*/
	private static int tempSize;
	public static File managers = new File("managers.dat");
	public static File doctors = new File("doctors.dat");

	public static void main(String[] args) 
	{
		try{
			if(!IOController.checkExistance(doctors)){
				Controller.addItem(testDoc01, 2);
				Controller.addItem(testDoc02, 2);
				IOController.createFile(Collector.doctorList, Collector.numberOfDoctors, doctors);
			} else {
				if(IOController.readList(doctors) != null){
					Collector.numberOfDoctors = tempSize;
					Collector.setDoctorList(IOController.readList(doctors));
				}
			}
			if(!IOController.checkExistance(managers)){
				Controller.addItem(testMan02, 1);
				Controller.addItem(testMan01, 1);
				IOController.createFile(Collector.managerList, Collector.numberOfManagers, managers);
			} else {
				System.out.println("Already Exists!!");
				if(IOController.readList(managers) != null){
					Collector.numberOfManagers = tempSize;
					Collector.setManagerList(IOController.readList(managers));
				} else {
					System.out.println("Fail");
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		launch(args);
	}

	public static void setTempSize(int tempSizeIn)
	{
		tempSize = tempSizeIn;
	}
	public static void closeProgram()
	{
		boolean answer = PopUp.confirmBox("System exit", "Are you sure you wish to exit?");
		if(answer){
			System.exit(0);
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		MainMenu.display();
	}
	
}
