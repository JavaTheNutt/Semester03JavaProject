package ie.wit.assignment;

import ie.wit.assignment.gui.ListItemsGui;
import ie.wit.assignment.implObjects.ItemCounter;
import ie.wit.assignment.implObjects.Lists;
import ie.wit.assignment.controllers.IOController;
import ie.wit.assignment.gui.MainMenu;
import ie.wit.assignment.gui.PopUp;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{

/*	public static Collector managerList = new Collector();
	public static Collector doctorList = new Collector();
	public static Collector playerList = new Collector();*/
	public static void main(String[] args)
	{
		try {
			InitialSetup.gatherItemsInSystem();
			launch(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*public static Collector getList(int type)
	{
		switch (type){
			case 1:
				return managerList;
			case 2:
				return doctorList;
			case 3:
				return playerList;
		}
		return null;
	}*/

	/*This method saves the data and closes the program*/
	public static void closeProgram()
	{
		boolean answer = PopUp.confirmBox("System exit", "Are you sure you wish to exit?");
		if (answer) {
			if (IOController.createFile(Lists.managerList, ItemCounter.numberOfManagers, InitialSetup.managers) &&
					IOController.createFile(Lists.doctorList,
							ItemCounter.numberOfDoctors,
							InitialSetup.doctors) && IOController.createFile(Lists.playerList,
					ItemCounter.numberOfPlayers,
					InitialSetup.players)) {
				PopUp.alertBox("System Shutdown", "Files saved successfully, system will now shut down");
				System.exit(0);
			} else {
				if (PopUp.confirmBox("Error", "An error has occurred. Force shutdown?")) {
					System.exit(1);
				}
			}
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		/*MainMenu.display();*/
		ListItemsGui.display();
	}

}
