import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class AdventureParty {
    private ArrayList<Character> party;
    
    public AdventureParty() {
        party = new ArrayList<Character>();
    }

    public void addMember(Character partymember) {
        party.add(partymember);
    }
    
    public Character getMember(int i) {
        return party.get(i);
    }

    public void showParty() {
        for (Character character : party) {
            System.out.println(character);
        }
    }

    public void combatEncounter(int numberOfRounds, int monsterAC) {
        for (int i = 0; i < numberOfRounds; i++) {
            for (Character character : party) {
                character.attack(monsterAC);
            }
        }
    }

    public void showStats(int numberOfRounds, int monsterAC) {
        NumberFormat percentageFormat = NumberFormat.getPercentInstance();
        DecimalFormat decFormat = new DecimalFormat("#.##");

        System.out.println("Number of Rounds: " + numberOfRounds + "\t\tMonster AC: " + monsterAC);
        System.out.println();
        System.out.print("Name:\t\t\t\t");
        for (Character character : party) {
            System.out.print(character + "\t");
        }
        System.out.println();

        System.out.print("Number of Attacks:\t\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(numberOfRounds * party.get(i).getNumberOfAttacks() + "\t");
        }
        System.out.println();
        
        System.out.print("Total Damage:\t\t\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(party.get(i).getTotalDamage() + "\t");
        }
        System.out.println();
        
        System.out.print("Total Critical Hits:\t\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(party.get(i).getTotalCrits() + "\t");
        }
        System.out.println();

        System.out.print("Total Hits:\t\t\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(party.get(i).getTotalHits() + "\t");
        }
        System.out.println();

        System.out.print("Total Misses:\t\t\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(party.get(i).getTotalMisses() + "\t");
        }
        System.out.println();

        System.out.print("Theoretical Chance to hit:\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(percentageFormat.format(party.get(i).calculateToHit(monsterAC)) + "\t");
        }
        System.out.println();

        System.out.print("Test Run chance to hit:\t\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(percentageFormat.format(party.get(i).calculateActualHit(numberOfRounds) + party.get(i).calculateToCrit(numberOfRounds)) + "\t");
        }
        System.out.println();

        System.out.print("Test run chance to crit:\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(percentageFormat.format(party.get(i).calculateToCrit(numberOfRounds)) + "\t");
        }
        System.out.println();

        System.out.print("Average Damage per round:\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(decFormat.format((double)party.get(i).getTotalDamage() / numberOfRounds) + "\t");
        }
        System.out.println();

        System.out.print("Average Damage per attack:\t");
        for (int i = 0; i < party.size(); i++) {
            System.out.print(decFormat.format((double)party.get(i).getTotalDamage() / (numberOfRounds * party.get(i).getNumberOfAttacks())) + "\t");
        }
    }
}
