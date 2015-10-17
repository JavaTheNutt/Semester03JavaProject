package ie.wit.assignment.gui;

import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.controllers.FindItemController;
import javafx.collections.ObservableList;
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
		Label findPlayerByNameLabel = new Label("Find a player by name");
		Label findDoctorByNameLabel = new Label("Find a doctor by name");
		Label findManagerByNameLabel = new Label("Find a manger by name");
		
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

		Button findPlayerByNameButton = new Button("X");
		findPlayerByNameButton.setOnAction(e -> {
			ObservableList tempList = FindItemController.findByName(3);
			if(tempList == null){
				PopUp.alertBox("No Data", "There is no data to display");
				return;
			} else {
				DisplayItems.displayPlayers(tempList);
			}
		});

		Button findManagerByNameButton = new Button("X");
		findManagerByNameButton.setOnAction(e -> {
			ObservableList tempList = FindItemController.findByName(1);
			if(tempList == null){
				PopUp.alertBox("No Data", "There is no data to display");
				return;
			} else {
				DisplayItems.displayPlayers(tempList);
			}
		});

		Button findDoctorByNameButton = new Button("X");
		findDoctorByNameButton.setOnAction(e -> {
			ObservableList tempList = FindItemController.findByName(2);
			if (tempList == null) {
				PopUp.alertBox("No Data", "There is no data to display");
				return;
			} else {
				DisplayItems.displayPlayers(tempList);
			}
		});

		GridPane.setConstraints(listManagersLabel, 0, 0);
		GridPane.setConstraints(listManagersButton, 1, 0);
		GridPane.setConstraints(listDoctorsLabel, 0, 1);
		GridPane.setConstraints(listDoctorsButton, 1, 1);
		GridPane.setConstraints(listPlayersLabel, 0, 2);
		GridPane.setConstraints(listPlayersButton, 1, 2);
		GridPane.setConstraints(listPlayersByAgeDivisionLabel, 0, 3);
		GridPane.setConstraints(listPlayersByAgeDivisionButton, 1, 3);
		GridPane.setConstraints(findPlayerByNameLabel, 0, 4);
		GridPane.setConstraints(findPlayerByNameButton, 1 , 4);
		GridPane.setConstraints(findManagerByNameLabel, 0, 5);
		GridPane.setConstraints(findManagerByNameButton, 1, 5);
		GridPane.setConstraints(findDoctorByNameLabel, 0, 6);
		GridPane.setConstraints(findDoctorByNameButton, 1, 6);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(listManagersLabel, listManagersButton, listDoctorsLabel, listDoctorsButton, listPlayersLabel, listPlayersButton, listPlayersByAgeDivisionLabel, listPlayersByAgeDivisionButton, findDoctorByNameButton, findDoctorByNameLabel, findManagerByNameButton, findManagerByNameLabel, findPlayerByNameButton, findPlayerByNameLabel);
		
		BorderPane outerPane = new BorderPane();
		outerPane.setTop(topLayout);
		outerPane.setCenter(grid);
		Scene scene = new Scene(outerPane);
		window.setScene(scene);
		window.showAndWait();
	}
}
