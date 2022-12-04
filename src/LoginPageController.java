import javafx.fxml.FXML;
import java.io.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.Connection;


public class LoginPageController{
    public LoginPageController() {
    }
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button logInButton;

    @FXML
    private Button signupButton;

    @FXML
    private Text errorMsg;

    private String inputEmail;
    private String inputPassword;

    @FXML
    public void userLogIn(ActionEvent event) throws IOException 
    {
        inputEmail = username.getText();
        inputPassword = password.getText();
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection conn = dbConnection.getConnection();
        Boolean flag = dbConnection.checkLogin(conn,inputEmail,inputPassword);

        if(flag == true)
        {
	        	  	Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
		            Stage window = (Stage) logInButton.getScene().getWindow();
		            window.setScene(new Scene(root, 600, 400));
	         
        }
        else{
        	if(inputEmail.isEmpty() || inputPassword.isEmpty())
	          {
		          if(inputEmail.isEmpty() && inputPassword.isEmpty()){
		        	  errorMsg.setText("Miss email and password!");
		          }else{
		        	  if(inputEmail.isEmpty())
		        	  {
		        		  System.out.println("Please enter your E-mail.");
			              errorMsg.setText("Please enter your E-mail."); 
		        	  }
		        	  else
		        	  {
		        		  System.out.println("Please enter your password.");
			              errorMsg.setText("Please enter your password."); 
		        	  }
		              
		          }
		          
		        	  
	          }
	          else
	          {
	        	  errorMsg.setText("Wrong email or password!");
	        	  
	          }
            
        }

    }
    @FXML
    public void userSignUp(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Stage window = (Stage) signupButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

//    private boolean checkLogin() throws IOException {
//    	
//        //Main m = new Main();
//		String typeUsername = "Username: ";
//		String typePassword = "Password: ";
//		String name = username.getText().toString();
//		String inputPassword;
//		name = (new StringBuilder()).append(typeUsername).append(name).toString();
//		System.out.println(name);
//
//		inputPassword = password.getText().toString().trim();
//		inputPassword = (new StringBuilder()).append(typePassword).append(inputPassword).toString();
//        
//        //check if name and password are correct, if correct return 
//		//CheckUP check = new CheckUP(name, inputPassword, "Ci.txt");
//        boolean loginValid = true;
//        // = check.checkUsernameAndPassword();
//        //boolean passwordMatch;
//        if (loginValid){
//            errorMsg.setText("Success!");
//            return true;
//            //m.changeScene("HomePage.fxml"); 	        	
//        }else if(username.getText().isEmpty() && password.getText().isEmpty()) {
//            errorMsg.setText("Please enter your data.");
//            return false;
//        }else {
//            errorMsg.setText("Wrong username or password!");
//            return false;
//        } 
//    }
}