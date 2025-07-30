import java.util.Random;

public enum Die {
    D4(4), D6(6), D8(8), D10(10), D12(12), D20(20), D100(100), NO_DICE(1);

    private int sides;
    private Random generator;

    private Die(int numSides) {
        sides = numSides;
        generator = new Random();
    }

    public int rollDie() {
        int valueRolled;

        valueRolled = generator.nextInt(sides) + 1;

        return valueRolled;
    }

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
