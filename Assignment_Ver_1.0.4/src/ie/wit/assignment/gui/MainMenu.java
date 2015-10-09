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

public abstract class MainMenu 
{
	private static Stage window;
	private static Scene scene;
	
	private static Button listManagersButton;
	private static Button listDoctorsButton;
	private static Button addManagerButton;
	private static Button addDoctorButton;
	private static Button addItemsButton;
	private static Button listItemsButton;
	
	private static Label listManagersLabel;
	private static Label listDoctorsLabel;
	private static Label addManagerLabel;
	private static Label addDoctorLabel;
	private static Label topLabel;
	
	private static StackPane topHeader;
	private static BorderPane outerLayout;
	private static GridPane grid;
	private static HBox topMenu;
	
	public static void display()
	{
		window = new Stage();
		window.setTitle("Thomastown UTD AFC");
		window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});
		
		/*topLabel = new Label("Thomastown UTD AFC");
		topHeader = new StackPane();
		topHeader.setAlignment(Pos.CENTER);
		topHeader.getChildren().add(topLabel);*/
		
		addItemsButton = new Button("Add");
		addItemsButton.setOnAction(e -> {
			AddItemsMenu.display();
		});
		listItemsButton = new Button("List");
		listItemsButton.setOnAction(e -> {
			ListItemsGui.display();
		});
		
		topMenu = new HBox(20);
		topMenu.setAlignment(Pos.CENTER);
		topMenu.getChildren().addAll(addItemsButton, listItemsButton);

		outerLayout = new BorderPane();
		outerLayout.setTop(topMenu);
		scene = new Scene(outerLayout, 300, 500);
		window.setScene(scene);
		window.show();
	}
}
