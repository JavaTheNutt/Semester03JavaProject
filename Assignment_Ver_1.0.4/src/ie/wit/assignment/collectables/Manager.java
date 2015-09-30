/*This inherits from collectable*/
package ie.wit.assignment.collectables;

public class Manager extends Collectable 
{
	private String partnerId;
	private String ageDivision;
	public Manager(int index, String fName, String lName, String address01, String address02, String contactNo, String email, String partnerId, String ageDivision) 
	{
		super(fName, lName, address01, address02, contactNo, email);
		this.id = "mn0" + index;
		this.partnerId = partnerId;
		this.ageDivision = ageDivision;
	}
	public String getPartnerId() 
	{
		return partnerId;
	}
	public void setPartnerId(String partnerId) 
	{
		this.partnerId = partnerId;
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