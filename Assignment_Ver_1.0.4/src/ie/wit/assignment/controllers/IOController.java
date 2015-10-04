package ie.wit.assignment.controllers;

import java.io.File;
import java.util.ArrayList;

import ie.wit.assignment.Main;
import ie.wit.assignment.collectables.Collectable;
import ie.wit.assignment.collectables.Manager;
import ie.wit.assignment.collectors.Collector;
import ie.wit.assignment.fileHandling.ManagerFileHandler;

public class IOController 
{
	public static boolean checkExistance(File fileIn)
	{
		try{
			if(fileIn.exists()){
				return true;
			} else {
				System.out.println("does not exist");
				return false;
			}
		} catch(Exception e){
			return false;
		}
	}
	public static boolean createFile(ArrayList<Collectable> listIn, int size, File fileIn)
	{
		try{
			ManagerFileHandler.writeOut(listIn, size, fileIn);
			return true;
		}catch(Exception e){
			System.out.println("File write failed");
			return false;
		}
	}
	public static ArrayList<Collectable> readList(File fileIn){
		try{
			return ManagerFileHandler.readIn(fileIn);
		} catch(Exception e){
			return null;
		}
	}
}
