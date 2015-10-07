package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectors.Collector;

public class ValidationController 
{
	//Ensure that all something has been entered in all fields
	public static boolean fieldsFilled(String[] items)
	{
		for(String item : items){
			if(item.equals("")){
				return false;
			}
		}
		return true;
	}
	//This checks that there is not more than two managers entered for each age division
	public static boolean checkCorrectDivision(String ageDivisionIn)
	{
		int totalInDivision = 0;
		for(Collectable manager : Collector.managerList)
		{
			Manager tempMan = (Manager) manager;
			if(tempMan.getAgeDivision().equalsIgnoreCase(ageDivisionIn)){
				totalInDivision++;
			}
			if(totalInDivision == 2){
				return false;
			}
		}
		return true;
	}
	public static boolean checkEmail(String emailIn)
	{
		if(emailIn.indexOf('@') > 0){
			return true;
		}
		return false;
	}
}
