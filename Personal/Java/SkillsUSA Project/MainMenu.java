import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainMenu {
    ArrayList<Parts> parts;
    int[] challenges; 
    Compete compete;
    Search searchingForParts;
    String userResponse;
    //challenges [Runway, Terrain, Weather]
    //inventory [Engine, Wings, Landing Gear]
    
    public MainMenu() {
        startUpCalculations();
    }

    public void menu() {
        //Main menu where the user can choose between search, compete, and quit.
        //If user inputs anything else then they will be displayed a meesage to choose again.
        compete = new Compete(challenges, parts);
        Scanner keyboardScanner;
        String userResponse = "";
        keyboardScanner = new Scanner(System.in);
 

        do {
            System.out.println();
            userResponse = "";
            System.out.println("What do you want to do? Type in search, compete, quit.");
            userResponse = keyboardScanner.nextLine();
            userResponse.trim().toLowerCase();
            if (userResponse.equals("search")) { //This will go into my search class and find parts for an airplane.
                if (parts.size() < 3) { //seeing if the inventory is full or not.
                    searchingForParts = new Search(keyboardScanner);
                    parts.add(searchingForParts.getPart(parts));
                    keyboardScanner = new Scanner(System.in);

                } else {
                    System.out.println("You have reach your capacity, please choose compete.");
                }
                
            } else if (userResponse.equals("compete")) { //This runs the compete class to determine if they succeed or not.
                compete.runCompetition();

            } else if (userResponse.equals("quit")) { //kills the program.
                System.out.println("Bye!");
                break;

            } else {
                System.out.println("That is not one of the options, try again.");
            }

        } while (!userResponse.equals("compete"));
        keyboardScanner.close();
    }

    private void startUpCalculations() {
        Random randomNumberGenerator = new Random();
        challenges = new int[3];
        parts = new ArrayList<Parts>();

        //This is where I am randomly generating the difficulty for the challenges.
        challenges[0] = randomNumberGenerator.nextInt(7);
        challenges[1] = randomNumberGenerator.nextInt(7) + 4;
        challenges[2] = randomNumberGenerator.nextInt(10) + 2;
    }
}
