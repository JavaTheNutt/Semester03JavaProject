package ie.wit.assignment.gui;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
public class AlertBox 
{
	private static Stage window;
	private static Button confButton;
	private static Label messageLabel;
	private static Scene scene;
	private static VBox layout;
	public static void display(String title, String message)
	{
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		messageLabel = new Label(message);
		confButton = new Button("OK");
		confButton.setOnAction(event -> window.close());
		layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(messageLabel, confButton);
		scene = new Scene(layout, 250, 300);
		window.setScene(scene);
		window.showAndWait();
	}
}
