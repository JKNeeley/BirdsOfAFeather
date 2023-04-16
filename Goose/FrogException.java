package Goose;

public class FrogException extends Exception
{
    public FrogException()
    {
        super();
    }
    public static void invalidNameException()
    {
        System.out.println("|                                                                   |");
        System.out.println("| ------------------------ Frog:  bad name ------------------------ |");
        System.out.println("|                                                                   |");
    }

    public void invalidActionException(String message, Exception cause)
    {
        System.out.println("|                                                                   |");
        System.out.println("| ----------------------- Frog:  bad action ----------------------- |");
        System.out.println("|                                                                   |");
    }

    public void noStuffException()
    {
        System.out.println("|                                                                   |");
        System.out.println("| ------------------------ Frog:  no stuff ------------------------ |");
        System.out.println("|                                                                   |");
    }
    
}
