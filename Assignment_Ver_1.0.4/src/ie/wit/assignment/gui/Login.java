package ie.wit.assignment.gui;

import ie.wit.assignment.Main;
import ie.wit.assignment.controllers.ValidationController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Joe on 16/11/2015.
 */
public class Login
{
	public static void display(){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setOnCloseRequest(e -> {
			e.consume();
			if (PopUp.confirmBox("Warning", "User not logged in, system will now shutdown. Proceed?")) {
				Main.closeProgram();
			}
		});

		StackPane topLayout = new StackPane();
		Label topLabel = new Label("Please login to continue");
		topLayout.getChildren().add(topLabel);
		BorderPane outerLayout = new BorderPane();
		outerLayout.setTop(topLayout);

		Label passwordLabel = new Label("Password");
		Label usernameLabel = new Label("Username");
		Label adminLabel = new Label("admin");

		PasswordField passwordInput = new PasswordField();
		TextField usernameInput = new TextField();
		RadioButton adminInput = new RadioButton("Admin");

		Button submitButton = new Button("Submit");
		GridPane.setConstraints(usernameLabel, 0, 0);
		GridPane.setConstraints(usernameInput, 1, 0);
		GridPane.setConstraints(passwordLabel, 0, 1);
		GridPane.setConstraints(passwordInput, 1, 1);
		GridPane.setConstraints(adminInput, 0, 2);
		GridPane.setConstraints(submitButton, 1, 2);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, submitButton, adminInput);

		outerLayout.setCenter(grid);

		submitButton.setOnAction(e ->{
			if(ValidationController.loginValid(usernameInput.getText(), passwordInput.getText(), adminInput.isSelected())){
				MainMenu.display();
				window.close();
			} else {
				usernameInput.setText(null);
				passwordInput.setText(null);
			}

		});

		Scene scene = new Scene(outerLayout);
		window.setScene(scene);
		window.showAndWait();
	}


}
