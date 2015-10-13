package ie.wit.assignment.gui;

import ie.wit.assignment.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class PopUp 
{
	
	private static boolean answer;
	
	public static void alertBox(String title, String message)
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> {
			window.close();
		});
		Label messageLabel = new Label(message);
		VBox layout = new VBox(20);
		layout.getChildren().addAll(messageLabel, closeButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 250, 300);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public static boolean confirmBox(String title, String message)
	{

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});
		
		Button submitButton = new Button("Yes");
		submitButton.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		Button closeButton = new Button("No");
		closeButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		Label messageLabel = new Label(message);
		VBox layout = new VBox(20);
		layout.getChildren().addAll(messageLabel, closeButton, submitButton);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 250, 300);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
	public static String singleInput(String title, String label)
	{
		Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label inputLabel = new Label(label);
        TextField input = new TextField();
        Button submit = new Button("Submit");
        Button close = new Button("Close");

        GridPane.setConstraints(inputLabel, 0, 0);
        GridPane.setConstraints(input, 1, 0);
        GridPane.setConstraints(submit, 0, 1);
        GridPane.setConstraints(close, 1, 1);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.getChildren().addAll(inputLabel, input, submit, close);

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

        return null;
	}
}
