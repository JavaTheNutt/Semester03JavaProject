/*This inherits from collectable*/
package ie.wit.assignment.collectables;

public class Manager extends Collectible
{
	
	private String ageDivision;
	public Manager(int index, String fName, String lName, String address01, String address02, String contactNo, String email, String ageDivision) 
	{
		super(fName, lName, address01, address02, contactNo, email);
		this.id = "mn" + (index +1);
		this.ageDivision = ageDivision;
	}

	public String getAgeDivision() 
	{
		return ageDivision;
	}
	public void setAgeDivision(String ageDivision) 
	{
		this.ageDivision = ageDivision;
	}
	@Override
	public String toString() {
		return super.toString() + "\nAge Division:\t" + ageDivision;
	}
	

}
