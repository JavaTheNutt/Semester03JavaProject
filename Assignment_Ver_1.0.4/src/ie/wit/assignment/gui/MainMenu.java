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
	
	private static Label listManagersLabel;
	private static Label listDoctorsLabel;
	private static Label addManagerLabel;
	private static Label addDoctorLabel;
	private static Label topLabel;
	
	private static StackPane topHeader;
	private static BorderPane outerLayout;
	private static GridPane grid;
	
	public static void display()
	{
		window = new Stage();
		window.setTitle("Thomastown UTD AFC");
		window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});
		
		topLabel = new Label("Thomastown UTD AFC");
		topHeader = new StackPane();
		topHeader.setAlignment(Pos.CENTER);
		topHeader.getChildren().add(topLabel);
		
		grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid .setAlignment(Pos.CENTER);
		listManagersLabel = new Label("List All Managers");
		GridPane.setConstraints(listManagersLabel, 0, 0);
		listManagersButton = new Button("List");
		GridPane.setConstraints(listManagersButton, 1, 0);
		listManagersButton.setOnAction(event -> {
			DisplayItems.displayManagers(Collector.getManagerList());
		});
		listDoctorsLabel = new Label("List All Doctors");
		GridPane.setConstraints(listDoctorsLabel, 0, 1);
		listDoctorsButton = new Button("List");
		GridPane.setConstraints(listDoctorsButton, 1, 1);
		listDoctorsButton.setOnAction(e-> {
			
		});
		addManagerLabel = new Label("Add Manager");
		GridPane.setConstraints(addManagerLabel, 0, 2);
		addManagerButton = new Button("Add");
		GridPane.setConstraints(addManagerButton, 1, 2);
		addManagerButton.setOnAction(e -> {
			AddItem.addManager();
		});
		addDoctorLabel = new Label("Add Doctor");
		GridPane.setConstraints(addDoctorLabel, 0, 3);
		addDoctorButton = new Button("Add");
		GridPane.setConstraints(addDoctorButton, 1, 3);
		addDoctorButton.setOnAction(e -> {
			AddItem.addDoctor();
		});
		grid.getChildren().addAll(listManagersLabel, listManagersButton, listDoctorsLabel, listDoctorsButton, addManagerLabel, addManagerButton, addDoctorLabel,addDoctorButton);
		outerLayout = new BorderPane();
		outerLayout.setTop(topHeader);
		outerLayout.setCenter(grid);
		scene = new Scene(outerLayout, 300, 500);
		window.setScene(scene);
		window.show();
	}
}
