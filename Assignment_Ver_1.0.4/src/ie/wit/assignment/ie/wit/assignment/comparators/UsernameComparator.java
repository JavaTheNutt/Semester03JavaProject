package ie.wit.assignment.ie.wit.assignment.comparators;

import ie.wit.assignment.accounts.Account;

import java.util.Comparator;

/**
 * Created by Joe on 16/11/2015.
 */
public class UsernameComparator implements Comparator<Account>
{
	@Override
	public int compare(Account o1, Account o2)
	{
		return o1.getUsername().compareTo(o2.getUsername());
	}
}
