import java.util.ArrayList;

/**
 * The farmer increases the food stat when it's ability is used.
 * It has a day counter as well.
 */
public class Farmer extends Character {
    private int numDays;


    public Farmer() {
        super("Farmer", 2);
        numDays = 1;
    }

    @Override
    public void useAnarchyAbility() {
        incrementDay();
        if ((numDays % 3) == 0) {
            increaseFood(3);
        }
    }

    @Override
    public void useSocialAbility(ArrayList<Character> party) {
        incrementDay();
        if ((numDays % 3) == 0) {
            for (Character character : party) {
                character.increaseFood(3);
            }
        }
    }

    public void incrementDay() {
        numDays++;
    }
 
    public String toString() {
        return "Farmer:\t\t" + this.getHealth() + "\t" + this.getFood() + "\t" + this.getShelter();
    }
}
