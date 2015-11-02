package ie.wit.assignment.implObjects;

public abstract class Lists
{
	public static Collector managerList;
	public static Collector doctorList;
	public static Collector playerList;

	public static void createLists(){
		managerList = new Collector(1);
		doctorList = new Collector(2);
		playerList = new Collector(3);
	}

	public static Collector setType(int type)
	{
		switch (type){
			case 1:
				return managerList;
			case 2:
				return doctorList;
			case 3:
				return playerList;
		}
		return null;
	}
}
