package dialog;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Dialog Demos");

		initRootLayout();

		showDialogDemo();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("MainFrame.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showDialogDemo() {

		try {
			FXMLLoader loader = new FXMLLoader() ;
			loader.setLocation(MainApp.class.getResource("DialogDemo.fxml"));
			AnchorPane dialogDemo = ( AnchorPane) loader.load();

			rootLayout.setCenter(dialogDemo);

			DialogController controller = loader.getController() ;
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
