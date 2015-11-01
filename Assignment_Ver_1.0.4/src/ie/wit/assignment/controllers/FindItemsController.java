package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Collectible;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.collectors.Lists;
import ie.wit.assignment.collectors.NewCollector;
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
		List<Collectible> list = Lists.playerList.list;
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
		NewCollector list = Lists.setType(type);
		String [] allNames = list.getNamesInArray();
		String name = PopUp.singleComboBox(allNames, "Select Name", "Please select the name of the person");
		String[] names = name.split(" ");
		return list.getItem(names);
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
}
