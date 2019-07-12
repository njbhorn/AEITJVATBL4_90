package helloworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	public static void main(String[] args) {
		launch ( args ) ;

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World");
		StackPane root = new StackPane() ;
		Button btn = new Button("Hello World");
		btn.setOnAction( e -> System.out.println("Hello World"));
		root.getChildren().add(btn);
		Scene scene = new Scene ( root, 300, 250 ) ;
		primaryStage.setScene(scene) ;
		primaryStage.show();
		
	}

}
