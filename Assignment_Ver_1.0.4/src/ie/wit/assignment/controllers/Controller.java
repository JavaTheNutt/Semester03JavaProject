package ie.wit.assignment.controllers;

import ie.wit.assignment.Main;
import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.gui.PopUp;

public abstract class Controller 
{
	public static boolean addItem(Collectable itemIn, int type)
	{
		try{
			Collector.addItem(itemIn, type);
			return true;
		}catch(Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return false;
		}
	}
	public static  boolean removeItem(String idIn, int type){
        try{
            Collectable tempItem = Controller.getById(type, idIn);
            if(tempItem.equals(null)){
                return false;
            }
            Collector.removeItem(tempItem, type);
            return true;
        } catch (ListEmptyException e){
            PopUp.alertBox("List Empty", "The list is empty");
            return false;
        } catch(ItemNotFoundException e){
            PopUp.alertBox("Item not found", "Item specified does not exist");
            return false;
        } catch (Exception e){
            PopUp.alertBox("Error", "An unknown error has occurred");
            return false;
        }
    }
	public static String getAllAsString(int type)
	{
		try{
			return Collector.listAll(type);
		}catch(ListEmptyException e) {
            PopUp.alertBox("List Empty", "The list is empty");
            return null;
        }catch (Exception e){
            PopUp.alertBox("Error", "An unknown error has occurred");
			return null;
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
