public class CampaignInformation {
   booleanVariable[] variables = {new booleanVariable("Good", false, 1),
                                    new booleanVariable("Evil", false, 2),
                                    new booleanVariable("Neutral", false, 4),
                                    new booleanVariable("Heroic", false, 8),
                                    new booleanVariable("Grimdark", false, 16),
                                    new booleanVariable("Balanced", false, 32),
                                    new booleanVariable("Combat", false, 64),
                                    new booleanVariable("Intrige_Social", false, 128),
                                    new booleanVariable("Street_Level", false, 256),
                                    new booleanVariable("Country_Level", false, 512),
                                    new booleanVariable("World_Level", false, 1024)
                                };
    int total = 0;


    public CampaignInformation() {

    }

    public void setTotal() {
        for (booleanVariable variables : variables) {
            if (variables.getBooleanValue()) {
                total += variables.getBitWiseValue();
            }
        }
    }

    public int getTotal() {
        int copyTotal = total;
        return copyTotal;
    }

    public void setBoolean(booleanVariable variable, boolean value) {
        for (int i = 0; i < variables.length; i++) {
            if (variables[i].equals(variable)) {
                variables[i].setVariable(value);
            }
        }
    }
}
