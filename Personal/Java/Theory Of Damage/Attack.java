/**
 * This is a the attack class for each individual attacks. Right now, I have it where if a character can
 * attack multiple times with the same attack then I need a new object for each attack. I will change that in
 * a later version.
 * @author Simeon Grant
 */

public class Attack {
    private int attackMod, damageMod;
    private Die[] attackDice;


    /**
     * This is the constructor of the class. It takes in a int for attack modifier, damage modifier, then a number of dice that is part of the attack.
     * @param attackMod
     * @param damageMod
     * @param attackDice
     */
    public Attack(int attackMod, int damageMod, Die ... attackDice) {
        this.attackMod = attackMod;
        this.damageMod = damageMod;
        this.attackDice = attackDice;
    }

    /**
     * Method to return the attack modifier.
     * @return attackMod
     */
    public int getAttackMod() {
        int copyAttack = attackMod;
        return copyAttack;
    }

    /**
     * Method to return the damageModifier.
     * @return damageMod.
     */
    public int getDamageMod() {
        int copyDamage = damageMod;
        return copyDamage;
    }

    /**
     * Method to return the array of damage dice.
     * @return array of damage dice.
     */
    public Die[] getDamageDice() {
        return attackDice;
    }

    /**
     * Method to calculate the amount of damage that this particular attack has done. It checks if the attack was
     * a critical or not first.
     * @param critical
     * @return the total damage that was dealt.
     */
    public int dealDamage(boolean critical) {
        int totalDamage = 0;
        if (critical) {
            for (Die die : attackDice) {
                totalDamage += die.rollDie();
            }
        }
        for (Die die : attackDice) {
            totalDamage += die.rollDie();
        }
        totalDamage += getDamageMod();
        return totalDamage;
    }
}
