package ie.wit.assignment.implementableObjects;

public class Parent01 extends Parent02 
{
	//This will identify each pair of parents.
	private String parentId;
	private	String address01;
	private String address02;
	private String emailAddress;
	private String contactNo;
	
	public Parent01(String fName, String lName, String child01Id, String address01, String address02) 
	{
		super(fName, lName, child01Id);
		this.address01 = address01;
		this.address02 = address02;
	}

	public Parent01(String fName, String lName, String child01Id, String child02Id, String address01, String address02) 
	{
		super(fName, lName, child01Id, child02Id);
		this.address01 = address01;
		this.address02 = address02;
	}

	public Parent01(String fName, String lName, String child01Id, String child02Id, String child03Id, String address01, String address02) 
	{
		super(fName, lName, child01Id, child02Id, child03Id);
		this.address01 = address01;
		this.address02 = address02;
	}

	public Parent01(String fName, String lName, String child01Id, String child02Id, String child03Id,
			String child04Id, String address01, String address02) 
	{
		super(fName, lName, child01Id, child02Id, child03Id, child04Id);
		this.address01 = address01;
		this.address02 = address02;
	}

	public Parent01(String fName, String lName, String child01Id, String child02Id, String child03Id, String child04Id,
			String child05Id, String address01, String address02) 
	{
		super(fName, lName, child01Id, child02Id, child03Id, child04Id, child05Id);
		this.address01 = address01;
		this.address02 = address02;
	}
	
	public String getAddress(){
		return address01 + " " + address02;
	}
	public String toString()
	{
		return super.toString() + "\nAddress:\t" + address01 + " " + address02;
	}

}
