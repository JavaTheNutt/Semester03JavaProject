package ie.wit.assignment;

import java.io.File;
import java.util.ArrayList;

import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Doctor;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectables.Player;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.controllers.Controller;
import ie.wit.assignment.controllers.IOController;

public abstract class InitialSetup 
{
	private static Manager testMan02 = new Manager(2, "Jason", "Bloggs","Pipe Street", "Thomastown","0567734343","example@test.ie","u-12");
	private static Manager testMan01 = new Manager(1, "Joe", "Bloggs", "Low Street", "Thomastown","0567734343","example@test.ie", "u-12");
	private static Doctor testDoc01 = new Doctor(1, "Achim", "Shlunke", "Low Street", "Thomastown", "0567724162");
	private static Doctor testDoc02 = new Doctor(2, "James", "Drynan", "Mill Street", "Thomastown", "0567768118");
	private static Player testPlayer01 = new Player(1, "James", "Bloggs", "Jerpoint Abbey", "Thomastown,", "11111111", "me@me.com", 12, 11, 2000, "dr1");
	private static Player testPlayer02 = new Player(2, "John", "Bloggs", "Tullaroan", "Dungarven", "222222222", "you@you.com", 16, 5, 2005, "dr2");
	private static Player[] playerHolder = {testPlayer01, testPlayer02};
	private static Manager[] managerHolder = {testMan01, testMan02};
	private static Doctor[] doctorHolder = {testDoc01, testDoc02};
	
	/*This will temporarily hold the size of the lists being read in until it is
	 * passed to the collection class*/
	public static int tempSize;
	public static File managers = new File("managers.dat");
	public static File doctors = new File("doctors.dat");
	public static File players = new File("players.dat");
	
	
	public static boolean gatherItemsInSystem()
	{
		try{
			if(checkAndAdd(1) && checkAndAdd(2) && checkAndAdd(3)){
				return true;
			}
			return false;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	private static boolean checkAndAdd(int type)
	{
		File tempFile = setFile(type);
		ArrayList<Collectable> tempList = Collector.setType(type);
		Collectable[] tempArray = getTempFiles(type);
		
		if(!IOController.checkExistance(tempFile)){
			for(Collectable item : tempArray){
				Controller.addItem(item, type);
			}
			IOController.createFile(tempList, Collector.getAmount(type), tempFile);
			return true;
		} else {
			if(IOController.readList(tempFile) != null){
				switch(type){
				case 1:
					Collector.numberOfManagers = tempSize;
					Collector.setManagerList(IOController.readList(tempFile));
					break;
				case 2:
					Collector.numberOfDoctors = tempSize;
					Collector.setDoctorList(IOController.readList(tempFile));
					break;
				case 3:
					Collector.numberOfPlayers = tempSize;
					Collector.setPlayerList(IOController.readList(tempFile));
					break;
				}
				return true;
			} else {
				return false;
			}
		}
		
	}
	private static File setFile(int type)
	{
		File tempFile = null;
		switch(type){
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
	private static Collectable[] getTempFiles(int type)
	{
		Collectable[] tempArray = null;
		switch(type){
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
	
}
