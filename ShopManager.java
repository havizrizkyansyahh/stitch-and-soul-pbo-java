import java.util.ArrayList;
import java.util.Scanner;

public class ShopManager {
    Tools tools = new Tools();
    private ArrayList<Product> productList;
    private Cart cart;
    private Payment payment;
    private UserManager userManager;

    public ShopManager() {
        productList = new ArrayList<>();
        cart = new Cart();
        payment = new Payment();
        userManager = new UserManager();
        productInitialization();
    }
    
    private void productInitialization() {
        productList.add(new Clothes("Polo shirt", 30, 20, "L", "White", "T-shirt"));
        productList.add(new Clothes("Jeans", 20, 30, "32", "Washed Blue", "Long pants"));
        productList.add(new Clothes("Denim Jacket", 70, 40, "M", "Washed Blue", "Jacket"));
        productList.add(new Clothes("Turtlenect Sweater", 40, 30, "M", "Light Grey", "Sweater"));
        productList.add(new Clothes("Baseball Cap", 25, 23, "L", "Black, Red", "Cap"));
        productList.add(new Clothes("Sneakers", 18, 17, "40", "Black, White", "Shoes"));
    }
    
    public void getProductList() {
        tools.renderPageTitle("Products", "=", 120);
        System.out.printf("%-15s %-30s %-13s %-13s %-13s %-13s %-13s %n", "ID", "Name", "Price", "Stock", "Size", "Color", "Category");
        System.out.println("-".repeat(120));
        for (Product product : productList) {
            product.getProductDetail();
        }
    }

    public void buyProduct(int index) {
        if (index >= 0 && index < productList.size()) {
            cart.addProduct(productList.get(index));
        } else {
            System.out.println("The product index is invalid!");
        }
    }

    public void getCart() {
        cart.showCart();
    }

    public void paymentProccess(Scanner scanner) {
        if (!userManager.isLoggedIn()) {
            System.out.println("Please login first!");
            return;
        }

        if (cart.getItems().isEmpty()) {
            System.out.println("Empty cart! Unable to process payment.");
            return;
        }

        payment.getPaymentMethod();
        System.out.print("Choose a payment method (1-3): ");
        int paymentOption = Integer.parseInt(scanner.nextLine());

        String paymentMethod = payment.getPayment(paymentOption, cart.getTotalPrice());
        if (paymentMethod != null) {
            Customer customer = userManager.getCurrentCustomer();
            Order order = new Order(customer, cart.getItems(), cart.getTotalPrice(), paymentMethod);
            order.setStatus("Already paid");
            customer.addOrder(order);
            cart.emptyCart();
        } else {
            System.out.println("Payment failed! Invalid payment method selected.");
        }
    }

    public void getOrderHistory() {
        if (!userManager.isLoggedIn()) {
            System.out.println("Please login first!");
            return;
        }

        Customer customer = userManager.getCurrentCustomer();
        ArrayList<Order> orderHistory = customer.getOrderHistory();

        if (orderHistory.isEmpty()) {
            System.out.println("There is no order history yet.");
            return;
        }

        tools.renderPageTitle("Order History", "=", 150);
        System.out.printf("%-15s %-30s %-20s %-20s %-20s %-30s %-10s %n", "ID", "Ordered by", "Order date", "Status", "Payment method", "Purchased", "Total");
        System.out.println("-".repeat(150));
        for (Order order : orderHistory) {
            order.getOrderDetail();
        }
    }

    public UserManager getUserManager() {
        return userManager;
    }
}
