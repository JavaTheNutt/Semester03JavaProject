package ie.wit.assignment.gui;

import ie.wit.assignment.Main;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.controllers.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/*This will be the main menu*/
public abstract class MainMenu 
{
	public static void display()
	{
		Stage window = new Stage();
		window.setTitle("Thomastown UTD AFC");
		window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});
		
		Label topLabel = new Label("Thomastown UTD AFC");
		StackPane topHeader = new StackPane();
		topHeader.setAlignment(Pos.CENTER);
		topHeader.getChildren().add(topLabel);
		
		Button addItemsButton = new Button("Add");
		addItemsButton.setOnAction(e -> {
			AddItemsMenu.display();
		});
		Button listItemsButton = new Button("List");
		listItemsButton.setOnAction(e -> {
			ListItemsGui.display();
		});
		Button removeItemsButton = new Button("Remove");
		removeItemsButton.setOnAction(e -> {
			RemoveItemMenu.display();
		});
		VBox menuBox = new VBox(10);
		menuBox.getChildren().addAll(addItemsButton, listItemsButton, removeItemsButton);
		menuBox.setAlignment(Pos.CENTER);

		BorderPane outerLayout = new BorderPane();
		outerLayout.setTop(topHeader);
		outerLayout.setCenter(menuBox);
		Scene scene = new Scene(outerLayout, 200, 300);
		window.setScene(scene);
		window.show();
	}
}
