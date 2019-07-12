package dialog;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class DialogController {

	private MainApp mainApp;

	@FXML
	private Button info;

	@FXML
	private Button warning;

	@FXML
	private Button exception;

	@FXML
	private Button error;

	@FXML
	private Button confirm;

	@FXML
	private Button textInput;

	@FXML
	void close(ActionEvent event) {
		System.exit(0);
	}

	@FXML
    void showDialog(ActionEvent event) {

    	Button button = (Button) event.getSource() ;
    	String buttonId = button.getId() ;
    	Alert alert ;
//    	alert = new Alert(AlertType.INFORMATION);
//    	alert.setTitle("Debug Info");
//    	alert.setContentText(buttonId);
//    	alert.showAndWait();
    	switch ( buttonId ) {
    	case "info" :
    		alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Information Dialog");
        	alert.setHeaderText("Look, an Information Dialog");
        	alert.setContentText("I have a great message for you!");
        	alert.showAndWait();
        	break ;
    	case "warning" :
    		alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Warning Dialog");
    		alert.setHeaderText("Look, a Warning Dialog");
    		alert.setContentText("Careful with the next step!");
    		alert.showAndWait();
    		break ;
    	case "exception" :
    		alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Exception Dialog");
    		alert.setHeaderText("Look, an Exception Dialog");
    		alert.setContentText("Could not find file blabla.txt!");

    		Exception ex = new FileNotFoundException("Could not find file blabla.txt");

    		// Create expandable Exception.
    		StringWriter sw = new StringWriter();
    		PrintWriter pw = new PrintWriter(sw);
    		ex.printStackTrace(pw);
    		String exceptionText = sw.toString();

    		Label label = new Label("The exception stacktrace was:");

    		TextArea textArea = new TextArea(exceptionText);
    		textArea.setEditable(false);
    		textArea.setWrapText(true);

    		textArea.setMaxWidth(Double.MAX_VALUE);
    		textArea.setMaxHeight(Double.MAX_VALUE);
    		GridPane.setVgrow(textArea, Priority.ALWAYS);
    		GridPane.setHgrow(textArea, Priority.ALWAYS);

    		GridPane expContent = new GridPane();
    		expContent.setMaxWidth(Double.MAX_VALUE);
    		expContent.add(label, 0, 0);
    		expContent.add(textArea, 0, 1);

    		// Set expandable Exception into the dialog pane.
    		alert.getDialogPane().setExpandableContent(expContent);

    		alert.showAndWait();
    		break ;
    	case "confirm" :
    		alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmation Dialog");
    		alert.setHeaderText("Look, a Confirmation Dialog");
    		alert.setContentText("Are you ok with this?");

    		Optional<ButtonType> result = alert.showAndWait();
    		if (result.get() == ButtonType.OK){
    		    // ... user chose OK
    		} else {
    		    // ... user chose CANCEL or closed the dialog
    		}
    		break ;
    	case "error" :
    		alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error Dialog");
    		alert.setHeaderText("Look, an Error Dialog");
    		alert.setContentText("Ooops, there was an error!");
    		alert.showAndWait();
    		break ;
    	case "textInput" :
    		TextInputDialog dialog = new TextInputDialog("nigel b");
    		dialog.setTitle("Text Input Dialog");
    		dialog.setHeaderText("Look, a Text Input Dialog");
    		dialog.setContentText("Please enter your name:");

    		// Traditional way to get the response value.
    		Optional<String> textResult = dialog.showAndWait();
    		if (textResult.isPresent()){
    		    System.out.println("Your name: " + textResult.get());
    		}

    		// The Java 8 way to get the response value (with lambda expression).
    		textResult.ifPresent(name -> System.out.println("Your name: " + name));
    	case "choice" :
    		List<String> choices = new ArrayList<>();
    		choices.add("Arsenal");
    		choices.add("Barnet");
    		choices.add("Watford");
    		choices.add("Leicester");
    		choices.add("Udinese");
    		choices.add("Granada");


    		ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Watford", choices);
    		choiceDialog.setTitle("Choice Dialog");
    		choiceDialog.setHeaderText("Look, a Choice Dialog");
    		choiceDialog.setContentText("Choose your letter:");


    		// Traditional way to get the response value.
    		Optional<String> choiceResult = choiceDialog.showAndWait();
    		if (choiceResult.isPresent()){
    		    System.out.println("Your choice: " + choiceResult.get());
    		}

    		// The Java 8 way to get the response value (with lambda expression).
    		choiceResult.ifPresent(letter -> System.out.println("Your choice: " + letter));

    	default :
    		break ;
    	}



    }

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}

}
