/**
 * This is the main class for my Thoery of Damage. This is where I need to set up the characters. Then run the simulation.
 * This is where the number of rounds and monsterAC are for right now.
 * @author Simeon Grant
 */

public class TheoryOfDamageMain {
    public static void main(String[] args) {
        int rounds = 20;
        int monsterAC = 13;
        AdventureParty adventureGroup = new AdventureParty();
        adventureGroup.addMember(new Character("Kraytos", 0, true, new Attack(8, 5, Die.D4, Die.D4),
                                                                    new Attack(9, 6, Die.D6, Die.D4),
                                                                    new Attack(9, 6, Die.D6, Die.D4)));

        adventureGroup.addMember(new Character("Indy", 0, false, new Attack(4, 14, Die.D8),
                                                                    new Attack(4, 14, Die.D8)));

        adventureGroup.addMember(new Character("Ikkie", 0, true, new Attack(7, 4, Die.D6, Die.D6, Die.D6, Die.D6)));

        adventureGroup.addMember(new Character("Hecklar", 0, false, new Attack(8, 5, Die.D10, Die.D6),
                                                                    new Attack(8, 5, Die.D10, Die.D6)));

        adventureGroup.addMember(new Character("Wolf", 0, true, new Attack(3, 17, Die.D6, Die.D6),
                                                                    new Attack(3, 17, Die.D6, Die.D6)));
        
        adventureGroup.addMember(new Character("Reayna", 1, true, new Attack(8, 7, Die.D8),
                                                                    new Attack(8, 7, Die.D8),
                                                                    new Attack(8, 7, Die.D8)));
                

        adventureGroup.combatEncounter(rounds, monsterAC);
        adventureGroup.showStats(rounds, monsterAC);
        System.out.println("Blarg");
    }
}