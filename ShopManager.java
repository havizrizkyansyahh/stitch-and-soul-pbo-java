import java.util.ArrayList;
import java.util.Scanner;

public class ShopManager {
    Tools tools = new Tools(); // membuat objek tools dari class Tools
    private ArrayList<Product> productList; // deklarasi array list yang elemennya bertipe class Product
    private Cart cart; // deklarasi objek cart dari class Cart 
    private Payment payment; // deklarasi objek payment dari class Payment
    private UserManager userManager; // deklarasi objek userManger dari class UserManager

    public ShopManager() { // konstruktor 
        productList = new ArrayList<>(); // inisialisasi terhadarp array productList
        cart = new Cart(); // inisialisasi objek cart
        payment = new Payment(); // inisialisasi objek payment
        userManager = new UserManager(); // inisialisasi objek userManager
        productInitialization(); // menginisialisasi elemen pada array productList dengan objek produk pakaian
    }
    
    private void productInitialization() { 
        productList.add(new Clothes("Polo shirt", 30, 20, "L", "White", "T-shirt")); // menambahkan objek yang diinisialisasi class Clothes ke array productList
        productList.add(new Clothes("Jeans", 20, 30, "32", "Washed Blue", "Long pants"));
        productList.add(new Clothes("Denim Jacket", 70, 40, "M", "Washed Blue", "Jacket"));
        productList.add(new Clothes("Turtlenect Sweater", 40, 30, "M", "Light Grey", "Sweater"));
        productList.add(new Clothes("Baseball Cap", 25, 23, "L", "Black, Red", "Cap"));
        productList.add(new Clothes("Sneakers", 18, 17, "40", "Black, White", "Shoes"));
    }
    
    public void getProductList() {
        tools.renderPageTitle("Products", "=", 120); // menggunakan method pada objek tools untuk membuat judul halaman
        // mengeprint judul tabel dengan jarak yang simetris menggunakan printf
        System.out.printf("%-15s %-30s %-13s %-13s %-13s %-13s %-13s %n", "ID", "Name", "Price", "Stock", "Size", "Color", "Category");
        System.out.println("-".repeat(120)); // membuat garis - sebanyak 120 kali
        for (Product product : productList) { // melooping produk dari array productList
            product.getProductDetail(); // kemudian objek product memanggil method getProductDetail() yang akan menampilkan data objek produk
        }
    }

    public void buyProduct(int index) { // method buyProduct menerima parameter index dari nomor produk yang dibeli customer
        
        // mengecek apabila index lebih dari sama dengan 0 DAN index tidak lebih dari panjang dari array productList
        if (index >= 0 && index < productList.size()) { 
            // jika kondisi di atas true, maka object cart memanggil method addProduct
            // method addProduct menerima parameter berupa objek yang dikembalikan dari array productList yang sesuai dengan index barang yang dibeli customer
            cart.addProduct(productList.get(index)); 
        } else {
            System.out.println("The product index is invalid!"); // jika kondisi diatas false, maka kode ini akan dijalankan
        }
    }

    public void getCart() { // method untuk menampilan list product yang terdapat pada cart atau keranjang
        cart.showCart(); // objek cart memanggil method showCart() yang akan menampilkan list barang yang ditambahkan oleh customer jika ada
    }

