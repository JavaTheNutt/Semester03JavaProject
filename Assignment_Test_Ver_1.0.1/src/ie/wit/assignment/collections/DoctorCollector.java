package ie.wit.assignment.collections;

import ie.wit.assignment.implementableObjects.Doctor;

public class DoctorCollector 
{
	public Doctor[] listOfDoctors;
	public int totalDoctors;
	
	public DoctorCollector(int maxSize){
		listOfDoctors = new Doctor[maxSize];
		totalDoctors = 0;
	}
	
	public DoctorCollector(){
		listOfDoctors = new Doctor[10];
		totalDoctors = 0;
	}
	
	private boolean isFull(){
		if(totalDoctors == listOfDoctors.length){
			return true;
		}
		return false;
	}
	
	private boolean isEmpty(){
		if (totalDoctors == 0){
			return true;
		}
		return false;
	}
	
	private String search(String idIn){
		if(isEmpty()){
			return "List Empty";
		}
		for(int i = 0; i < totalDoctors; i++){
			if(idIn.equals(listOfDoctors[i].getDoctorId())){
				return listOfDoctors[i].getDoctorId();
			}
		}
		return "No such Doctor";
	}
	
	public boolean addDoctor(Doctor docIn){
		if(!isFull()){
			listOfDoctors[totalDoctors] = docIn;
			totalDoctors++;
			return true;
		}
		return false;
	}
	
	public boolean removeDoctor(String idIn){
		String docId = search(idIn);
		if(isEmpty()){
			return false;
		}
		if(docId.equals("No such Doctor")){
			return false;
		}
		for(int i = 0; i <= totalDoctors -2; i++){
			list[]
		}
		
	}
	
}
