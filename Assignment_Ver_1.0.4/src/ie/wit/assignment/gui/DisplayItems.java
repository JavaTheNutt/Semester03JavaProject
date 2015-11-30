package ie.wit.assignment.gui;

import ie.wit.assignment.implObjects.Collectible;
import ie.wit.assignment.implObjects.Parent;
import ie.wit.assignment.implObjects.Player;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/*This class will be used to display the tables of objects*/
public class DisplayItems 
{
	
	public static void displayManagers(ObservableList<Collectible> listIn)
	{
		TableView<Collectible> managerTable = new TableView<>();
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Display Managers");
		window.setMinWidth(600);

		if(listIn.isEmpty()){
			PopUp.alertBox("No data", "No data to display");
			return;
		}
		TableColumn<Collectible, String> managerIdColumn = new TableColumn<>("Manager Id");
		managerIdColumn.setMinWidth(50);
		managerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Collectible, String> managerFNameColumn = new TableColumn<>("First Name");
		managerFNameColumn.setMinWidth(100);
		managerFNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
		
		TableColumn<Collectible, String> managerLNameColumn = new TableColumn<>("Last Name");
		managerLNameColumn.setMinWidth(100);
		managerLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
		
		TableColumn<Collectible, String> managerAddress01Column = new TableColumn<>("Street Name");
		managerAddress01Column.setMinWidth(100);
		managerAddress01Column.setCellValueFactory(new PropertyValueFactory<>("address01"));
		
		TableColumn<Collectible, String> managerAddress02Column = new TableColumn<>("Parish Name");
		managerAddress02Column.setMinWidth(100);
		managerAddress02Column.setCellValueFactory(new PropertyValueFactory<>("address02"));
		
		TableColumn<Collectible, String> ageDivisionColumn = new TableColumn<>("Age Division");
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
	public static void displayDoctor(ObservableList<Collectible> listIn)
	{
		TableView<Collectible> doctorTable = new TableView<>();
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Display Managers");
		window.setMinWidth(600);

		if(listIn.isEmpty()){
			PopUp.alertBox("No data", "No data to display");
			return;
		}
		TableColumn<Collectible, String> doctorIdColumn = new TableColumn<>("Manager Id");
		doctorIdColumn.setMinWidth(50);
		doctorIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Collectible, String> doctorFNameColumn = new TableColumn<>("First Name");
		doctorFNameColumn.setMinWidth(100);
		doctorFNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));
		
