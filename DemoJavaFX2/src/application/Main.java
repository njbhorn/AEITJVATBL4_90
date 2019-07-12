package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Button btnOK = new Button("OK");
			Button btnCancel = new Button("Cancel");
			TextArea ta = new TextArea() ;
			Label lblBodyPart = new Label("Body Part") ;
			TextField txtBodyPart = new TextField() ;

			HBox vbButtons = new HBox() ;
			HBox vbInfo = new HBox();
			Pane displayPane = new Pane(ta) ;
//			displayPane.setPrefSize(300, 100);

			vbButtons.setSpacing(10);
			vbButtons.setPadding(new Insets(0,20,10,20));
			vbButtons.getChildren().addAll(btnOK,btnCancel) ;

			vbInfo.setSpacing(10);
			vbInfo.setPadding(new Insets(0,20,10,20));
			vbInfo.getChildren().addAll(lblBodyPart,txtBodyPart) ;

			ClickedButtonEventHandleOK eh = new ClickedButtonEventHandleOK() ;
//			btnOK.setOnAction(eh);

			btnOK.setOnAction( e -> {
//				System.out.println("Lambda Expression Clicked...") ;
//				System.out.println("More work...") ;
				ta.appendText("OK Clicked...\n");
			});

			btnCancel.setOnAction( new EventHandler () {
				@Override
				public void handle(Event event) {
//					System.out.println("Cancel clicked...");
					ta.appendText("Cancel Clicked...\n");
				}
			});

			BorderPane root = new BorderPane();
			root.setTop(displayPane);
			root.setCenter(vbInfo);
			root.setBottom(vbButtons);
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class ClickedButtonEventHandleOK implements EventHandler {

	@Override
	public void handle(Event arg0) {
		System.out.println("Clicked...");

	}
}
