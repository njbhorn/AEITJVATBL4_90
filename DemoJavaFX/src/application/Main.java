package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			BorderPane root = new BorderPane();
			String pathMainWindow = "src/application/MainWindow.fxml" ;
			String pathAccordionWindow = "src/application/AccordionWindow.fxml";

			FXMLLoader loader = new FXMLLoader ( );

			FileInputStream fxmlStreamMain = new FileInputStream(pathMainWindow);
			FileInputStream fxmlStreamAccordion = new FileInputStream(pathAccordionWindow);

			ControllerMain controller = new ControllerMain() ;
			loader.setController(controller);
			Parent root = loader.load(fxmlStreamMain);
//			Parent accordion = loader.load(fxmlStreamAccordion);

//			Parent root = loader.load();
			// get reference to textfiel and label
			TextField tf = controller.getTxtField() ;
			Label tl = controller.getLblField() ;
//			tl.textProperty().bind(tf.textProperty());
			tf.setText("FRED");

			Scene scene = new Scene(root);
//			Scene scene2 = new Scene(accordion);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
