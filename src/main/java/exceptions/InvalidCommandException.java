package exceptions;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(String s) {
        super(s);
    }
}
