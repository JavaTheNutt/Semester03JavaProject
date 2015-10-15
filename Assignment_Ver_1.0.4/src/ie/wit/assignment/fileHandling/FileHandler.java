package ie.wit.assignment.fileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import ie.wit.assignment.InitialSetup;
import ie.wit.assignment.collectables.Collectable;

/*This class deals with writing to, and reading from files*/
public class FileHandler
{
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	
	public static void writeOut(List<Collectable> list, int size, File fileIn)throws FileNotFoundException, IOException
	{
		oos = new ObjectOutputStream(new FileOutputStream(fileIn));
		oos.writeInt(size);
		oos.writeObject(list);
		oos.close();
	}
	
	public static List<Collectable> readIn(File fileIn) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		int tempSize;
		List<Collectable> temp = null;
		ois = new ObjectInputStream(new FileInputStream(fileIn));
		tempSize = ois.readInt();
		/*This variable is temporarily set, then the method that calls this method will use that
		* value to set the size of the list before attempting to read another list*/
		InitialSetup.setTempSize(tempSize);
		temp = (List<Collectable>) ois.readObject();
		ois.close();
		return temp;
	}
}
