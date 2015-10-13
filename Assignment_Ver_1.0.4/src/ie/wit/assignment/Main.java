package ie.wit.assignment;

import java.io.File;
import java.util.ArrayList;

import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.controllers.Controller;
import ie.wit.assignment.controllers.IOController;
import ie.wit.assignment.fileHandling.ManagerFileHandler;
import ie.wit.assignment.gui.AddItem;
import ie.wit.assignment.gui.DisplayItems;
import ie.wit.assignment.gui.MainMenu;
import ie.wit.assignment.gui.PopUp;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{

	public static void main(String[] args) 
	{

		try{
			InitialSetup.gatherItemsInSystem();
			launch(args);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public static void setTempSize(int tempSizeIn)
	{
		InitialSetup.tempSize = tempSizeIn;
	}
	public static void closeProgram()
	{
		boolean answer = PopUp.confirmBox("System exit", "Are you sure you wish to exit?");
		if(answer){
			if(IOController.createFile(Collector.managerList, Collector.numberOfManagers, InitialSetup.managers) && IOController.createFile(Collector.doctorList, Collector.numberOfDoctors, InitialSetup.doctors) && IOController.createFile(Collector.playerList, Collector.numberOfPlayers, InitialSetup.players))
            {
                PopUp.alertBox("System Shutdown", "Files saved successfully, system will now shut down");
                System.exit(0);
            } else {
               if (PopUp.confirmBox("Error", "An error has occured. Force shutdown?")){
                   System.exit(1);
               }
            }
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		/*AddItem.addPlayer();*/
		/*MainMenu.display();*/
		/*DisplayItems.displayManagers(Collector.getList(1));*/
		/*DisplayItems.displayDoctor(Collector.getList(2));*/
		PopUp.singleInput("Enter data", "Enter the data");
		
	}
	
}
