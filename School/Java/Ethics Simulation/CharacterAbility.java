import java.util.ArrayList;

/**
 * An interface to enforce the characters to have the anarchy ability and sociatle ability.
 */
public interface CharacterAbility {
    
    /**
     * This uses the anarchyAbility that each of the characters use.
     */
    public void useAnarchyAbility();

    /**
     * This uses the anarachyAbility on each of the characters in the society.
     * @param party
     */
    public void useSocialAbility(ArrayList<Character> party);
}
