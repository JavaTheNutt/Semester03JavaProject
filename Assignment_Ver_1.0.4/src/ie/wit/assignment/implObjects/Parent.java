package ie.wit.assignment.implObjects;
/*This class will be instantiated if the fees are to be paid in a single lump sum, else will be InstallmentPayment*/
public class Parent extends Collectible
{
	protected String pairId;
	protected String email;
	protected int numberOfChildren;
	protected float fee;
	protected boolean fullyPaid;
	protected String paymentMethod;

	public Parent(int index, String fName, String lName, String address01, String address02, String contactNo, String email, String paymentMethod, int type, int placeInGroup){
		super(fName, lName, address01, address02, contactNo, type);
		this.email = email;
		this.fee = calculateFee();
		this.fullyPaid = false;
		this.pairId = "pr" + (index + 1);
		this.paymentMethod = paymentMethod;
		numberOfChildren = 1;
		this.id = pairId + "." + placeInGroup;
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

	public int getNumberOfChildren()
	{
		return numberOfChildren;
	}

	public void addChild(){
		numberOfChildren++;
	}

	public float getFee()
	{
		return fee;
	}

	public void setFee()
	{
		fee = calculateFee();
	}

	@Override
	public String getId()
	{
		return id;
	}

	public boolean isFullyPaid()
	{
		return fullyPaid;
	}

	public void setFullyPaid(boolean fullyPaid)
	{
		this.fullyPaid = fullyPaid;
	}

	public String getPaymentMethod()
	{
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public void paymentMade(){
		fullyPaid = true;
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
