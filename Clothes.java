
public class Clothes extends Product {
    private String size; // Ukuran pakaian.
    private String color; // Warna pakaian.
    private String category; // Kategori pakaian (misal: casual, formal).
    private static String uniqueProductId = "PRODUCT43500"; // Format ID unik produk.
    private static int uniqueNumber = 0;  // Counter untuk ID unik.
    
    public Clothes(String productName, int productPrice, int productStock, String size, String color, String category) {
        super(productName, productPrice, productStock); // Memanggil konstruktor kelas induk.
        this.productId = generateProductId(); // Menghasilkan ID unik untuk produk.
        this.size = size;
        this.color = color;
        this.category = category;
    }
    
    public String generateProductId(){
        uniqueNumber++;
        return uniqueProductId + uniqueNumber; // Membuat ID unik produk.
    }
    
    // Getter untuk atribut khusus pakaian.
    public String getProductSize(){ return size; }
    public String getProductColor(){ return color; }
    public String getProductCategory() { return category; }
    
    @Override
    public void getProductDetail() {
        // Menampilkan detail produk dalam format tabel.
        System.out.printf("%-15s %-30s $%-13d %-13d %-13s %-13s %-13s %n", getProductId(), getProductName(), getProductPrice(), getProductStock(), 
                            getProductSize(), getProductColor(), getProductCategory());
    }

    @Override
    public int getProductDiscount(int discount) {
        // Menghitung nilai diskon berdasarkan persentase.
        return getProductPrice() * (discount/100);
    }
    
}
