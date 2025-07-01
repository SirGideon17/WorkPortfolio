import java.util.InputMismatchException;

/**
 * This is the main class for the project. It grabs the information from the user
 * and then process it into the simulation. It sets the default for the number of
 * days as 365, number of games as 100, and the social characteristic of the simulation
 * to anarchy.
 * Author: Simeon Grant
 * Date: Feburary 3rd 2025
 */
public class Project1Main {
    
    public static void main(String[] args) throws UsageException {
        if (args.length  < 2 || args.length > 9) {
            throw new UsageException(usageMessage());
        }

        int numGames = 100;
        int numDays = 365;
        boolean social = false;

        //This is a for loop with a switch statement to collect all of the date from the user.
        //This is done by checking if the character at the second position is the right letter or not.
        for (int i = 2; i < args.length; i++) {
            switch (args[i].charAt(1)) {
                case 'd':
                    try {
                        numDays = Integer.parseInt(args[i + 1]);
                    } catch (InputMismatchException Exception) {
                        throw new UsageException("Invalid input for number of Days\n" + usageMessage());
                    }

                    i++;
                    break;

                case 'g':
                    try {
                        numGames = Integer.parseInt(args[i + 1]);
                    } catch (InputMismatchException Exception) {
                        throw new UsageException("Invalid input for number of games\n" + usageMessage());
                    }

                    i++;
                    break;

                case 's':
                try {
                    social = Boolean.parseBoolean(args[i + 1]);
                } catch (InputMismatchException Exception) {
                    throw new UsageException("Invalid input to determine if society is social\n" + usageMessage());
                }
                    i++;
                    break;

                case 'h':
                    showHelpMessage();
                    System.exit(0);
                    break;
                
                default:
                    throw new UsageException(usageMessage());
            }
        }

        //This runs the simulation and shows the data.
        MetaGameData game = new MetaGameData();
        game.playGame(numDays, numGames, social);
        System.out.println();
        game.showData();
        

    }

    //This returns a string to show how to run the program.
    public static String usageMessage() {
        return "\nUsage:\njava Project1Main [-d <number-of-Days>] [-g <number-of-games>] [-s [isSocial]] [-h]";
    }

    //This shows a message of how to run the program and what each opetion means.
    public static void showHelpMessage() {
        System.out.println(usageMessage());
        System.out.println("-d number of Days\tThis changes how many days are run in the simulation. Set to 365 days as default.");
        System.out.println("-g number of Games\tThis changes how many games are run in the simulation. Set to 100 games as default.");
        System.out.println("-s isSocial\t\tThis determines if the characters in the society uses it's abilities on themeselves or on the society. Set to false by default.");
        System.out.println("-h\t\t\tDisplays this help message.");
    }
}
