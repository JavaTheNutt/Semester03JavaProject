package ie.wit.assignment.controllers;

import ie.wit.assignment.Main;
import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.exceptions.InputNotValidException;
import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.gui.PopUp;

import java.util.List;

/*This class is mainly used as a barrier class to handle try..catch blocks and deal with
* exceptions thrown in the collector class*/
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
	public static boolean checkEmpty(List listIn) throws ListEmptyException
	{
		if(listIn.isEmpty()){
			throw new ListEmptyException("The list is empty");
		}
		return false;
	}
	public static boolean checkNameEntered(String[] listIn)
	{
		if(listIn.length < 2){
			return false;
		}
		return true;
	}
	public static boolean catchEmptyException(List listIn)
	{
		try{
			checkEmpty(listIn);
		} catch (ListEmptyException e){
			return true;
		}
		return false;
	}

}
