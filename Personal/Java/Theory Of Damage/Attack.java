public class Attack {
    private int attackMod, damageMod;
    private Die[] attackDice;


    public Attack(int attackMod, int damageMod, Die ... attackDice) {
        this.attackMod = attackMod;
        this.damageMod = damageMod;
        this.attackDice = attackDice;
    }

    public int getAttackMod() {
        int copyAttack = attackMod;
        return copyAttack;
    }

    public int getDamageMod() {
        int copyDamage = damageMod;
        return copyDamage;
    }

    public Die[] getDamageDice() {
        return attackDice;
    }

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
