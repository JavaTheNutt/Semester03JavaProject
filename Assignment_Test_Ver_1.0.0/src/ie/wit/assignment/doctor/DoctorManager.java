package ie.wit.assignment.doctor;

public class DoctorManager 
{
	private Doctor [] listOfDoctors;
	private int currentDoctors;
	private int maxSize;
	
	public DoctorManager(int maxSize) 
	{
		this.maxSize = maxSize;
		listOfDoctors = new Doctor[maxSize];
		currentDoctors = 0;
	}
	
	public boolean addDoctor(Doctor doctorIn)
	{
		if(!isFull())
		{
			listOfDoctors[currentDoctors] = doctorIn;
			currentDoctors++;
			System.out.println(currentDoctors + " " + maxSize);
			return true;
		}
		return false;
	}
	
	public boolean removeDoctor(String idIn){
		if(search(idIn) != -999){
			for(int i = search(idIn); i < currentDoctors - 2; i++){
				listOfDoctors[i] = listOfDoctors[i+1];
			}
			currentDoctors --;
			return true;
		}
		return false;
	}
	
	private int search(String idIn){
		for(int i = 0; i < currentDoctors; i++){
			if(idIn.equals(listOfDoctors[i].getDoctorId())){
				return i;
			}
		}
		return -999;
	}
	public boolean isFull()
	{
		if (currentDoctors == maxSize){
			return true;
		}
		return false;
	}
	public boolean isEmpty()
	{
		if(currentDoctors == 0){
			return true;
		}
		return false;
	}
	public String listAll()
	{
		String tempString = "";
		if(isEmpty()){
			tempString = "Nothing to display";
		} else{
			for(int i = 0; i < currentDoctors; i++){
				tempString += listOfDoctors[i].toString();
			}
		}
		return tempString;
	}
}
