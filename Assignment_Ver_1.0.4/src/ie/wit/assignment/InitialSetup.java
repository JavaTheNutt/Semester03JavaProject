package ie.wit.assignment;

import ie.wit.assignment.collectables.Collectible;
import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.collectors.NewCollector;
import ie.wit.assignment.controllers.Controller;
import ie.wit.assignment.controllers.IOController;

import java.io.File;
import java.util.List;

/*This class will handle initial IO operations. If the *.dat files are deleted, this class
* will create them again and add the initial dummy data again*/
public abstract class InitialSetup
{
	private static Manager testMan02 = new Manager(1,
			"Jason",
			"Bloggs",
			"Pipe Street",
			"Thomastown",
			"0567734343",
			"example@test.ie",
			"U-12");
	private static Manager testMan01 = new Manager(0,
			"Joe",
			"Bloggs",
			"Low Street",
			"Thomastown",
			"0567734343",
			"example@test.ie",
			"U-12");
	private static Doctor testDoc01 = new Doctor(0, "Achim", "Shlunke", "Low Street", "Thomastown", "0567724162");
	private static Doctor testDoc02 = new Doctor(1, "James", "Drynan", "Mill Street", "Thomastown", "0567768118");
	private static Player testPlayer01 = new Player(0,
			"James",
			"Bloggs",
			"Jerpoint Abbey",
			"Thomastown,",
			"11111111",
			"me@me.com",
			12,
			11,
			2000,
			"dr1");
	private static Player testPlayer02 = new Player(1,
			"John",
			"Bloggs",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2005,
			"dr1");
	private static Player testPlayer03 = new Player(2,
			"Jason",
			"Bloggs",
			"Dunhill",
			"Bennetsbridge",
			"33333333",
			"them@them.com",
			16,
			5,
			2004,
			"dr1");
	private static Player testPlayer04 = new Player(3,
			"Jack",
			"Bloggs",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2003,
			"dr1");
	private static Player testPlayer05 = new Player(4,
			"Micheal",
			"Bloggs",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2002,
			"dr1");
	private static Player testPlayer06 = new Player(5,
			"Paddy",
			"Bloggs",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2001,
			"dr1");
	private static Player testPlayer07 = new Player(6,
			"Mary",
			"Bloggs",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			1999,
			"dr1");
	private static Player testPlayer08 = new Player(7,
			"Susan",
			"Bloggs",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2006,
			"dr1");
	private static Player testPlayer09 = new Player(8,
			"Michelle",
			"Bloggs",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2007,
			"dr1");
	private static Player testPlayer10 = new Player(9,
			"Steve",
			"Bloggs",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2008,
			"dr1");
	private static Player testPlayer11 = new Player(10,
			"Liam",
			"Bloggs",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2009,
			"dr1");
	private static Player[] playerHolder = {testPlayer01, testPlayer02, testPlayer03, testPlayer04, testPlayer05, testPlayer06, testPlayer07, testPlayer08, testPlayer09, testPlayer10, testPlayer11};
	private static Manager[] managerHolder = {testMan01, testMan02};
	private static Doctor[] doctorHolder = {testDoc01, testDoc02};

	/*This will temporarily hold the size of the lists being read in until it is
	 * passed to the collection class*/
	private static int tempSize;
	public static File managers = new File("managers.dat");
	public static File doctors = new File("doctors.dat");
	public static File players = new File("players.dat");


	/*This encloses the method below in a try...catch block and calls it once for each list */
	public static boolean gatherItemsInSystem()
	{
		try {
			if (checkAndAdd(1) && checkAndAdd(2) && checkAndAdd(3)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/*This class reads the object from the file and adds them to the
	* appropriate array*/
	private static boolean checkAndAdd(int type)
	{
		File tempFile = setFile(type);
		List<Collectible> tempList = Collector.setType(type);
		Collectible[] tempArray = getTempFiles(type);

		if (!IOController.checkExistance(tempFile)) {
			for (Collectible item : tempArray) {
				Controller.addItem(item, type);
			}
			IOController.createFile(tempList, Collector.getAmount(type), tempFile);
			return true;
		} else {
			if (IOController.readList(tempFile) != null) {
				switch (type) {
					case 1:
						Collector.numberOfManagers = tempSize + 1;
						Collector.setManagerList(IOController.readList(tempFile));
						break;
					case 2:
						Collector.numberOfDoctors = tempSize + 1;
						Collector.setDoctorList(IOController.readList(tempFile));
						break;
					case 3:
						Collector.numberOfPlayers = tempSize + 1;
						Collector.setPlayerList(IOController.readList(tempFile));
						break;
				}
				return true;
			} else {
				return false;
			}
		}

	}

	/*This sets the file to be written to*/
	private static File setFile(int type)
	{
		File tempFile = null;
		switch (type) {
			case 1:
				tempFile = managers;
				break;
			case 2:
				tempFile = doctors;
				break;
			case 3:
				tempFile = players;
				break;
		}
		return tempFile;
	}

	/*This gets the temporary data stored in the array*/
	private static Collectible[] getTempFiles(int type)
	{
		Collectible[] tempArray = null;
		switch (type) {
			case 1:
				tempArray = managerHolder;
				break;
			case 2:
				tempArray = doctorHolder;
				break;
			case 3:
				tempArray = playerHolder;
				break;
		}
		return tempArray;
	}

	public static void setTempSize(int tempSizeIn)
	{
		tempSize = tempSizeIn;
	}
}


