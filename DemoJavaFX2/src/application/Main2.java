package application;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main2 extends Application {

	ThreeLetterBodyPartsEngine engine = ThreeLetterBodyPartsEngine.getThreePartEngine();
	GridPane root = new GridPane();
	Button btnOK = new Button("OK");
	Button btnCancel = new Button("Cancel");
	Button btnExit = new Button("Exit");
	ListView<String> ta = new ListView<>();
	Label lblBodyPart = new Label("Body Part");
	TextField txtBodyPart = new TextField();
	TextField statusLine = new TextField();
	LocalTime startTime ;

	@Override
	public void start(Stage primaryStage) {
		try {

			btnOK.setDefaultButton(true);
			btnCancel.setDisable(true);
			statusLine.setStyle("-fx-background-color: azure");
			root.add(lblBodyPart, 0, 0);
			root.add(txtBodyPart, 1, 0);
			root.add(btnOK, 0, 2);
			root.add(btnCancel, 1, 2);
			root.add(btnExit, 2, 2);
			root.add(ta, 0, 4, 2, 1);
			root.add(statusLine, 0, 6, 3, 1);

			List<String> bodyParts = new ArrayList<>();

			ListProperty<String> bodyPartsList = new SimpleListProperty<>();
			ta.itemsProperty().bind(bodyPartsList);

			btnOK.setOnAction(e -> {
				try {
					String value = txtBodyPart.getText();
					validateBodyPart(value);
					bodyParts.add(value);
					bodyPartsList.set(FXCollections.observableArrayList(bodyParts));
					btnCancel.setDisable(bodyParts.size() == 0);
					updateStatusInfo() ;
				} catch (IllegalArgumentException ex) {
					statusLine.setText(ex.getMessage());
					System.out.println("Whoops exception " + ex.getMessage());
					clearForNextGuess();
					txtBodyPart.requestFocus();
				}
			});

			btnCancel.setOnAction(e -> {
				if ( startTime.equals(null)) {
					startTime = LocalTime.now();
				}
				bodyParts.remove(bodyParts.size() - 1);
				bodyPartsList.set(FXCollections.observableArrayList(bodyParts));
				btnCancel.setDisable(bodyParts.size() == 0);
			});

			btnExit.setOnAction(e -> {
				Platform.exit();
			});

			root.setAlignment(Pos.CENTER);
			root.setHgap(10);
			root.setVgap(10);
			root.setPadding(new Insets(25, 25, 25, 25));

			Scene scene = new Scene(root, 400, 400);
			root.getStyleClass().add("main");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateStatusInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Guesses : ") ;
		sb.append(engine.getNumberGuesses()) ;
		sb.append(" Correct : ") ;
		sb.append(engine.getNumberCorrect()) ;
		sb.append(" Time : ") ;
		sb.append(engine.getTimeTaken());
		sb.append(" secs ") ;
		statusLine.setText(sb.toString());

	}

	private void clearForNextGuess() {
		txtBodyPart.setText("");

	}

	private void validateBodyPart(String value) {
		switch (engine.checkValue(value)) {
		case ALREADY_GUESSED:
			break;
		case CORRECT:
			break;
		case INCORRECT:
			break;
		}
		clearForNextGuess();
		System.out.println(engine.getNumberCorrect());
		System.out.println(engine.getNumberGuesses());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
