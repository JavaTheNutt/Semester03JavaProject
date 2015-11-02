package ie.wit.assignment.implObjects;


public class Doctor extends Collectible
{
	public Doctor(int index, String fName, String lName, String address01, String address02, String contactNo) 
	{
		super(fName, lName, address01, address02, contactNo);
		this.id = "dr" + (index + 1);
	}

}
