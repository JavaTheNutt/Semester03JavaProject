package ie.wit.assignment.gui;

import ie.wit.assignment.Main;
import ie.wit.assignment.collectables.Manager;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayItems 
{
	
	private static TableView<Manager> table = new TableView<>();
	
	public static void displayManagers(ObservableList<Manager> listIn)
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Display Managers");
		/*window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});*/
		window.setMinWidth(600);
		if(listIn.isEmpty()){
			System.out.println("no list");
		}
		for(Manager item : listIn){
			System.out.println(item.toString());
		}
		
		TableColumn<Manager, String> managerIdColumn = new TableColumn<>("Manager Id");
		managerIdColumn.setMinWidth(50);
		managerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Manager, String> managerFNameColumn = new TableColumn<>("First Name");
		managerFNameColumn.setMinWidth(100);
		managerFNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
		
		TableColumn<Manager, String> managerLNameColumn = new TableColumn<>("Last Name");
		managerLNameColumn.setMinWidth(100);
		managerLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
		
		TableColumn<Manager, String> managerAddress01Column = new TableColumn<>("Street Name");
		managerAddress01Column.setMinWidth(100);
		managerAddress01Column.setCellValueFactory(new PropertyValueFactory<>("address01"));
		
		TableColumn<Manager, String> managerAddress02Column = new TableColumn<>("Parish Name");
		managerAddress02Column.setMinWidth(100);
		managerAddress02Column.setCellValueFactory(new PropertyValueFactory<>("address02"));
		
		TableColumn<Manager, String> ageDivisionColumn = new TableColumn<>("Age Division");
		ageDivisionColumn.setMinWidth(20);
		ageDivisionColumn.setCellValueFactory(new PropertyValueFactory<>("ageDivision"));
		
		table.setItems(listIn);
		table.getColumns().addAll(managerIdColumn, managerFNameColumn, managerLNameColumn, managerAddress01Column, managerAddress02Column, ageDivisionColumn);
		
		VBox layout = new VBox();
		layout.getChildren().addAll(table);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
