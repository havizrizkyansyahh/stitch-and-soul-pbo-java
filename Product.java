public abstract class Product {
    protected String productId; // ID unik produk.
    private String productName;  // Nama produk.
    private int productPrice; // Harga produk.
    private int productStock; // Jumlah stok produk.
    
    public Product(String productName, int productPrice, int productStock){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
    
    // Getter dan setter untuk mengakses/memodifikasi atribut. 
    public String getProductId(){ return productId;};
    public String getProductName(){ return productName; };
    public int getProductPrice(){ return productPrice; };
    public int getProductStock(){ return productStock; };
    public void setProductStock(int productStock){ this.productStock = productStock; };
    
    // Method abstrak untuk implementasi spesifik di subclass.
    public abstract void getProductDetail(); 
    public abstract int getProductDiscount(int discount); 
}
