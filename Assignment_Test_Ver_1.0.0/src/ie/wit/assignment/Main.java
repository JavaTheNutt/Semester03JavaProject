package ie.wit.assignment;
import ie.wit.assignment.doctor.*;
public class Main {

	public static void main(String[] args) 
	{
		Doctor testDoc = new Doctor("1", "Ahcim", "Shlunke", "22 Low Street", "Thomastown", "0567768867");
		DoctorManager doctorList = new DoctorManager(5);
		
		boolean test = doctorList.addDoctor(testDoc);
		System.out.println(doctorList.listAll());
		boolean test01 = doctorList.removeDoctor("1");
		System.out.println(test01);
		System.out.println(doctorList.listAll());
	}

}
