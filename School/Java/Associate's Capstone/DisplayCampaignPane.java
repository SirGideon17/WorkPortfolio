import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DisplayCampaignPane extends VBox {
    private Text openText;
    private RadioButton highFantasyButton, lowFantasyButton;
    private CheckBox[] campaignChoices = {   new CheckBox("Good"),
                                             new CheckBox("Evil"),
                                             new CheckBox("Neutral"),
                                             new CheckBox("Heroic"),
                                             new CheckBox("Grimdark"),
                                             new CheckBox("Balanced"),
                                             new CheckBox("Combat"),
                                             new CheckBox("Intrigue/Social"),
                                             new CheckBox("Street Level"),
                                             new CheckBox("Country Level"),
                                             new CheckBox("World Level"),   
                                        };
    private Button runButton;
    private Genre GENRE;
    private CampaignInformation info;
    private TextField nameOfCampaign;
    
    public DisplayCampaignPane() {
        openText = new Text("Welcome to the Adventure Architect.\nPlease select a " +
        "Genre and Campaign options that you want.");
        // openText.setFont(new Font("Helvetica", 11)); //need this?

        //Setting the background?
        // this.setStyle("-fx-background-color: black");


        // Set up radio button toggle group
        ToggleGroup group = new ToggleGroup();
        highFantasyButton = new RadioButton("High Fantasy");
        lowFantasyButton = new RadioButton("Low Fantasy");

        highFantasyButton.setToggleGroup(group);
        lowFantasyButton.setToggleGroup(group);

        group.selectToggle(highFantasyButton);

        //I need to create a method that will choose the genre ENUM.
        //Setting this to null for now.
        highFantasyButton.setOnAction(this:: processRadioButtonClick);
        lowFantasyButton.setOnAction(this:: processRadioButtonClick);

        //Constructing all of the campaign modifiers
        VBox alignmentChoice = new VBox(campaignChoices[0], campaignChoices[1], campaignChoices[2]);
        VBox toneChoice = new VBox(campaignChoices[3], campaignChoices[4]);
        VBox typeOfCampaign = new VBox(campaignChoices[5], campaignChoices[6], campaignChoices[7]);
        VBox plotStakes = new VBox(campaignChoices[8], campaignChoices[9], campaignChoices[10]);

        //This is setting them to the processCheckBoxClick
        for (int i = 0; i < campaignChoices.length; i++) {
          campaignChoices[i].setOnAction(this::processCheckBoxClick);
        }

    
        HBox campaignModifiers = new HBox(alignmentChoice,toneChoice, typeOfCampaign, plotStakes);
        campaignModifiers.setSpacing(30);
        campaignModifiers.setAlignment(Pos.CENTER);

        //Here's my button section.
        Button turnThemAllOn = new Button("Turn on all options");
        turnThemAllOn.setOnAction(this::processAllButtonClick);

        //Instantiating the run button
        runButton = new Button("Run Generator");
        runButton.setOnAction(this::processRunButtonClick);

        //Here's my work on my textfield for name of campaign.
        nameOfCampaign = new TextField("Please enter a name for campaign");
        nameOfCampaign.setPrefWidth(55);

        //This is where I am organizing all of the options.
        HBox genreChoice = new HBox(highFantasyButton, lowFantasyButton);
        genreChoice.setSpacing(20);
        genreChoice.setAlignment(Pos.CENTER);
        turnThemAllOn.setAlignment(Pos.CENTER);
        VBox main = new VBox(openText, nameOfCampaign, genreChoice, campaignModifiers, turnThemAllOn, runButton);
        main.setSpacing(20);

        main.setAlignment(Pos.CENTER);
        this.getChildren().addAll(main);

        info = new CampaignInformation();
        GENRE = Genre.HIGH_FANTASY;
        GENRE.evaluate();
    }

    private void processRadioButtonClick(ActionEvent event) {
        if (highFantasyButton.isSelected()) {
            GENRE = Genre.HIGH_FANTASY;
        } else {
            GENRE = Genre.LOW_FANTASY;
        }
        GENRE.evaluate();   
    }

    private void processAllButtonClick(ActionEvent event) {
        for (CheckBox temp : campaignChoices) {
            temp.setSelected(true);
        }
    }

    private void processCheckBoxClick(ActionEvent event) {
        CheckBox temp = (CheckBox)event.getSource();
        booleanVariable variable = new booleanVariable(temp.getText(), false, 0);
        info.setBoolean(variable, temp.isSelected());
        info.setTotal();
    }

    private void processRunButtonClick(ActionEvent event) {
        int bitWiseComparision;
        bitWiseComparision = info.getTotal();
        if ((bitWiseComparision & 1) == 0 && (bitWiseComparision & 2) == 0 && (bitWiseComparision & 4) == 0) { 
            bitWiseComparision += 1; //guard statement for alignment
        } 
        if ((bitWiseComparision & 8) == 0 && (bitWiseComparision & 16) == 0) { 
            bitWiseComparision += 8; //guard statement for tone section
        } 
        if ((bitWiseComparision & 32) == 0 && (bitWiseComparision & 64) == 0 && (bitWiseComparision & 128) == 0) {
            bitWiseComparision += 32; //guard statement for style
        } 
        if ((bitWiseComparision & 256) == 0 && (bitWiseComparision & 512) == 0 && (bitWiseComparision & 1024) == 0) {
            bitWiseComparision += 256; //guard statement for PlatStakesScale
        }

       CampgainGenerator generator = new CampgainGenerator(GENRE.getFilePath(), bitWiseComparision);
        if (nameOfCampaign.getText().isEmpty()) {
            generator.writeToFile("blarg!");
        
        } else {
            generator.writeToFile(nameOfCampaign.getText());
        }
    }
}
