package ie.wit.assignment.exceptions;

/**
 * Created by Joe on 16/11/2015.
 */
public class PasswordInvalidException extends Exception
{
	public PasswordInvalidException()
	{
		super();
	}

	public PasswordInvalidException(String message)
	{
		super(message);
	}
}
