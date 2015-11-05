package ie.wit.assignment.implObjects;

public abstract class Lists
{
	public static Collector managerList = new Collector(1);
	public static Collector doctorList = new Collector(2);
	public static Collector playerList = new Collector(3);
	public static Collector parentList = new Collector(4);

	public static Collector setType(int type)
	{
		switch (type){
			case 1:
				return managerList;
			case 2:
				return doctorList;
			case 3:
				return playerList;
			case 4:
				return parentList;
		}
		return null;
	}
}
