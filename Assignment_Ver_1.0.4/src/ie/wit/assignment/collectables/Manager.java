/*This inherits from collectable*/
package ie.wit.assignment.collectables;

public class Manager extends Collectable 
{
	
	private String ageDivision;
	public Manager(int index, String fName, String lName, String address01, String address02, String contactNo, String email, String ageDivision) 
	{
		super(fName, lName, address01, address02, contactNo, email);
		this.id = "mn0" + index;
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
