package ie.wit.assignment.gui;

import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.implObjects.Lists;
import ie.wit.assignment.implObjects.Collector;
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

	private static void getItemToBeRemoved(int type, String typeName)
	{
		try {
			String[] listOfNames = Lists.setType(type).getNamesInArray();
			String name = PopUp.singleComboBox(listOfNames, "Remove " + typeName, "Please select the " + typeName + " to be removed");
			Collector tempList = Lists.setType(type);
			String id = tempList.getNameFromId(name);
			if (tempList.removeItem(id)){
				PopUp.alertBox("Success", "Item Removed Successfully");
			} else {
				PopUp.alertBox("Failure", "Item not removed");
			}
		} catch (ListEmptyException | ItemNotFoundException e) {
			PopUp.alertBox("Error", e.getMessage());
			/*e.printStackTrace();*/
		} catch(Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			e.printStackTrace();
		}
	}
}
