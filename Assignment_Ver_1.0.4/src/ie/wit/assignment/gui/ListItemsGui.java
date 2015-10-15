package ie.wit.assignment.gui;

import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.controllers.FindItemController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
/*This class will be the GUI for choosing which items to display*/
public class ListItemsGui 
{
	public static void display()
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("List items");
		
		Label topLabel = new Label("List Items");
		StackPane topLayout = new StackPane();
		topLayout.setAlignment(Pos.CENTER);
		topLayout.getChildren().add(topLabel);
		
		Label listManagersLabel = new Label("List managers");
		Label listDoctorsLabel = new Label("List doctors");
		Label listPlayersLabel = new Label("List players");
		Label listPlayersByAgeDivisionLabel = new Label("Show an entire age division");
		
		Button listManagersButton = new Button("X");
		listManagersButton.setOnAction(e -> {
			DisplayItems.displayManagers(Collector.getList(1));
		});
		
		Button listDoctorsButton = new Button("X");
		listDoctorsButton.setOnAction(e -> {
			DisplayItems.displayDoctor(Collector.getList(2));
		});
		Button listPlayersButton = new Button("X");
		listPlayersButton.setOnAction(e -> {
			DisplayItems.displayPlayers(Collector.getList(3));
		});

		Button listPlayersByAgeDivisionButton = new Button("X");
		listPlayersByAgeDivisionButton.setOnAction(e -> {
			DisplayItems.displayPlayers(FindItemController.findPlayersByAgeDivision(PopUp.selectAgeDivision()));
		});

		GridPane.setConstraints(listManagersLabel, 0, 0);
		GridPane.setConstraints(listManagersButton, 1, 0);
		GridPane.setConstraints(listDoctorsLabel, 0, 1);
		GridPane.setConstraints(listDoctorsButton, 1, 1);
		GridPane.setConstraints(listPlayersLabel, 0, 2);
		GridPane.setConstraints(listPlayersButton, 1, 2);
		GridPane.setConstraints(listPlayersByAgeDivisionLabel, 0, 3);
		GridPane.setConstraints(listPlayersByAgeDivisionButton, 1, 3);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(listManagersLabel, listManagersButton, listDoctorsLabel, listDoctorsButton, listPlayersLabel, listPlayersButton, listPlayersByAgeDivisionLabel, listPlayersByAgeDivisionButton);
		
		BorderPane outerPane = new BorderPane();
		outerPane.setTop(topLayout);
		outerPane.setCenter(grid);
		Scene scene = new Scene(outerPane);
		window.setScene(scene);
		window.showAndWait();
	}
}
