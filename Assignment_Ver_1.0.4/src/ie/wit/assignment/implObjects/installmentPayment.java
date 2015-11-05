package ie.wit.assignment.implObjects;

public class InstallmentPayment extends Parent
{
	private int frequency; //1, 3, 6
	private float installmentAmount;
	private float amountLeftToPay;

	public InstallmentPayment(int index, String fName, String lName, String address01, String address02, String contactNo, String email, byte numberOfChildren, int frequency, String paymentMethod)
	{
		super(index, fName, lName, address01, address02, contactNo, email, numberOfChildren, paymentMethod);
		this.frequency = frequency;
		installmentAmount = calculateInstallmentAmount();
		amountLeftToPay = fee;
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

	public void setInstallmentAmount(){
		installmentAmount = calculateInstallmentAmount();
	}
	public float getAmountLeftToPay(){
		return amountLeftToPay;
	}

	private float calculateInstallmentAmount()
	{
		return fee / frequency;
	}

	@Override
	public void paymentMade()
	{
		amountLeftToPay -= installmentAmount;
		if (amountLeftToPay <= 0){
			fullyPaid = true;
		}
	}
}
