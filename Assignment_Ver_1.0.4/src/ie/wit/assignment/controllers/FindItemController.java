package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Collectible;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.exceptions.InputNotValidException;
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
    public static ObservableList<Collectible> findPlayersByAgeDivision(String ageDivisionIn)
    {
       try{
           ObservableList<Collectible> playerList = FXCollections.observableArrayList();
           for(Collectible collectible : Collector.playerList){
               Player player = (Player) collectible;
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
	public static ObservableList<Collectible> findByName(int type)
	{
		ObservableList<Collectible> list = FXCollections.observableArrayList();
		String fullName;
		String [] name;
		boolean check;
		do{
			fullName = PopUp.singleInput("Enter name", "Please enter the full name of the person you wish to find");
			name = fullName.split(" ");
			if(!fullName.equalsIgnoreCase("close")){
				check = Controller.checkNameEntered(name);
				if(!check){
					PopUp.alertBox("Incorrect entry", "Please enter  a full name with no spaces");
				}
			} else {
				return null;
			}
		} while(!check);
		for(Collectible item : Collector.setType(type)){
			if(item.getFName().equalsIgnoreCase(name[0]) && item.getLName().equalsIgnoreCase(name[1])){
				list.add(item);
			}
		}
		return list;
	}
}
