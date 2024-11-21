import java.util.ArrayList;
public class UserManager {
    private ArrayList<Customer> customers; // Daftar pengguna terdaftar.
    private Customer currentCustomer; // Pengguna yang sedang login.
    
    public UserManager(){
        this.customers = new ArrayList<>(); // Inisialisasi daftar pengguna.
    }
    
    public boolean register(String username, String password, String email, String fullname, String homeAddress, String numberPhone){
        // Validasi bahwa semua field terisi.
        // method trim() berfungsi untuk menghapus whitespace atau spasi bila ada
        // dan isEmpty() untuk mengecek jika kosong maka true dan blok kode dibawah akan dijalankan
        if (username.trim().isEmpty() || password.trim().isEmpty() ||  
            email.trim().isEmpty() || fullname.trim().isEmpty() || 
            homeAddress.trim().isEmpty() || numberPhone.trim().isEmpty()) {
            System.out.println("Error: All fields must be filled!");
            return false;
        }
        
        // Validasi bahwa email sudah terdaftar.
        // customers.stream() mengubah array menjadi aliran(stream) untuk diproses lebih lanjut
        // .anyMatch() adalah operasi pada stream untuk mengecek apakah ada elemen yang memenuhi kondisi tertentu
        // cust -> cust.getEmail().equals(email) adalah ekspresi logika untuk memerika email dari objek cust dengan email yang diberikan
        if(customers.stream().anyMatch(cust -> cust.getEmail().equals(email))){
            System.out.println("Email has been registered");
            return false;
        }
        
        // Membuat pengguna baru dan menambahkannya ke array customers yang sudah terdaftar.
        Customer newCustomer = new Customer(username, password, email, fullname, homeAddress, numberPhone);
        customers.add(newCustomer);
        System.out.println("Account has been successfully created");
        return true;
    }
    
    public boolean login(String email, String password) {
        // Validasi email dan password jika input kosong.
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
            System.out.println("Error: Email and password cannot be empty!");
            return false;
        }
        
        boolean emailFound = false; // Penanda apakah email ditemukan.
        
        for (Customer customer : customers) {
            if(customer.getEmail().equals(email)){ // Memeriksa apakah email cocok.
                emailFound = true;
                
                if (customer.getPassword().equals(password)) { // Validasi password.
                    currentCustomer = customer; // Login berhasil.
                    return true;
                } else if(!customer.getEmail().equals(email) || !customer.getPassword().equals(password)) {
                    System.out.println("Incorrect username or password! please try again.");
                    return false;
                }
            }
        }
        
        if(!emailFound){
            System.out.println("Account not found, please create an account first!");    
        }
        
        return false; // Jika email tidak ditemukan.
    }

    public void logout() { // Logout pengguna yang sedang login.
        if (currentCustomer != null) {
            System.out.println("Logout successful! See you soon, " + currentCustomer.getFullname());
            currentCustomer = null;
        }
    }

    public Customer getCurrentCustomer() {
        return currentCustomer; // Mengembalikan pengguna yang sedang login (objek currentCustomer).
    }

    public boolean isLoggedIn() { // Memeriksa apakah ada pengguna yang login.
        return currentCustomer != null;
     }
}
