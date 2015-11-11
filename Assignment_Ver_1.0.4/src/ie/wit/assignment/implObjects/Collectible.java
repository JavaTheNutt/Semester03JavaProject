/*This is the class that all collectible objects in this program
 * inherit from.*/
package ie.wit.assignment.implObjects;

import java.io.Serializable;

public class Collectible implements Serializable, Comparable<String>
{
	/*Id will be generated in a subclass*/
	protected String id;
	protected String fName;
	protected String lName;
	protected String address01;
	protected String address02;
	protected String contactNo;
	protected int type;

	
	public Collectible(String fName, String lName, String address01, String address02, String contactNo, int type)
	{
		this.fName = fName;
		this.lName = lName;
		this.address01 = address01;
		this.address02 = address02;
		this.contactNo = contactNo;
		this.type = type;
	}

	public  String getId(){
		return id;
	}

	@Override
	public int compareTo(String o)
	{
		return 0;
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getAddress01() {
		return address01;
	}

	public void setAddress01(String address01) {
		this.address01 = address01;
	}

	public String getAddress02() {
		return address02;
	}

	public void setAddress02(String address02) {
		this.address02 = address02;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override 
	public String toString() {
		return "\n\nName:\t" + fName + " " + lName + "\nAddress:\t" + address01 + " " + address02;
	}


	public int getType()
	{
		return type;
	}
}