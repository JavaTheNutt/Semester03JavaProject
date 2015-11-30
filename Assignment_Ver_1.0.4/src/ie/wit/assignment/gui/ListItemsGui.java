package ie.wit.assignment.gui;

import ie.wit.assignment.exceptions.GroupMismatchException;
import ie.wit.assignment.exceptions.InputNotValidException;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.implObjects.Collectible;
import ie.wit.assignment.implObjects.Lists;
import ie.wit.assignment.controllers.FindItemsController;
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

import java.util.List;

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
		Label findManagerByNameLabel = new Label("Find a manager by name");
		Label showAllPlayersWithDoctorLabel = new Label("Find all players with a specific doctor");
		Label showFamiliesLabel = new Label("Show families");
		
		Button listManagersButton = new Button("X");
		listManagersButton.setOnAction(e -> {
			try {
				DisplayItems.displayManagers(Lists.managerList.getAsObservableList());
			} catch (ListEmptyException e1) {
				PopUp.alertBox("Error", e1.getMessage());
				e1.printStackTrace();
			} catch (Exception e1){
				PopUp.alertBox("Error", "An unknown error has occurred");
				e1.printStackTrace();
			}
		});
		
		Button listDoctorsButton = new Button("X");
		listDoctorsButton.setOnAction(e -> {
			try {
				DisplayItems.displayDoctor(Lists.doctorList.getAsObservableList());
			} catch (ListEmptyException e1) {
				PopUp.alertBox("Error", e1.getMessage());
				e1.printStackTrace();
			} catch(Exception e1){
				PopUp.alertBox("Error", "An unknown error has occurred ");
				e1.printStackTrace();
			}
		});
		Button listPlayersButton = new Button("X");
		listPlayersButton.setOnAction(e -> {
			try {
				DisplayItems.displayPlayers(Lists.playerList.getAsObservableList());
			} catch (ListEmptyException e1) {
				PopUp.alertBox("Error", e1.getMessage());
				e1.printStackTrace();
			} catch (Exception e1){
				PopUp.alertBox("Error", "An unknown error has occurred");
				e1.printStackTrace();
			}
		});

		Button listPlayersByAgeDivisionButton = new Button("X");
		listPlayersByAgeDivisionButton.setOnAction(e -> {
			DisplayItems.displayPlayers(FindItemsController.findPlayersByAgeDivision(PopUp.selectAgeDivision()));
		});

		Button findPlayerByNameButton = new Button("X");
		findPlayerByNameButton.setOnAction(e -> {
			Collectible player = FindItemsController.findItemsByName(3);
			if(player == null){
				PopUp.alertBox("No Data", "There is no data to display");
			} else {
				PopUp.alertBox("Player", player.toString());
			}
		});

		Button findManagerByNameButton = new Button("X");
		findManagerByNameButton.setOnAction(e -> {
			Collectible manager = FindItemsController.findItemsByName(1);
			if(manager == null){
				PopUp.alertBox("No Data", "There is no data to display");
			} else {
				PopUp.alertBox("Manager", manager.toString());
			}
		});

		Button findDoctorByNameButton = new Button("X");
		findDoctorByNameButton.setOnAction(e -> {
			Collectible doctor = FindItemsController.findItemsByName(2);
			if (doctor == null) {
				PopUp.alertBox("No Data", "There is no data to display");
			} else {
				PopUp.alertBox("Doctor", doctor.toString());
			}
		});

		Button showAllPlayersWithDoctorButton = new Button("X");
		showAllPlayersWithDoctorButton.setOnAction(e -> {
			try {
				String doctorName = PopUp.singleComboBox(Lists.doctorList.getNamesInArray(), "Select Doctor", "Please select a doctor");
				String doctorId = Lists.doctorList.getIdFromName(doctorName);
				DisplayItems.displayPlayers(FindItemsController.getAssociatedItems(doctorId));
			} catch (ListEmptyException |InputNotValidException | ItemNotFoundException e1) {
				PopUp.alertBox("Error", e1.getMessage());
				e1.printStackTrace();
			} catch (Exception e1){
				PopUp.alertBox("Error", "An unknown error has occurred");
				e1.printStackTrace();
			}

		});
		Button showFamiliesButton = new Button("X");
		showFamiliesButton.setOnAction(e -> {
			String names = getParents();
			String[] nameArray = names.split(" ");
			String id = getParentId(nameArray[0], nameArray[1]);
			String pairId = id.substring(0, 3);
			if(!pairId.substring(0, 2).equalsIgnoreCase("pr")){
				PopUp.alertBox("Error", id);
				return;
			}
			List<Collectible> family = FindItemsController.findFamilies(pairId);
			DisplayItems.displayFamilies(family);
			/*window.close();*/
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
		GridPane.setConstraints(showAllPlayersWithDoctorLabel, 0, 7);
		GridPane.setConstraints(showAllPlayersWithDoctorButton, 1, 7);
		GridPane.setConstraints(showFamiliesLabel, 0, 8);
		GridPane.setConstraints(showFamiliesButton, 1, 8);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(listManagersLabel, listManagersButton, listDoctorsLabel, listDoctorsButton,
				listPlayersLabel, listPlayersButton, listPlayersByAgeDivisionLabel, listPlayersByAgeDivisionButton,
				findDoctorByNameButton, findDoctorByNameLabel, findManagerByNameButton, findManagerByNameLabel,
				findPlayerByNameButton, findPlayerByNameLabel, showAllPlayersWithDoctorLabel, showAllPlayersWithDoctorButton,
				showFamiliesLabel, showFamiliesButton);
		
		BorderPane outerPane = new BorderPane();
		outerPane.setTop(topLayout);
		outerPane.setCenter(grid);
		Scene scene = new Scene(outerPane);
		window.setScene(scene);
		window.showAndWait();
	}
	private static String getParents(){
		try{
			Object[] objectArray = /*(String [])*/FindItemsController.getParentsInArray().toArray();
			String[] nameArray = new String[objectArray.length];
			int i = 0;
			for(Object name : objectArray){
				String stringName = name.toString();
				nameArray[i] = stringName;
				i++;
			}
			return PopUp.singleComboBox(nameArray, "Select parent", "Please select the parents names");

		}catch (ListEmptyException | GroupMismatchException | ItemNotFoundException e){
			return e.getMessage();
		} catch (Exception e){
			e.printStackTrace();
			return "unknown error";
		}
	}
	private static String getParentId(String fName, String lName){
		try{
			String id = Lists.parentList.getIdFromName(fName, lName);
			return id;
		}catch (ListEmptyException | ItemNotFoundException e){
			return e.getMessage();
		}
	}
}
