package ie.wit.assignment.fileHandling;

import ie.wit.assignment.InitialSetup;
import ie.wit.assignment.implObjects.Collector;

import java.io.*;

/*This class deals with writing to, and reading from files*/
public class FileHandler
{
	public static void writeOut(Collector list, int size, File fileIn)throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileIn));
		oos.writeInt(size);
		oos.writeObject(list);
		oos.close();
	}
	
	public static Collector readIn(File fileIn) throws IOException, ClassNotFoundException
	{
		int tempSize;
		Collector temp = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileIn));
		tempSize = ois.readInt();
		/*This variable is temporarily set, then the method that calls this method will use that
		* value to set the size of the list before attempting to read another list*/
		InitialSetup.setTempSize(tempSize);
		temp = (Collector) ois.readObject();
		ois.close();
		return temp;
	}
}
