package ie.wit.assignment.gui;

import ie.wit.assignment.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddItem 
{
	private static Stage window;
	private static Scene scene;
	private static GridPane mainLayout;
	
	private static Button submitButton;
	private static Button closeButton;
	
	private static Label firstNameLabel;
	private static Label surnameLabel;
	private static Label address01Label;
	private static Label address02Label;
	
	private static TextField firstNameInput;
	private static TextField surnameInput;
	private static TextField address01Input;
	private static TextField address02Input;
	
	public static void addManager()
	{
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add a manager");
		window.setOnCloseRequest(e -> {
			e.consume();
			Main.closeProgram();
		});
		
		firstNameLabel = new Label("Enter first name:");
		firstNameInput = new TextField();
		surnameLabel = new Label("Enter surname:");
		surnameInput = new TextField();
		address01Label = new Label("Enter street name:");
		address01Input = new TextField();
		address02Label = new Label("Enter parish name:");
		address02Input = new TextField();
	}
}
