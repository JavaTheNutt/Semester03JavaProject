package ie.wit.assignment.accounts;

import ie.wit.assignment.exceptions.ItemNotFoundException;
import ie.wit.assignment.exceptions.ListEmptyException;
import ie.wit.assignment.ie.wit.assignment.comparators.UsernameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Joe on 16/11/2015.
 */
public class AccountCollector
{
	public static List<Account> list = new ArrayList<>();
	public static  int numberInList = 0;

	public static boolean addAccount(Account account)
	{
		return list.add(account);
	}
	public static List<Account> getAdmins(){
		ArrayList<Account> tempList = new ArrayList<>();
		for (Account item: list) {
			if (item.isAdmin()){
				tempList.add(item);
			}
		}
		return tempList;
	}
	public static Account getUser(String username) throws ItemNotFoundException, ListEmptyException
	{
		isEmpty();
		list.sort(new UsernameComparator());
		return list.get(Collections.binarySearch(list, username));
	}
	private static boolean isEmpty() throws ListEmptyException
	{
		if(list.isEmpty()){
			throw new ListEmptyException("There are no accounts associated with the service. Please contact a system administrator.");
		}
		return false;
	}
	public static void setList(List<Account> listIn){
		list = listIn;
	}
}
