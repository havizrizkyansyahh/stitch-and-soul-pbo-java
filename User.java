public abstract class User{
    // Atribut untuk menyimpan informasi pengguna
    protected String userId; // ID unik untuk pengguna
    protected String username; // Nama pengguna
    protected String password; // Kata sandi pengguna
    protected String email; // Email pengguna
    protected String fullname; // Nama lengkap pengguna
    
    // Konstruktor untuk menginisialisasi data pengguna
    public User(String username, String password, String email, String fullname){
        this.username = username; // Inisialisasi nama pengguna
        this.password = password; // Inisialisasi kata sandi
        this.email = email;       // Inisialisasi email
        this.fullname = fullname; // Inisialisasi nama lengkap
    }
    
    // Method abstrak untuk menghasilkan ID unik pengguna
    protected abstract String generateUserId();
    
    // Method abstrak untuk menampilkan profil pengguna
    public abstract void getUserProfile();
    
    // Getter untuk atribut (implementasi encapsulation)
    public String getUserId(){ return userId; } // Mengembalikan userId
    public String getUsername(){ return username; } // Mengembalikan username
    public String getEmail(){ return email; } // Mengembalikan email
    public String getFullname(){ return fullname; } // Mengembalikan fullname
    protected String getPassword(){ return password; } // Getter untuk password, hanya dapat diakses oleh subclass
}
