package org.example.the_squares_odyssey;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Introduction extends Application {
    @Override
    public void start(Stage primaryStage) {
        Media media = new Media(getClass().getResource("/static/images/videos/video.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setFitWidth(755);
        mediaView.setFitHeight(700);
        mediaView.setPreserveRatio(false);

        StackPane layout = new StackPane();
        layout.getChildren().add(mediaView);

        Scene scene = new Scene(layout, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Square's Odyssey");
        primaryStage.show();

        mediaPlayer.play();

        mediaPlayer.setOnEndOfMedia(() -> {
            Choice choicePage = new Choice();
            choicePage.start(primaryStage);
        });

        mediaPlayer.setOnError(() -> {
            System.out.println("Media Error: " + mediaPlayer.getError().getMessage());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}