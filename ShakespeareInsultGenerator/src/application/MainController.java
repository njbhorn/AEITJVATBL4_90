package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.InputMethodEvent;

public class MainController {

	private ObservableList<String> wordOneList;
	private String choiceOne ;
	private String choiceTwo ;
	private String choiceThree ;

	@FXML
	private ChoiceBox<String> firstBox;

	@FXML
	private ChoiceBox<String> secondBox;

	@FXML
	private ChoiceBox<String> thirdBox;

	@FXML
	private Button generateButton;

	@FXML
	void generateInsult(ActionEvent event) {
		System.out.println("Generate...");
	}

	@FXML
	void wordOne(InputMethodEvent event) {
		System.out.println("word one");
	}
// Selected Item Changed.
//choiceBox.getSelectionModel().selectedItemProperty().addListener(changeListener);

	@FXML
	void wordThree(InputMethodEvent event) {

	}

	@FXML
	void wordTwo(InputMethodEvent event) {

	}

	public void initialize() {
		System.out.println("init window...");
		registerListeners();
		setupChoiceBoxOne(firstBox);
		
	}

	private void setupChoiceBoxOne(ChoiceBox<String> box) {
		wordOneList = getListFromFileOne("words_one.txt");
		firstBox.setItems(wordOneList);
		
	}

	private void registerListeners() {
		firstBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
				choiceOne = firstBox.getItems().get((Integer) number2);
				System.out.println(choiceOne);
				setupChoiceBoxTwo() ;
			}

			private void setupChoiceBoxTwo() {
				System.out.println("Choice two");
				getListFromFileTwo("words_two.txt");
				
			}

			private void getListFromFileTwo(String fileName) {
				ObservableList<String> ol = null;

				try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)) {
					String info = br.readLine();
					String[] words = info.split(",");
					ol = FXCollections.observableArrayList(Arrays.asList(words));
					System.out.println("AFter filtering...");
//					List<String> letterList = ol.stream().filter(s -> s.startsWith(choiceOne.substring(2,3))).collect(Collectors.toList()) ;
					ol.stream().forEach( s -> System.out.println(choiceOne.substring(2, 3)));
					ol.stream().forEach( s -> System.out.println(s.startsWith(choiceOne.substring(2, 3))));
					
			
					ol.stream().filter(s -> s.startsWith(choiceOne.substring(2, 3))).forEach(System.out::println) ;
				
//					letterList.toArray(words);
//					System.out.println(letterList.toString());
//					ol = FXCollections.observableArrayList(Arrays.asList(words));
//					letterList.forEach(s -> firstBox.getItems().add(s));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

//				return ol;
				
			}
		});
		
		secondBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
				choiceTwo = secondBox.getItems().get((Integer) number2);
				System.out.println(secondBox.getItems().get((Integer) number2));
				
			}
		});
		
		thirdBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
				choiceThree = thirdBox.getItems().get((Integer) number2);
				System.out.println(thirdBox.getItems().get((Integer) number2));
			}
		});

	}

//	@FXML
	private ObservableList<String> getListFromFileOne(String fileName) {

//ChangeListener<Language> changeListener = new ChangeListener<Language>() {
//
//    @Override
//    public void changed(ObservableValue<? extends Language> observable, //
//            Language oldValue, Language newValue) {
//        if (newValue != null) {
//            greetingLabel.setText(newValue.getGreeting());
//        }
//    }

		ObservableList<String> ol = null;

		try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)) {
			String info = br.readLine();
			String[] words = info.split(",");
			ol = FXCollections.observableArrayList(Arrays.asList(words));
			firstBox.setItems(ol);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ol;
	}

}
