package ie.wit.assignment.controllers;

import ie.wit.assignment.Main;
import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;

public abstract class Controller 
{
	public static boolean addItem(Collectable itemIn, int type)
	{
		try{
			Collector.addItem(itemIn, type);
			return true;
		}catch(Exception e){
			System.out.println("fail");
			return false;
		}
	}
	public static String getAllAsString(int type)
	{
		try{
			return Collector.listAll(type);
		} catch(Exception e){
			return e.getMessage();
		}
	}
	public static Collectable getById(int type, String idIn)
	{
		try{
			return Collector.searchById(idIn, type);
		}catch(Exception e){
			return null;
		}
	}
}
