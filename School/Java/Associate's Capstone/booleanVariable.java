public class booleanVariable {
    private String name;
    private boolean booleanValue;
    private int bitWiseValue;
    
    public booleanVariable(String name, boolean boonleanValue, int bitWiseValue) {
        this.name = name;
        this.booleanValue = boonleanValue;
        this.bitWiseValue = bitWiseValue;
    }

    public void setVariable(boolean value) {
        this.booleanValue = value;
    }

    public boolean getBooleanValue() {
        boolean copyBooleanValue = booleanValue;
        return copyBooleanValue;
    }

    public String toString() {
        String copyName = name;
        return copyName;
    }

    public int getBitWiseValue() {
        int copyIntValue = bitWiseValue;
        return copyIntValue;
    }

    public boolean equals(Object value) {
        if (!(value instanceof booleanVariable)) {return false;}
        booleanVariable temp = (booleanVariable) value;
        return this.name.toLowerCase().equals(temp.toString().toLowerCase());
        
    }
}
