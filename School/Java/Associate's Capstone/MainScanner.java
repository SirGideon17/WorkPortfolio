import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class MainScanner {
    private ArrayList<String> infoDump;

    public MainScanner(String contentName, String fileName, int arraySize, int bitComparision) {
        infoDump = new ArrayList<String>();
        String dummyText;
        File filePath = new File(contentName);
        int lineCount = 0;

        try {
            Scanner fileScanner = new Scanner(new File(filePath.getAbsolutePath() + fileName)); //creating main scanner
            while (fileScanner.hasNextLine()) { //while main scanner has a next line to read.
                dummyText = fileScanner.nextLine();
                Scanner textScanner = new Scanner(dummyText);

                // this is checking to see if there is a number in front and if there is, comparing it against
                // the bitwise comparison and see if that is greater than 0.
                if (textScanner.hasNextInt() && (textScanner.nextInt() & bitComparision) > 0) {
                    //This is rebuilding the name without the number in it. 
                    dummyText = "";
                    do {
                        dummyText += textScanner.next();
                        dummyText += " ";
                    } while (textScanner.hasNext());

                    dummyText.trim();

                    //This is adding the name and the info into the initial array before being randomized.
                    //This also ignores all of the formating stuff as well.
                    infoDump.add(dummyText);
                    lineCount++;

                    for (int i = 0; i < (arraySize - 1); i++) {
                            infoDump.add(fileScanner.nextLine());
                            lineCount++;
                    }
                } else {
                    textScanner.close();
                    lineCount++;
                }
            }
            fileScanner.close();

            // Some catch statements in case things go weird.
        } catch (FileNotFoundException exception) {
            System.out.println("File Not found for: " + fileName);
            System.out.println("File Path: " + filePath.getAbsolutePath());
        
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Array index out of bounds for: " + contentName);

        } catch (NoSuchElementException exception) {
            System.out.println("Something went wrong at Line: " + lineCount);
            // for (int i = 0; i <infoDump.size(); i++) {
                // System.out.println(infoDump.get(i));
            // }
        }
    }

    public ArrayList<String> generateAnswer(int arraySize) {
        Random randomNumber = new Random();
        int randomNumberChosen;
        ArrayList<String> returnDump = new ArrayList<String>();
                
            //creating and assignment of random chosen.
            randomNumberChosen = randomNumber.nextInt((infoDump.size() - 1) / arraySize);

            // This is where the logic will pull from the arrayList to put it in the array that is going to be returned.
            for (int i = 0; i < arraySize; i++) {
                returnDump.add(infoDump.get((randomNumberChosen * arraySize + i)));
            }

            return returnDump;
        }
    }
