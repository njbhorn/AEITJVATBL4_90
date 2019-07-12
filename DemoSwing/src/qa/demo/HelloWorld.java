package qa.demo;

import java.awt.Paint;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloWorld extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);
        rectangle.setStroke();

        StackPane stackPane = new StackPane(rectangle);
        stackPane.setPrefHeight(200);
        stackPane.setPrefWidth(200);
        stackPane.setStyle("-fx-background-color: RED;");

        Group groupStackPaneAdd = new Group();
        groupStackPaneAdd.getChildren().add(stackPane);

        Scene scene = new Scene(groupStackPaneAdd, 400, 400, Color.AZURE);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}