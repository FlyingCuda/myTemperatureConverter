package org.example.two;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage primaryStage;

    private void setPrimaryStage(Stage stage){
        HelloApplication.primaryStage = stage;
    }

    static public Stage getPrimaryStage(){
        return HelloApplication.primaryStage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Hello!");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}