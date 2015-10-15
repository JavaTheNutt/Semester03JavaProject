package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.controllers.Controller;
import ie.wit.assignment.exceptions.InputNotValidException;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.gui.DisplayItems;
import ie.wit.assignment.gui.PopUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*This class handles finding objects and deals with any exceptions that may be thrown in the process*/
public class FindItemController
{
	/*This method will initiate a pop-up prompting the user to enter an id. It will display a single item based on
	* that id, or catch any exceptions thrown*/
    public static void findById()
    {
        String tempId = PopUp.singleInput("Enter id", "Please enter the id of the person you are looking for");
        try{
            int tempType = Collector.getTypeById(tempId);
            PopUp.alertBox("Requested Item", Controller.getById(tempType, tempId).toString());
        } catch (InputNotValidException e){
            PopUp.alertBox("Error", e.getMessage());
        } catch (Exception e){
            PopUp.alertBox("Error", "An unknown error has occurred");
        }
    }
	/*Display a list of players based on an age division entered at runtime*/
    public static ObservableList<Collectable> findPlayersByAgeDivision(String ageDivisionIn)
    {
       try{
           ObservableList<Collectable> playerList = FXCollections.observableArrayList();
           for(Collectable collectable : Collector.playerList){
               Player player = (Player)collectable;
               if (player.getAgeDivision().equals(ageDivisionIn)){
                   playerList.add(player);
               }
           }
           return playerList;
       } catch (Exception e){
           return null;
       }
    }

	/*Display a list of objects based on a name entered at runtime*/
	public static ObservableList<Collectable> findByName(int type)
	{
		ObservableList<Collectable> list = FXCollections.observableArrayList();
		String fullName = PopUp.singleInput("Enter name", "Please enter the full name of the person you wish to find");
		String [] name = fullName.split(" ");
		if(name.length < 2){
			PopUp.alertBox("Error", "Please enter a full name containing spaces");
			return null;
		}
		for(Collectable item : Collector.getList(type)){
			if(item.getFName().equals(name[0]) && item.getLName().equals(name[1])){
				list.add(item);
			}
		}
		if(list.isEmpty()){
			PopUp.alertBox("Nothing to display", "There is no data to display");
			return null;
		}
		return list;
	}
}
