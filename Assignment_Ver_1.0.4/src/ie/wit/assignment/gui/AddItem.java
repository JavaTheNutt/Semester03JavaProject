package ie.wit.assignment.gui;



import ie.wit.assignment.Main;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.controllers.Controller;
import ie.wit.assignment.controllers.ValidationController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddItem 
{
	private static Stage window;
	private static Scene scene;
	private static GridPane mainLayout;
	private static BorderPane outerLayout;
	private static StackPane topHead;
	
	private static Button submitButton;
	private static Button closeButton;
	
	private static Label topLabel;
	private static Label firstNameLabel;
	private static Label surnameLabel;
	private static Label address01Label;
	private static Label address02Label;
	private static Label contactNoLabel;
	private static Label emailLabel;
	private static Label ageDivisionLabel;
	
	private static TextField firstNameInput;
	private static TextField surnameInput;
	private static TextField address01Input;
	private static TextField address02Input;
	private static TextField contactNoInput;
	private static TextField emailInput;
	private static ComboBox<String> ageDivisionInput;
	
	public static void addManager()
	{
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add a manager");
		window.setOnCloseRequest(e -> {
			e.consume();
			if(PopUp.confirmBox("Confirm Exit", "If you close this window, data may be lost. Proceed?")){
				window.close();
			}
		});
		
		topLabel = new Label("Add a Manager");
		
		topHead = new StackPane();
		topHead.setAlignment(Pos.CENTER);
		topHead.setPadding(new Insets(50, 5, 5, 5));
		topHead.getChildren().add(topLabel);
		
		mainLayout = new GridPane();
		mainLayout.setPadding(new Insets(10, 10, 10, 10));
		mainLayout.setVgap(8);
		mainLayout.setHgap(10);
		mainLayout.setAlignment(Pos.CENTER);
		
		firstNameLabel = new Label("Enter first name:");
		surnameLabel = new Label("Enter surname:");
		address01Label = new Label("Enter street name:");
		address02Label = new Label("Enter parish name:");
		contactNoLabel = new Label("Enter conatct number:");
		emailLabel = new Label("Enter email:");
		ageDivisionLabel = new Label("Please enter the age division");
		
		firstNameInput = new TextField();
		surnameInput = new TextField();
		address01Input = new TextField();
		address02Input = new TextField();
		contactNoInput = new TextField();
		emailInput = new TextField();
		ageDivisionInput = new ComboBox<String>();
		
		submitButton = new Button("Submit");
		closeButton = new Button("close");
		
		ageDivisionInput.getItems().addAll(
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
				"U-17"
		);
		ageDivisionInput.setValue("U-7");
		
		GridPane.setConstraints(firstNameLabel, 0, 0);
		GridPane.setConstraints(firstNameInput, 1, 0);
		GridPane.setConstraints(surnameLabel, 0, 1);
		GridPane.setConstraints(surnameInput, 1, 1);
		GridPane.setConstraints(address01Label, 0, 2);
		GridPane.setConstraints(address01Input, 1, 2);
		GridPane.setConstraints(address02Label, 0, 3);
		GridPane.setConstraints(address02Input, 1, 3);
		GridPane.setConstraints(contactNoLabel, 0, 4);
		GridPane.setConstraints(contactNoInput, 1, 4);
		GridPane.setConstraints(emailLabel, 0, 5);
		GridPane.setConstraints(emailInput, 1, 5);
		GridPane.setConstraints(ageDivisionLabel, 0, 6);
		GridPane.setConstraints(ageDivisionInput, 1, 6);
		GridPane.setConstraints(submitButton, 0, 8);
		GridPane.setConstraints(closeButton, 1, 8);
		
		
		submitButton.setOnAction(e -> {
			String [] items = {
					firstNameInput.getText(),
					surnameInput.getText(),
					address01Input.getText(),
					address02Input.getText(),
					contactNoInput.getText(),
					emailInput.getText()
			};
			//check all fields filled
			if(!ValidationController.fieldsFilled(items)){
				PopUp.alertBox("Please fill correctly", "Please fill out all fields");
			} else {
				//ensure that there is not already two managers for this division
				if(!ValidationController.checkCorrectDivision(ageDivisionInput.getValue())){
					PopUp.alertBox("Please fill correctly", "That age division already has two managers. Please verify that records already entered are correct");
				} else {
					//check email is valid
					if(!ValidationController.checkEmail(emailInput.getText())){
						PopUp.alertBox("Please fill correctly", "Please enter a valid email address");
					} else {
						Manager tempMan = new Manager(Collector.numberOfManagers + 1, firstNameInput.getText(), surnameInput.getText(), 
								address01Input.getText(), address02Input.getText(), contactNoInput.getText(), emailInput.getText(), ageDivisionInput.getValue());
						if(Controller.addItem(tempMan, 1)){
							System.out.println("Added");
							firstNameInput.setText("");
							surnameInput.setText("");
							address01Input.setText("");
							address02Input.setText("");
							contactNoInput.setText("");
							emailInput.setText("");
						} else {
							System.out.println("Failed");
						}
					}
				}
			}
		});
		
		
		closeButton.setOnAction(e -> {
			if(PopUp.confirmBox("Are you sure?", "If you close this window, data may be lost. Continue?")){
				window.close();
			}
			
		});
		
		mainLayout.getChildren().addAll(firstNameLabel, firstNameInput, surnameLabel, surnameInput, address01Label, 
				address01Input, address02Label, address02Input, submitButton, closeButton, contactNoInput, contactNoLabel, 
				emailInput, emailLabel, ageDivisionInput, ageDivisionLabel);
		
		outerLayout = new BorderPane();
		outerLayout.setTop(topHead);
		outerLayout.setCenter(mainLayout);
		
		scene = new Scene(outerLayout, 400, 600);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public static void addDoctor()
	{
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add a doctor");
		window.setOnCloseRequest(e -> {
			e.consume();
			if(PopUp.confirmBox("Confirm Exit", "If you close this window, data may be lost. Proceed?")){
				window.close();
			}
		});
		
		topLabel = new Label("Add a Doctor");
		
		topHead = new StackPane();
		topHead.setAlignment(Pos.CENTER);
		topHead.setPadding(new Insets(50, 5, 5, 5));
		topHead.getChildren().add(topLabel);
		
		mainLayout = new GridPane();
		mainLayout.setPadding(new Insets(10, 10, 10, 10));
		mainLayout.setVgap(8);
		mainLayout.setHgap(10);
		mainLayout.setAlignment(Pos.CENTER);
		
		firstNameLabel = new Label("Enter first name:");
		surnameLabel = new Label("Enter surname:");
		address01Label = new Label("Enter street name:");
		address02Label = new Label("Enter parish name:");
		contactNoLabel = new Label("Enter conatct number:");
		
		firstNameInput = new TextField();
		surnameInput = new TextField();
		address01Input = new TextField();
		address02Input = new TextField();
		contactNoInput = new TextField();
		
		submitButton = new Button("Submit");
		closeButton = new Button("close");
		
		
		GridPane.setConstraints(firstNameLabel, 0, 0);
		GridPane.setConstraints(firstNameInput, 1, 0);
		GridPane.setConstraints(surnameLabel, 0, 1);
		GridPane.setConstraints(surnameInput, 1, 1);
		GridPane.setConstraints(address01Label, 0, 2);
		GridPane.setConstraints(address01Input, 1, 2);
		GridPane.setConstraints(address02Label, 0, 3);
		GridPane.setConstraints(address02Input, 1, 3);
		GridPane.setConstraints(contactNoLabel, 0, 4);
		GridPane.setConstraints(contactNoInput, 1, 4);
		GridPane.setConstraints(submitButton, 0, 8);
		GridPane.setConstraints(closeButton, 1, 8);
		
		mainLayout.getChildren().addAll(firstNameLabel, firstNameInput, surnameLabel, surnameInput, address01Label, address01Input, address02Label, address02Input,
				contactNoLabel, contactNoInput, submitButton, closeButton);
		
		outerLayout = new BorderPane();
		outerLayout.setTop(topHead);
		outerLayout.setCenter(mainLayout);
		
		scene = new Scene(outerLayout, 400, 600);
		window.setScene(scene);
		window.showAndWait();
	}
}
