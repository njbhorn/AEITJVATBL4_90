package login;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch ( args) ;

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane ( ) ;
		Scene scene = new Scene ( root, 400, 400 ) ;
		root.setAlignment(Pos.CENTER);
		root.setHgap( 10 );
		root.setVgap(10);
		
		Text sceneTitle = new Text ( "Welcome") ;
		root.add(sceneTitle, 0, 0);
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		Label userName = new Label ("User Name" ) ;
		root.add(userName, 0, 1);
		
		Label pwd = new Label ("Password" ) ;
		root.add(pwd, 0, 2);
		
		TextField userTextField = new TextField () ;
		root.add(userTextField, 1, 1);
		
		PasswordField pwdTextField = new PasswordField() ;
		root.add(pwdTextField, 1,2);
		
		Button btn = new Button ( "Login") ;
		
		HBox hbBtn = new HBox(10) ;
		hbBtn.setAlignment(Pos.CENTER_LEFT);
		hbBtn.getChildren().add(btn);
		
		root.add(hbBtn,  1,  4);
		
		Text actionTarget = new Text () ;
		root.add(actionTarget, 1, 6);
		
		btn.setOnAction( e -> {
			
			actionTarget.setFill( Color.FIREBRICK);
			actionTarget.setText("Login Button Pressed!");
			
		});
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

}
