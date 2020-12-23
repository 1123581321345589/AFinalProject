package application;

import javafx.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainMenuController {

	@FXML private Button btn;
	@FXML private TextField inputName;
	@FXML private Label Points;
	@FXML private Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	public void handlebtn(ActionEvent event) {
		
			
			String playerPoints = points(inputName.getText());
		
			Points.setText("Predicted points: " + playerPoints);

	}
	
	public String points(String PlayerName) {
		
		String BaseURL = "https://www.footballdb.com/fantasy-football/index.html";
		
		String data;
		
		try {
			
				data = ReadURL(BaseURL, PlayerName);
				
		} catch (IOException e) {
			
			e.printStackTrace();
			
			Points.setText("Predicted points: " + "----- Invalid URL Exeption -----");
			
			data = "NO_DATA_ EXEPTION";
			
		}
		
		System.out.println(data);
		System.out.println();
		
		int index = data.indexOf("class=\"hilite\">");
		
		StringBuilder result = new StringBuilder();
		
		result.append(data.charAt(index + 15));
		result.append(data.charAt(index + 16));
		result.append(data.charAt(index + 17));
		result.append(data.charAt(index + 18));
		result.append(data.charAt(index + 19));
		
		
		return result.toString();
	}
	
	    public static String ReadURL(String TargetURL, String playerName) throws IOException {

	    	String BaseURL = TargetURL + "";
	    	
	        // Make a URL to the web page
	        URL url = new URL(BaseURL);

	        // Get the input stream through URL Connection
	        URLConnection con = url.openConnection();
	        InputStream in = con.getInputStream();

	 

	        BufferedReader br = new BufferedReader(new InputStreamReader(in));

	        String line = null;
	        StringBuilder sb = new StringBuilder();
	        // read each line and append to StringBuilder to be returned
	        while ((line = br.readLine()) != null) {
	            if(line.contains(playerName + " Stats")) {
	            	sb.append(line);
	            }
	        }
	        return sb.toString();
	    }


	
}