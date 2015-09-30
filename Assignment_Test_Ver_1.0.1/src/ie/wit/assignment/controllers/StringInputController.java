package ie.wit.assignment.controllers;

import ie.wit.assignment.collections.ManagerCollector;
import ie.wit.assignment.implementableObjects.Manager;

public class StringInputController 
{
	public  static String collectStringFromUser(String idIn)
	{
		Manager tempManager = ManagerCollector.getManagerById(idIn);
		if(tempManager == null){
			return "Manger not Found";
		} else {
			return "Manager found";
		}
	}
}