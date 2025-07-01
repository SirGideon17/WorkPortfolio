
public abstract class Character implements CharacterAbility {
    private int health, food, shelter, characterID;
    private String name;

    /**
     * This class is an abstract class for all of the characters in the simulation.
     * It has the following statistics: health, food, shelter, characterID, and name.
     * 
     * @param name
     * @param characterID
     */
    public Character(String name, int characterID) {
        health = 10;
        food = 10;
        shelter = 10;
        this.name = name;
        this.characterID = characterID;
    }

    /**
     * This returns the health of the character.
     * @return the health of the character
     */
    public int getHealth() {;
        return health;
    }

    /**
     * This returns the food stat of the character.
     * @return food stat
     */
    public int getFood() {
        int copyFood = food;
        return copyFood;
    }

    /**
     * This returns the shelter stat of the character.
     * @return
     */
    public int getShelter() {
        int copyShelter = shelter;
        return copyShelter;
    }

    /**
     * This returns the character ID.
     * @return
     */
    public int getID() {
        int copyID = characterID;
        return copyID;
    }

    /**
     * This returns the name of the character.
     * @return
     */
    public String getName() {
        String copyName = name;
        return copyName;
    }

    /**
     * This sets the value of the health stat. It checks
     * that the input is an valid input.
     * @param value
     */
    public void setHealth(int value) {
        if (value < 11 && value >= 0) {
            health = value;
        }
    }

    /**
     * This sets the value of the food stat. It checks
     * that the input is an valid input.
     * @param value
     */
    public void setFood(int value) {
        if (food >= 0) {
            food = value;
        } 
    }

    /**
     * This sets the value of the food stat. It checks
     * that the input is an valid input.
     * @param value
     */
    public void setShelter(int value) {
        if (value < 11 && value >= 0) {
            shelter = value;
        }
    }

    /**
     * This increases the health of the character. This checks
     * if the value is a positive value and make sures that the value
     * doesn't go above the specified amount.
     * @param value
     */
    public void increaseHealth(int value) {
        if (value < 0) {
            value = 0;
        }

        if (health + value > 10) {
            health = 10;
        } else {
            health += value;
        }
    }

    /**
     * This decreases the health value of the character. This checks
     * if the value is a positive value and make sures that the value
     * doesn't go below the specified amount.
     * @param value
     */
    public void decreaseHealth(int value) {
        if (value < 0) {
            value = 0;
        }

        if (health - value < 0) {
            health = 0;
        
        } else {
            health -= value;
        }
    }

    /**
     * This increases the shelter value of the character. This checks
     * if the value is a positive value and make sures that the value
     * doesn't go above the specified amount.
     * @param value
     */
    public void increaseShelter(int value) {
        if (value < 0) {
            value = 0;
        }

        if (shelter + value > 10) {
            shelter = 10;
        } else {
            shelter += value;
        }
    }

    /**
     * This decreases the shelter value of the character. This checks
     * if the value is a positive value and make sures that the value
     * doesn't go below the specified amount.
     * @param value
     */
    public void decreaseShelter(int value) {
        if (value < 0) {
            value = 0;
        }

        if (shelter - value < 0) {
            shelter = 0;
        
        } else {
            shelter -= value;
        }
    }

    /**
     * This increases the food value of the character. This checks
     * if the value is a positive value.
     * @param value
     */
    public void increaseFood(int value) {
        if (value < 0) {
            value = 0;
        }

        food += value;
    }

    /**
     * This decreases the food value of the character. This checks
     * if the value is a positive value and make sures that the value
     * doesn't go below the specified amount.
     * @param value
     */
    public void decreaseFood(int value) {
        if (value < 0) {
            value = 0;
        }

        if (food - value < 0) {
            food = 0;
        
        } else {
            food -= value;
        }
    }

    /**
     * returns a string with the name, health, food, and shelter stats.
     */
    public String toString() {
        return name + ":\t" + getHealth() + "\t" + getFood() + "\t" + getShelter();
    }
}