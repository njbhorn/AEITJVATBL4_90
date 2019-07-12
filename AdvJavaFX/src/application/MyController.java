package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MyController {

	@FXML
	private Button btnOK;

	@FXML
	void okClicked(ActionEvent event) {
		System.out.println("Clicked...");
	}

}
