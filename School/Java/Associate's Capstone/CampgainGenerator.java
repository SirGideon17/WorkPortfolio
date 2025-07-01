import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CampgainGenerator {
    // private CampaignInformation info = new CampaignInformation();
    private PageStub pageStub = new PageStub();
    private CampiagnInfoInterface[] campaign;
    private ArrayList<String> masterList;


    public CampgainGenerator(String contentPath, int bitWiseComparision) {
        masterList = new ArrayList<String>();
        campaign = new CampiagnInfoInterface[9];
        campaign[0] = new MainSetting(contentPath, bitWiseComparision);
        campaign[1] = new Antagonist(contentPath, bitWiseComparision);
        campaign[2] = new Quests(contentPath, bitWiseComparision);
        campaign[3] = new PopulationCenter(contentPath, bitWiseComparision, 1);
        campaign[4] = new PopulationCenter(contentPath, bitWiseComparision, 2);
        campaign[5] = new PopulationCenter(contentPath, bitWiseComparision, 3);
        campaign[6] = new Dungeon(contentPath, bitWiseComparision, 3);
        campaign[7] = new Dungeon(contentPath, bitWiseComparision, 5);
        campaign[8] = new Dungeon(contentPath, bitWiseComparision, 7);

        createMasterList();
    }


    public void writeToFile (String fileTitle) {
        File fileName = new File("");

        try {
            FileWriter fileWriter = new FileWriter(fileName.getAbsolutePath() + "\\Save\\" + fileTitle + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
    
            for (int i = 0; i < masterList.size(); i++) {
                printWriter.println(masterList.get(i));
            }
            printWriter.close();
        } catch (Exception exception) {
            System.out.println("Whoops, something went wrong.");
        }
    }

    private void createMasterList() {
        for (int i = 0; i < pageStub.getTableOfContents().size(); i++) {
            masterList.add(pageStub.getTableOfContents().get(i));
        }

        masterList.add(pageStub.PageSeperate());

        for (int i = 0; i < campaign.length; i++) {
            for (int j = 0; j < campaign[i].getList().size(); j++) {
                masterList.add(campaign[i].getList().get(j));
            }

            masterList.add(pageStub.PageSeperate());
        }
    }

    public ArrayList<String> getMasterList() {
        return masterList;
    }
}
