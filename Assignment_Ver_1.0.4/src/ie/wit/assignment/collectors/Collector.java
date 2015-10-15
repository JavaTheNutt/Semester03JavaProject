package ie.wit.assignment.collectors;

import java.util.ArrayList;
import java.util.List;

import ie.wit.assignment.collectables.Collectible;
import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.exceptions.InputNotValidException;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.gui.PopUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*This class handles collections of concrete objects. It collects Collectible objects and stores them in a List.
* This class also handles operations on the lists*/
public abstract class Collector
{
	public static List<Collectible> managerList = new ArrayList<Collectible>();
	public static List<Collectible> doctorList = new ArrayList<Collectible>();
	public static List<Collectible> playerList = new ArrayList<Collectible>();
	public static int numberOfManagers;
	public static int numberOfDoctors;
	public static int numberOfPlayers;

	/*This method is used to determine which list to perform an operation on*/
	public static List<Collectible> setType(int type)
	{
		List<Collectible> tempList = null;
		switch(type){
		case 1:
			tempList = managerList;
			break;
		case 2:
			tempList = doctorList;
			break;
		case 3:
			tempList = playerList;
		}
		return tempList;
	}

	public static boolean removeItem(Collectible item, int type) throws ItemNotFoundException, ListEmptyException
	{
		List<Collectible>tempList = setType(type);
		if (tempList.isEmpty()){
			throw new ListEmptyException("The list is empty");
		}
		if(tempList.remove(item)){
			return true;
		}
		return false;
	}
	/*Return the number of a specific object in a list*/
	public static int getAmount(int type){
		int tempNum = -9;
		switch(type){
		case 1:
			tempNum = numberOfManagers;
			break;
		case 2:
			tempNum = numberOfDoctors;
			break;
		case 3:
			tempNum = numberOfPlayers;
			break;
		}
		return tempNum;
	}

	private static int getIndex(Collectible itemIn, int type)
	{
		List<Collectible> tempList = setType(type);
		int i = 0;
		for(Collectible item : tempList){
			if(item.getId().equals(itemIn.getId())){
				return i;
			}
			i++;
		}
		return -999;
	}

	public static Collectible searchById(String idIn, int type)throws ListEmptyException, ItemNotFoundException
	{
		List<Collectible> tempList = setType(type);
		if(tempList.isEmpty()){
			throw new ListEmptyException();
		}
		for(Collectible item : tempList){
			if(item.getId().equals(idIn)){
				return item;
			}
		}
		throw new ItemNotFoundException();
	}

	public static Collectible searchByName(String fNameIn, String lNameIn, int type)throws ListEmptyException, ItemNotFoundException
	{
		List<Collectible> tempList = setType(type);
		if(checkEmpty(type)){
			throw new ListEmptyException();
		}
		for(Collectible item : tempList){
			if(item.getFName().equals(fNameIn) && item.getLName().equals(lNameIn)){
				return item;
			}
		}
		throw new ItemNotFoundException();
	}
	public static void addItem(Collectible itemIn, int type)
	{
		List<Collectible> tempList = setType(type);
		tempList.add(itemIn);
		if(type == 1){
			numberOfManagers++;
		} else if(type == 2){
			numberOfDoctors++;
		} else if (type == 3){
			numberOfPlayers ++;
		}
	}
	/*Return all items of a list in a string*/
	public static String listAll(int type)throws ListEmptyException
	{
		List<Collectible> tempList = setType(type);
		
		if(!checkEmpty(type)){
			throw new ListEmptyException("The list is empty");
		}
		String tempString = "";
		for(Collectible item: tempList)
		{
			tempString += item.toString();
		}
		return tempString;
	}
	public static void setManagerList(List <Collectible> listIn)
	{
		managerList = listIn;
	}
	public static void setDoctorList(List <Collectible> listIn)
	{
		doctorList = listIn;
	}	
	public static void setPlayerList(List<Collectible> listIn){
		playerList = listIn;
	}
	/*Convert from an ArrayList to an ObservableList*/
	public static ObservableList<Collectible> getList(int type){
		ObservableList<Collectible> list = FXCollections.observableArrayList();
		switch(type){
		case 1:
			for(Collectible manager : managerList){
				list.add((Manager)manager);
			}
			return list;
		case 2:
			for(Collectible doctor : doctorList){
				list.add((Doctor) doctor);
			}
			return list;
		case 3:
			for(Collectible player : playerList){
				list.add((Player) player);
			}
			return list;
		}
		return null;
		
	}
	/*Place all of the doctor names into an array. (Used in the doctor combobox)*/
	public static String[] getDoctorNamesInArray()
	{
        int amountOfDoctors  = getAmount(2);
        String[] tempArray = new String[amountOfDoctors];
        String tempString = "";
        int i = 0;
        for(Collectible doc : doctorList){
            tempString = doc.getFName() + " " + doc.getLName();
            tempArray[i] = tempString;
            i++;
        }
        return tempArray;
	}
	/*Take a doctors full name, split it and try match it to an ID*/
    public static String matchDoctorNameToId(String name){
        try{
            name = name.trim();
            String[] names = name.split(" ");
            Doctor thisdoc = (Doctor) searchByName(names[0], names[1], 2);
            return thisdoc.getId();
        } catch (ListEmptyException e){
            PopUp.alertBox("List Empty", "There are no items");
            return null;
        } catch(ItemNotFoundException e){
            PopUp.alertBox("Item not found", "There was no such item found");
            return null;
        } catch(Exception e){
            PopUp.alertBox("Unknown Error", "An unknown error has occurred");
            return null;
        }
    }
	/*Return the type based on the id passed. Gets the first two letters of the ID and
	* uses that to determine a type.*/
	public static int getTypeById(String idIn) throws InputNotValidException
	{
		int tempType = -999;
		String tempString = idIn.substring(0, 2);
		switch (tempString){
			case "mn":
				tempType = 1;
			break;
			case "dr":
				tempType =  2;
			break;
			case "pl":
				tempType =  3;
			break;
		}
		if(tempType == -999){
			throw new InputNotValidException("That ID does not match any known ID types");
		}
		return tempType;
	}
	public static boolean checkEmpty(int type)throws ListEmptyException
	{
		List<Collectible> tempList = setType(type);
		if (tempList.isEmpty()){
			throw new ListEmptyException("The list is empty");
		}
		return false;
	}
}
