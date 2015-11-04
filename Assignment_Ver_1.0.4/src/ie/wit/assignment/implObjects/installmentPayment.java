package ie.wit.assignment.implObjects;

public class installmentPayment extends Parent
{
	private int frequency; //1, 3, 6
	private float installmentAmount;

	public installmentPayment(int index, String fName, String lName, String address01, String address02, String contactNo, String email, byte numberOfChildren, boolean fullyPaid, int frequency, String paymentMethod)
	{
		super(index, fName, lName, address01, address02, contactNo, email, numberOfChildren, fullyPaid, paymentMethod);
		this.frequency = frequency;
		installmentAmount = calculateInstallmentAmount();
	}

	public int getFrequency()
	{
		return frequency;
	}

	public void setFrequency(int frequency)
	{
		this.frequency = frequency;
	}

	public float getInstallmentAmount()
	{
		return installmentAmount;
	}

	public void setInstallmentAmount(float installmentAmount)
	{
		this.installmentAmount = installmentAmount;
	}

	private float calculateInstallmentAmount()
	{
		return fee / frequency;
	}
}
