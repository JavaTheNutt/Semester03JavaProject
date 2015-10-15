package ie.wit.assignment.controllers;

import ie.wit.assignment.collectables.Collectible;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.exceptions.InputNotValidException;

import java.util.ArrayList;
import java.util.List;
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
			List<Collectible> list = Collector.setType(type);
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

			}
		}
		catch (InputNotValidException e) {
			e.printStackTrace();
		}
	}
	/*This method will check that the attribute name entered matches an attribute of
	* the corresponding object*/
	private static int checkAttributeList(int type, String attributeIn)
	{
		/*Add the default attributes to the arraylist*/
		for(String attribute : tempListOfAttributes){
			listOfAttributes.add(attribute);
		}
		/*Type 2(Doctor) only has default attributes*/
		if(type == 1 || type == 3){
			switch (type){
				case 1:
					/*reset temporary variables and add extras*/
					tempListOfAttributes = new String[]{
							"email",
							"ageDivision"
					};
					break;
				case 3:
					tempListOfAttributes = new String[]{
							"email",
							"day",
							"month",
							"year"
					};
					break;
			}
			/*push extra attributes to the arraylist*/
			for(String item : tempListOfAttributes){
				listOfAttributes.add(item);
			}
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

}
