package ie.wit.assignment.collections;

import ie.wit.assignment.implementableObjects.Doctor;
import ie.wit.assignment.implementableObjects.Manager;

public abstract class ListOfObjects 
{
	protected Object[] list;
	protected int totalObjects;
	
	protected final int MANAGER_REF = 1;
	protected final int DOCTOR_REF = 2;
	
	protected ListOfObjects()
	{
		totalObjects = 0;
		list = new Object[10];
	}
	protected ListOfObjects(int sizeIn, int type)
	{
		totalObjects = 0;
		switch(type){
		case 1:
			list = new Manager[sizeIn];
			break;
		case 2:
			list = new Doctor[sizeIn];
			break;
		}
	}
	protected boolean add(Object obj)
	{
		if(!isFull()){
			list[totalObjects] = obj;
			return true;
		}
		return false;
	}
	protected boolean isFull()
	{
		if(totalObjects == list.length){
			return true;
		}
		return false;
	}
	protected boolean isEmpty(){
		if(totalObjects == 0){
			return true;
		}
		return false;
	}

	
}