import java.util.NoSuchElementException;

public enum Genre {
    HIGH_FANTASY, LOW_FANTASY, HIGH_SCI_FI, LOW_SCI_FI;

    private String filePath;


    public void evaluate() {
        //This needs to return the string of the file path to the individual genres.
        switch (this) {
            case HIGH_FANTASY:
                filePath = "Content/Genre/Fantasy/High_Fantasy/";
                break;
            
            case LOW_FANTASY:
                filePath = "Content/Genre/Fantasy/Low_Fantasy/";
                break;

            case HIGH_SCI_FI:
                filePath = "Content-Genre-High Sci-Fi-";
                break;

            case LOW_SCI_FI:
                filePath = "Content-Genre-Low Sci-Fi-";
                break;
            
            default:
                throw new NoSuchElementException();
        } 
    }

    public String getFilePath() {
        String copyFilePath = filePath;
        return copyFilePath;
    }

}

