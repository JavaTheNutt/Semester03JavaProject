package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Collectible;
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
	public static boolean addItem(Collectible itemIn, int type)
	{
		try{
			Collector.addItem(itemIn, type);
			return true;
		} catch(Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return false;
		}
	}
	public static  boolean removeItem(String idIn, int type){
        try{
            Collectible tempItem = Controller.getById(type, idIn);
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
	public static String matchNameToId(String name, int type)
	{
		try{
			name = name.trim();
			String [] names = name.split(" ");
			if(checkNameEntered(names)){
				Collectible tempItem = Collector.searchByName(names[0], names[1], type);
				return tempItem.getId();
			}
			throw new InputNotValidException("The name entered has no spaces");
		} catch(ItemNotFoundException e){
			PopUp.alertBox("Item not found", "The selected item was not found");
			return null;
		} catch (ListEmptyException e){
			PopUp.alertBox("List empty", "The list is empty");
			return null;
		} catch (InputNotValidException e){
			PopUp.alertBox("Error", e.getMessage());
			return null;
		}catch (Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
			return null;
		}
	}
	public static Collectible getById(int type, String idIn)
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
	public static boolean checkNameEntered(String nameIn){
		if((!nameIn.contains(" "))|| nameIn.length() < 3){
			return false;
		}
		return true;
	}
	public static boolean checkNameEntered(String[] nameIn)
	{
		if(nameIn.length < 2 || nameIn.length >= 3){
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
