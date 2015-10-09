package ie.wit.assignment.gui;

import ie.wit.assignment.collectors.Collector;
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
		
		GridPane.setConstraints(listManagersLabel, 0, 0);
		GridPane.setConstraints(listManagersButton, 1, 0);
		GridPane.setConstraints(listDoctorsLabel, 0, 1);
		GridPane.setConstraints(listDoctorsButton, 1, 1);
		GridPane.setConstraints(listPlayersLabel, 0, 2);
		GridPane.setConstraints(listPlayersButton, 1, 2);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(listManagersLabel, listManagersButton, listDoctorsLabel, listDoctorsButton, listPlayersLabel, listPlayersButton);
		
		BorderPane outerPane = new BorderPane();
		outerPane.setTop(topLayout);
		outerPane.setCenter(grid);
		Scene scene = new Scene(outerPane);
		window.setScene(scene);
		window.showAndWait();
	}
}
