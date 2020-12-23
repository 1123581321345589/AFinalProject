package application;
	
import java.net.URL;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class Main extends Application implements Initializable {
	
	public Button playGame;
	
	public String file = "mainMenu.fxml";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(file));
			
			Parent root = FXMLLoader.load(getClass().getResource(file));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Fantasy Points V1.00");	
			primaryStage.setScene(scene);
			primaryStage.show();
			
			MainMenuController c = loader.getController();
			
			c.setMain(this);
			
			/*
			 * playGame.setOnAction(event -> {
				
				primaryStage.hide();
		
				
			});
			
			*/
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
	}
	
	
	
}
