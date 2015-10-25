package ie.wit.assignment.collectors;

public abstract class ItemCounter
{
	public static int numberOfDoctors;
	public static int numberOfManagers;
	public static int numberOfPlayers;

	public static void add(int type)
	{
		switch(type){
			case 1:
				numberOfManagers++;
				break;
			case 2:
				numberOfDoctors++;
				break;
			case 3:
				numberOfPlayers++;
				break;
		}

	}
}
