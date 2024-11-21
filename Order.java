import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order{
    private String orderId; // ID unik untuk pesanan.
    private Customer customer; // Pelanggan yang melakukan pesanan.
    private ArrayList<Product> items; // Daftar produk yang dipesan.
    private int totalPrice; // Total harga pesanan.
    private String date; // Tanggal pesanan.
    private String status; // Status pesanan.
    private String paymentMethod; // Metode pembayaran.
    private static String uniqueOrderId = "ORDER43500"; // Format ID unik pesanan.
    private static int uniqueNumber = 0; // Counter untuk ID pesanan.

    public Order(Customer customer, ArrayList<Product> items, int totalPrice, String paymentMethod) {
        this.orderId = generateOrderId(); // Menghasilkan ID unik pesanan.
        this.customer = customer;
        this.items = new ArrayList<>(items); // Menginisialisasi array items dengan array items yang diberikan oleh parameter.
        this.totalPrice = totalPrice;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.status = "Waiting for payment..."; // Status default order.
        this.paymentMethod = paymentMethod; // Metode pembayaran.
    }

    private String generateOrderId() {
        uniqueNumber++;
        return uniqueOrderId + uniqueNumber; // Membuat ID unik untuk pesanan.
    }

    public void setStatus(String status) {
        this.status = status; // Mengatur status pesanan.
    }

    public void getOrderDetail() {
        // Menampilkan detail pesanan dalam format tabel.
        System.out.printf("%-15s %-30s %-20s %-20s %-20s %-30s $%-10d %n", 
            orderId, 
            customer.getFullname(), 
            date, 
            status, 
            paymentMethod, 
            items.get(0).getProductName() + ", $" + items.get(0).getProductPrice(), 
            totalPrice);
            
        // Jika panjang array items lebih dari 0, menampilkan semua detail objek pesanan.
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
