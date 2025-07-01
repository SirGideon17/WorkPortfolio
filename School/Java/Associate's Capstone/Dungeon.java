import java.util.ArrayList;
import java.util.Random;

public class Dungeon implements CampiagnInfoInterface {
    //This is where we will create the dungeon description, dungeon layout, the individual rooms in our dungeons.

    private ArrayList<String> dungeonRooms;

    public Dungeon(String filePath, int bitWiseComparision, int numberOfOptionalRoomsInDungeon) {
        ArrayList<String> initialdungeonRooms = new ArrayList<String>();
        dungeonRooms = new ArrayList<String>();
        Random randomNumber = new Random();
        String fileNameDungeon = "\\Dungeon_Description.txt";
        int initialArraySize = 21;
        MainScanner scanner = new MainScanner(filePath, fileNameDungeon, initialArraySize, bitWiseComparision);


        initialdungeonRooms = scanner.generateAnswer(initialArraySize);

        dungeonRooms.add(initialdungeonRooms.get(0));
        dungeonRooms.add(initialdungeonRooms.get(1));

        for (int i = 0; i < numberOfOptionalRoomsInDungeon; i++) {
            dungeonRooms.add(chooseRoom(initialdungeonRooms));
        }

        addSpace();
        dungeonRooms.add(initialdungeonRooms.get(9));
        dungeonRooms.add("Boss Treasure:\n" + initialdungeonRooms.get(randomNumber.nextInt(9)+ 9));

    }

    private String chooseRoom(ArrayList<String> list) {
        Random numberGenerator = new Random();
        double roomPercent = numberGenerator.nextDouble();
        if (0.0 <= roomPercent && roomPercent < .50) { //enemies start at 5
            return list.get(numberGenerator.nextInt(3) + 3);

        } else if (.50 <= roomPercent && roomPercent < .65) {
            return list.get(numberGenerator.nextInt(4) + 3);

        } else if (.65 <= roomPercent && roomPercent < .80) {
            return "Trap Room";

        } else {
            return "Treasure: " + list.get(numberGenerator.nextInt(9) + 9);
        }
    }

    private void addSpace() {
        dungeonRooms.add(1, "Dungeon Description: ");
        dungeonRooms.add(3, "");
        dungeonRooms.add(4, "Rooms: ");
        dungeonRooms.add(dungeonRooms.size(), "\nBoss Room:");
    }

    public void showDungeonRooms() {
        for (int i = 0; i < dungeonRooms.size(); i++) {
            System.out.println(dungeonRooms.get(i));
        }
    }

    @Override
    public ArrayList<String> getList() {
        ArrayList<String> copyDungeonRooms = dungeonRooms;
        return copyDungeonRooms;
    }

    @Override
    public String getName() {
        return "Dungeon";
    }
}
