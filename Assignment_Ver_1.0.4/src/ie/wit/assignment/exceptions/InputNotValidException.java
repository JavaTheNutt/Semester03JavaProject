package ie.wit.assignment.exceptions;
/*This exception will be thrown when the user enters a value that is invalid
(such as an ID that does not have the correct letters at the beginning)*/
public class InputNotValidException extends Exception
{
    public InputNotValidException()
    {
        super("The input does not match a saved value");
    }

    public InputNotValidException(String message)
    {
        super(message);
    }
}
