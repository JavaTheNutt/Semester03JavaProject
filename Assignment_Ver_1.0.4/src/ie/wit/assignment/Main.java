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
			System.exit(0);
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		AddItem.addPlayer();
		/*MainMenu.display();*/
		/*DisplayItems.displayManagers(Collector.getList(1));*/
		/*DisplayItems.displayDoctor(Collector.getList(2));*/
		
	}
	
}
