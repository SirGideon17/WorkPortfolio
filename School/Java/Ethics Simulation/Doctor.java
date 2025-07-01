import java.util.ArrayList;

/**
 * The doctor character. A character that increases health with it's ability is used.
 */
public class Doctor extends Character {

    public Doctor() {
        super("Doctor", 1);
    }

    /**
     * the anarchy ability icreases health.
     */
    @Override
    public void useAnarchyAbility() {
        if (getFood() == 1) {
            increaseFood(1);

        } else {
            increaseHealth(2);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void useSocialAbility(ArrayList<Character> party) {
        if (getFood() == 1) {
            increaseFood(1);
        
        } else {
            for (Character character : party) {
                character.increaseHealth(2);
            }
        }
    }

    public String toString() {
        return "Doctor:\t\t" + this.getHealth() + "\t" + this.getFood() + "\t" + this.getShelter();
    }
}
