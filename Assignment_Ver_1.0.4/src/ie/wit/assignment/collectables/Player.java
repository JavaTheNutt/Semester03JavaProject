package ie.wit.assignment.collectables;

import java.util.Calendar;
import java.util.Date;
import java.time.*;

public class Player extends Collectable {
	
	private String ageDivision;
	private int ageThisYear;
	private int day;
	private int month;
	private int year;
	

	public Player(int index, String fName, String lName, String address01, String address02, String contactNo, String email, int day, int month, int year, String drId) 
	{
		super(fName, lName, address01, address02, contactNo, email);
		id = "pl" + (index + 1);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		ageThisYear = currentYear - year;
		this.day = day;
		this.month = month;
		this.year = year;
		switch(ageThisYear){
		case 6:
			ageDivision = "U-7";
			break;
		case 7:
			ageDivision = "U-8";
			break;
		case 8:
			ageDivision = "U-9";
			break;
		case 9:
			ageDivision = "U-10";
			break;
		case 10:
			ageDivision = "U-11";
			break;
		case 11:
			ageDivision = "U-12";
			break;
		case 12:
			ageDivision = "U-13";
			break;
		case 13:
			ageDivision = "U-14";
			break;
		case 14:
			ageDivision = "U-15";
			break;
		case 15:
			ageDivision = "U-16";
			break;
		case 16:
			ageDivision = "U-17";
		case 17:
			ageDivision = "Junior";
			break;
		
		}
		
	}
	
	public String getAgeDivision() 
	{
		return ageDivision;
	}

	public void setAgeDivision(String ageDivision) 
	{
		this.ageDivision = ageDivision;
	}

	public int getDay() 
	{
		return day;
	}

	public void setDay(int day) 
	{
		this.day = day;
	}

	public int getMonth() 
	{
		return month;
	}

	public void setMonth(int month) 
	{
		this.month = month;
	}

	public int getYear() 
	{
		return year;
	}

	public void setYear(int year) 
	{
		this.year = year;
	}

	@Override
	public  String toString()
	{
		return super.toString() + "\nDate of Birth:\t" + day + "/" + month + "/" + year + "\nAge Division:\t" + ageDivision;
	}
}
