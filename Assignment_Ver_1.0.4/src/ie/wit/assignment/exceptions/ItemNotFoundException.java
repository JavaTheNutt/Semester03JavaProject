package ie.wit.assignment.exceptions;
/*This exception is thrown when a user requests an item that does not exist*/
public class ItemNotFoundException extends Exception
{

	public ItemNotFoundException()
    {
		super("Item not found");
	}

	public ItemNotFoundException(String message)
    {
		super(message);
	}

	public ItemNotFoundException(Throwable cause)
    {
		super(cause);
	}

	public ItemNotFoundException(String message, Throwable cause)
    {
		super(message, cause);
	}

	public ItemNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
