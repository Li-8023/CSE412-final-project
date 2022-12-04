import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.FXML;

 
public class App extends Application {
	// private static Stage stg;

	    @Override
	    public void start(Stage stage) throws Exception{
	        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }
	    public static void main(String[] args) {
	        launch(args);
	    }
}
