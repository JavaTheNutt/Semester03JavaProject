package ie.wit.assignment.controllers;

import ie.wit.assignment.exceptions.GroupMismatchException;
import ie.wit.assignment.exceptions.InputNotValidException;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.implObjects.*;
import ie.wit.assignment.gui.PopUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
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

	public static List<String> getParentsInArray()throws ListEmptyException, GroupMismatchException, ItemNotFoundException
	{

		List<String> names = new ArrayList<>();
		List<String> pairIds = findDistinctPairIds();
		List<String> nameList = new ArrayList<>();
		for(String ids : pairIds){
			for (Collectible item : Lists.parentList.getList()){
				Parent parent = (Parent) item;
				if(parent.getPairId().equals(ids)){
					names.add(parent.getFName() + " " + parent.getLName());
				}
			}
			if(names.size() > 2){
				throw new GroupMismatchException("There appear to be too many names assigned to one parent group");
			} else if(names.size() == 1){
				nameList.addAll(names);
			} else if(names.size() == 2){
				String tempName = names.get(0) + " and " + names.get(1);
				nameList.add(tempName);
			} else{
				throw new ItemNotFoundException("No parents were found with that id");
			}
			names.removeAll(names);
		}
		return nameList;
	}
	public static List<Collectible> findFamilies(String pairId){
		List<Collectible> familyList = new ArrayList<>();
		for (Collectible item : Lists.parentList.getList()){
			Parent parent = (Parent) item;
			if(parent.getPairId().equals(pairId)){
				familyList.add(item);
			}
		}
		for (Collectible item : Lists.playerList.getList()){
			Player player = (Player) item;
			if (player.getParentId().equals(pairId)){
				familyList.add(item);
			}
		}
		return familyList;
	}
	public static List<String> findDistinctPairIds(){
		ArrayList<String> list = new ArrayList<>();
		for(Collectible item : Lists.parentList.getList()){
			Parent parent = (Parent) item;
			String tempPairId = parent.getPairId();
			if(!list.contains(tempPairId)){
				list.add(tempPairId);
			}
		}
		return list;
	}
	public static List<Collectible> findParents(String pairIdIn){
		List<Collectible> tempList = new ArrayList<>();
		for(Collectible item : Lists.parentList.getList()){
			Parent parent = (Parent) item;
			if(parent.getPairId().equals(pairIdIn)){
				tempList.add(parent);
			}
		}
		return tempList;
	}
}
