package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectors.ManagerCollector;
import ie.wit.assignment.exceptions.ListFullException;

public class ManagerController extends Controller 
{
	
	public static boolean addManager(Manager managerIn)
	{
		try{
			ManagerCollector.add(managerIn);
			return true;
		} catch(ListFullException e){
			return false;
		}
	}
}
