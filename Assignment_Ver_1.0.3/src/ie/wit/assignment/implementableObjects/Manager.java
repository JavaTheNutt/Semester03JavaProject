/*This class holds the details of each individual team manager. Since each age division is managed 
 * by a team of two managers, each manager object will hold a reference to their partner*/
package ie.wit.assignment.implementableObjects;



public class Manager 
{
	private String managerId;
	private String partnerId;
	private String managerFName;
	private String managerLName;
	private String managerContactNo;
	private String managerAddress01;
	private String managerAddress02;
	private String ageDivision;
	
	public Manager(String partnerId, String managerFName, String managerLName,
			String managerContactNo, String managerAddress01, String managerAddress02, String ageDivision) {
		/*managerId = "mn" + (ManagerCollector.getTotalManagers() + 1);*/
		this.partnerId = partnerId;
		this.managerFName = managerFName;
		this.managerLName = managerLName;
		this.managerContactNo = managerContactNo;
		this.managerAddress01 = managerAddress01;
		this.managerAddress02 = managerAddress02;
		this.ageDivision = ageDivision;
	}

	public Manager() 
	{
		
	}

	public String getManagerId() 
	{
		return managerId;
	}

	public void setManagerId(String managerId) 
	{
		this.managerId = managerId;
	}

	public String getPartnerId() 
	{
		return partnerId;
	}

	public void setPartnerId(String partnerId) 
	{
		this.partnerId = partnerId;
	}

	public String getManagerFName() 
	{
		return managerFName;
	}

	public void setManagerFName(String managerFName) 
	{
		this.managerFName = managerFName;
	}

	public String getManagerLName() 
	{
		return managerLName;
	}

	public void setManagerLName(String managerLName) 
	{
		this.managerLName = managerLName;
	}

	public String getManagerContactNo() 
	{
		return managerContactNo;
	}

	public void setManagerContactNo(String managerContactNo) 
	{
		this.managerContactNo = managerContactNo;
	}

	public String getManagerAddress01() 
	{
		return managerAddress01;
	}

	public void setManagerAddress01(String managerAddress01) 
	{
		this.managerAddress01 = managerAddress01;
	}

	public String getManagerAddress02() 
	{
		return managerAddress02;
	}

	public void setManagerAddress02(String managerAddress02) 
	{
		this.managerAddress02 = managerAddress02;
	}

	public String getAgeDivision() 
	{
		return ageDivision;
	}

	public void setAgeDivision(String ageDivision) 
	{
		this.ageDivision = ageDivision;
	}
	public String toString()
	{
		return "\n\nName:\t" + managerFName + " " + managerLName + "\nManager ID:\t" + managerId + "\nManager Address:\t" + managerAddress01 + " "
				+ managerAddress02 + "\nAge Division:\t" + ageDivision;
	}
		
}
