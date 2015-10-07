package ie.wit.assignment.validation;

import javafx.scene.control.TextField;

public class ManagerValidation 
{
	public static boolean isFilled(String fieldIn)
	{
		if(fieldIn.equals("")){
			return false;
		}
		return true;
	}
}
