import java.util.ArrayList;

/**
 * A character who's ability is to increase shelter.
 */
public class Carpenter extends Character {

    public Carpenter() {
        super("Carpenter", 3);

    }
    @Override
    public void useAnarchyAbility() {
        if (getFood() == 1) {
            increaseFood(1);
        
        } else {
            increaseShelter(2);
        }
    }

    @Override
    public void useSocialAbility(ArrayList<Character> party) {
        if (getFood() == 1) {
            increaseFood(1);
        
        } else {
            for (Character character : party) {
                character.increaseShelter(1);
            }
        }
    }
    
}
