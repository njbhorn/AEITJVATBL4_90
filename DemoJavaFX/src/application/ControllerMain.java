package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerMain {

//    @FXML
    private Button btn_ok;

    @FXML
    private Button btn_cancel;

    @FXML
    private TextField txtField;

    @FXML
    private Label lblField;

    @FXML
    private Button btn_open;

    @FXML
    void clicked(ActionEvent event) {
    	System.out.println(event.getEventType().toString());
    	items.add(txtField.getText()) ;
    }

    @FXML
    private ListView<String> listview;

    @FXML
    void openNewWindow(ActionEvent event) throws IOException {


    	String pathAccordionWindow = "src/application/AccordionWindow.fxml";

		FXMLLoader loader = new FXMLLoader ( );

		FileInputStream fxmlStreamAccordion = new FileInputStream(pathAccordionWindow);

		ControllerLeague controller = new ControllerLeague() ;
		loader.setController(controller);

		Parent accordion = loader.load(fxmlStreamAccordion);

		Scene scene2 = new Scene(accordion);

		Stage secondStage = new Stage() ;
		secondStage.setScene(scene2);
		secondStage.show();

    }

    ObservableList<String> items = FXCollections.observableArrayList() ;

    public void initialize() {
    	lblField.textProperty().bind(txtField.textProperty());

    	listview.setItems(items);
    }

	public Button getBtn_ok() {
		return btn_ok;
	}

	public void setBtn_ok(Button btn_ok) {
		this.btn_ok = btn_ok;
	}

	public Button getBtn_cancel() {
		return btn_cancel;
	}

	public void setBtn_cancel(Button btn_cancel) {
		this.btn_cancel = btn_cancel;
	}

	public TextField getTxtField() {
		return txtField;
	}

	public void setTxtField(TextField txtField) {
		this.txtField = txtField;
	}

	public Label getLblField() {
		return lblField;
	}

	public void setLblField(Label lblField) {
		this.lblField = lblField;
	}

	public ListView<String> getListview() {
		return listview;
	}

	public void setListview(ListView<String> listview) {
		this.listview = listview;
	}





}
