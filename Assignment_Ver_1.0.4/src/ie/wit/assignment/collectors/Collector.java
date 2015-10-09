package ie.wit.assignment.collectors;

import java.util.ArrayList;
import java.util.Collection;

import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.gui.PopUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Collector
{
	public static ArrayList<Collectable> managerList = new ArrayList<Collectable>();
	public static ArrayList<Collectable> doctorList = new ArrayList<Collectable>();
	public static ArrayList<Collectable> playerList = new ArrayList<Collectable>();
	public static int numberOfManagers;
	public static int numberOfDoctors;
	public static int numberOfPlayers;
	
	public static ArrayList<Collectable> setType(int type)
	{
		ArrayList<Collectable> tempList = null;
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
	public static int getAmount(int type){
		int tempNum = -9;
		switch(type){
		case 1:
			tempNum = numberOfManagers;
			break;
		case 2:
			tempNum = numberOfDoctors;
			break;
		}
		return tempNum;
	}
	private static int getIndex(Collectable itemIn, int type)
	{
		ArrayList<Collectable> tempList = setType(type);
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
		ArrayList<Collectable> tempList = setType(type);
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
		ArrayList<Collectable> tempList = setType(type);
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
		ArrayList<Collectable> tempList = setType(type);
		tempList.add(itemIn);
		if(type == 1){
			numberOfManagers++;
		} else if(type == 2){
			numberOfDoctors++;
		} else if (type == 3){
			numberOfPlayers ++;
		}
	}
	
	public static String listAll(int type)throws ListEmptyException
	{
		ArrayList<Collectable> tempList = setType(type);
		
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
	public static void setManagerList(ArrayList <Collectable> listIn)
	{
		managerList = listIn;
	}
	public static void setDoctorList(ArrayList <Collectable> listIn)
	{
		doctorList = listIn;
	}	
	public static void setPlayerList(ArrayList<Collectable> listIn){
		playerList = listIn;
	}
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
	
    public static String matchDoctorNameToId(String name){
        try{
            name = name.trim();
            String[] names = name.split(" ");
            System.out.println(names.toString());

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
}
