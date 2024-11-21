public class Tools {
    String title; // Judul halaman.
    String border; // Karakter border.
    int borderLength; // Panjang border.
    int padding; // Jumlah padding untuk judul.
    
    public void renderPageTitle(String title, String border,int borderLength){
        this.padding = (title.length() + borderLength) / 2; // Menghitung padding untuk memposisikan judul di tengah.
        System.out.println(border.repeat(borderLength)); // Menampilkan border atas.
        System.out.printf("%" + this.padding + "s %n", title); // Menampilkan judul dengan padding.
        System.out.println(border.repeat(borderLength)); // Menampilkan border bawah.
    }
}
