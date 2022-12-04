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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class CategoryController implements Initializable{
	
	public CategoryController()
	{

	}
    //send data

    @FXML
    private Label blousePrice;
    @FXML
    private TextField blouseNum;
    @FXML
    private Label coatPrice;
    @FXML
    private TextField coatNum;
    @FXML
    private Label dressPrice;
    @FXML
    private TextField dressNum;
    @FXML
    private Label dungareesPrice;
    @FXML
    private TextField dungareesNum;

    @FXML
    private Label pajamaPrice;
    @FXML
    private TextField pajamaNum;

    @FXML
    private Label suitPrice;

    @FXML
    private TextField suitNum;
    
    private int blouse;
    private int coat = 0;
    private int dress = 0;
    private int dungarees = 0;
    private int pajama = 0;
    private int suit = 0;
    private item item;
//    private LinkedList<item> itemList;
    private ObservableList<item> items;
    //int blouse = 0;
    public void setBlouseQuantity(ActionEvent event)
    {
        if (blouseNum.getText().isEmpty()){
            blouse =0;
        }else {
            blouse = Integer.parseInt(blouseNum.getText());
        }

    }
    
    //int coat;
    public void setCoatQuantity(ActionEvent event)
    {
        coat = 0;
        coat = Integer.parseInt(coatNum.getText());
    }
    

    //int dress;
    public void setDressQuantity(ActionEvent event)
    {
    	dress = 0;
        dress = Integer.parseInt(dressNum.getText());
    }
    //int dungarees;
    public void setDungareesQuantity(ActionEvent event)
    {
    	dungarees = 0;
        dungarees = Integer.parseInt(dungareesNum.getText());
    }
    
    
    //int pajama;
    public void setPajamaQuantity(ActionEvent event)
    {
        pajama = 0;
    	pajama = Integer.parseInt(pajamaNum.getText());
    	
    }
    
    //int suit;
    public void setSuitQuantity(ActionEvent event)
    {
    	suit = 0;
        suit = Integer.valueOf(suitNum.getText());
    }
	
	public int getBlouseQuantity()
	{
		return blouse;
	}
	public int getCoatQuantity()
	{
		return coat;
	}
	public int getDressQuantity()
	{
		return dress;
	}
	public int getDungareesQuantity()
	{
		return dungarees;
	}
	public int getPajamaQuantity()
	{
		return pajama;
	}
	public int getSuitQuantity()
	{
		return suit;
	}
	
	//When this function is called, it will change the scene
	//to the shopping cart view
	public void changeSceneToCart(ActionEvent event) throws IOException
	{
        int blouseQuantity = 0;
        int coatQuantity =0;
        int dressQuantity=0;
        int dungareesQuantity=0;
        int suitQuantity=0;
        int pajamaQuantity =0;

        if (!blouseNum.getText().isEmpty()){
            String blouseNumText = blouseNum.getText();
            blouseQuantity = Integer.valueOf(blouseNumText);
            double blouseTotalPrice = blouseQuantity*15.0;
        }
        if (!coatNum.getText().isEmpty()){
            String coatNumText = coatNum.getText();
            coatQuantity = Integer.valueOf(coatNumText);
            double coatTotalPrice = coatQuantity*30.0;

        }
        if (!dressNum.getText().isEmpty()){
            String dressNumText = dressNum.getText();
            dressQuantity = Integer.valueOf(dressNumText);
            double dressTotalPrice = dressQuantity*25.0;

        }
        if (!dungareesNum.getText().isEmpty()){
            String dungareesNumText = dungareesNum.getText();
            dungareesQuantity = Integer.valueOf(dungareesNumText);
            double dungareesTotalPrice = dungareesQuantity*30.0;

        }
        if (!suitNum.getText().isEmpty()) {
            String suitNumText = suitNum.getText();
            suitQuantity = Integer.valueOf(suitNumText);
            double suitTotalPrice = suitQuantity*50.0;

        }

        if(!pajamaNum.getText().isEmpty()) {

            String pajamaNumText = pajamaNum.getText(); //test for pajama
            pajamaQuantity = Integer.valueOf(pajamaNumText);
            double pajamaTotalPrice = pajamaQuantity * 20.0;
        }

        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoppingCart.fxml"));
        root = loader.load();
        CartController cartController = loader.getController();
        cartController.tableView.setItems(getItem());

        //display quantity
        int finalQuantity =  blouseQuantity+coatQuantity+dressQuantity+dungareesQuantity+pajamaQuantity+suitQuantity;
        double blouseTotalPrice = blouseQuantity*15.0;
        double coatTotalPrice = coatQuantity*30.0;
        double dressTotalPrice = dressQuantity*25.0;
        double dungareesTotalPrice = dungareesQuantity*30.0;
        double pajamaTotalPrice = pajamaQuantity*20.0;
        double suitTotalPrice = suitQuantity*50.0;

        double finalPrice =  blouseQuantity*15.0+coatQuantity*30.0+dressQuantity*25.0+dungareesQuantity*30.0+pajamaQuantity*20.0+suitQuantity*50.0;
        cartController.displayQuantity(finalQuantity);
        cartController.displayPrice(finalPrice);
//        cartController.getItem();
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public ObservableList<item> getItem()
	{
        items = FXCollections.observableArrayList();

        if (!blouseNum.getText().isEmpty()){
            String blouseNumText = blouseNum.getText();
            int blouseQuantity = Integer.valueOf(blouseNumText);
            double blouseTotalPrice = blouseQuantity*15.0;
            items.add(new item("Blouse",  blouseQuantity , blouseTotalPrice));
        }
        if (!coatNum.getText().isEmpty()){
            String coatNumText = coatNum.getText();
            int coatQuantity = Integer.valueOf(coatNumText);
            double coatTotalPrice = coatQuantity*30.0;
            items.add(new item("Coat",  coatQuantity, coatTotalPrice));

        }
        if (!dressNum.getText().isEmpty()){
            String dressNumText = dressNum.getText();
            int dressQuantity = Integer.valueOf(dressNumText);
            double dressTotalPrice = dressQuantity*25.0;
            items.add(new item("Dress", dressQuantity, dressTotalPrice ));

        }
        if (!dungareesNum.getText().isEmpty()){
            String dungareesNumText = dungareesNum.getText();
            int dungareesQuantity = Integer.valueOf(dungareesNumText);
            double dungareesTotalPrice = dungareesQuantity*30.0;
            items.add(new item("Dungarees", dungareesQuantity, dungareesTotalPrice));

        }
        if (!suitNum.getText().isEmpty()) {
            String suitNumText = suitNum.getText();
            int suitQuantity = Integer.valueOf(suitNumText);
            double suitTotalPrice = suitQuantity*50.0;
            items.add(new item("Suit", suitQuantity, suitTotalPrice ));

        }

        if(!pajamaNum.getText().isEmpty()) {

            String pajamaNumText = pajamaNum.getText(); //test for pajama
            int pajamaQuantity = Integer.valueOf(pajamaNumText);
            double pajamaTotalPrice = pajamaQuantity * 20.0;
            //CategoryController categoryCon = new CategoryController();
            items.add(new item("Pajama", pajamaQuantity, pajamaTotalPrice));
        }

		return items;
	}
	
}