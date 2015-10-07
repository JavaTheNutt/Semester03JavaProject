package ie.wit.assignment.collectors;

import java.util.ArrayList;
import java.util.Collection;

import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Collector
{
	public static ArrayList<Collectable> managerList = new ArrayList<Collectable>();
	public static ArrayList<Collectable> doctorList = new ArrayList<Collectable>();
	public static int numberOfManagers;
	public static int numberOfDoctors;
	
	private static ArrayList<Collectable> setType(int type)
	{
		ArrayList<Collectable> tempList = null;
		switch(type){
		case 1:
			tempList = managerList;
			break;
		case 2:
			tempList = doctorList;
			break;
		}
		return tempList;
	}
	private static int getAmount(int type){
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
	public static boolean removeItem(Collectable itemIn, int type)throws ListEmptyException, ItemNotFoundException
	{
		ArrayList<Collectable> tempList = setType(type);
		if(tempList.isEmpty()){
			throw new ListEmptyException();
		}
		int index = getIndex(itemIn, type);
		if(index == -999){
			throw new ItemNotFoundException();
		}
		tempList.remove(index);
		return true;
		
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
	public static ObservableList<Manager> getManagerList()
	{
		ObservableList<Manager> listOfManagers = FXCollections.observableArrayList();
		for(Collectable manager : managerList){
			listOfManagers.add((Manager) manager);
		}
		return listOfManagers;
	}
}
