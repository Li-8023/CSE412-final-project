import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class DatabaseConnection {
    public Connection conn;
    boolean checkUsernameAndPassword;
    public Connection getConnection() {
        String dbname = "CSE412";
        String user = "postgres";
        String password = "Hl011028";
        String url = "jdbc:postgresql://localhost:5432/";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url+dbname, user, password);
            if(conn!=null) {
                System.out.println("Connection successful");
            } else {
                System.out.println("Connection failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }

    /**
     * Inputs the customer login information into the Customer database
     */
    private int customerId = 100;
    public void customerLogin(Connection conn, Customer customer) {
        String table_name = "customer";
        Statement statement;
        try {
            int hash = 7;
            for (int i = 0; i < customer.getFirstname().length(); i++) {
                hash = hash*31 + customer.getFirstname().charAt(i);
            }
            customerId += hash;
            String query = String.format("insert into %s(user_id, username, first_name, last_name, password, email, address) " +
                    "values('%d','%s','%s','%s','%s','%s','%s');",table_name, customerId, customer.getFirstname()+customer.getLastname(), customer.getFirstname(), customer.getLastname(),
                    customer.getPassword(), customer.getEmail(), customer.getAddress());
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Customer added to database."); // logging
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Add a cart item into the cart_item database
     */
    public void addItemToCart(Connection conn)
    {
        String table_name = "cart_item";
        Statement statement;
    }
    public static int id;
    public boolean checkLogin(Connection conn,String a, String b) {
        String table_name = "customer";
        String email = "";
        String password = "";
        String query;
        Statement statement;
        ResultSet rs;
        try {
            query = String.format("select user_id, email, password from customer");
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
            	id  = rs.getInt("user_id");
                email = rs.getString("email");
                password = rs.getString("password");
         
                System.out.println("input email: " + a);
                System.out.println("input password: " + b);
                System.out.println("email: " + email);
                System.out.println("password: "+ password);
                System.out.println("Database login id: " + id);
                if(email.equals(a) && password.equals(b)){
                	System.out.println("match");
                    return true;
                }else{
                	System.out.println("NO match");
                    //return false;
                }
            }
            System.out.println("Information fetched");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
    
  public String copyShip(Connection conn)
  {
  	String table_name = "customer";
  	Statement statement;
  	String address = "";
  	try
  	{
  		System.out.println("copy address user id: " + id);
  		String query = String.format("select address from %s where user_id = %d", table_name, id);
  		statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            address = rs.getString("address");
            System.out.println("Database Address: " + address);
            return address;
        }
  		System.out.println("Successful copy shipping address to billing address");
  		System.out.println("Database id:" + id);
  		
  	}catch(Exception e)
  	{
  		System.out.println(e);
  	}
  	return address;
  }
  
  public int paymentId = 0;
  public void saveCardNumber(Connection conn, Payment pay)
  {
	  String table_name = "payment";
      Statement statement;
     
      
      try {
          int hash = 7;
          for (int i = 0; i < pay.getCardNum().length(); i++) {
              hash = hash*31 + pay.getCardNum().charAt(i);
          }
          paymentId += hash;
          String query = String.format("insert into %s(payment_id, amount, acctnumber) " +
                  "values('%d','%d','%s');",table_name, paymentId, pay.getAmount(), pay.getCardNum());
          statement = conn.createStatement();
          statement.executeUpdate(query);
          System.out.println("Payment Info added to database."); // logging
          System.out.println("Amount: " + pay.getAmount());
          System.out.println("Card number: " + pay.getCardNum());
      } catch (Exception e) {
          System.out.println(e);
      }
  }
  
  
}

   
//}