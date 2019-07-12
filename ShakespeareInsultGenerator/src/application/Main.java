package application;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static MainController controller ;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			controller = new MainController();
			FXMLLoader loader = new FXMLLoader();
			loader.setController(controller);
			Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			Scene scene = new Scene(root,600,270);
			primaryStage.setTitle("Shakespearean Insult Generator");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
//			controller.initialiseWindow();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
