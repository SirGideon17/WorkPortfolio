import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Search {
    private Scanner keyboardScanner;
    
    public Search(Scanner keyboardScanner) {
        this.keyboardScanner = keyboardScanner;
    }

    public Parts getPart(ArrayList<Parts> inventory) {
        String[] choices = new String[3];
        Parts[] randomParts = new Parts[3];
        int numberChosen = -1;
        Random randomNumber = new Random();
        ArrayList<String> partNames = new ArrayList<String>();
        //This creates a list to compare against.
        choices[0] = "wings";
        choices[1] = "engine";
        choices[2] = "landing gear";

        //This creates a list of possible items to find.
        partNames.add("wings");
        partNames.add("engine");
        partNames.add("landing gear");

        if (inventory.size() > 0) {
            for (int i = 0; i < inventory.size(); i++) {
                for (int j = 0; j < choices.length; j++) {
                    //if the part name is found in the inventory, it will remove it from the possible parts list.
                    if (inventory.get(i).getPartName() == choices[j]) { 
                        partNames.remove(choices[j]);
                    }
                }
            }
        }

        //This randomly generates a parts object that has a name, a number attached to it, and put it into another list.
        for (int i = 0; i < randomParts.length; i++) {
            randomParts[i] = new Parts(partNames.get(randomNumber.nextInt(partNames.size())), randomNumber.nextInt(10));
        }

        //this displays the list of available parts to the user.
        do {
            System.out.println("Please choose a number for the coresponding part from the list found: ");
            for (int i = 0; i < randomParts.length; i++ ) {
                System.out.println((i + 1) + " " + randomParts[i]);
            }

            //user will choose a number from the list. If they input something else than a number, then they get kicked out.
            try {
                numberChosen = 0;
                numberChosen = keyboardScanner.nextInt() - 1;

                if (numberChosen < 0 || numberChosen > 3) {
                    System.out.println("Please enter a number that corresponds to a part");
                }

            } catch (InputMismatchException exception) {
                System.out.println("Input is not valid, going back to main menu.");
                System.out.println();
            }   

        } while (numberChosen < 0 || numberChosen > 3);

        return randomParts[numberChosen];
    }
}