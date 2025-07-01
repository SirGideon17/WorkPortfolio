import java.util.ArrayList;

public class PageStub {
    private Integer pageCount = 0;
    //this class will be called to seperate the information for now.
    private ArrayList<String> tableOfContents;

    public PageStub() {
        tableOfContents = new ArrayList<String>();

        buildTableOfContents();



    }

    private void buildTableOfContents(){
        tableOfContents.add("Adventure Architect:\n");
        tableOfContents.add("=".repeat(83) + "\n");
        tableOfContents.add("Table of Contents:    " + ".".repeat(59) + "  1");
        tableOfContents.add("Main Setting:         " + ".".repeat(59) + "  2");
        tableOfContents.add("Antagonist:           " + ".".repeat(59) + "  3");
        tableOfContents.add("Main Quest:           " + ".".repeat(59) + "  4");
        tableOfContents.add("Populations Center 1: " + ".".repeat(59) + "  5");
        tableOfContents.add("Populations Center 2: " + ".".repeat(59) + "  6");
        tableOfContents.add("Populations Center 3: " + ".".repeat(59) + "  7");
        tableOfContents.add("Dungeon 1:            " + ".".repeat(59) + "  8");
        tableOfContents.add("Dungeon 2:            " + ".".repeat(59) + "  9");
        tableOfContents.add("Dungeon 3:            " + ".".repeat(59) + " 10");

        // pageSeperate();
    }

    public String PageSeperate() {
        pageCount++;
        return "\n" + "=".repeat(83) + "\n" + pageCount + "\n";
    }

    public ArrayList<String> getTableOfContents() {
        ArrayList<String> copyTitleOfContents = tableOfContents;
        return copyTitleOfContents;
    }
}
