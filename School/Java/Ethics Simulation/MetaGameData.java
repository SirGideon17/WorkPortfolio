import java.util.ArrayList;
/**
 * This class is used to run the simulation as well as collect data from the individual games.
 * This class specifically collects the total wins, the total losses, the average day for all of the games
 * played and the number of days for each game.
 */
public class MetaGameData {
    private int totalWins, totalLosses, averageGameLength;
    private ArrayList<Integer> numDays;
    
    /**
     * Constructor to set everything to zero.
     */
    public MetaGameData() {
        numDays = new ArrayList<Integer>();
        totalWins = 0;
        totalLosses = 0;
        averageGameLength = 0;
    }

    /**
     * This method plays the game in the most default value. This was used for testing purposes and is not used
     * in the main program.
     */
    public void playGame() {
        playGame(365, 100, false);
    }

    /**
     * This method plays the game in the most default value except to change the social outcome to be nonanarchy.
     * This was used for testing purposes and is not used in the main program.
     */
    public void playGame(boolean social) {
        playGame(365, 100, social);
    }

    /**
     * This method plays the game using the parameters that were given by the user. It creates a game object
     * then uses a for loop given by numGames to determine how many games to play. It then passes the number
     * of days and the societal potential to the game object. If the game reaches the specified number of days
     * then the game is won and total wins is incremented. If the game is lost then total losses is incremented.
     * Once all of the games are played then it will calculate the average amount of days each game was played. 
     * 
     * @param totalGameDays
     * @param numGames
     * @param social
     */
    public void playGame(int totalGameDays, int numGames, boolean social) {
        Game currentGame = new Game(social, totalGameDays);
        int lastDay = 0;

        for (int i = 0; i < numGames; i++) {
            lastDay = currentGame.runGame();
            numDays.add(lastDay);

            if (lastDay == totalGameDays) {
                totalWins++;

            } else {
                totalLosses++;
            }
            calculateAverageGameLength();
        }
        
    }

    /** This method shows the metadata of the games that were run, total losses and total wins. then it displays the 
     * list of the last day of each of the games.
     */
    public void showData() {
        if (totalWins == 0 && totalLosses == 0) {
            System.out.println("No metadata yet. Use playgame method");
        
        } else {
            System.out.println("Simulation Stats");
            System.out.println("Total Wins: " + totalWins + "\tTotal losses: " + totalLosses);
            System.out.println("Average number of Days for all the games: " + averageGameLength);
            System.out.println("List of game days: ");
            for (int i = 0; i < numDays.size();) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(numDays.get(i) + "\t");
                    i++;
                }
                System.out.println();
            }
        }
    }

    /** This calculates the average game day. It rounds down instead of giving a decimal value. */
    private void calculateAverageGameLength() {
        int totalLength = 0;
        for (Integer integer : numDays) {
            totalLength += integer;
        }

        averageGameLength = totalLength / numDays.size();
    }
}
