import java.util.ArrayList;
import java.util.Scanner;

public class Cart{
    Tools tools = new Tools();
    private ArrayList<Product> items;
    private int totalPrice;
    private int discountPercentage = 0;
    Scanner scan = new Scanner(System.in);

    public Cart() {
        items = new ArrayList<>();
        totalPrice = 0;
    }

    public ArrayList<Product> getItems() { return items; }

    public int getTotalPrice() { return totalPrice; }

    public void addProduct(Product product) {
        if (product.getProductStock() > 0) {
            items.add(product);
            product.setProductStock(product.getProductStock() - 1);
            totalPrice += product.getProductPrice() - product.getProductDiscount(discountPercentage);
            System.out.println("Product successfully added to cart!");
        } else {
            System.out.println("Sorry, the product is out of stock!");
        }
    }

    public void deleteProduct(int index) {
        if (index >= 0 && index < items.size()) {
            Product product = items.get(index);
            items.remove(index);
            product.setProductStock(product.getProductStock() + 1);
            totalPrice -= (product.getProductPrice() - product.getProductDiscount(discountPercentage));
            System.out.println("Product successfully removed from cart!");
        }
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("The cart is empty!");
            return;
        }
        
        tools.renderPageTitle("Your Cart", "=", 100);
        for (int i = 0; i < items.size(); i++) {
            System.out.println("\nProduct " + (i + 1) + ": ");
            items.get(i).getProductDetail();
        }
        System.out.println("\nTotal Price: $" + totalPrice);
    }

    public void emptyCart() {
        items.clear();
        totalPrice = 0;
    }
}
