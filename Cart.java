import java.util.ArrayList;
import java.util.Scanner;

public class Cart{
    Tools tools = new Tools(); // Alat bantu untuk membuat tampilan.
    private ArrayList<Product> items; // Daftar produk dalam keranjang.
    private int totalPrice; // Total harga seluruh produk dalam keranjang.
    private int discountPercentage = 0; // Diskon yang diterapkan ke produk.
    Scanner scan = new Scanner(System.in); // Scanner untuk input pengguna.

    public Cart() {
        items = new ArrayList<>(); // Inisialisasi daftar produk.
        totalPrice = 0; // Inisialisasi total harga ke 0.
    }

     // Mengembalikan daftar produk dalam keranjang.
    public ArrayList<Product> getItems() { return items; }

    // Mengembalikan total harga.
    public int getTotalPrice() { return totalPrice; }

    public void addProduct(Product product) {
        if (product.getProductStock() > 0) { // Mengecek apakah produk masih tersedia.
            items.add(product); // Menambahkan produk ke cart atau keranjang.
            product.setProductStock(product.getProductStock() - 1);  // Mengurangi stok produk.
            
            // Menghitung total harga setelah diskon.
            totalPrice += product.getProductPrice() - product.getProductDiscount(discountPercentage);
            System.out.println("Product successfully added to cart!");
        } else {
            System.out.println("Sorry, the product is out of stock!");
        }
    }

    public void deleteProduct(int index) {
        index = index - 1;
        if (index >= 0 && index < items.size()) { // Validasi indeks produk.
            Product product = items.get(index); // Mengambil objek produk dari array items.
            items.remove(index); // Menghapus produk dari keranjang.
            product.setProductStock(product.getProductStock() + 1); // Menambah kembali stok produk.
            
            // Memperbarui total harga.
            totalPrice -= (product.getProductPrice() - product.getProductDiscount(discountPercentage));
            System.out.println("Product successfully removed from cart!");
        } else{
            System.out.println("Invalid Input!");
        }
    }

    public void showCart() {
        if (items.isEmpty()) { // Mengecek apakah keranjang kosong.
            System.out.println("The cart is empty!"); 
            return;
        }
        
        tools.renderPageTitle("Your Cart", "=", 100);  // Menampilkan judul halaman keranjang.
        for (int i = 0; i < items.size(); i++) {
            System.out.println("\nProduct " + (i + 1) + ": ");
            items.get(i).getProductDetail(); // Menampilkan detail setiap produk.
        }
        System.out.println("\nTotal Price: $" + totalPrice); // Tampilkan total harga.
    }

    public void emptyCart() {
        items.clear(); // Hapus semua produk dari keranjang.
        totalPrice = 0; // Reset total harga.
    }
}
