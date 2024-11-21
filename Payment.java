import java.util.ArrayList;

public class Payment {
    Tools tools = new Tools(); // Alat bantu untuk membuat tampilan dengan border.
    private ArrayList<String> paymentMethods; // Daftar metode pembayaran.

    public Payment() {
        paymentMethods = new ArrayList<>(); // Inisialisasi daftar metode pembayaran.
        paymentMethods.add("Transfer Bank");
        paymentMethods.add("E-Wallet");
        paymentMethods.add("Credit Card");
    }

    public void getPaymentMethod() { // Menampilkan judul halaman.
        tools.renderPageTitle("Payment Methods", "=", 100);
        for (int i = 0; i < paymentMethods.size(); i++) {
            // Menampilkan metode pembayaran satu per satu.
            System.out.println((i + 1) + ". " + paymentMethods.get(i)); 
        }
    }

    public String getPayment(int paymentOption, int totalPrice) {
        // Validasi pilihan pembayaran berada dalam rentang yang valid.
        if (paymentOption >= 1 && paymentOption <= paymentMethods.size()) { 
            // Mengambil metode pembayaran berdasarkan pilihan.
            String method = paymentMethods.get(paymentOption - 1);
            System.out.println("\nProcessing a payment of $" + totalPrice);
            System.out.println("via " + method); // Menampilkan metode pembayaran.
            System.out.println("Payment successful!");
            return method; // Mengembalikan metode pembayaran.
        }
        return null; // Jika pilihan tidak valid, mengembalikan null.
    }    
}
