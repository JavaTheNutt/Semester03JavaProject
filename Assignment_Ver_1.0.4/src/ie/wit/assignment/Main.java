package ie.wit.assignment;

import ie.wit.assignment.accounts.Account;
import ie.wit.assignment.accounts.AccountCollector;
import ie.wit.assignment.controllers.FindItemsController;
import ie.wit.assignment.fileHandling.FileHandler;
import ie.wit.assignment.gui.*;
import ie.wit.assignment.ie.wit.assignment.comparators.IdComparator;
import ie.wit.assignment.ie.wit.assignment.comparators.SurnameComparator;
import ie.wit.assignment.implObjects.Collectible;
import ie.wit.assignment.implObjects.ItemCounter;
import ie.wit.assignment.implObjects.Lists;
import ie.wit.assignment.controllers.IOController;
import ie.wit.assignment.implObjects.Parent;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Main extends Application
{
	public static void main(String[] args)
	{
		try {
			InitialSetup.gatherItemsInSystem();
			InitialSetup.addChildren();
			/*System.out.println(parent01.toString());*/
			/*for (Collectible item : Lists.parentList.getList()){
				Parent parent = (Parent) item;
				parent.calculateFee();
				System.out.println(parent.getFName() + " " + parent.getLName());
				System.out.println(parent.getFee());
				System.out.println(parent.getNumberOfChildren() + "\n");
			}*/
			/*for(String names : FindItemsController.getParentsInArray()){
				System.out.println(names);
			}*/
			/*System.out.println(Lists.parentList.getParentNames("pr1.2", "pr1.1"));*/
			/*System.out.println(Lists.parentList.getItem("pr1.1").toString());
			System.out.println(Lists.parentList.getItem("pr1.2").toString());*/
			/*for(Account item : AccountCollector.list){
				System.out.println(item.toString());
			}*/

			launch(args);



		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/*This method saves the data and closes the program*/
	public static void closeProgram()
	{
		try {
			boolean answer = PopUp.confirmBox("System exit", "Are you sure you wish to exit?");
			if (answer) {
				if (IOController.createFile(Lists.managerList, ItemCounter.numberOfManagers, InitialSetup.managers) &&
						IOController.createFile(Lists.doctorList,
								ItemCounter.numberOfDoctors,
								InitialSetup.doctors) && IOController.createFile(Lists.playerList,
						ItemCounter.numberOfPlayers,
						InitialSetup.players) && IOController.createFile(Lists.parentList, ItemCounter.numberOfParents, InitialSetup.parents)
						&& FileHandler.writeOut(AccountCollector.list, InitialSetup.accounts)) {
					PopUp.alertBox("System Shutdown", "Files saved successfully, system will now shut down");
					System.exit(0);
				} else {
					if (PopUp.confirmBox("Error", "An error has occurred. Force shutdown?")) {
						System.exit(1);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{


		try{
			/*MainMenu.display();*/
			/*DisplayItems.displayFamilies(Lists.parentList.getAsObservableList());*/
			/*AddItem.addParent();*/
			Login.display();
			/*DisplayItems.displayFamilies(FindItemsController.findFamilies("pr1"));*/
			/*closeProgram();*/
			/*AddItem.addPlayer();*/
			/*ListItemsGui.display();*/
			/*RemoveItemMenu.display();*/
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
