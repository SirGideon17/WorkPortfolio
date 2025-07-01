import java.util.ArrayList;
import java.util.Random;

/**
 * A character class that protects the other characters when the wolves disaster happens.
 * It sometimes increase the food stat.
 */
public class Hunter extends Character {

    public Hunter() {
        super("Hunter", 4);
    }

    @Override
    public void useAnarchyAbility() {
        if (huntingChance()) {
            increaseFood(2);
        } 
    }

    @Override
    public void useSocialAbility(ArrayList<Character> party) {
        if (huntingChance()) {
            for (Character character : party) {
                character.increaseFood(2);
            }
        }
    }
    
    /**
     * This returns a boolean value. It returns true if the random generated number
     * is one and false otherwise.
     * @return
     */
    private boolean huntingChance() {
        Random numGen = new Random();
        int randomNumber = numGen.nextInt(5) + 1;
        return randomNumber == 1;
    }

    public String toString() {
        return "Hunter:\t\t" + this.getHealth() + "\t" + this.getFood() + "\t" + this.getShelter();
    }
}
