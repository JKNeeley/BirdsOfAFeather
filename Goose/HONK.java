package Goose;

import java.util.*;

public class HONK 
{
    public static void main(String args[]) throws Exception
    {
    /* game intro */
        System.out.println("|                                                                   |");
        System.out.println("| ***************************   HONK   **************************** |");
        System.out.println("|                                                                   |");
        System.out.println("|                                                         _...--.   |");
        System.out.println("|                                         _____......----'     .'   |");
        System.out.println("|                                   _..-''                   .'     |");
        System.out.println("|                                 .'                       ./       |");
        System.out.println("|                         _.--._.'                       .' |       |");
        System.out.println("|                      .-'                           .-.'  /        |");
        System.out.println("|                    .'   _.-.                     .  |   '         |");
        System.out.println("|                  .'  .'   .'    _    ..,        / `./  :          |");
        System.out.println("|                .'  .'   .'  .--' `.  |  |  |`. |     .'           |");
        System.out.println("|             _.'  .'   .' `.'       `-'   | / |.'   .'             |");
        System.out.println("|          _.'  .-'   .'     `-.            `      .'               |");
        System.out.println("|        .'   .'    .'          `-.._ _ _ _ .-.    :                |");
        System.out.println("|       /    /o _.-'               .--'   .'   |   |                |");
        System.out.println("|     .'-.__..-'                  /..    .`    / .'                 |");
        System.out.println("|   .'   . '                       /.'/.'     /  |                  |");
        System.out.println("|   `--'                                   _.'   '                  |");
        System.out.println("|                                        /.'    .'                  |");
        System.out.println("|                                         /.'/.'                    |");
        System.out.println("|                                                                   |");
        System.out.println("| ***************************************************************** |");
        System.out.println("|                                                                   |");
        System.out.println("| ***********************   GAME   RULES   ************************ |");
        System.out.println("|                                                                   |");
        System.out.println("| Start phase: create your goose!                                   |");
        System.out.println("|        You will choose a name for your new goose.                 |");
        System.out.println("|                                                                   |");
        System.out.println("| Action phase: complete tasks!                                     |");
        System.out.println("|        You will choose an action for your goose to perform.       |");
        System.out.println("|        After each turn, the game's time will progress.            |");
        System.out.println("|        There are 3 turns for each goose-year.                     |");
        System.out.println("|                                                                   |");
        System.out.println("| End phase: celebrate your goose!                                  |");
        System.out.println("|        See your life as a goose.                                  |");
        System.out.println("|        Play again or quit game.                                   |");
        System.out.println("|                                                                   |");
        System.out.println("| ***************************************************************** |");
        System.out.println("|                                                                   |");
        Scanner userInput = new Scanner(System.in);
    /* start phase */
        System.out.println("| ***********************   START  PHASE   ************************ |");
        System.out.println("|                                                                   |");
        System.out.println("| What is your goose's name? (10 characters)                        |");
        String gooseName = userInput.nextLine();
        gooseName = HonkUtil.makeValidName(gooseName);
        Goose userGoose = new Goose(gooseName);
        System.out.println("| You now have a goose named: " + userGoose.getName() + "                            |");

        Space pondSpace = new Space("POND", 100);
        pondSpace.generateStartStuff();
        userGoose.setLocation(pondSpace);
        System.out.println("|                                                                   |");
        System.out.println("| ***************************************************************** |");
        System.out.println("|                                                                   |");
    /* action phase */
        System.out.println("| **********************   ACTION   PHASE   *********************** |");
        System.out.println("|                                                                   |");
        HonkUtil.liveGooseLife(userGoose);
        System.out.println("| ***************************************************************** |");
        System.out.println("|                                                                   |");
    /* end phase */
        System.out.println("| ************************   END  PHASE   ************************* |");
        System.out.println("|                                                                   |");
        userGoose.showPast();
        System.out.println("| ***************************************************************** |");
        userInput.close();
    }
}
