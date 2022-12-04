import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class CompleteOrderViewController {

	public void switchToCategory(ActionEvent event) throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
}
