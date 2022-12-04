import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.*;

public class CartController implements Initializable{
	public CartController() {

	}

	@FXML
	public TableView<item> tableView;
	@FXML private ObservableList<item> item = FXCollections.observableArrayList();
    @FXML private TableColumn<item, String> itemDetailsColumn;
    @FXML private TableColumn<item, Integer> quantityColumn;
    
    @FXML private TableColumn<item, Double> totalPriceColumn;

	@FXML
	private Label FinalQuantity;
	public void displayQuantity(int finalQuantity)
	{
		String output = Integer.toString(finalQuantity);
		this.FinalQuantity.setText(output +" Items");
	}
	@FXML
	private Label FinalPrice;
	public void displayPrice(double finalPrice)
	{
		String output = Double.toString(finalPrice);
		this.FinalPrice.setText("Total："+ output);
	}

    //parsing information

	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		
			itemDetailsColumn.setCellValueFactory(new PropertyValueFactory<item, String>("itemDetails"));
			quantityColumn.setCellValueFactory(new PropertyValueFactory<item, Integer>("quantity"));
			totalPriceColumn.setCellValueFactory(new PropertyValueFactory<item, Double>("totalPrice"));
			//tableView.getColumns().addAll(itemDetailsColumn,quantityColumn,totalPriceColumn);
	}
	
	public void switchToCategory(ActionEvent event) throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchToCusAccount(ActionEvent event) throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchToCompleteOrderView(ActionEvent event) throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("CompleteOrderView.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchToPayment(ActionEvent event) throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("PaymentMethod.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
}