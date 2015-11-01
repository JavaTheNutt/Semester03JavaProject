package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Collectible;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectors.Lists;

import java.util.List;

/*This class validates user input before object creation*/
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
		for(Collectible manager : Lists.managerList.list)
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
		if((emailIn.indexOf('@') > 0) && emailIn.indexOf('.') > 0){
			return true;
		}
		return false;
	}
	public static boolean alreadyExists(String fName, String lName, int type)
	{
		List<Collectible> tempList = Lists.setType(type).list;
		for(Collectible item : tempList){
			if(item.getFName().equalsIgnoreCase(fName) && item.getLName().equalsIgnoreCase(lName)){
				return true;
			}
		}
		return false;
	}
	/*Ensure that months entered are valid*/
	public static boolean checkMonthValidity(String monthIn, String dayIn)
	{
		int month = Integer.parseInt(monthIn);
		int day = Integer.parseInt(dayIn);
		if(month == 9 || month == 4 || month == 6 || month == 11 || month == 2){
			if(day > 30){
				return false;
			}
			if(month == 2 && day > 29){
				return false;
			}
		}
		return true;
	}
}
