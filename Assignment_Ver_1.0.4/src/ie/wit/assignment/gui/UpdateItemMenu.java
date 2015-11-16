package ie.wit.assignment.gui;

import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.implObjects.Collector;
import ie.wit.assignment.implObjects.Lists;
import ie.wit.assignment.controllers.UpdateItemController;
import ie.wit.assignment.controllers.ValidationController;
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
		updateManagerButton.setOnAction(e -> collectInput(1));
		Button updateDoctorButton = new Button("X");
		updateDoctorButton.setOnAction(e -> collectInput(2));
		Button updatePlayerButton = new Button("X");
		updatePlayerButton.setOnAction(e -> collectInput(3));

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
	private static boolean validateAttribute(int type, String attributeIn)
	{
		for(String attribute : UpdateItemController.returnAttributesInArray(type)){
			if(attribute.equalsIgnoreCase(attributeIn)){
				return true;
			}
		}
		return false;
	}

	private static void collectInput(int type)
	{
		try {
			String tempName  = PopUp.singleComboBox(Lists.setType(type).getNamesInArray(),
					"Select item",
					"Please select the item to be updated");
			String attribute = "";
			String attributeValue = "";
			if(!tempName.equalsIgnoreCase("close")){
				Collector tempList = Lists.setType(type);
				String tempId = tempList.getNameFromId(tempName);
				attribute = PopUp.singleComboBox(UpdateItemController.returnAttributesInArray(type), "Select attributes", "Select the attribute to be updated");
				if(!attribute.equalsIgnoreCase("close")){
					if(validateAttribute(type, attribute)){
						attributeValue = PopUp.singleInput("Enter Value", "Enter the value of the attribute");
						if(attribute.equalsIgnoreCase("email")){
							if(ValidationController.checkEmail(attributeValue)){
								UpdateItemController.updateItem(tempId, attribute, attributeValue);
							}
						} else{
							if(type == 1 && attribute.equalsIgnoreCase("ageDivision")){
								if(ValidationController.checkCorrectDivision(attributeValue)){
									UpdateItemController.updateItem(tempId, attribute, attributeValue);
								} else {
									PopUp.alertBox("Error", "There are already two managers for that division");
								}
							} else {
								UpdateItemController.updateItem(tempId, attribute, attributeValue);
							}
						}
					} else {
						PopUp.alertBox("Error", "That is not a valid attribute for that object");
					}
				}
			}
		} catch (ListEmptyException | ItemNotFoundException e) {
			PopUp.alertBox("Error", e.getMessage());
			/*e.printStackTrace();*/
		}  catch(Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			e.printStackTrace();
		}
	}
}
