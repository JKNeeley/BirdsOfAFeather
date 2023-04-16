package Goose;

import java.util.*;

public class HonkUtil 
{
    public static Goose makeUserGoose()
    {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("| What is your goose's name? (10 characters)                        |");
        String gooseName = inputScanner.nextLine();
        gooseName = HonkUtil.makeValidName(gooseName);
        Goose newGoose = new Goose(gooseName);
        System.out.println("| You now have a goose named: " + newGoose.getName() + "                            |");
        inputScanner.close();
        return newGoose;
    }

    public static void liveGooseLife(Goose thisGoose)
    {
        Scanner inputScanner = new Scanner(System.in);
        thisGoose.getActionOptions();
        while(thisGoose.isAlive()) 
        {
            for(int i=0; i<3; i++)
            {
                System.out.println("| What is your goose's action?                                      |");
                int gooseAction = thisGoose.getAction(inputScanner);
                thisGoose.doAction(gooseAction);
                System.out.println("|                                                                   |");
            }
            thisGoose.ageGoose();
        }
        inputScanner.close();
    }

    public static boolean checkName(String n)
    {
        if(n.isEmpty() || n.isBlank() || (n.length() > 10))
        {
            FrogException.invalidNameException();
            return false;
        }
        return true;
    }

    public static String makeValidName(String n)
    {
        String newN = n;
        if(!checkName(n))
        {
            return "no Name   ";
        }
        int length = newN.length();
        while(length < 10)
        {
            newN = newN.concat(" ");
            length++;
        }
        return newN;
    }

    public static void pause()
    {
        for(int i=0; i<50; i++)
        {
            
        }
    }
}
