package ie.wit.assignment.implementableObjects;



public class Doctor 
{
	private String doctorId;
	private String doctorFName;
	private String doctorLName;
	private String address01;
	private String address02;
	private String contactNo;
	
	public Doctor(String doctorFName, String doctorLName, String address01, String address02,
			String contactNo) 
	{
		/*doctorId = "dr" + (DoctorCollector.getTotalDoctors() + 1);*/
		this.doctorFName = doctorFName;
		this.doctorLName = doctorLName;
		this.address01 = address01;
		this.address02 = address02;
		this.contactNo = contactNo;
	}

	public String getDoctorId() 
	{
		return doctorId;
	}

	public void setDoctorId(String doctorId) 
	{
		this.doctorId = doctorId;
	}

	public String getDoctorFName() 
	{
		return doctorFName;
	}

	public void setDoctorFName(String doctorFName) 
	{
		this.doctorFName = doctorFName;
	}

	public String getDoctorLName() 
	{
		return doctorLName;
	}

	public void setDoctorLName(String doctorLName) 
	{
		this.doctorLName = doctorLName;
	}

	public String getAddress01() {
		return address01;
	}

	public void setAddress01(String address01) 
	{
		this.address01 = address01;
	}

	public String getAddress02() 
	{
		return address02;
	}

	public void setAddress02(String address02) 
	{
		this.address02 = address02;
	}

	public String getContactNo() 
	{
		return contactNo;
	}

	public void setContactNo(String contactNo) 
	{
		this.contactNo = contactNo;
	}
	public String toString()
	{
		return "\n\nDoctor Name:\tDr. " + doctorFName + " " + doctorLName 
				+ "\nDoctor Id:\t" + doctorId + "\nAddress:\t" + address01 + " " + address02 
				+ "\nContact Number:\t" + contactNo;
	}
}
