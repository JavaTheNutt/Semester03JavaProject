package ie.wit.assignment.exceptions;

/**
 * Created by Joe on 17/11/2015.
 */
public class GroupMismatchException extends Exception
{
	public GroupMismatchException()
	{
		super("The items do not match");
	}

	public GroupMismatchException(String message)
	{
		super(message);
	}
}
