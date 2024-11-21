import java.util.ArrayList;
public class Customer extends User{
    Tools tools = new Tools();
    private String homeAddress;
    private String numberPhone;
    private static String uniqueId = "CUST43500";
    private static int uniqueNumber = 0;
    private ArrayList<Order> orderHistory;
    
    public Customer(String username, String password, String email, String fullname, String homeAddress, String numberPhone){
        super(username, password, email, fullname);
        this.userId = generateUserId();
        this.homeAddress = homeAddress;
        this.numberPhone = numberPhone;
        this.orderHistory = new ArrayList<>();  // Initialize the ArrayList in constructor
    }
    
    @Override // Polymorfisme
    protected String generateUserId(){
        uniqueNumber++;
        return uniqueId + uniqueNumber;
    }
    
    @Override // Polymorfisme
    public void getUserProfile(){
        tools.renderPageTitle("Customer profile", "=", 100);
        System.out.println("User ID: " + userId);
        System.out.println("Fullname: " + fullname);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Home Address: " + homeAddress);
        System.out.println("Number Phone: " + numberPhone);
    }
    
    public void addOrder(Order order){
        orderHistory.add(order);
    }
    
    public ArrayList<Order> getOrderHistory(){
        return orderHistory;
    }
    
    // Method getter (encapsulation)
    public String getHomeAddress(){ return homeAddress; };
    public String getNumberPhone(){ return numberPhone; };
}
