import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;

public class CreateAccountViewController {

    @FXML
    public TextField fnameTxtFld;
    @FXML
    public TextField lnameTxtFld;
    @FXML
    public TextField emailTxtFld;
    @FXML
    public PasswordField passTxtFld;
    @FXML
    public PasswordField confirmPassTxtFld;
    @FXML
    public Button submitButton;
    @FXML
    public Label passLbl;

    @FXML
    private Text prompt;
    
    @FXML
    private Text passText;
    @FXML
    public TextField addressTxtFld;

    private String customerFname;
    private String customerLname;
    private String customerEmail;
    private String customerPass;
    private String customerPassConfirm;
    private String customerAddress;
    
    public int CUSTOMER_ID;

    @FXML
    public void customerViewStart(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Save customer data to database and launch category page
     * */
    public void submitClicked(ActionEvent event) throws Exception {
        // get customer data
        customerFname = fnameTxtFld.getText();
        customerLname = lnameTxtFld.getText();
        customerEmail = emailTxtFld.getText();
        customerPass = passTxtFld.getText();
        customerPassConfirm = confirmPassTxtFld.getText();
        customerAddress = addressTxtFld.getText();

        if(customerFname.isEmpty() || customerLname.isEmpty() || customerEmail.isEmpty() || customerPass.isEmpty() || customerAddress.isEmpty()) {
            prompt.setText("One or more fields cannot be empty.");
        } else {
            prompt.setText("");
            
            // check for password
            if(!customerPass.equals(customerPassConfirm)) {
            	passText.setText("Confirmation password doesn't match. Please try again");
            } else {
            	passText.setText("");
                System.out.println("Password match. Saving data."); // debug
                int customerId = 100;
                int hash = 7;
                for (int i = 0; i < customerFname.length(); i++) {
                    hash = hash*31 + customerFname.charAt(i);
                }
                customerId += hash;
                CUSTOMER_ID = customerId;
                // create a new customer object
                Customer cust = new Customer(customerId, customerFname, customerLname, customerEmail, customerPass, customerAddress);
                //store customer data in DB
                DatabaseConnection dbConnection = new DatabaseConnection();
                Connection conn = dbConnection.getConnection();
                dbConnection.customerLogin(conn, cust);

                // go to CATEGORY page
                Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        
    }
}