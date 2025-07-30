/**
 * This is an enum that was given to me by my CS 121 teacher. We built it in class and it was quite fun to use.
 * I would like to turn the parse die method into a switch statement at some point.
 * @author Lawence Sevigney 
 */

import java.util.Random;

//This is where we build the individual dice.
public enum Die {
    D4(4), D6(6), D8(8), D10(10), D12(12), D20(20), D100(100), NO_DICE(1);

    private int sides;
    private Random generator;

    /**
     * This is the constructor of the class. This generates the random using the java random generator.
     * @param numSides
     */
    private Die(int numSides) {
        sides = numSides;
        generator = new Random();
    }

    /**
     * This 'roll's' the die. Using the number of sides as the highest value.
     * @return randomly determined number from 1 to highest value.
     */
    public int rollDie() {
        int valueRolled;

        valueRolled = generator.nextInt(sides) + 1;

        return valueRolled;
    }

    /**
     * String method, returns the gaming convention of a die. Such as if a die is 4 sided, then it is called a d4.
     */
    public String toString() {
        switch (this) {
            case D4:
                return "d4";
            
            case D6:
                return "d6";

            case D8:
                return "d8";
            
            case D10:
                return "d10";
            
            case D12:
                return "d12";

            case D20:
                return "d20";

            case D100:
                return "d100";
        
            default:
                return "no dice";
        }
    }

    /**
     * This parses a string to determine what die to return.
     * @param dieString
     * @return the die value of the string.
     */
    public static Die parseDie(String dieString) {
        String compareString = dieString.trim().toLowerCase();
        if (compareString.equals("d4")) {
            return D4;

        } else if (compareString.equals("d6")) {
            return D6;
        
        } else if (compareString.equals("d8")) {
            return D8;
        
        } else if (compareString.equals("d10")) {
            return D10;

        } else if (compareString.equals("d12")) {
            return D12;
        
        } else if (compareString.equals("d20")) {
            return D20;
        
        } else if (compareString.equals("d100")) {
            return D100;
        
        } else {
            return NO_DICE;
        }
    }
    
}
