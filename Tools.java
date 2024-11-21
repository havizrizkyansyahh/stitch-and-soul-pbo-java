public class Tools {
    String title;
    String border;
    int borderLength;
    int padding;
    
    public void renderPageTitle(String title, String border,int borderLength){
        this.padding = (title.length() + borderLength) / 2;
        System.out.println(border.repeat(borderLength));
        System.out.printf("%" + this.padding + "s %n", title);
        System.out.println(border.repeat(borderLength));
    }
}