		TableColumn<Collectible, String> doctorLNameColumn = new TableColumn<>("Last Name");
		doctorLNameColumn.setMinWidth(100);
		doctorLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));
		
		TableColumn<Collectible, String> doctorAddress01Column = new TableColumn<>("Street Name");
		doctorAddress01Column.setMinWidth(100);
		doctorAddress01Column.setCellValueFactory(new PropertyValueFactory<>("address01"));
		
		TableColumn<Collectible, String> doctorAddress02Column = new TableColumn<>("Parish Name");
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
	public static  void displayPlayers(ObservableList<Collectible> listIn)
    {
        TableView<Collectible> playerTable = new TableView<>();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Display Players");
	    window.setResizable(false);

		if(listIn.isEmpty()){
			PopUp.alertBox("No data", "No data to display");
			return;
		}

        TableColumn<Collectible, String> playerIdColumn = new TableColumn<>("Player Id");
        playerIdColumn.setMinWidth(50);
        playerIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Collectible, String> playerFNameColumn = new TableColumn<>("First Name");
        playerFNameColumn.setMinWidth(100);
        playerFNameColumn.setCellValueFactory(new PropertyValueFactory<>("fName"));

        TableColumn<Collectible, String> playerLNameColumn = new TableColumn<>("Last Name");
        playerLNameColumn.setMinWidth(100);
        playerLNameColumn.setCellValueFactory(new PropertyValueFactory<>("lName"));

        TableColumn<Collectible, String> playerAddress01Column = new TableColumn<>("Street Name");
        playerAddress01Column.setMinWidth(100);
        playerAddress01Column.setCellValueFactory(new PropertyValueFactory<>("address01"));

        TableColumn<Collectible, String> playerAddress02Column = new TableColumn<>("Parish Name");
        playerAddress02Column.setMinWidth(100);
        playerAddress02Column.setCellValueFactory(new PropertyValueFactory<>("address02"));

        TableColumn<Collectible, String> playerContactNoColumn = new TableColumn<>("Contact Number");
        playerContactNoColumn.setMinWidth(100);
        playerContactNoColumn.setCellValueFactory(new PropertyValueFactory<Collectible, String>("contactNo"));

        TableColumn<Collectible, String> playerEmailColumn = new TableColumn<>("Contact Email");
        playerEmailColumn.setMinWidth(100);
        playerEmailColumn.setCellValueFactory(new PropertyValueFactory<Collectible, String>("email"));

        TableColumn<Collectible, String>playerAgeDivisionColumn = new TableColumn<>("Age Division");
        playerAgeDivisionColumn.setMinWidth(30);
        playerAgeDivisionColumn.setCellValueFactory(new PropertyValueFactory<Collectible, String>("ageDivision"));

        playerTable.setItems(listIn);
        playerTable.getColumns().addAll(playerIdColumn, playerFNameColumn, playerLNameColumn, playerAddress01Column, playerAddress02Column, playerContactNoColumn, playerEmailColumn, playerAgeDivisionColumn);

        VBox layout = new VBox();
        layout.getChildren().addAll(playerTable);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
	}
	public static void displayFamilies(List<Collectible> list){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);

		if (list.isEmpty()){
			PopUp.alertBox("No data", "No data to display");
			window.close();
		}
		String players = "";
		Label parentLabel = new Label("Parents");
		List<Collectible> parentList = getParents(list);
		List<Collectible> playerList = getPlayers(list);
		Label parent01Name = new Label("Parent01: " + parentList.get(0).getFName() + " " +  parentList.get(0).getLName());
		parent01Name.setContentDisplay(ContentDisplay.LEFT);
		Label parent02Name = new Label(" ");
		parent02Name.setContentDisplay(ContentDisplay.RIGHT);
		Label playerLabel = new Label();
		if (parentList.size() == 2){
			parent02Name.setText("Parent02: " + parentList.get(1).getFName() + " " + parentList.get(1).getLName());
		}
		for (Collectible item : playerList){
			Player player = (Player) item;
			players += player.toShortString() + "\n";
		}
		playerLabel.setText(players);
		Parent parent = (Parent) parentList.get(0);
		Label paymentAmountLabel = new Label("Payment amount: €" + Float.toString(parent.getFee()));
		Label paymentMethodLabel = new Label("Payment method: " + parent.getPaymentMethod());
		StackPane playerPane = new StackPane();
		StackPane paymentAmountPane = new StackPane(paymentAmountLabel);
		StackPane paymentMethodPane = new StackPane(paymentMethodLabel);
		playerPane.getChildren().addAll(playerLabel);
		BorderPane topLayout = new BorderPane();
		StackPane topPane = new StackPane();
		topPane.getChildren().add(parentLabel);
		topLayout.setLeft(parent01Name);
		topLayout.setRight(parent02Name);
		topLayout.setTop(topPane);
		BorderPane outerLayout = new BorderPane();
		outerLayout.setTop(topLayout);
		outerLayout.setCenter(playerPane);
		outerLayout.setLeft(paymentAmountPane);
		outerLayout.setRight(paymentMethodPane);
		outerLayout.setPadding(new Insets(15, 15, 15, 15));

		Scene scene = new Scene(outerLayout, 500, 500);
		window.setScene(scene);
		window.showAndWait();
	}

	private static List<Collectible> getParents(List<Collectible> list){
		ArrayList<Collectible> tempList = new ArrayList<>();
		for (Collectible item : list){
			if(item.getId().substring(0, 2).equals("pr")){
				tempList.add(item);
				if (tempList.size() == 2){
					return tempList;
				}
			}
		}
		return tempList;
	}
	private static List<Collectible> getPlayers(List<Collectible> list){
		ArrayList<Collectible> tempList = new ArrayList<>();
		for (Collectible item : list){
			if(item.getId().substring(0, 2).equals("pl")){
				tempList.add(item);
			}
		}
		return tempList;
	}
	
}
