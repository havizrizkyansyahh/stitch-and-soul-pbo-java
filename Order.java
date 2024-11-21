import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order{
    private String orderId;
    private Customer customer;
    private ArrayList<Product> items;
    private int totalPrice;
    private String date;
    private String status;
    private String paymentMethod;
    private static String uniqueOrderId = "ORDER43500";
    private static int uniqueNumber = 0;

    public Order(Customer customer, ArrayList<Product> items, int totalPrice, String paymentMethod) {
        this.orderId = generateOrderId();
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.totalPrice = totalPrice;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.status = "Waiting for payment...";
        this.paymentMethod = paymentMethod;
    }

    private String generateOrderId() {
        uniqueNumber++;
        return uniqueOrderId + uniqueNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void getOrderDetail() {
        System.out.printf("%-15s %-30s %-20s %-20s %-20s %-30s $%-10d %n", 
            orderId, 
            customer.getFullname(), 
            date, 
            status, 
            paymentMethod, 
            items.get(0).getProductName() + ", $" + items.get(0).getProductPrice(), 
            totalPrice);
            
        if(items.size() > 0){
            for(int i = 1; i < items.size(); i++){
                System.out.printf("%-15s %-30s %-20s %-20s %-20s %-30s %-10s %n", 
                "", "", "", "", "", 
                items.get(i).getProductName() + ", $" + items.get(i).getProductPrice(), 
                "");
            }
        }
    }    
}
