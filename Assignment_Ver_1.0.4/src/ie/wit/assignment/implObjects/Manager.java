/*This inherits from collectable*/
package ie.wit.assignment.implObjects;

public class Manager extends Collectible
{
	
	private String ageDivision;
	private String email;
	public Manager(int index, String fName, String lName, String address01, String address02, String contactNo, String email, String ageDivision) 
	{
		super(fName, lName, address01, address02, contactNo);
		this.id = "mn" + (index +1);
		this.ageDivision = ageDivision;
		this.email = email;
	}

	public String getAgeDivision() 
	{
		return ageDivision;
	}
	public void setAgeDivision(String ageDivision) 
	{
		this.ageDivision = ageDivision;
	}
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	@Override
	public String toString() {
		return super.toString() + "\nAge Division:\t" + ageDivision;
	}


}
