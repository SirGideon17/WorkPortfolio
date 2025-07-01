import java.util.ArrayList;

public class PopulationCenter implements CampiagnInfoInterface {
    //This will create the campaign 'map', setting, and general lore of the campaign.
    //It will create population centers, dungeons, and points of interest.

    private ArrayList<String> popCenter;
    private ArrayList<ArrayList<String>> popDistricts;

    public PopulationCenter(String fileName, int bitWiseComparision, int numberOfDistricts) {
        int sizeOfPopulationArray = 63;
        int sizeOfDistrict = 17;
        popCenter = new ArrayList<String>();
        popDistricts = new ArrayList<ArrayList<String>>();
        String populationCenterFileName = "\\PopCenters_Descriptions.txt";
        String populationCenterDistrictFileName = "\\PopCenters_Districts.txt";
        MainScanner popCenterScanner = new MainScanner(fileName, populationCenterFileName, sizeOfPopulationArray, bitWiseComparision);
        MainScanner districtMainScanner = new MainScanner(fileName, populationCenterDistrictFileName, sizeOfDistrict, bitWiseComparision);

        popCenter = popCenterScanner.generateAnswer(sizeOfPopulationArray);

        for (int i = 0; i < numberOfDistricts; i++) {
            popDistricts.add(districtMainScanner.generateAnswer(sizeOfDistrict));
        }
        
        addSpace();
        addAllDistricts();
    }

    private void addSpace() {
        for (int i = 1; i < popCenter.size(); i = i + 3) {
            popCenter.add(i, "");
        }
        popCenter.add("");

        for (int i = 0; i < popDistricts.size(); i++) {
            for (int j = 1; j < popDistricts.get(i).size(); j = j + 3) {
                popDistricts.get(i).add(j, "");
            }
            popDistricts.get(i).add("");
        }
    }

    private void addAllDistricts() {
        for (int i = 0; i < popDistricts.size(); i++) {
            for (int j = 0; j < popDistricts.get(i).size(); j++) {
                popCenter.add(popDistricts.get(i).get(j));
            }
        }
    }

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> copyPopCenter = popCenter;
        return copyPopCenter;
    }

    @Override
    public String getName() {
        return "Population Center";
    }
}
