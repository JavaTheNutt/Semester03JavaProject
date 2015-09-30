package ie.wit.assignment.collections;

import ie.wit.assignment.implementableObjects.Doctor;

public class DoctorCollector 
{
	private Doctor[] listOfDoctors;
	private static int totalDoctors;
	
	public DoctorCollector(int maxSize)
	{
		listOfDoctors = new Doctor[maxSize];
		totalDoctors = 0;
	}
	
	public DoctorCollector()
	{
		listOfDoctors = new Doctor[10];
		totalDoctors = 0;
	}
	
	private boolean isFull()
	{
		if(totalDoctors == listOfDoctors.length){
			return true;
		}
		return false;
	}
	
	private boolean isEmpty()
	{
		if (totalDoctors == 0){
			return true;
		}
		return false;
	}
	
	private int search(String idIn)
	{
		if(isEmpty()){
			//return -888 if array is empty
			return -888;
		}
		for(int i = 0; i < totalDoctors; i++){
			if(idIn.equals(listOfDoctors[i].getDoctorId())){
				return i;
			}
		}
		//return -999 if id does not exist
		return -999;
	}
	public static int getTotalDoctors()
	{
		return totalDoctors;
	}
	public boolean addDoctor(Doctor docIn)
	{
		if(!isFull()){
			listOfDoctors[totalDoctors] = docIn;
			totalDoctors++;
			return true;
		}
		return false;
	}
	
	public boolean removeDoctor(String idIn)
	{
		int index = search(idIn);
		if (index == -888 || index == -999){
			return false;
		}
		for (int i = index; i <= totalDoctors -2; i++){
			listOfDoctors[i] = listOfDoctors[i + 1];
		}
		totalDoctors --;
		return true;
		
	}
	
	public Doctor getDoctor(String idIn)
	{
		int index = search(idIn);
		if(index == -888 || index == -999){
			return null;
		} else {
			return listOfDoctors[index];
		}
	}
	
	public String listAll()
	{
		String tempString = "";
		if(isEmpty()){
			tempString = "Nothing to display";
		} else {
			for(int i = 0; i < totalDoctors; i++){
				tempString += listOfDoctors[i].toString();
			}
		}
		return tempString;
	}
	
}
