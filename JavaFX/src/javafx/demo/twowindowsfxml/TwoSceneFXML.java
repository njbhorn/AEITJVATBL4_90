package javafx.demo.twowindowsfxml ;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TwoSceneFXML extends Application {
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent root ;

		root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		
		// create a new scene with root and set the stage
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
