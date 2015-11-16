package ie.wit.assignment;

import ie.wit.assignment.accounts.Account;
import ie.wit.assignment.accounts.AccountCollector;
import ie.wit.assignment.controllers.ValidationController;
import ie.wit.assignment.fileHandling.FileHandler;
import ie.wit.assignment.implObjects.*;
import ie.wit.assignment.controllers.IOController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
	private static Parent testParent01 = new Parent(
			0,
			"Jane",
			"Bloggs",
			"Jerpoint Abbey",
			"Thomastown",
			"222222222",
			"kjdid@jsdsi.sdsd",
			"Cheque",
			4,
			2
	);
	private static Parent testParent02 = new Parent(
			0,
			"Jamie",
			"Bloggs",
			"Jerpoint Abbey",
			"Thomastown",
			"222222222",
			"kjdid@jsdsi.sdsd",
			"Cheque",
			4,
			1
	);
	private static Player testPlayer01 = new Player(0,
			"James",
			"Murphy",
			"Jerpoint Abbey",
			"Thomastown,",
			"11111111",
			"me@me.com",
			12,
			11,
			2000,
			"dr1",
			"pr1");
	private static Player testPlayer02 = new Player(1,
			"John",
			"Walsh",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2005,
			"dr1",
			"pr1");
	private static Player testPlayer03 = new Player(2,
			"Jason",
			"Ulrich",
			"Dunhill",
			"Bennetsbridge",
			"33333333",
			"them@them.com",
			16,
			5,
			2004,
			"dr1",
			"pr1");
	private static Player testPlayer04 = new Player(3,
			"Jack",
			"Taylor",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2003,
			"dr1",
			"pr1");
	private static Player testPlayer05 = new Player(4,
			"Micheal",
			"Osbourne",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2002,
			"dr1",
			"pr1");
	private static Player testPlayer06 = new Player(5,
			"Paddy",
			"Darrell",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2001,
			"dr1",
			"pr1");
	private static Player testPlayer07 = new Player(6,
			"Mary",
			"Hetfield",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			1999,
			"dr1",
			"pr1");
	private static Player testPlayer08 = new Player(7,
			"Susan",
			"Morrission",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2006,
			"dr1",
			"pr1");
	private static Player testPlayer09 = new Player(8,
			"Michelle",
			"Manzerak",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2007,
			"dr1",
			"pr1");
	private static Player testPlayer10 = new Player(9,
			"Steve",
			"Plant",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2008,
			"dr1",
			"pr1");
	private static Player testPlayer11 = new Player(10,
			"Liam",
			"Page",
			"Tullaroan",
			"Dungarven",
			"222222222",
			"you@you.com",
			16,
			5,
			2009,
			"dr1",
			"pr1");
	private static Account testAccount01 = new Account("admin", "root", true);
	private static Account testAccount02 = new Account("testGuy11", "pass", false);
	private static Collectible[] playerHolder = {testPlayer01, testPlayer02, testPlayer03, testPlayer04, testPlayer05, testPlayer06, testPlayer07, testPlayer08, testPlayer09, testPlayer10, testPlayer11};
	private static Collectible[] managerHolder = {testMan01, testMan02};
	private static Collectible[] doctorHolder = {testDoc01, testDoc02};
	private static Collectible[] parentHolder ={testParent01};
	private static Account[] accountHolder = {testAccount01, testAccount02};

	/*This will temporarily hold the size of the lists being read in until it is
	 * passed to the collection class*/
	private static int tempSize;
	public static File managers = new File("managers.dat");
	public static File doctors = new File("doctors.dat");
	public static File players = new File("players.dat");
	public static File parents = new File("parents.dat");
	public static File accounts = new File("accounts.dat");



	/*This encloses the method below in a try...catch block and calls it once for each list */
	public static boolean gatherItemsInSystem()
	{
		try {
			if (checkAndAdd(1) && checkAndAdd(2) && checkAndAdd(3) && checkAndAdd(4)) {
				if (createAccounts()) {
					return true;
				}
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
		Collector tempList = Lists.setType(type);
		Collectible[] tempArray = getTempFiles(type);

		if (!IOController.checkExistance(tempFile)) {
			for (Collectible item : tempArray) {
				tempList.addItem(item);
			}
			IOController.createFile(tempList, ItemCounter.getItem(type), tempFile);
			return true;
		} else {
			if (IOController.readList(tempFile) != null) {
				ItemCounter.setItem(type, tempSize + 1);
				/*switch (type) {
					case 1:
						Lists.managerList = IOController.readList(tempFile);
						break;
					case 2:
						Lists.doctorList = IOController.readList(tempFile);
						break;
					case 3:
						Lists.playerList = IOController.readList(tempFile);
						break;
					case 4:
						Lists.parentList = IOController.readList(tempFile);
						break;
				}*/
				tempList = IOController.readList(tempFile);
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
			case 4:
				tempFile = parents;
		}
		return tempFile;
	}

	/*This gets the temporary data stored in the array*/
	private static Collectible[] getTempFiles(int type)
	{
		switch (type) {
			case 1:
				return managerHolder;
			case 2:
				return doctorHolder;
			case 3:
				return playerHolder;
			case 4:
				return parentHolder;
			default:
				return null;
		}
	}

	public static void setTempSize(int tempSizeIn)
	{
		tempSize = tempSizeIn;
	}

	public static boolean createAccounts(){
		try{
			if(IOController.checkExistance(accounts)){
				ArrayList<Account> list;
				list = (ArrayList<Account>) FileHandler.readAccountIn(accounts);
				AccountCollector.setList(list);
				return true;
			} else {
				FileHandler.writeOut(accountHolder, accounts);
				return true;
			}
		}catch(ClassNotFoundException | IOException e){
			e.printStackTrace();
			return false;
		}

	}

}


