/**
 * This is the character class. This builds the characters for the simulation. This is where I store the name of the character,
 * the number of attacks, criticalRange, totalDamage, totalHits, totalMisses, totalCrits, and whether I have advantage or not.
 * @author Simeon Grant
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Character {
    // private int toHitBonus, numberOfAttacks, damageBonus; 
    private int criticalRange, totalDamage, totalHits, totalMisses, totalCrits;
    private String name;
    // private Die[] damageDice;
    private Attack[] attacks;
    private boolean advantage;


    // public Character(String name, int toHitBonus, int damageBonus, int criticalBonus, int numberOfAttacks, boolean advantage, Die ... damageDice) {
    //     this.advantage = advantage;
    //     this.toHitBonus = toHitBonus;
    //     this.damageBonus = damageBonus;
    //     this.numberOfAttacks = numberOfAttacks;
    //     this.damageDice = damageDice;
    //     this.name = name;
    //     criticalRange = 20 - criticalBonus;
    // }

    /**
     * Construtor that takes in the following: name, criticalBonus, advantage, and a variable amount of attacks.
     * @param name
     * @param criticalBonus
     * @param advantage
     * @param attacks
     */
    public Character(String name, int criticalBonus, boolean advantage, Attack ... attacks) {
        this.advantage = advantage;
        this.name = name;
        criticalRange = 20 - criticalBonus;
        this.attacks = attacks;
    }

    /**
     * This is the method that deals with an individual attack. This checks if the character has advantage,
     * checks if the attack is a critical, and then deals damage appropiately. It takes in the following parameter
     * monster AC.
     * @param monsterAC
     */
    public void attack(int monsterAC) {
        Die toHitDie = Die.D20;
        int damageDealt;
        for (int i = 0; i < attacks.length; i++) {
            int attackRoll = toHitDie.rollDie();
        
            if (advantage) {
                int advantageAttRoll = toHitDie.rollDie();
                if (advantageAttRoll > attackRoll) {
                    attackRoll = advantageAttRoll;
                }
            }
            if (attackRoll >= criticalRange) {
                totalCrits++;
                // System.out.println("Critical!");
                damageDealt = attacks[i].dealDamage(true);
            }
            
            if ((attackRoll + attacks[i].getAttackMod()) >= monsterAC) {
                totalHits++;
                damageDealt = attacks[i].dealDamage(false);
                // System.out.println("You hit! You deal: " + damageDealt);
                totalDamage += damageDealt;

            } else {
                totalMisses++;
                // System.out.println("You miss");
            }
        }
    }

    /**
     * Old method that has migrated to the individual attack class.
     * @return
     */
    // private void damageRoll(boolean criticalHit) {
    //     int damage = 0;
    //     if (criticalHit) {
    //         for (Die die : damageDice) {
    //             damage += die.rollDie();
    //         }
    //     }

    //     for (Die die : damageDice) {
    //             damage += die.rollDie();
    //     }

    //     totalDamage += damage + damageBonus;
    // }

    // public int getToHitBonus() {
    //     int copyToHit = toHitBonus;
    //     return copyToHit;
    // }

    /**
     * Method to return the total damage.
     * @return total Damage
     */
    public int getTotalDamage() {
        int copyDamage = totalDamage;
        return copyDamage;
    }

    /**
     * Method to return totalCrits
     * @return totalCrits
     */
    public int getTotalCrits() {
        int copyCrits = totalCrits;
        return copyCrits;
    }

    /**
     * Method to return the total number of hits by the character.
     * @return totalHits
     */
    public int getTotalHits() {
        int copyHits = totalHits;
        return copyHits;
    }

    /**
     * Method to return the total number of misses by the character.
     * @return
     */
    public int getTotalMisses() {
        int copyMisses = totalMisses;
        return copyMisses;
    }

    /**
     * Method to return the total number of attacks that are made by the character.
     * @return
     */
    public int getNumberOfAttacks() {
        int copyAttacks = attacks.length;
        return copyAttacks;
    }

    /**
     * This is an old method to show stastics for damage for a combat round over the course of the number of rounds.
     * The AdventureParty class has a better method for this.
     * @param numberOfRounds
     * @param monsterAC
     */
    public void calculations(int numberOfRounds, int monsterAC) {
        NumberFormat percentageFormat = NumberFormat.getPercentInstance();
        DecimalFormat decFormat = new DecimalFormat("#.##");

        System.out.println("Number of Rounds: " + numberOfRounds);
        System.out.println("Number of Attacks: " + (numberOfRounds * attacks.length));
        System.out.println("Total Damage: " + getTotalDamage());
        System.out.println("Total Critical Hits: " + getTotalCrits());
        System.out.println("Total Hits: " + getTotalHits());
        System.out.println("Total Misses: " + getTotalMisses());
        System.out.println("Test run chance to crit: " + percentageFormat.format((double)getTotalCrits() / (numberOfRounds * attacks.length)));
        System.out.println("Test run Chance to hit: " + percentageFormat.format(((double)getTotalHits() + (double)getTotalCrits()) / (numberOfRounds * attacks.length)));
        System.out.println("Average Damage per round: " + decFormat.format((double)totalDamage / numberOfRounds)); 
        System.out.println("Average Damage per attack: " + decFormat.format((double)totalDamage / (numberOfRounds * attacks.length)));
  
    }

    /**
     * This calculates the theoretical probability of a mosnter at a certain AC.
     * @param monsterAC
     * @return
     */
    public double calculateToHit(int monsterAC) {
        double percentageToHit = ((double)20 - monsterAC + attacks[0].getAttackMod()) / 20;
        if (advantage) {
            percentageToHit = (1.0 - Math.pow((1.00 - percentageToHit), 2));
        }

        return percentageToHit;
    }

    /**
     * This returns the actual chance that the character had at criticaling during the duration of the simulation.
     * @param numberOfRounds
     * @return chance to crit.
     */
    public double calculateToCrit(int numberOfRounds) {
        return (double)getTotalCrits() / (numberOfRounds * attacks.length);
    }

    /**
     * This returns the actual chance that the character had at hitting the monster AC during the duration of the simulation.
     * @param numberOfRounds
     * @return chance to hit.
     */
    public double calculateActualHit(int numberOfRounds) {
        return (double)getTotalHits() / (numberOfRounds * attacks.length);
    }

    /**
     * ToString method just returning the name.
     */
    public String toString() {
        return name;
    }
}
