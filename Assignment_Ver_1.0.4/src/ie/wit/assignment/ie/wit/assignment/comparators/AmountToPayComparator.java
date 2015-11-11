package ie.wit.assignment.ie.wit.assignment.comparators;

import ie.wit.assignment.implObjects.Collectible;
import ie.wit.assignment.implObjects.InstallmentPayment;

import java.util.Comparator;

public class AmountToPayComparator implements Comparator<Collectible>
{
	@Override
	public int compare(Collectible o1, Collectible o2)
	{
		InstallmentPayment parent01 = ((InstallmentPayment)o1);
		InstallmentPayment parent02 = ((InstallmentPayment)o2);
		float parent01Amount = parent01.getAmountLeftToPay();
		float parent02Amount = parent02.getAmountLeftToPay();
		float diff = (parent01Amount - parent02Amount);

		if(diff > 0){
			return 1;
		} else if(diff < 0){
			return -1;
		} else {
			return 0;
		}
	}
}
