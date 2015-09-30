package ie.wit.assignment.collections;


import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.exceptions.ListFullException;
import ie.wit.assignment.gui.AlertBox;
import ie.wit.assignment.implementableObjects.Manager;

public class ManagerCollector
{
	private static Manager[] listOfManagers = new Manager[10];
	private static int totalManagers = 0;

	private static boolean listFull()
	{
		if(totalManagers == listOfManagers.length){
			return true;
		}
		return false;
	}
	private static boolean isEmpty()
	{
		if(totalManagers == 0){
			return true;
		
		}
		return false;
	}
	
	private static int search(String idIn)
	{
		if(listFull()){
			return -999;
		}
		for(int i = 0; i < totalManagers; i++){
			if(listOfManagers[i].getManagerId().equals(idIn)){
				return i;
			}
		}
		return -888;
		
	}
	private static int searchByName(String fNameIn, String lNameIn)
	{
		if (listFull()){
			return -999;
		}
		for(int i = 0; i < totalManagers; i++){
			if(listOfManagers[i].getManagerFName().equals(fNameIn)  && listOfManagers[i].getManagerLName().equals(lNameIn)){
				return i;
			}
		}
		return -888;
	}
	public static int getTotalManagers(){
		return totalManagers;
	}
	
	public static boolean addManager(Manager managerIn)
	{
		if(listFull()){
			return false;
		}
		listOfManagers[totalManagers] = managerIn;
		totalManagers++;
		return true;
	}
	public static boolean removeManager(String idIn)
	{
		int index = search(idIn);
		for(int i = index; i < totalManagers -2; i++){
			listOfManagers[i] = listOfManagers[i + 1];
		}
		totalManagers --;
		return true;
	}
	public static Manager getManagerById(String idIn)
	{
		int index = search(idIn);
		if(index >= 0){
			return listOfManagers[index];
		} 
		return null;	
	}
	
	public static Manager getManagerByName(String fNameIn, String lNameIn){
		/*if an error message is displayed, this value will receive a
		 * corresponding error code. Not used at present but can be
		 * implemented later*/ 
		int index = searchByName(fNameIn, lNameIn);
		if(index < 100 ){
			return listOfManagers[index];
		}
		return null;
	}
	
	public static String listAll()
	{
		String tempString = "";
		if(isEmpty())
		{
			tempString = "List Empty";
			return tempString;
		}
		for(int i = 0; i < totalManagers; i++){
			tempString += listOfManagers[i].toString();
		}
		return tempString;
	}
}