package ie.wit.assignment.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/*This class will display the menu for updating the items*/
public class UpdateItemMenu
{
	private static String[] listOfAttributes;
	private static String selectedAttribute;
	public static void display()
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Select item to be updated");

		Label updateManagerLabel = new Label("Update Manager");
		Label updateDoctorLabel = new Label("Update Doctor");
		Label updatePlayerLabel = new Label("Update Player");

		Button updateManagerButton = new Button("X");
		updateManagerButton.setOnAction(e -> {
			listOfAttributes = new String[]{
					"First Name",
					"Last Name",
					"Street Address",
					"Parish",
					"Contact Number",
					"Contact Email"
			};
			selectedAttribute = PopUp.singleComboBox(listOfAttributes, "Select attribute", "Please select the attribute to be updated");
			if(!selectedAttribute.equalsIgnoreCase("close")){
				PopUp.singleInput("Select manager", "Please enter the id of then manager that you wish to update");
			}
		});
		Button updateDoctorButton = new Button("X");
		Button updatePlayerButton = new Button("X");

		GridPane.setConstraints(updateManagerLabel, 0, 0);
		GridPane.setConstraints(updateManagerButton, 1, 0);
		GridPane.setConstraints(updateDoctorLabel, 0, 1);
		GridPane.setConstraints(updateDoctorButton, 1, 1);
		GridPane.setConstraints(updatePlayerLabel,0, 2);
		GridPane.setConstraints(updatePlayerButton, 1, 2);

		GridPane grid  = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(updateManagerLabel, updateManagerButton, updateDoctorLabel, updateDoctorButton, updatePlayerLabel, updatePlayerButton);

		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.showAndWait();

	}
	private static void validateManager(String valueIn)
	{

	}
}
