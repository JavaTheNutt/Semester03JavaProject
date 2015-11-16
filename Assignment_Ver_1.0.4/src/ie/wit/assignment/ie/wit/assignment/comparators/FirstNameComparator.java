package ie.wit.assignment.ie.wit.assignment.comparators;

import ie.wit.assignment.implObjects.Collectible;

import java.util.Comparator;

/**
 * Created by Joe on 05/11/2015.
 */
public class FirstNameComparator implements Comparator<Collectible>
{
	@Override
	public int compare(Collectible o1, Collectible o2)
	{
		int res = o1.getFName().compareTo(o2.getFName());
		return res;
	}
}
