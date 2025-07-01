public class Parts {
    
    private String partName;
    private int strength;

    public Parts(String partName, int strength) {
        this.partName = partName;
        this.strength = strength;
    }

    public String getPartName() {
        return partName;
    }

    public int getStrength() {
        return strength; 
    }

    public String toString() {
        return getPartName() + ": " + getStrength();
    }
}
