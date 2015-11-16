package ie.wit.assignment.accounts;

import java.io.Serializable;

/**
 * Created by Joe on 16/11/2015.
 */
public class Account implements Serializable, Comparable<String>
{
	private String username;
	private String password;
	private boolean admin;

	public Account(String username, String password, boolean admin)
	{
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean isAdmin()
	{
		return admin;
	}

	public void setAdmin(boolean admin)
	{
		this.admin = admin;
	}

	@Override
	public int compareTo(String o)
	{
		return username.compareTo(o);
	}
}
