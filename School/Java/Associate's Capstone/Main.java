import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //This is where we will ask the user questions and put those in the setting class.
    //Right now, this is our testing area.
    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        DisplayCampaignPane pane = new DisplayCampaignPane();
        Scene scene = new Scene(pane, 450, 300);

        primaryStage.setTitle("Adventure Architect");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}