import java.util.ArrayList;

public class Quests implements CampiagnInfoInterface {
    //This class will do the following:
    //generate 3 quest string arrays that will contand all of the info for the quests.
    //Generate the name of each quest object.
    //Create a reward that is tied to the quest.
    //Grab the number of steps that are needed to complete this quest.

    //Generate contact NPCs.
    //The name of the NPC
    //A basic description of the NPC.
    //How they are tied to the quest.

    private ArrayList<String> quest;

    public Quests(String fileName, int bitWiseComparision) {
        Integer numberOfLinesForArray = 24; //This is the number of lines for each quest. We'll update it here if we need to change it.
        this.quest = new ArrayList<String>();
        String questFileName = "\\Quests.txt";
        MainScanner fileScanner = new MainScanner(fileName, questFileName, numberOfLinesForArray, bitWiseComparision);


        quest = fileScanner.generateAnswer(numberOfLinesForArray);
        addSpace();
    }

    private void addSpace() {
        for (int i = 1; i < 8; i = i + 3) {
            quest.add(i, "");
        }

        for (int i = 11; i < quest.size(); i = i + 3) {
            quest.add(i, "");
        }


    }

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> copyQuest = quest;
        return copyQuest;
    }

    @Override
    public String getName() {
        return "Main Quest";
    }
}