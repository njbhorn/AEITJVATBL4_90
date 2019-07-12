package application;

import java.io.IOException;
import java.time.LocalTime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainFXML extends Application {
	@Override
	public void start(Stage primaryStage) {
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("DemoThreeLetterBodyparts.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
