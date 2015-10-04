package ie.wit.assignment.gui;

import ie.wit.assignment.Main;
import ie.wit.assignment.controllers.Controller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class MainMenu 
{
	private static Stage window;
	private static Scene scene;
	private static Button listManagersButton;
	private static Button listDoctorsButton;
	private static VBox layout;
	
	public static void display()
	{
		window = new Stage();
		window.setTitle("Thomastown UTD AFC");
		window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});
		layout = new VBox(20);
		listManagersButton = new Button("List Managers");
		listManagersButton.setOnAction(event -> {
			
		});
		listDoctorsButton = new Button("List Doctors");
		listDoctorsButton.setOnAction(e-> {
			
		});
		layout.getChildren().addAll(listManagersButton, listDoctorsButton);
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout, 250, 300);
		window.setScene(scene);
		window.show();
	}
}
