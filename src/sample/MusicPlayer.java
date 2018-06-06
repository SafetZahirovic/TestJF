import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Main extends Application {

    private Button play;
    private Button rewind;
    private Button stop;
    private MediaPlayer player;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        play = new Button("Play");
        rewind = new Button("Rewind");
        stop = new Button("Stop");

        Media media = new Media(Paths.get("/Users/safetzahirovic/Documents/CardGame/untitled19/src/music/SoundOfSuccess.mp3").toUri().toString());
        player = new MediaPlayer(media);

        GridPane pane = new GridPane();


        pane.add(play, 1, 0);
        pane.add(rewind, 0, 0);
        pane.add(stop, 2, 0);


        play.setOnAction(event -> player.play());
        stop.setOnAction(event -> player.stop());
        rewind.setOnAction(event -> {
            if (media.getDuration().toSeconds() >= 0) {
                player.stop();
                player.setStartTime(Duration.millis(0));
                player.play();
            }
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
