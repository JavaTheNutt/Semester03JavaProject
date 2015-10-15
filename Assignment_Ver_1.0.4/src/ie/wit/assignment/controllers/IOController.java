package ie.wit.assignment.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.fileHandling.FileHandler;

/*This class handles exceptions that may be thrown by the IO process*/
public class IOController 
{
	public static boolean checkExistance(File fileIn)
	{
		try{
			if(fileIn.exists()){
				return true;
			} else {
				return false;
			}
		} catch(Exception e){
			return false;
		}
	}
	public static boolean createFile(List<Collectable> listIn, int size, File fileIn)
	{
		try{
			FileHandler.writeOut(listIn, size, fileIn);
			return true;
		}catch(Exception e){
			System.out.println("File write failed");
			return false;
		}
	}
	public static List<Collectable> readList(File fileIn){
		try{
			return FileHandler.readIn(fileIn);
		} catch(Exception e){
			return null;
		}
	}
}
