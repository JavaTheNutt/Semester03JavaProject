package ie.wit.assignment.gui;

import ie.wit.assignment.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/*This class will handle the various small popups that are used*/
public abstract class PopUp 
{
	
	private static boolean answer;
	private static String tempString = "";
	/*This is a generic alert box that displays a message and a single button used to close the popup*/
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
	/*This box has a label and a choice of a yes or no button to return a boolean*/
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
	/*This popup will have a  message and a single textfield to return a string value*/
	public static String singleInput(String title, String label)
	{
		/*String tempString = "";*/
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

		submit.setOnAction(e -> {
			if(input.getText().equals("")){
				PopUp.alertBox("Field blank", "Please enter a value in the field");
			} else {
				tempString = input.getText();
				window.close();
			}
		});
		close.setOnAction(e -> {
			tempString = "close";
			window.close();
		});
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.getChildren().addAll(inputLabel, input, submit, close);

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

        return tempString;
	}
	/*This popup will have a combobox to select an age division*/
	public static String selectAgeDivision()
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Select Age Division");

		Label label = new Label("Please select an age division");
		ComboBox<String> comboBox = new ComboBox<>();
		String [] ary = {
				"U-7",
				"U-8",
				"U-9",
				"U-10",
				"U-11",
				"U-12",
				"U-13",
				"U-14",
				"U-15",
				"U-16",
				"U-17",
				"Junior"
		};
		comboBox.setValue("U-7");
		comboBox.getItems().addAll(ary);
		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			tempString = comboBox.getValue();
			window.close();
		});

		Button close = new Button("Close");
		close.setOnAction(e -> {
			window.close();
		});

		GridPane.setConstraints(label, 0, 0);
		GridPane.setConstraints(comboBox, 1, 0);
		GridPane.setConstraints(submit, 0, 1);
		GridPane.setConstraints(close, 1, 1);

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getChildren().addAll(label, comboBox, submit, close);
		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.showAndWait();
		return tempString;
	}
	public static String singleComboBox(String[] listIn, String title, String label)
	{

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);

		Label mainLabel = new Label(label);
		ComboBox<String> list = new ComboBox<>();
		list.getItems().addAll(listIn);
		list.setValue(listIn[0]);

		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			tempString = list.getValue();
			window.close();
		});
		Button close = new Button("Close");
		close.setOnAction(e -> {
			tempString = "close";
			window.close();
		});

		GridPane.setConstraints(mainLabel, 0, 0);
		GridPane.setConstraints(list, 1, 0);
		GridPane.setConstraints(submit, 0, 1);
		GridPane.setConstraints(close, 1, 1);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.getChildren().addAll(mainLabel, list, submit, close);

		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.showAndWait();
		return tempString;
	}
}




















