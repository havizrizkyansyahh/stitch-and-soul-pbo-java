import java.util.ArrayList;
public class Customer extends User{
    Tools tools = new Tools(); // Alat bantu untuk membuat tampilan.
    private String homeAddress; // Alamat rumah pelanggan.
    private String numberPhone; // Nomor telepon pelanggan.
    private static String uniqueId = "CUST43500"; // Format ID unik pelanggan.
    private static int uniqueNumber = 0; // Counter untuk ID pelanggan.
    private ArrayList<Order> orderHistory; // Riwayat pesanan pelanggan.
    
    public Customer(String username, String password, String email, String fullname, String homeAddress, String numberPhone){
        super(username, password, email, fullname); // Memanggil konstruktor kelas induk.
        this.userId = generateUserId(); // Menghasilkan ID pelanggan.
        this.homeAddress = homeAddress;
        this.numberPhone = numberPhone;
        this.orderHistory = new ArrayList<>();  // Inisialisasi riwayat pesanan.
    }
    
    @Override // Polymorfisme
    protected String generateUserId(){
        uniqueNumber++;
        return uniqueId + uniqueNumber; // Menghasilkan ID unik pelanggan.
    }
    
    @Override // Polymorfisme
    public void getUserProfile(){ // Menampilkan profil pelanggan.
        tools.renderPageTitle("Customer profile", "=", 100);
        System.out.println("User ID: " + userId);
        System.out.println("Fullname: " + fullname);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Home Address: " + homeAddress);
        System.out.println("Number Phone: " + numberPhone);
    }
    
    public void addOrder(Order order){ // Menambahkan pesanan ke riwayat.
        orderHistory.add(order); 
    }
    
    public ArrayList<Order> getOrderHistory(){
        return orderHistory; // Mengembalikan array orderHistory.
    }
    
    // Method getter (encapsulation)
    public String getHomeAddress(){ return homeAddress; };
    public String getNumberPhone(){ return numberPhone; };
}
