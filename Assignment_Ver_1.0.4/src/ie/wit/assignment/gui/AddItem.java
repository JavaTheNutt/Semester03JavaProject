package ie.wit.assignment.gui;

import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectables.Player;
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
/*This class contains the GUI for adding items.*/
public class AddItem 
{
	private static String notFilledTitle = "Please fill correctly", notFilledMessage = "Please fill out all fields";
	private static ComboBox<String> doctorSelection;
	
	
	public static void addManager()
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add a manager");
		window.setOnCloseRequest(e -> {
			e.consume();
			if(PopUp.confirmBox("Confirm Exit", "If you close this window, data may be lost. Proceed?")){
				window.close();
			}
		});
		
		Label topLabel = new Label("Add a Manager");
		
		StackPane topHead = new StackPane();
		topHead.setAlignment(Pos.CENTER);
		topHead.setPadding(new Insets(50, 5, 5, 5));
		topHead.getChildren().add(topLabel);
		
		GridPane mainLayout = new GridPane();
		mainLayout.setPadding(new Insets(10, 10, 10, 10));
		mainLayout.setVgap(8);
		mainLayout.setHgap(10);
		mainLayout.setAlignment(Pos.CENTER);
		
		Label firstNameLabel = new Label("Enter first name:");
		Label surnameLabel = new Label("Enter surname:");
		Label address01Label = new Label("Enter street name:");
		Label address02Label = new Label("Enter parish name:");
		Label contactNoLabel = new Label("Enter conatct number:");
		Label emailLabel = new Label("Enter email:");
		Label ageDivisionLabel = new Label("Please enter the age division");
		
		TextField firstNameInput = new TextField();
		TextField surnameInput = new TextField();
		TextField address01Input = new TextField();
		TextField address02Input = new TextField();
		TextField contactNoInput = new TextField();
		TextField emailInput = new TextField();
		ComboBox<String> ageDivisionInput = new ComboBox<String>();
		
