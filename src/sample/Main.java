package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Button button = new Button("Do not touch me");
        Button explanation = new Button("Explanation!");


        GridPane pane = new GridPane();
        VBox box = new VBox();
        pane.setGridLinesVisible(true);


        box.setPadding(new Insets(10,10,10,10));


        Label heading = new Label("Do not press the button!!!!");
        Label why = new Label("Describe why did you press me?");

        TextField textField = new TextField();
        textField.setPrefWidth(300);
        textField.setPrefHeight(300);

        box.getChildren().addAll(heading,button);
        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);

        button.setOnAction(event->{
            box.getChildren().removeAll(button, heading);
            box.getChildren().add(textField);
            box.getChildren().addAll(why, explanation);

        });

        StackPane explanationPane = new StackPane();
        explanationPane.setAlignment(Pos.CENTER);

        Label explanationHeading = new Label("Stupid ass explanation");
        Label explanationLabel = new Label("Stupid ass explanation!!!!!");

        VBox explanationVBox = new VBox();
        explanationVBox.getChildren().add(explanationHeading);
        explanationPane.getChildren().add(explanationVBox);
        Scene explanationScene = new Scene(explanationPane, 500,500);

        explanation.setOnAction(event -> {
            primaryStage.setScene(explanationScene);
            explanationLabel.setText(textField.getText());
            explanationPane.getChildren().add(explanationLabel);
        });


        primaryStage.setTitle("Do not press the button!!!!!!");
        Scene intro = new Scene(pane, 500,500);

        primaryStage.setScene(intro);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