    public void paymentProccess(Scanner scanner) { // method untuk memproses pembayaran  
        
        // mengecek jika user tidak login maka akan program akan menyuruh customer untuk login dan program akan direturn
        if (!userManager.isLoggedIn()) {
            System.out.println("Please login first!");
            return;
        }

        // mengecek apakah array pada cart kosong atau tidak, jika array kosong maka akan dijalankan code dibawah ini
        // jika tidak kosong maka item yang telah ditambahkan oleh customer ke cart akan ditampilkan
        if (cart.getItems().isEmpty()) {
            System.out.println("Empty cart! Unable to process payment.");
            return;
        }

        // objek payment memanggil method getPaymentMethod() yang akan menampilkan pilihan metode pembayaran yang dapat dipilih oleh customer
        payment.getPaymentMethod();
        System.out.print("Choose a payment method (1-3): ");
        int paymentOption = Integer.parseInt(scanner.nextLine()); // variabel untuk menyimpan nomor dari pilihan metode pembayaran customer

        // variabel paymentMethod menyimpan nilai string dari nama metode pembayaran yang dipilih customer jika paymentMethod valid
        // jika tidak valid maka paymentMethod akan ber isi null
        // objek payment memanggil method getPayment dengan parameter nomor paymentOption yang dipilih user dan total harga yang ada pada objek cart
        String paymentMethod = payment.getPayment(paymentOption, cart.getTotalPrice());
        
        // jika payment method tidak sama dengan null maka block code dibawah akan dijalankan
        if (paymentMethod != null) {
            // membuat objek customer dari class Customer, dan mengisi nilainya dengan objek currentCustomer
            // objek userManager memanggil method getCurrentCustomer() untuk mendapatkan objek currentCustomer tersebut
            Customer customer = userManager.getCurrentCustomer(); 
            
            // membuat objek order dari class Order dan menginisialisasinya dengan new Order 
            // dan parameternya yang menerima objek customer, array items dari objek cart, total harga dari objek cart, dan jenis metode pembayaran yang dipilih
            Order order = new Order(customer, cart.getItems(), cart.getTotalPrice(), paymentMethod);
            order.setStatus("Already paid"); // mengganti nilai properti status pada order menjadi already paid
            
            // objek customer memanggil method addOrder yang menerima parameter objek order
            // nantinya objek order akan dimasukkan ke dalam array order history customer
            customer.addOrder(order);
            
            // objek cart memanggil method emptyCart() untuk mengosongkan isi cart apabila proses code di atas sudah berhasil semua
            cart.emptyCart();
        } else {
            System.out.println("Payment failed! Invalid payment method selected.");
        }
    }

    public void getOrderHistory() {  // method untuk menampilkan order history customer
        // mengecek apakah user sudah login, jika belum, maka block kode dibawah akan dijalankan
        if (!userManager.isLoggedIn()) { 
            System.out.println("Please login first!");
            return;
        }
        
        // jika user sudah login mereka dapat melihat otder history
        // membuat objek customer dari class Customer yang diberi nilai objek currentCustomer (customer yang sedang login)
        // objek userManager memanggil method getCurrentCustomer untuk mendapatkan objek currentCustomer tersebut
        Customer customer = userManager.getCurrentCustomer();
        
        // membuat array list ber tipe Order yang isi nilainya adalah array order history customer
        // objek customer memanggil method getOrderHistory() untuk mendapatkan array orderHistory customer
        ArrayList<Order> orderHistory = customer.getOrderHistory();

        // mengecek apakay array orderHistory kosong atau tidak, jika kosong maka block kode dibawah akan dijalankan
        if (orderHistory.isEmpty()) {
            System.out.println("There is no order history yet.");
            return;
        }

        tools.renderPageTitle("Order History", "=", 150); // // menggunakan method pada objek tools untuk membuat judul halaman
        // menampilkan judul tabel order history
        System.out.printf("%-15s %-30s %-20s %-20s %-20s %-30s %-10s %n", "ID", "Ordered by", "Order date", "Status", "Payment method", "Purchased", "Total");
        System.out.println("-".repeat(150)); // membuat garis dengan - yang diulang sebanyak 150 kalu
        
        // looping objek order dari array orderHistory
        for (Order order : orderHistory) {
            // objek order memanggil method getOrderDetail untuk menampilkan data-data order
            order.getOrderDetail();
        }
    }

    public UserManager getUserManager() { // method dengan tipe UserManager untuk mendapatkan objek userManager
        return userManager; // method mengembalikan objek userManager
    }
}