		Button submitButton = new Button("Submit");
		Button closeButton = new Button("close");
		
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
				PopUp.alertBox(notFilledTitle, notFilledMessage);
			} else {
				//ensure that there is not already two managers for this division
				if(!ValidationController.checkCorrectDivision(ageDivisionInput.getValue())){
					PopUp.alertBox(notFilledTitle, "That age division already has two managers. Please verify that records already entered are correct");
				} else {
					//check email is valid
					if(!ValidationController.checkEmail(emailInput.getText())){
						PopUp.alertBox(notFilledTitle, "Please enter a valid email address");
					} else {
						Manager tempMan = new Manager(Collector.numberOfManagers, firstNameInput.getText(), surnameInput.getText(),
								address01Input.getText(), address02Input.getText(), contactNoInput.getText(), emailInput.getText(), ageDivisionInput.getValue());
						if(Controller.addItem(tempMan, 1)){
							System.out.println("Added");
							/*reset fields*/
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
		
		BorderPane outerLayout = new BorderPane();
		outerLayout.setTop(topHead);
		outerLayout.setCenter(mainLayout);
		
		Scene scene = new Scene(outerLayout, 400, 600);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public static void addDoctor()
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add a doctor");
		window.setOnCloseRequest(e -> {
			e.consume();
			if(PopUp.confirmBox("Confirm Exit", "If you close this window, data may be lost. Proceed?")){
				window.close();
			}
		});
		
		Label topLabel = new Label("Add a Doctor");
		
		StackPane topHead = new StackPane();
		topHead.setAlignment(Pos.CENTER);
		topHead.setPadding(new Insets(50, 5, 5, 5));
		topHead.getChildren().add(topLabel);
		
		GridPane mainLayout = new GridPane();
		mainLayout.setPadding(new Insets(10, 10, 10, 10));
		mainLayout.setVgap(8);
		mainLayout.setHgap(10);
		mainLayout.setAlignment(Pos.CENTER);
		
		Label firstNameLabel = new Label("Enter first name:");
		Label surnameLabel = new Label("Enter surname:");
		Label address01Label = new Label("Enter street name:");
		Label address02Label = new Label("Enter parish name:");
		Label contactNoLabel = new Label("Enter conatct number:");
		
		TextField firstNameInput = new TextField();
		TextField surnameInput = new TextField();
		TextField address01Input = new TextField();
		TextField address02Input = new TextField();
		TextField contactNoInput = new TextField();
		
		Button submitButton = new Button("Submit");
		Button closeButton = new Button("close");
		
		submitButton.setOnAction(e -> {
			String [] items = {
				firstNameInput.getText(),
				surnameInput.getText(),
				address01Input.getText(),
				address02Input.getText(),
				contactNoInput.getText()	
			};
			/*Check fields filled */
			if(!ValidationController.fieldsFilled(items)){
				PopUp.alertBox(notFilledTitle, "Please fill out all fields");
			} else {
				/*Check a doctor by this name is not already in the system*/
				if(ValidationController.alreadyExists(firstNameInput.getText(), surnameInput.getText(), 2)){
					PopUp.alertBox("Already Present", "That doctor is already present in the system");
				} else {
					Doctor tempDoc = new Doctor(Collector.numberOfDoctors, items[0], items[1], items[2],
						items[3], items[4]);
					if(Controller.addItem(tempDoc, 2)){
						PopUp.alertBox("Success", "Added Successfully");
						/*reset fields*/
						firstNameInput.setText("");
						surnameInput.setText("");
						address01Input.setText("");
						address02Input.setText("");
						contactNoInput.setText("");
						
					} else{
						PopUp.alertBox("Failed", "Unsuccessful add");
					}
				}
			}
		});
		closeButton.setOnAction(e -> {
			window.close();
		});
		
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
		
		BorderPane outerLayout = new BorderPane();
		outerLayout.setTop(topHead);
		outerLayout.setCenter(mainLayout);
		
		Scene scene = new Scene(outerLayout, 400, 600);
		window.setScene(scene);
		window.showAndWait();
	}
	public static void addPlayer()
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add a player");
		window.setOnCloseRequest(e -> {
			e.consume();
			if(PopUp.confirmBox("Confirm Exit", "If you close this window, data may be lost. Proceed?")){
				window.close();
			}
		});
		
		Label topLabel = new Label("Add a Player");
		
		StackPane topHead = new StackPane();
		topHead.setAlignment(Pos.CENTER);
		topHead.setPadding(new Insets(50, 5, 5, 5));
		topHead.getChildren().add(topLabel);
		
		GridPane mainLayout = new GridPane();
		mainLayout.setPadding(new Insets(10, 10, 10, 10));
		mainLayout.setVgap(8);
		mainLayout.setHgap(10);
		mainLayout.setAlignment(Pos.CENTER);
		
		Label firstNameLabel = new Label("Enter first name:");
		Label surnameLabel = new Label("Enter surname:");
		Label address01Label = new Label("Enter street name:");
		Label address02Label = new Label("Enter parish name:");
		Label contactNoLabel = new Label("Enter conatct number:");
		Label emailLabel = new Label("Enter email:");
		Label dateofBirthLabel = new Label("Date of Birth");
		Label dayLabel = new Label("Day:");
		Label monthLabel = new Label("Month");
		Label yearLabel = new Label("Year");
        Label doctorLabel = new Label("Please Select Doctor");



		
		TextField firstNameInput = new TextField();
		TextField surnameInput = new TextField();
		TextField address01Input = new TextField();
		TextField address02Input = new TextField();
		TextField contactNoInput = new TextField();
		TextField emailInput = new TextField();
		ComboBox<String> dateofBirthInput = new ComboBox<String>();
		ComboBox<String> monthOfBirth = new ComboBox<String>();
		ComboBox<String> yearOfBirth = new ComboBox<String>();
        doctorSelection = new ComboBox<String>();


		dateofBirthInput.getItems().addAll(setNumberDays(31));
		monthOfBirth.getItems().addAll(setNumberDays(12));
		yearOfBirth.getItems().addAll("1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009");
        setDoctorSelection();

		doctorSelection.setValue("Achim Shlunke");
		
		dateofBirthInput.setValue("1");
		monthOfBirth.setValue("1");
		yearOfBirth.setValue("2009");
		
		Button submitButton = new Button("Submit");
        Button addNewDoctorButton = new Button("Add doctor");
		Button closeButton = new Button("Close");
		
		submitButton.setOnAction(e -> {
			String[] items = {
					firstNameInput.getText(),
					surnameInput.getText(),
					address01Input.getText(),
					address02Input.getText(),
					contactNoInput.getText(),
					emailInput.getText()
			};
			/*Check all fields filled*/
			if(!ValidationController.fieldsFilled(items)){
				PopUp.alertBox(notFilledTitle, notFilledMessage);
			} else {
				/*Check validity of dates entered*/
				if(!ValidationController.checkMonthValidity(monthOfBirth.getValue(), dateofBirthInput.getValue())){
					PopUp.alertBox(notFilledTitle, "Please enter a valid date");
				} else{
					/*Validate email*/
					if(!ValidationController.checkEmail(emailInput.getText())){
						PopUp.alertBox(notFilledTitle, "Please enter a valid email");
					} else {
                       String tempDoc = Controller.matchNameToId(doctorSelection.getValue(), 2);
						/*Ensure doctor not null*/
                        if(!tempDoc.equals("")){
                            Player tempPlayer = new Player(Collector.numberOfPlayers,
                                    items[0],
                                    items[1],
                                    items[2],
                                    items[3],
                                    items[4],
                                    items[5],
                                    Integer.parseInt(dateofBirthInput.getValue()),
                                    Integer.parseInt(monthOfBirth.getValue()),
                                    Integer.parseInt(yearOfBirth.getValue()),
                                    tempDoc
                            );
                            Collector.addItem(tempPlayer, 3);
							PopUp.alertBox("Success", "Player added succesfully");
							/*reset fields*/
							firstNameInput.setText("");
							surnameInput.setText("");
							address01Input.setText("");
							address02Input.setText("");
							contactNoInput.setText("");
							emailInput.setText("");
                        } else {
							PopUp.alertBox("Doctor does not exist", "The doctor specified does not exist");
						}
					}
				}
			}
		});
        closeButton.setOnAction(e -> {
            if(PopUp.confirmBox("Are you sure you want to quit?", "Data you have entered will not be saved if you exit.")){
                window.close();
            }
        });
        addNewDoctorButton.setOnAction(e -> {
            AddItem.addDoctor();
            setDoctorSelection();
        });
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
		GridPane.setConstraints(dayLabel, 0, 6);
		GridPane.setConstraints(dateofBirthInput, 1, 6);
		GridPane.setConstraints(monthLabel, 0, 7);
		GridPane.setConstraints(monthOfBirth,1, 7);
		GridPane.setConstraints(yearLabel, 0, 8);
		GridPane.setConstraints(yearOfBirth, 1, 8);
        GridPane.setConstraints(doctorLabel, 0, 9);
        GridPane.setConstraints(doctorSelection, 1, 9);
		GridPane.setConstraints(submitButton, 0, 10);
        GridPane.setConstraints(addNewDoctorButton, 1, 10);
		GridPane.setConstraints(closeButton, 2, 10);
		
		mainLayout.getChildren().addAll(firstNameLabel, firstNameInput, surnameLabel, surnameInput, address01Label, address01Input, address02Label, address02Input,
				contactNoLabel, contactNoInput, emailLabel, emailInput, dayLabel, dateofBirthInput, monthLabel, monthOfBirth
				, yearLabel, yearOfBirth, doctorLabel, doctorSelection, submitButton,addNewDoctorButton,  closeButton);
		
		BorderPane outerLayout = new BorderPane();
		outerLayout.setTop(topHead);
		outerLayout.setCenter(mainLayout);
		
		Scene scene = new Scene(outerLayout, 400, 600);
		window.setScene(scene);
		window.showAndWait();
	}
	/*This method will empty the comboBox and fill it again every time a doctor is added*/
	private static void setDoctorSelection()
    {
        doctorSelection.getItems().removeAll(doctorSelection.getItems());
		doctorSelection.getItems().addAll(Collector.getNamesInArray(2));
		doctorSelection.setValue("Achim Shlunke");
	}
	/*This method will fill an array with a specified number of integers to be used in a comboBox*/
	private static String[] setNumberDays(int sizeIn)
    {
        String[] ary = new String[sizeIn];
        for (int i = 0; i < sizeIn; i++) {
            ary[i] = Integer.toString(i + 1);
        }
        return ary;
    }
}
