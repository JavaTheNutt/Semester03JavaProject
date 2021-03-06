package ie.wit.assignment.exceptions;
/*This exception is thrown when a user tries to perform an operation on an empty list*/
public class ListEmptyException extends Exception
{
	public ListEmptyException()
	{
		super("List Empty");
	}

	public ListEmptyException(String message)
    {
		super(message);
	}

	public ListEmptyException(Throwable cause)
    {
		super(cause);
	}

	public ListEmptyException(String message, Throwable cause)
    {
		super(message, cause);
	}

	public ListEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
