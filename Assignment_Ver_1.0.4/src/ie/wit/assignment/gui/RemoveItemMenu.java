package ie.wit.assignment.gui;

import ie.wit.assignment.collectors.Lists;
import ie.wit.assignment.collectors.NewCollector;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*This class will be the GUI for removing items*/
public class RemoveItemMenu
{
	private static String tempId;
	public static void display()
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Select type");

		Label removeManagerLabel = new Label("Remove Manager");
		Label removeDoctorLabel = new Label("Remove Doctor");
		Label removePlayerLabel = new Label("Remove Player");


		Button removeManagerButton = new Button("X");
		removeManagerButton.setOnAction(e-> {
			getItemToBeRemoved(1, "manager");
		});

		Button removeDoctorButton = new Button("X");
		removeDoctorButton.setOnAction(e -> {
			getItemToBeRemoved(2, "doctor");
		});

		Button removePlayerButton = new Button("X");
		removePlayerButton.setOnAction(e -> {
			getItemToBeRemoved(3, "player");
		});

		GridPane.setConstraints(removeManagerLabel, 0, 0);
		GridPane.setConstraints(removeManagerButton, 1, 0);
		GridPane.setConstraints(removeDoctorLabel, 0, 1);
		GridPane.setConstraints(removeDoctorButton, 1, 1);
		GridPane.setConstraints(removePlayerLabel, 0, 2);
		GridPane.setConstraints(removePlayerButton, 1, 2);

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(removeManagerLabel, removeManagerButton, removeDoctorLabel, removeDoctorButton, removePlayerLabel, removePlayerButton);
		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.showAndWait();
	}
	/*This method will prompt the user for an ID, validate it and use that to remove the item*/
	/*private static void passData(String typeString, int type)
	{
		String subId;
		String tempId;
		boolean check;
		do{
			tempId = PopUp.singleInput("Enter id", "Please enter the Id of the " + typeString + " to be removed");
			if(!tempId.equalsIgnoreCase("close")){
				subId = tempId.substring(0, 2);
				if((!subId.equalsIgnoreCase("mn")&& type ==1) || (!subId.equalsIgnoreCase("dr") && type == 2) || (subId.equalsIgnoreCase("pl") && type == 3)){
					check = false;
					PopUp.alertBox("Incorrect entry", "Please enter a valid Id.(One beginning with either 'pl', 'mn' or 'dr'");
				} else {
					check = true;
				}
			}else{
				check = true;
			}
		}while(!check);
		if(tempId.equalsIgnoreCase("close")){
			if(Controller.removeItem(tempId, type)){
				PopUp.alertBox("Success", "Item successfully removed");
				return;
			} else {
				PopUp.alertBox("Failed", "The item has not been removed");
				return;
			}
		}
	}*/
	private static void getItemToBeRemoved(int type, String typeName)
	{
		String[] listOfNames = Lists.setType(type).getNamesInArray();
		String name = PopUp.singleComboBox(listOfNames, "Remove " + typeName, "Please select the " + typeName + " to be removed");
		NewCollector tempList = Lists.setType(type);
		String id = tempList.matchNameToId(name);
		if (tempList.removeItem(id)){
			PopUp.alertBox("Success", "Item Removed Successfully");
		} else {
			PopUp.alertBox("Failure", "Item not removed");
		}
	}
}
