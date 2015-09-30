package ie.wit.assignment.gui;

import ie.wit.assignment.collections.ManagerCollector;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainMenu 
{
	private static Stage window;
	private static Scene scene;
	private static Button listAll;
	private static Button searchById;
	private static Label mainLabel;
	private static VBox layout;
	
	
	public static void display()
	{
		
		window = new Stage();
		window.setTitle("Main Menu");
		mainLabel = new Label("Main Menu");
		listAll = new Button("List all");
		listAll.setOnAction(event -> 
		{
			String tempString = ManagerCollector.listAll();
			AlertBox.display("List All", tempString);
		});
		searchById = new Button("Search");
		searchById.setOnAction(event -> 
		{
			CollectString.display("Search by Id", "Enter the ID to search for");
		});
		layout = new VBox(10);
		layout.getChildren().addAll(mainLabel, listAll, searchById);
		scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}
	
}