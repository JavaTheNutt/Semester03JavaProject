package ie.wit.assignment.fileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ie.wit.assignment.Main;
import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Manager;

public class ManagerFileHandler 
{
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	
	public static void writeOut(ArrayList<Collectable>  list, int size, File fileIn)throws FileNotFoundException, IOException
	{
		oos = new ObjectOutputStream(new FileOutputStream(fileIn));
		oos.writeInt(size);
		oos.writeObject(list);
		oos.close();
	}
	
	public static ArrayList<Collectable> readIn(File fileIn) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		int tempSize;
		ArrayList<Collectable> temp = null;
		ois = new ObjectInputStream(new FileInputStream(fileIn));
		tempSize = ois.readInt();
		Main.setTempSize(tempSize);
		temp = (ArrayList<Collectable>) ois.readObject();
		ois.close();
		return temp;
	}
}
