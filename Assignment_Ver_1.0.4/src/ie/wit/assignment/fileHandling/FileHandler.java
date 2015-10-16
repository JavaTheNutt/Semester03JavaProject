package ie.wit.assignment.fileHandling;

import ie.wit.assignment.InitialSetup;
import ie.wit.assignment.collectables.Collectible;

import java.io.*;
import java.util.List;

/*This class deals with writing to, and reading from files*/
public class FileHandler
{
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	
	public static void writeOut(List<Collectible> list, int size, File fileIn)throws FileNotFoundException, IOException
	{
		oos = new ObjectOutputStream(new FileOutputStream(fileIn));
		oos.writeInt(size);
		oos.writeObject(list);
		oos.close();
	}
	
	public static List<Collectible> readIn(File fileIn) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		int tempSize;
		List<Collectible> temp = null;
		ois = new ObjectInputStream(new FileInputStream(fileIn));
		tempSize = ois.readInt();
		/*This variable is temporarily set, then the method that calls this method will use that
		* value to set the size of the list before attempting to read another list*/
		InitialSetup.setTempSize(tempSize);
		temp = (List<Collectible>) ois.readObject();
		ois.close();
		return temp;
	}
}
