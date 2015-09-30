package ie.wit.assignment.collectors;

import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.exceptions.ListFullException;

public abstract class Collector 
{
	protected static Collectable[] list;
	protected static int total;
	
	public Collector(){
		list = new Collectable[10];
		total = 0;
	}
	public Collector(int sizeIn, int type)
	{
		total = 0;
		switch(type){
		case 1:
			list = new Manager[sizeIn];
			break;
		}
	}
	protected static boolean isFull()
	{
		if(total == list.length){
			return true;
		}
		return false;
	}
	protected static boolean isEmpty()
	{
		if(total == 0){
			return true;
		}
		return false;
	}
	protected static int search(String idIn)
	{
		if(!isEmpty()){
			for(int i = 0; i < total; i++){
				if(list[i].getId().equals(idIn)){
					return i;
				}
			}
			return -888;	//Not found
		}
		return -999;	//Empty
	}
	public static boolean add(Collectable objIn)throws ListFullException
	{
		if(!isFull()){
			list[total] = objIn;
			total++;
			return true;
		}
		throw new ListFullException();
	}
	public boolean remove()
	{
		return true;
	}
	public static Collectable getItem(String idIn) throws ListEmptyException, ItemNotFoundException
	{
		int tempIndex = search(idIn);
		if(tempIndex == -888){
			throw new ItemNotFoundException("Item not found");
		} else if(tempIndex == -999){
			throw new ListEmptyException();
		}
		return list[tempIndex];
		
	}
	public static String listAll() throws ListEmptyException
	{
		String tempString = "";
		if(isEmpty()){
			throw new ListEmptyException();
		}
		for(int i = 0; i < total; i++){
			tempString += list[i].toString();
		}
		return tempString;
	}
}