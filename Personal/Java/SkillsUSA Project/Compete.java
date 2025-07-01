import java.util.ArrayList;

public class Compete {
    int[] challenges;
    ArrayList<Parts> partList;
    Parts currentPart;
    int carryOver = 0;
    //challenges [Runway, Terrain, Weather]
    //inventory [Engine, Wings, Landing Gear]
    
    public Compete(int[] challenges, ArrayList<Parts> partList) {
        this.challenges = challenges;
        this.partList = partList;

    }

    public void runCompetition() {
        //This checks of the partList is smaller than 3.
        //If it is, then it will throw a part object into the list called NA with -1.
        if (partList.size() < 3) {
            for (int i = 0; i < 3 - partList.size(); i++) {
                partList.add(new Parts("NA", -1));
            }
        }
        //This is the start of the competition.
        System.out.println("Landing Gear vs Runway");
        findPart(partList, "landing gear");
        System.out.println(currentPart.toString() + " " + "Runway: " + challenges[0]);
        calculations(currentPart.getStrength(), challenges[0], carryOver);
        System.out.println();
        
        System.out.println("Wings vs Terrain");
        findPart(partList, "wings");      
        System.out.println(currentPart.toString() + " + Carry Over: " + carryOver + " - " + "Terrain: " + challenges[1]);
        calculations(currentPart.getStrength(), challenges[1], carryOver);
        System.out.println();

        System.out.println("Engine vs Weather");
        findPart(partList, "engine");      
        System.out.println(currentPart.toString() + " + Carry Over: " + carryOver +  " - " + "Weather: " + challenges[2]);
        calculations(currentPart.getStrength(), challenges[2], carryOver);
        System.out.println();

        if (carryOver >= 0) {
            System.out.println("You win the game! Congradulations!");
        } else {
            System.out.println("Your plane fails the course. Try Again!");
        }
    }

    private void findPart(ArrayList<Parts> partList, String partName) {
        //This will search for the correct object and make that the current object to
        //do calculations.
        for (int i = 0; i < partList.size(); i++) {
            if (partList.get(i).getPartName() == "NA") {
                currentPart = partList.get(i);
            }
            if (partList.get(i).getPartName() == partName) {
                currentPart = partList.get(i);
            }
        }
    }

    private void calculations(int currentStrength, int challengeStrength, int previousCarryOver) {
        //This is the calculations part.
        int partStrength = currentPart.getStrength() + previousCarryOver;
        carryOver = partStrength - challengeStrength;
        if (carryOver < 0) {
            carryOver *= 2;
            System.out.println("You failed.");
        } else {
            System.out.println("You succeed!");
        }
        System.out.println("Carry Over: " + carryOver);

    }

}
