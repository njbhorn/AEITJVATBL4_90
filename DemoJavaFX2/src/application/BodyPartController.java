package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BodyPartController {

    @FXML
    private Button btnOK;

    @FXML
    private TextField textFieldGuess;

    @FXML
    private TextArea textAreaGuesses;

    @FXML
    void clickedForOK(ActionEvent event) {
    	System.out.println("here we go...");
    }


}
