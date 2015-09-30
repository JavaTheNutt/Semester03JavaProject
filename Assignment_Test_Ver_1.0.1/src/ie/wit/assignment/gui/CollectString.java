package ie.wit.assignment.gui;

import ie.wit.assignment.collections.ManagerCollector;
import ie.wit.assignment.controllers.StringInputController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CollectString 
{
	private static Stage window;
	private static Scene scene;
	private static Label mainLabel;
	private static Button confButton;
	private static TextField userInput;
	private static VBox layout;
	
	public static void display(String title, String message)
	{
		window = new Stage();
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		mainLabel = new Label(message);
		confButton = new Button("confirm");
		confButton.setOnAction(event -> 
		{
			String tempString = StringInputController.collectStringFromUser(userInput.getText());
			if(tempString.equalsIgnoreCase("manager not found")){
				AlertBox.display("Error", tempString);
			} else {
				AlertBox.display("Requested Manager", ManagerCollector.getManagerById(userInput.getText()).toString());
			}
		});
		userInput = new TextField();
		layout = new VBox(10);
		layout.getChildren().addAll(mainLabel, userInput, confButton);
		scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
}