package ie.wit.assignment.implObjects;

public abstract class Parent extends Collectible
{
	protected String pairId;
	protected String email;
	protected byte numberOfChildren;
	protected float fee;
	protected boolean fullyPaid;
	protected String paymentMethod;

	public Parent(int index, String fName, String lName, String address01, String address02, String contactNo, String email, byte numberOfChildren,  boolean fullyPaid, String paymentMethod){
		super(fName, lName, address01, address02, contactNo);
		this.email = email;
		this.numberOfChildren = numberOfChildren;
		this.fee = calculateFee();
		this.fullyPaid = fullyPaid;
		this.id = "pr" + index;
		this.paymentMethod = paymentMethod;
	}

	public String getPairId()
	{
		return pairId;
	}

	public void setPairId(String pairId)
	{
		this.pairId = pairId;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public byte getNumberOfChildren()
	{
		return numberOfChildren;
	}

	public void setNumberOfChildren(byte numberOfChildren)
	{
		this.numberOfChildren = numberOfChildren;
	}

	public float getFee()
	{
		return fee;
	}

	public void setFee(float fee)
	{
		this.fee = fee;
	}

	public boolean isFullyPaid()
	{
		return fullyPaid;
	}

	public void setFullyPaid(boolean fullyPaid)
	{
		this.fullyPaid = fullyPaid;
	}

	private float calculateFee()
	{
		switch(numberOfChildren){
			case 1:
				return 80;
			case 2:
				return 150;
			case 3:
				return 220;
			case 4:
				return 300;
			case 5:
				return 350;
			default:
				return 400;
		}
	}
}
