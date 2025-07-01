import java.util.ArrayList;
import java.util.Random;

/**
 * This class handles the disasters that are part of the simulation.
 * It has an ENUM tied to it to give each disaster a discription.
 * It first generates a new disaster and then applies that disaster
 * to the society.
 */
public class Disaster {
    private DisaterType current;

    public Disaster() {
        current = DisaterType.NOTHING;

    }

    /**
     * This method returns the disaster that is set currently.
     * @return disaster
     */
    public DisaterType getDisater() {
        return current;
    }

    /**
     * This generates a random number from 0-4 and sets a new
     * disaster based off of that number.
     */
    private void newDisaster() {
        Random numGenerator = new Random();
        switch (numGenerator.nextInt(5)) {
            case 0:
                current = DisaterType.HURRICANE;
                break;
            
            case 1:
                current = DisaterType.FAMINE;
                break;

            case 2:
                current = DisaterType.DISEASE;
                break;

            case 3:
                current = DisaterType.WOLVES;
                break;

            case 4:
                current = DisaterType.NOTHING;
                break;

            default:
                break;
        }
    }

    /**
     * This applies each of the disasters to the party.
     * @param party
     * @param social
     */
    public void performDisaster(ArrayList<Character> party, boolean social) {
        newDisaster();
        switch (current) {
            case HURRICANE:
                hurricane(party);
                break;

            case FAMINE:
                famine(party);
                break;

            case DISEASE:
                disease(party);
                break;

            case WOLVES:
                wolves(party, social);
                break;

            default:
                break;
        }
    }

    /**
     * Hurricane decrements the shelter of the society or health if shelter is zero.
     * @param party
     */
    private void hurricane(ArrayList<Character> party) {
        for (Character character : party) {
            if (character.getShelter() > 0) {
                character.decreaseShelter(3);
            } else {
                character.decreaseHealth(5);
            }
        }
    }

    /**
     * famine decrements the food of the society by 2.
     * @param party
     */
    private void famine(ArrayList<Character> party) {
        for (Character character : party) {
            character.decreaseFood(2);
        }
    }

    /**
     * disease decrements the health of the society by 2.
     * @param party
     */
    private void disease(ArrayList<Character> party) {
        for (Character character : party) {
            character.decreaseHealth(2);
        }
    }

    /**
     * This disaster reduces the health of the society by 3 unless the society is in social and the hunter is alive. If the hunter is alive then
     * the society decrements 1 health.
     * @param party
     * @param social determines if the society is in anarchy or social. If it is and the hunter is alive then the hunter will protect the society from the wolves.
     * 
     */
    private void wolves(ArrayList<Character> party, boolean social) {
        boolean hunterAlive = false;
        if (social) {
            for (Character character : party) {
                if (character.getID() == 4) {
                    hunterAlive = true;
                }
            }

            if (hunterAlive) {
                for (Character character : party) {
                    character.decreaseHealth(1);
                }
            } else {
                for (Character character : party) {
                    character.decreaseHealth(3);
                }
            }

        } else {
            for (Character character : party) {
                if (character.getID() == 4) {
                    character.decreaseHealth(1);
                
                } else {
                    character.decreaseHealth(3);
                }
            }
        }
    }
}

/**
 * An enum to group all of the disasters together.
 */
enum DisaterType {HURRICANE, FAMINE, DISEASE, WOLVES, NOTHING}