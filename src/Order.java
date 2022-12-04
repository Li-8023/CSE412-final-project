public class Order {
    private String item;
    private String firstname;
    private String lastname;
    private String email;
    private int amount;
    private String password;
    private String address;
    Order(String item, String lastname, String email, String password, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
    }
    String getItem() {
        return this.firstname;
    }

    String getLastname() {
        return this.lastname;
    }

    String getEmail() {
        return this.email;
    }

    String getPassword() {
        return this.password;
    }

    String getAddress() {
        return this.address;
    }
}
