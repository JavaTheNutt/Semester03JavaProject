package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Collectible;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.exceptions.InputNotValidException;
import ie.wit.assignment.gui.PopUp;

import java.util.ArrayList;
/*This class will handle the logic for updating any attribute of any collectible*/
public class UpdateItemController
{
	/*These attributes are common to all objects*/
	private static String[] tempListOfAttributes = new String[]{
			"fName",
			"lName",
			"address01",
			"address02",
			"contactNo"
	};
	private static ArrayList<String> listOfAttributes = new ArrayList<>();
	/*AttributeIn refers to the value of the value to be placed into the attribute
	* AttributeTypeIn refers to the name of the attribute*/
	public static void updateItem(String idIn, String attributeTypeIn, String attributeIn)
	{
		try {
			int type = Collector.getTypeById(idIn);
			Collectible item = Controller.getById(type, idIn);
			int attributeIndex = checkAttributeList(type, attributeTypeIn);
			/*-999 is returned if the attributeName passed does not match an
			* attribute of the correct object*/
			if(!(attributeIndex == -999)){
				/*These are the attributes common to all objects*/
				if(attributeIndex < 5){
					switch (attributeIndex){
						case 0:
							item.setFName(attributeIn);
							break;
						case 1:
							item.setLName(attributeIn);
							break;
						case 2:
							item.setAddress01(attributeIn);
							break;
						case 3:
							item.setAddress02(attributeIn);
							break;
						case 4:
							item.setContactNo(attributeIn);
							break;
					}
				} else {
					/*Both type 1(Manager) and 3(Player) have the email attribute*/
					if(type == 1 || type == 3){
						if(attributeIndex == 5){
							item.setEmail(attributeIn);
						}
						switch (type){
							case 1:
								/*If its a manager, only attribute left is ageDivision*/
								((Manager) item).setAgeDivision(attributeIn);
								break;
							case 3:
								/*If its a player, only three attributes left are ints so parse input*/
								int tempDay = Integer.parseInt(attributeIn);
								/*Cast to a player*/
								Player tempPlayer = (Player) item;
								switch (attributeIndex){
									case 5:
										tempPlayer.setDay(tempDay);
										break;
									case 6:
										tempPlayer.setMonth(tempDay);
										break;
									case 7:
										tempPlayer.setYear(tempDay);
										break;
								}
								break;
						}
					}
				}
			} else {
				PopUp.alertBox("Error", "An error has occurred");
			}
		}
		catch (InputNotValidException e) {
			PopUp.alertBox("Input invalid", "The input entered is invalid");
		} catch(Exception e){
			PopUp.alertBox("Error", "An unknown error has occurred");
		}
	}
	/*This method will check that the attribute name entered matches an attribute of
	* the corresponding object*/
	private static int checkAttributeList(int type, String attributeIn)
	{
		for(String attribute : returnAttributesInArray(type)){
			listOfAttributes.add(attribute);
		}
		int i = 0;
		/*Check that the selected attribute matches an attribute of the selected object and return an index
		* which will be used to call the appropriate setter*/
		for(String attribute : listOfAttributes){
			if (attribute.equalsIgnoreCase(attributeIn)){
				return i;
			}
			i++;
		}
		/*If the attribute doesn't match, return -999*/
		return -999;
	}
	/*This method will add the correct attributes to the array to be
	* returned to be added to the list above for validation.
	* Will also be used to return the array to populate the combobox
	* correctly on the menu*/
	public static String [] returnAttributesInArray(int type)
	{
		String [] tempArray = {};
		ArrayList<String> tempArrayList = new ArrayList<>();
		for(String attribute : tempListOfAttributes){
			tempArrayList.add(attribute);
		}
		switch (type){
			case 1:
				tempArray = new String[]{
					"email",
					"ageDivision"
				};
				break;
			case 3:
				tempArray = new String[]{
						"email",
						"day",
						"month",
						"year"
				};
				break;
		}
		for (int i = 0; i < tempArray.length; i++) {
			tempArrayList.add(tempArray[i]);
		}
		String[] filledArray = new String[tempArrayList.size()];
		filledArray = tempArrayList.toArray(filledArray);
		return filledArray;
	}
}
