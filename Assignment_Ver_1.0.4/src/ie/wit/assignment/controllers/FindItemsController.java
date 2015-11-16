package ie.wit.assignment.controllers;

import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.implObjects.*;
import ie.wit.assignment.gui.PopUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Joe on 01/11/2015.
 */
public abstract class FindItemsController
{
	public static ObservableList<Collectible> findPlayersByAgeDivision(String ageDivision){
		ObservableList<Collectible> tempList = FXCollections.observableArrayList();
		List<Collectible> list = Lists.playerList.getList();
		for (Collectible item: list){
			Player player = (Player) item;
			if(player.getAgeDivision().equalsIgnoreCase(ageDivision)){
				tempList.add(player);
			}
		}
		return tempList;
	}
	public static Collectible findItemsByName(int type){
		ObservableList<Collectible> tempList = FXCollections.observableArrayList();
		try {
			Collector list = Lists.setType(type);
			String [] allNames = list.getNamesInArray();
			String name = PopUp.singleComboBox(allNames, "Select Name", "Please select the name of the person");
			String[] names = name.split(" ");
			return list.getItem(names);
		} catch (ListEmptyException e) {
			PopUp.alertBox("Error", e.getMessage());
			e.printStackTrace();
			return null;
		} catch (ItemNotFoundException e) {
			PopUp.alertBox("Error", e.getMessage());
			e.printStackTrace();
			return null;
		} catch (Exception e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		}
	}
	public static int getTypeById(String id){
		String identifier = id.substring(0, 2);
		switch (identifier){
			case "mn":
				return 1;
			case "dr":
				return 2;
			case "pl":
				return 3;
			default:
				return -999;
		}
	}
	/*This method is designed to match all items to another associated item. Used for many to many relationships
	* such as 1..1 doctors to 0..* Players*/
	public static ObservableList<Collectible> getAssociatedItems(String idIn)
	{
		ObservableList<Collectible> list = FXCollections.observableArrayList();
		for(Collectible item : Lists.playerList.getList()){
			Player tempItem = (Player)item;
			if(tempItem.getDoctorId().equalsIgnoreCase(idIn) || tempItem.getParentId().equalsIgnoreCase(idIn)){
				list.add(item);
			}
		}
		return list;
	}

}
