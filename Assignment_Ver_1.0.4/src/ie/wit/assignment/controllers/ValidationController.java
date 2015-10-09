package ie.wit.assignment.controllers;

import java.util.ArrayList;

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
	public static boolean alreadyExists(String fName, String lName, int type)
	{
		ArrayList<Collectable> tempList = Collector.setType(type);
		for(Collectable item : tempList){
			if(item.getFName().equalsIgnoreCase(fName) && item.getLName().equalsIgnoreCase(lName)){
				return true;
			}
		}
		return false;
	}
	public static boolean checkMonthValidity(String monthIn, String dayIn)
	{
		int month = Integer.parseInt(monthIn);
		int day = Integer.parseInt(dayIn);
		if(month == 9 || month == 4 || month == 6 || month == 11 || month == 2){
			if(day > 30){
				return false;
			}
			if(month == 2 && day > 28){
				return false;
			}
		}
		return true;
	}
}
