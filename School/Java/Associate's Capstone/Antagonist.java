import java.util.ArrayList;

public class Antagonist implements CampiagnInfoInterface {
    private ArrayList<String> villianList;

    // 2nd try for the villian class.
    // String order: name, archetype, goals, personality, lair, minions
    
    public Antagonist(String contentPath, int bitComparision) {
        this.villianList = new ArrayList<String>();
        String villianNameFilePath = "\\Antagonists.txt";
        int villianListSize = 11;
        MainScanner scanner = new MainScanner(contentPath, villianNameFilePath, villianListSize, bitComparision);
        villianList = scanner.generateAnswer(villianListSize);
        addSpaces();
    }

    private void addSpaces() {
        for (int i = 1; i < villianList.size(); i = i + 3) {
            villianList.add(i, "");
        }
    }

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> copyVillianList = villianList;
        return copyVillianList;
    }

    @Override
    public String getName() {
        return "Antagonist";
    }
}
