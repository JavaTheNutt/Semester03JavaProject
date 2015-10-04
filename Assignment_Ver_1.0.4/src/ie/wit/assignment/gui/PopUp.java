package ie.wit.assignment.gui;

import ie.wit.assignment.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp 
{
	private static Stage window;
	private static Scene scene;
	private static Button closeButton;
	private static Button submitButton;
	private static Label messageLabel;
	private static VBox layout;
	
	private static boolean answer;
	
	public static void alertBox(String title, String message)
	{
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});
		closeButton = new Button("Close");
		closeButton.setOnAction(e -> {
			window.close();
		});
		messageLabel = new Label(message);
		layout = new VBox(20);
		layout.getChildren().addAll(messageLabel, closeButton);
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout, 250, 300);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public static boolean confirmBox(String title, String message)
	{
		
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});
		
		submitButton = new Button("Yes");
		submitButton.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		closeButton = new Button("No");
		closeButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		messageLabel = new Label(message);
		layout = new VBox(20);
		layout.getChildren().addAll(messageLabel, closeButton, submitButton);
		layout.setAlignment(Pos.CENTER);
		scene = new Scene(layout, 250, 300);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
}
