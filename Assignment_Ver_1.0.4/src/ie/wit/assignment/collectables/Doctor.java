package ie.wit.assignment.collectables;


public class Doctor extends Collectable 
{
	public Doctor(int index, String fName, String lName, String address01, String address02, String contactNo) 
	{
		super(fName, lName, address01, address02, contactNo, null);
		this.id = "dr" + (index + 1);
	}

}
