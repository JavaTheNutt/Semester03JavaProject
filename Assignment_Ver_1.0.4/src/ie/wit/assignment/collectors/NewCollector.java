package ie.wit.assignment.collectors;

import ie.wit.assignment.collectables.Collectible;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;

import java.util.ArrayList;
import java.util.List;

public class NewCollector
{
	public static List<Collectible> list;

	public NewCollector()
	{
		list = new ArrayList<>();
	}
	public boolean removeItem(Collectible item) throws ListEmptyException, ItemNotFoundException
	{
		checkExists(item);
		if(list.remove(item)){
			return true;
		} 
		return false;
	}
	public boolean removeItem(String idIn) throws ListEmptyException, ItemNotFoundException
	{
		if (removeItem(getItem(idIn))){
			return true;
		}
		return false;
	}
	public int getIndex(Collectible itemIn)throws ListEmptyException, ItemNotFoundException
	{
		checkExists(itemIn);
		return list.indexOf(itemIn);
	}

	private static boolean checkEmpty() throws  ListEmptyException
	{
		if (list.isEmpty()){
			throw new ListEmptyException("The list is empty");
		}
		return true;
	}
	private boolean checkExists(Collectible itemIn)throws ItemNotFoundException, ListEmptyException
	{
		checkEmpty();
		if(list.indexOf(itemIn) < 0){
			throw new ItemNotFoundException("Item not found");
		}
		return true;
	}
	public Collectible getItem(String idIn)throws ListEmptyException, ItemNotFoundException
	{
		checkEmpty();
		for (Collectible item : list){
			if (item.getId().equalsIgnoreCase(idIn)){
				return item;
			}
		}
		throw new ItemNotFoundException("The item was not found");
	}

	public Collectible getItem(String fName, String lName) throws ListEmptyException, ItemNotFoundException
	{
		checkEmpty();
		for (Collectible item : list){
			if(item.getFName().equalsIgnoreCase(fName) && item.getLName().equalsIgnoreCase(lName)){
				return item;
			}
		}
		throw new ItemNotFoundException("Item not found");
	}
	public Collectible getItem(String[] names)throws ListEmptyException, ItemNotFoundException
	{
		return getItem(names[0], names[1]);
	}
	
}
