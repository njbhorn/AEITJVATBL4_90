package application;

import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

public class ControllerLeague {

	@FXML
	private TitledPane titledpane_prem;

	@FXML
	private ListView<String> listview_prem;

	@FXML
	private TitledPane titledpane_cham;

	@FXML
	private ListView<String> listview_cham;

	@FXML
	private TitledPane titledpane_done;

	@FXML
	private ListView<String> listview_done;

	@FXML
	private TextField textfield_team;

	@FXML
	private ChoiceBox<String> combo_leagues;

	@FXML
	private Button btn_add;

	@FXML
	private TextField count_prem;

	@FXML
	private TextField count_cham;

	@FXML
	private TextField count_done;

	IntegerExpression intex_prem_count;
	IntegerExpression intex_cham_count;
	IntegerExpression intex_done_count;
	IntegerExpression intex_count;

	@FXML
	void addTeam(ActionEvent event) {
		// first get combo box value
		String league = combo_leagues.getValue();
		String team = textfield_team.getText();
		System.out.println(league);
		switch (league) {
		case "Premier League":
			addTeamToLeague(team, League.PREMIERSHIP);
			break;
		case "Championship":
			addTeamToLeague(team, League.CHAMPIONSHIP);
			break;
		case "Division One":
			addTeamToLeague(team, League.DIVSION_ONE);
			break;
		}
	}

	public void initialize() {
		ObservableList<String> options = FXCollections.observableArrayList("Premier League", "Championship",
				"Division One");

		combo_leagues.getItems().addAll(options);
		combo_leagues.setValue(options.get(0));
		// combo_leagues.getItems().addAll(
		// "Premier League"
		// , "Championship"
		// ,"Division One"
		// ) ;
	}

	private void addTeamToLeague(String team, League premiership) {
		switch (premiership) {
		case PREMIERSHIP:
			addTeamToList(listview_prem, team);
			break;
		case CHAMPIONSHIP:
			addTeamToList(listview_cham, team);
			break;
		case DIVSION_ONE:
			addTeamToList(listview_done, team);
			break;
		}

	}

	private void addTeamToList(ListView<String> listview, String team) {
		listview.getItems().add(team);
		expandAccordionForCorrectView(listview);
		incrementCountForCorrectView(listview);
		// Accordion acc = (Accordion)
		// listview.getParent().getParent().getParent().getParent();

	}

	private void incrementCountForCorrectView(ListView<String> listview) {
		// System.out.println(listview.getItems().size());
		// System.out.println(listview.getId());
		intex_count = new SimpleIntegerProperty(listview.getItems().size());
		switch (listview.getId()) {
		case "listview_prem":
			count_prem.textProperty().bind(intex_count.asString());
			break;
		case "listview_cham":
			count_cham.textProperty().bind(intex_count.asString());
			break;
		case "listview_done":
			count_done.textProperty().bind(intex_count.asString());
			break;
		}
	}

	private boolean expandAccordionForCorrectView(Parent parent) {
		boolean return_flag = false;
		// get TitledPane first then Accordion
		TitledPane pane;
		Accordion acc;
		while (!(parent instanceof TitledPane)) {
			System.out.println(parent);
			parent = parent.getParent();
		}
		pane = (TitledPane) parent;
		while (!(parent instanceof Accordion)) {
			System.out.println(parent);
			parent = parent.getParent();
			return_flag = true;
		}
		acc = (Accordion) parent;
		acc.setExpandedPane(pane);
		return return_flag;
	}

}
