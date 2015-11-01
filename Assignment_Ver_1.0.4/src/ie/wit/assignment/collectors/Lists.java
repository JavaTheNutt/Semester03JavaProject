package ie.wit.assignment.collectors;

public abstract class Lists
{
	public static NewCollector managerList;
	public static NewCollector doctorList;
	public static NewCollector playerList;

	public static void createLists(){
		managerList = new NewCollector();
		doctorList = new NewCollector();
		playerList = new NewCollector();
	}

	public static NewCollector setType(int type)
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
