package ie.wit.assignment.collectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.exceptions.InputNotValidException;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.gui.PopUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*This class handles collections of concrete objects. It collects Collectable objects and stores them in a List.
* This class also handles operations on the lists*/
public abstract class Collector
{
	public static List<Collectable> managerList = new ArrayList<Collectable>();
	public static List<Collectable> doctorList = new ArrayList<Collectable>();
	public static List<Collectable> playerList = new ArrayList<Collectable>();
	public static int numberOfManagers;
	public static int numberOfDoctors;
	public static int numberOfPlayers;

	/*This method is used to determine which list to perform an operation on*/
	public static List<Collectable> setType(int type)
	{
		List<Collectable> tempList = null;
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

	public static boolean removeItem(Collectable item, int type) throws ItemNotFoundException, ListEmptyException
	{
		List<Collectable> tempList = setType(type);
		if(tempList.isEmpty()){
			throw new ListEmptyException();
		}
		Iterator<Collectable> iterator = tempList.iterator();
		while(iterator.hasNext()){
			if(item.equals(iterator)){
				iterator.remove();
				return true;
			}
		}
		throw new ItemNotFoundException();
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

	private static int getIndex(Collectable itemIn, int type)
	{
		List<Collectable> tempList = setType(type);
		int i = 0;
		for(Collectable item : tempList){
			if(item.getId().equals(itemIn.getId())){
				return i;
			}
			i++;
		}
		return -999;
	}

	public static Collectable searchById(String idIn, int type)throws ListEmptyException, ItemNotFoundException
	{
		List<Collectable> tempList = setType(type);
		if(tempList.isEmpty()){
			throw new ListEmptyException();
		}
		for(Collectable item : tempList){
			if(item.getId().equals(idIn)){
				return item;
			}
		}
		throw new ItemNotFoundException();
	}

	public static Collectable searchByName(String fNameIn, String lNameIn, int type)throws ListEmptyException, ItemNotFoundException
	{
		List<Collectable> tempList = setType(type);
		if(tempList.isEmpty()){
			throw new ListEmptyException();
		}
		for(Collectable item : tempList){
			if(item.getFName().equals(fNameIn) && item.getLName().equals(lNameIn)){
				return item;
			}
		}
		throw new ItemNotFoundException();
	}
	public static void addItem(Collectable itemIn, int type)
	{
		List<Collectable> tempList = setType(type);
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
		List<Collectable> tempList = setType(type);
		
		if(tempList.isEmpty()){
			throw new ListEmptyException("The list is empty");
		}
		String tempString = "";
		for(Collectable item: tempList)
		{
			tempString += item.toString();
		}
		return tempString;
	}
	public static void setManagerList(List <Collectable> listIn)
	{
		managerList = listIn;
	}
	public static void setDoctorList(List <Collectable> listIn)
	{
		doctorList = listIn;
	}	
	public static void setPlayerList(List<Collectable> listIn){
		playerList = listIn;
	}
	/*Convert from an ArrayList to an ObservableList*/
	public static ObservableList<Collectable> getList(int type){
		ObservableList<Collectable> list = FXCollections.observableArrayList();
		switch(type){
		case 1:
			for(Collectable manager : managerList){
				list.add((Manager)manager);
			}
			return list;
		case 2:
			for(Collectable doctor : doctorList){
				list.add((Doctor) doctor);
			}
			return list;
		case 3:
			for(Collectable player : playerList){
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
        for(Collectable doc : doctorList){
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
}
