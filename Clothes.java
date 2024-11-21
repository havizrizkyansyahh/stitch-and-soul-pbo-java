
public class Clothes extends Product {
    private String size;
    private String color;
    private String category;
    private static String uniqueProductId = "PRODUCT43500";
    private static int uniqueNumber = 0;
    
    public Clothes(String productName, int productPrice, int productStock, String size, String color, String category) {
        super(productName, productPrice, productStock);
        this.productId = generateProductId();
        this.size = size;
        this.color = color;
        this.category = category;
    }
    
    public String generateProductId(){
        uniqueNumber++;
        return uniqueProductId + uniqueNumber;
    }
    
    public String getProductSize(){ return size; }
    public String getProductColor(){ return color; }
    public String getProductCategory() { return category; }
    
    @Override
    public void getProductDetail() {
        System.out.printf("%-15s %-30s $%-13d %-13d %-13s %-13s %-13s %n", getProductId(), getProductName(), getProductPrice(), getProductStock(), 
                            getProductSize(), getProductColor(), getProductCategory());
    }

    @Override
    public int getProductDiscount(int discount) {
        return getProductPrice() * (discount/100);
    }
    
}
