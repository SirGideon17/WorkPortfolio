import java.util.ArrayList;
/**
 * This class handles the individual game. It creates an array of characters and plays the game.
 * 
 */

public class Game {
    private int day;
    private boolean social;
    private ArrayList<Character> party;
    private Disaster disaster;
    private final int MAX_DAY;


    public Game(boolean social) {
        this(social, 365);
    }

    public Game(boolean social, int maxDay) {
        day = 0;
        this.social = social;
        party = new ArrayList<Character>();
        party.add(new Doctor());
        party.add(new Farmer());
        party.add(new Carpenter());
        party.add(new Hunter());
        disaster = new Disaster();
        MAX_DAY = maxDay;
    }

    /**
     * Increments the day value for the game.
     */
    public void incrementDay() {
        day++;
    }

    /**
     * returns the day value.
     * @return
     */
    public int getDay() {
        int copyDay = day;
        return copyDay;
    }

    /**
     * Getter value to determine if the game is played in anarchy or social.
     * @return
     */
    public boolean getSocial() {
        boolean copySocial = social;
        return copySocial;
    }

    /**
     * runDay method runs the individual day. It increments the day integer, 
     * uses the character's abilities that are in the society, decrease daily food,
     * then applies the new disaster for that day onto the society. It then prints out
     * the characters that are still alive.
     */
    private void runDay() {
        incrementDay();
        applyCharacterAbilities();
        dailyFood();
        disaster.performDisaster(party, social);
        newDayDisplay();
        getPartyStats();
        System.out.println();
    }

    /**
     * This runs the individual game. It then retuns how many days it has run.
     * It does this by using a do loop and checks if the society list is 0 or not
     * at the end of each of it's days. Once the game is finished it will reset
     * the characters and the day value.
     * @return dayTotal - the total amount of days that transpire in the game.
     */
    public int runGame() {
        int dayTotal;
        displaySocial();
        do {
            runDay();
            stillAlive();
        } while (day < MAX_DAY && !party.isEmpty());

        if (party.isEmpty()) {
            System.out.println("Everybody is dead\n");

            System.out.println("The society lasted " + day + " days");
        } else {
            System.out.println("The characters last long enough to thrive!");
            System.out.println("You win!");
        }
        dayTotal = day;
        resetGame();

        return dayTotal;
    }

    /**
     * This applies the character abilities that are still alive in the game.
     */
    private void applyCharacterAbilities() {
        if (social) {
            for (Character character : party) {
                character.useSocialAbility(party);
            }
        } else {
            for (Character character : party) {
                character.useAnarchyAbility();
            }
        }
    }

    /**
     * dailyFood decrements each of the characters food supply by one.
     */
    private void dailyFood() {
        for (Character character : party) {
            character.decreaseFood(1);
        }
    }

    /**
     * Display the stats of each of the party that are still alive.
     */
    private void getPartyStats() {
        for (Character character : party) {
            System.out.println(character);
        }
    }

    /**
     * stillAlive determines if the food or health of a character is zero. If it
     * is then it removes the character from the party.
     */
    private void stillAlive() {
        for (int i = 0; i < party.size(); i++) {
            if (party.get(i).getFood() == 0 || party.get(i).getHealth() == 0) {
                System.out.println(party.get(i).getName() + " is dead");
                party.remove(party.get(i));
                i--;
            }
        }
    }

    /**
     * This resets the game and make it ready for the next iteration.
     */
    private void resetGame() {
        day = 0;
        if (party.isEmpty()) {
            party.add(new Doctor());
            party.add(new Farmer());
            party.add(new Carpenter());
            party.add(new Hunter());
        } else {
            for (int i = party.size() - 1; i >= 0; i-- ) {
                party.remove(i);
            }
            party.add(new Doctor());
            party.add(new Farmer());
            party.add(new Carpenter());
            party.add(new Hunter());
        }
    }

    /**
     * This displays if the game is run in anarchy or social mode.
     */
    private void displaySocial() {
        System.out.println("Running in " + (social ? "social" : "anarchy") + " mode ...");
    }

    /**
     * This display the new day information.
     */
    private void newDayDisplay() {
        System.out.println("Day " + day + ": " + disaster.getDisater());
        System.out.println("-".repeat(40));
        System.out.println("\t\tHealth:\tFood:\tShelter:");
    }


}
