package ie.wit.assignment.implObjects;

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
	public static int getItem(int type)
	{
		switch (type){
			case 1:
				return numberOfManagers;
			case 2:
				return numberOfDoctors;
			case 3:
				return numberOfPlayers;
		}
		return -999;
	}
	public static void setItem(int type, int amount)
	{
		switch (type){
			case 1:
				numberOfManagers = amount;
				break;
			case 2:
				numberOfDoctors = amount;
				break;
			case 3:
				numberOfPlayers = amount;
				break;
		}
	}
}
