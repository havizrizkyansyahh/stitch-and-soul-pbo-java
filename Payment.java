import java.util.ArrayList;

public class Payment {
    Tools tools = new Tools();
    private ArrayList<String> paymentMethods;

    public Payment() {
        paymentMethods = new ArrayList<>();
        paymentMethods.add("Transfer Bank");
        paymentMethods.add("E-Wallet");
        paymentMethods.add("Credit Card");
    }

    public void getPaymentMethod() {
        tools.renderPageTitle("Payment Methods", "=", 100);
        for (int i = 0; i < paymentMethods.size(); i++) {
            System.out.println((i + 1) + ". " + paymentMethods.get(i));
        }
    }

    public String getPayment(int paymentOption, int totalPrice) {
        if (paymentOption >= 1 && paymentOption <= paymentMethods.size()) {
            String method = paymentMethods.get(paymentOption - 1);
            System.out.println("\nProcessing a payment of $" + totalPrice);
            System.out.println("via " + method);
            System.out.println("Payment successful!");
            return method;
        }
        return null;
    }    
}
