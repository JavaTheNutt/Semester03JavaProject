package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;

public class Controller 
{
	public static Collectable returnItem(String idIn)
	{
		try{
			return Collector.getItem(idIn);
		}catch(ListEmptyException e){
			System.out.println(e.getMessage());
			return null;
		}catch(ItemNotFoundException e){
			System.out.println(e.getMessage());
			return null;
		}catch(Exception e){
			System.out.println("Unknown Error");
			return null;
		}
	}
	
	public static String returnString()
	{
		try{
			return Collector.listAll();
		}catch(ListEmptyException e){
			return e.getMessage();
		}catch(Exception e){
			return "Unknown Error";
		}
	}
	
}