package ie.wit.assignment;

import ie.wit.assignment.gui.*;
import ie.wit.assignment.ie.wit.assignment.comparators.IdComparator;
import ie.wit.assignment.ie.wit.assignment.comparators.SurnameComparator;
import ie.wit.assignment.implObjects.Collectible;
import ie.wit.assignment.implObjects.ItemCounter;
import ie.wit.assignment.implObjects.Lists;
import ie.wit.assignment.controllers.IOController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

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
			/*System.out.println(Lists.playerList.getItem("James", "Bloggs").toString());*/

			/*List<Collectible> list = Lists.playerList.getList();
			list.sort(new SurnameComparator());
			for(Collectible item : list){
				System.out.println(item.toString());
			}
			list.sort(new IdComparator());
			for (Collectible item : list){
				System.out.println(item.toString());
			}*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

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
		/*ListItemsGui.display();*/
		try{
			/*AddItem.addParent();*/
			Login.display();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
