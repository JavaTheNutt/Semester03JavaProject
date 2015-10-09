package ie.wit.assignment.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class AddItemsMenu 
{
	public static void display()
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Select an option");
		
		Label topLabel = new Label("Please select an option");
		Label addManagerLabel = new Label("Add a Manager");
		Label addDoctorLabel = new Label("Add a Doctor");
		Label addPlayerLabel = new Label("Add a Player");
		
		StackPane topLayout= new StackPane();
		topLayout.setAlignment(Pos.CENTER);
		topLayout.getChildren().add(topLabel);
		
		Button addManagerButton = new Button("X");
		addManagerButton.setOnAction(e -> {
			AddItem.addManager();
		});
		
		Button addDoctorButton = new Button("X");
		addDoctorButton.setOnAction(e -> {
			AddItem.addDoctor();
		});
		
		Button addPlayerButton = new Button("X");
		addPlayerButton.setOnAction(e -> {
			AddItem.addPlayer();
		});
		
		GridPane.setConstraints(addManagerLabel, 0, 1);
		GridPane.setConstraints(addManagerButton, 1, 1);
		GridPane.setConstraints(addDoctorLabel, 0, 2);
		GridPane.setConstraints(addDoctorButton, 1, 2);
		GridPane.setConstraints(addPlayerLabel, 0, 3);
		GridPane.setConstraints(addPlayerButton, 1, 3);
		
		GridPane grid = new GridPane();
		grid.setVgap(8);
		grid.setHgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setAlignment(Pos.CENTER);
		
		grid.getChildren().addAll(addManagerLabel, addManagerButton, addDoctorLabel, addDoctorButton, addPlayerLabel, addPlayerButton);
		
		BorderPane outerLayout = new BorderPane();
		outerLayout.setTop(topLayout);
		outerLayout.setCenter(grid);
		
		Scene scene = new Scene(outerLayout);
		window.setScene(scene);
		window.showAndWait();
	}
}
