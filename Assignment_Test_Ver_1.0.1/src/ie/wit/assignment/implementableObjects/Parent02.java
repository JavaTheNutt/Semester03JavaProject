package ie.wit.assignment.implementableObjects;

public class Parent02 
{
	private String fName;
	private String lName;
	private String child01Id;
	private String child02Id;
	private String child03Id;
	private String child04Id;
	private String child05Id;
	
	public Parent02(String fName, String lName, String child01Id)
	{
		this.fName = fName;
		this.lName = lName;
		this.child01Id = child01Id;
	}

	public Parent02(String fName, String lName, String child01Id, String child02Id)
	{
		this.fName = fName;
		this.lName = lName;
		this.child01Id = child01Id;
		this.child02Id = child02Id;
	}

	public Parent02(String fName, String lName, String child01Id, String child02Id, String child03Id) 
	{
		this.fName = fName;
		this.lName = lName;
		this.child01Id = child01Id;
		this.child02Id = child02Id;
		this.child03Id = child03Id;
	}

	public Parent02(String fName, String lName, String child01Id, String child02Id, String child03Id, String child04Id) 
	{
		this.fName = fName;
		this.lName = lName;
		this.child01Id = child01Id;
		this.child02Id = child02Id;
		this.child03Id = child03Id;
		this.child04Id = child04Id;
	}

	public Parent02(String fName, String lName, String child01Id, String child02Id, String child03Id, String child04Id,
			String child05Id) 
	{
		this.fName = fName;
		this.lName = lName;
		this.child01Id = child01Id;
		this.child02Id = child02Id;
		this.child03Id = child03Id;
		this.child04Id = child04Id;
		this.child05Id = child05Id;
	}

	public String getfName() 
	{
		return fName;
	}

	public void setfName(String fName) 
	{
		this.fName = fName;
	}

	public String getlName() 
	{
		return lName;
	}

	public void setlName(String lName) 
	{
		this.lName = lName;
	}

	public String getChild01Id() 
	{
		return child01Id;
	}

	public void setChild01Id(String child01Id) 
	{
		this.child01Id = child01Id;
	}

	public String getChild02Id() 
	{
		return child02Id;
	}

	public void setChild02Id(String child02Id) 
	{
		this.child02Id = child02Id;
	}

	public String getChild03Id() 
	{
		return child03Id;
	}

	public void setChild03Id(String child03Id) 
	{
		this.child03Id = child03Id;
	}

	public String getChild04Id() 
	{
		return child04Id;
	}

	public void setChild04Id(String child04Id) 
	{
		this.child04Id = child04Id;
	}

	public String getChild05Id() 
	{
		return child05Id;
	}

	public void setChild05Id(String child05Id) 
	{
		this.child05Id = child05Id;
	}
	
	public String toString()
	{
		//Only checks from child 2 onwards. Child 1 required.
		if(child02Id == null)
		{
			return "\nName:\t" + fName + " " + lName + "\nChild 1:\t" + child01Id;
		} 
		else if (child03Id == null)
		{
			return "\nName:\t" + fName + " " + lName + "\nChild 1:\t" + child01Id + "\nChild 2:\t" + child02Id;
		} 
		else if(child04Id == null)
		{
			return "\nName:\t" + fName + " " + lName + "\nChild 1:\t" + child01Id + "\nChild 2:\t" + child02Id
					+ "\nChild 3:\t" + child03Id;
		} 
		else if(child05Id == null)
		{
			return "\nName:\t" + fName + " " + lName + "\nChild 1:\t" + child01Id + "\nChild 2:\t" + child02Id
					+ "\nChild 3:\t" + child03Id + "\nChild 4:\t" + child04Id;
		}
		else 
		{
			return "\nName:\t" + fName + " " + lName + "\nChild 1:\t" + child01Id + "\nChild 2:\t" + child02Id
					+ "\nChild 3:\t" + child03Id + "\nChild 4:\t" + child04Id + "\nChild 5:\t" + child05Id;
		}
	}
}
