import java.util.ArrayList;
public class UserManager {
    private ArrayList<Customer> customers;
    private Customer currentCustomer;
    
    public UserManager(){
        this.customers = new ArrayList<>();
    }
    
    public boolean register(String username, String password, String email, String fullname, String homeAddress, String numberPhone){
        // Simple validation - check if any field is empty
        if (username.trim().isEmpty() || password.trim().isEmpty() || 
            email.trim().isEmpty() || fullname.trim().isEmpty() || 
            homeAddress.trim().isEmpty() || numberPhone.trim().isEmpty()) {
            System.out.println("Error: All fields must be filled!");
            return false;
        }
        
        // Check if email already exist
        if(customers.stream().anyMatch(cust -> cust.getEmail().equals(email))){
            System.out.println("Email has been registered");
            return false;
        }
        
        Customer newCustomer = new Customer(username, password, email, fullname, homeAddress, numberPhone);
        customers.add(newCustomer);
        System.out.println("Account has been successfully created");
        return true;
    }
    
    public boolean login(String email, String password) {
        // Check if email or password is empty
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
            System.out.println("Error: Email and password cannot be empty!");
            return false;
        }
        
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                currentCustomer = customer;
                return true;
            } else if(!customer.getEmail().equals(email) || !customer.getPassword().equals(password)) {
                System.out.println("Incorrect username or password! please try again.");
                return false;
            }
        }
        System.out.println("Account not found, please create an account first!");
        return false;
    }

    public void logout() {
        if (currentCustomer != null) {
            System.out.println("Logout successful! See you soon, " + currentCustomer.getFullname());
            currentCustomer = null;
        }
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public boolean isLoggedIn() {
        return currentCustomer != null;
    }
}
