package ie.wit.assignment.ie.wit.assignment.comparators;

import ie.wit.assignment.implObjects.Collectible;

import java.util.Comparator;

public class SurnameComparator implements Comparator<Collectible>
{
	@Override
	public int compare(Collectible o1, Collectible o2)
	{
		return o1.getLName().compareTo(o2.getLName());
	}
}