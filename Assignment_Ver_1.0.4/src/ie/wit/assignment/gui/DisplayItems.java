package ie.wit.assignment.gui;

import ie.wit.assignment.Main;
import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.controllers.Controller;
import ie.wit.assignment.exceptions.ListEmptyException;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/*This class will be used to display the tables of objects*/
public class DisplayItems 
{
	
	public static void displayManagers(ObservableList<Collectable> listIn)
	{
		TableView<Collectable> managerTable = new TableView<>();
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Display Managers");
		window.setMinWidth(600);

		if(listIn.isEmpty()){
			PopUp.alertBox("No data", "No data to display");
			return;
		}
		TableColumn<Collectable, String> managerIdColumn = new TableColumn<>("Manager Id");
		managerIdColumn.setMinWidth(50);
		managerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Collectable, String> managerFNameColumn = new TableColumn<>("First Name");
		managerFNameColumn.setMinWidth(100);
		managerFNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
		
		TableColumn<Collectable, String> managerLNameColumn = new TableColumn<>("Last Name");
		managerLNameColumn.setMinWidth(100);
		managerLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
		
		TableColumn<Collectable, String> managerAddress01Column = new TableColumn<>("Street Name");
		managerAddress01Column.setMinWidth(100);
		managerAddress01Column.setCellValueFactory(new PropertyValueFactory<>("address01"));
		
		TableColumn<Collectable, String> managerAddress02Column = new TableColumn<>("Parish Name");
		managerAddress02Column.setMinWidth(100);
		managerAddress02Column.setCellValueFactory(new PropertyValueFactory<>("address02"));
		
		TableColumn<Collectable, String> ageDivisionColumn = new TableColumn<>("Age Division");
		ageDivisionColumn.setMinWidth(20);
		ageDivisionColumn.setCellValueFactory(new PropertyValueFactory<>("ageDivision"));
		
		managerTable.setItems(listIn);
		managerTable.getColumns().addAll(managerIdColumn, managerFNameColumn, managerLNameColumn, managerAddress01Column, managerAddress02Column, ageDivisionColumn);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(managerTable);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	public static void displayDoctor(ObservableList<Collectable> listIn)
	{
		TableView<Collectable> doctorTable = new TableView<>();
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Display Managers");
		window.setMinWidth(600);

		if(listIn.isEmpty()){
			PopUp.alertBox("No data", "No data to display");
			return;
		}
		TableColumn<Collectable, String> doctorIdColumn = new TableColumn<>("Manager Id");
		doctorIdColumn.setMinWidth(50);
		doctorIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Collectable, String> doctorFNameColumn = new TableColumn<>("First Name");
		doctorFNameColumn.setMinWidth(100);
		doctorFNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
		
		TableColumn<Collectable, String> doctorLNameColumn = new TableColumn<>("Last Name");
		doctorLNameColumn.setMinWidth(100);
		doctorLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
		
		TableColumn<Collectable, String> doctorAddress01Column = new TableColumn<>("Street Name");
		doctorAddress01Column.setMinWidth(100);
		doctorAddress01Column.setCellValueFactory(new PropertyValueFactory<>("address01"));
		
		TableColumn<Collectable, String> doctorAddress02Column = new TableColumn<>("Parish Name");
		doctorAddress02Column.setMinWidth(100);
		doctorAddress02Column.setCellValueFactory(new PropertyValueFactory<>("address02"));

		doctorTable.setItems(listIn);
		doctorTable.getColumns().addAll(doctorIdColumn, doctorFNameColumn, doctorLNameColumn, doctorAddress01Column, doctorAddress02Column);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(doctorTable);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	public static  void displayPlayers(ObservableList<Collectable> listIn)
    {
        TableView<Collectable> playerTable = new TableView<>();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Display Players");
        window.setMinWidth(600);

		/*if(listIn.isEmpty()){
			PopUp.alertBox("No data", "No data to display");
		}*/


		Controller.catchEmptyException(listIn);

        TableColumn<Collectable, String> playerIdColumn = new TableColumn<>("Player Id");
        playerIdColumn.setMinWidth(50);
        playerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Collectable, String> playerFNameColumn = new TableColumn<>("First Name");
        playerFNameColumn.setMinWidth(100);
        playerFNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));

        TableColumn<Collectable, String> playerLNameColumn = new TableColumn<>("Last Name");
        playerLNameColumn.setMinWidth(100);
        playerLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));

        TableColumn<Collectable, String> playerAddress01Column = new TableColumn<>("Street Name");
        playerAddress01Column.setMinWidth(100);
        playerAddress01Column.setCellValueFactory(new PropertyValueFactory<>("address01"));

        TableColumn<Collectable, String> playerAddress02Column = new TableColumn<>("Parish Name");
        playerAddress02Column.setMinWidth(100);
        playerAddress02Column.setCellValueFactory(new PropertyValueFactory<>("address02"));

        TableColumn<Collectable, String> playerContactNoColumn = new TableColumn<>("Contact Number");
        playerContactNoColumn.setMinWidth(100);
        playerContactNoColumn.setCellValueFactory(new PropertyValueFactory<Collectable, String>("contactNo"));

        TableColumn<Collectable, String> playerEmailColumn = new TableColumn<>("Contact Email");
        playerEmailColumn.setMinWidth(100);
        playerEmailColumn.setCellValueFactory(new PropertyValueFactory<Collectable, String>("email"));

        TableColumn<Collectable, String>playerAgeDivisionColumn = new TableColumn<>("Age Division");
        playerAgeDivisionColumn.setMinWidth(30);
        playerAgeDivisionColumn.setCellValueFactory(new PropertyValueFactory<Collectable, String>("ageDivision"));

        playerTable.setItems(listIn);
        playerTable.getColumns().addAll(playerIdColumn, playerFNameColumn, playerLNameColumn, playerAddress01Column, playerAddress02Column, playerContactNoColumn, playerEmailColumn, playerAgeDivisionColumn);

        VBox layout = new VBox();
        layout.getChildren().addAll(playerTable);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
	}
	
}
