public abstract class Product {
    protected String productId;
    private String productName;
    private int productPrice;
    private int productStock;
    
    public Product(String productName, int productPrice, int productStock){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
    
    // Method getter and setter
    public String getProductId(){ return productId;};
    public String getProductName(){ return productName; };
    public int getProductPrice(){ return productPrice; };
    public int getProductStock(){ return productStock; };
    public void setProductStock(int productStock){ this.productStock = productStock; };
    
    // Method abstract
    public abstract void getProductDetail();
    public abstract int getProductDiscount(int discount);
}
