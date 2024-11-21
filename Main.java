import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in); // membuat objek scan dari class Scanner
        Tools tools = new Tools(); // membuat objek tools dari class Tools
        String username, email, password, fullname, numberPhone, homeAddress; // deklarasi variabel yang akan digunakan
        ShopManager shop = new ShopManager(); // membuat objek shop dari class ShopManager untuk memudahkan mengatur shop
        String tempScan;
        boolean programRunning = true; // variabel boolean yang akan membuat program dijalankan selama value nya true
        boolean menuRunning = false; // variabel boolean yang akan menampilkan menu setelah login apabila value nya true
        
        // menjalankan perulangan do while selama variabel programRunning bernilai true
        do{ 
            if(!shop.getUserManager().isLoggedIn()){ // mengecek kondisi apabila user belum login maka menu yang ditampilkan adalah menu login atau register
                System.out.print("\u000c"); // untuk Clear screen
                System.out.println("USE BLUEJ FOR BETTER EXPERIENCE (SUPPORT ANSI CODE FOR CLEAR SCREEN)");
                tools.renderPageTitle("Welcome to Stitch & Soul", "=", 100); // untuk render page title
                System.out.println("Press [1] to login, \nPress [2] to register an account, \nPress [0] to exit the program. \n");
                System.out.print("Select: ");
                tempScan = scan.nextLine(); // variabel untuk menyimpan nilai input
                
                // percabangan menu login atau register
                switch(tempScan){ // mengecek nilai input sesuai case nomor yang diinput jika 1 maka login, jika 2 maka register
                    case "1": // ketika user memilih 1, form login akan ditampilkan
                        System.out.print("\u000c"); // ANSI code for clear screen in bluej
                        tools.renderPageTitle("Login to Stitch & Soul", "=", 100); // menggunakan method pada objek tools untuk membuat judul halaman
                        System.out.print("Email: ");
                        email= scan.nextLine(); // input email
                        System.out.print("Password: ");
                        password = scan.nextLine(); // input password
                        
                        // melakukan validasi pada input email dan password, apabila akun ditemukan, maka menu setelah login akan ditampilkan
                        if(shop.getUserManager().login(email, password)){  
                            menuRunning = true; // merubah variabel menuRunning menjadi true agar menu setelah login ditampilkan
                        } else{ // jika validasi false maka user akan diarahkan kembali ke menu login register
                            System.out.println("\nPress Enter to return to main menu..."); 
                            scan.nextLine(); 
                        };
                        
                        break;
                    case "2": // ketika user memilih 2, form register akun akan ditampilkan
                        System.out.print("\u000c"); // ANSI code for clear screen in bluej
                        tools.renderPageTitle("Register a Stitch & Soul account", "=", 100); // menggunakan method pada objek tools untuk membuat judul halaman
                        System.out.print("Create your username: ");
                        username = scan.nextLine(); // input username
                        System.out.print("Create password: ");
                        password = scan.nextLine(); // input password
                        System.out.print("Your Email: ");
                        email = scan.nextLine(); // input email
                        System.out.print("Your fullname: ");
                        fullname = scan.nextLine(); // input fullname
                        System.out.print("Your home address: ");
                        homeAddress = scan.nextLine(); // input homeAddress
                        System.out.print("Your number phone: ");
                        numberPhone = scan.nextLine(); // input numberPhone
                        
                        // memanggil objek shop, kemudian memanggil method getUserManager, method tersebut mengembalikan objek userManager
                        // di dalam objek userManager terdapat method register yang melakukan validasi apakah registrasi sukses
                        // jika registrasi sukses maka user hanya perlu ke menu login dan masuk ke akun
                        shop.getUserManager().register(username, password, email, fullname, homeAddress, numberPhone);
                        System.out.println("\nPress Enter to return to main menu...");
                        scan.nextLine();
                        break;
                    case "0": // keluar dari program
                        System.out.println("Thank you for visiting our store!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input. please try again.");
                        scan.nextLine();
                        break;
                } 
            } else {
                // jika user sudah berhasil login maka menu dibawah ini akan ditampilkan
                while(menuRunning) { // jika value variabel menuRunning true maka program dibawah ini akan dijalankan
                    System.out.print("\u000c"); 
                    // memanggil objek shop yang memanggil method getUserManager() untuk mendapatkan objek userManager
                    // lalu objek userManager memanggil method getCurrentCustomer() untuk mendapatkan objek currentCustomer yang sudah berhasil login
                    // objek currentCustomer memanggil method getFullname() untuk mendapatkan atribut nama user dari objek currentUser
                    System.out.println("Login successful! Welcome, " + shop.getUserManager().getCurrentCustomer().getFullname());
                    tools.renderPageTitle("Stitch & Soul Main Menu", "=", 100); // menggunakan method pada objek tools untuk membuat judul halaman
                    System.out.println("1. Product Catalogue");
                    System.out.println("2. Buy Products");
                    System.out.println("3. Your Cart");
                    System.out.println("4. Payment Processing (Checkout)");
                    System.out.println("5. Order History");
                    System.out.println("6. Your Profile");
                    System.out.println("7. Logout");
                    System.out.println("0. Exit Program");
                    System.out.print("\nChoose menu: ");
                    
                    tempScan = scan.nextLine(); // membuat variabel untuk menyimpan nilai input
                    
                    switch (tempScan) {
                        case "1":
                            System.out.print("\u000c"); // untuk clear screen
                            shop.getProductList(); // objek shop memanggil method getProductList() untuk menampilkan list produk pakaian yang dijual
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "2":
                            System.out.print("\u000c"); // untuk clear screen
                            shop.getProductList(); // objek shop memanggil method getProductList() untuk menampilkan list produk pakaian yang dijual
                            System.out.print("\nEnter the number of the product you wish to purchase: ");
                            try {
                                int productNumber = Integer.parseInt(scan.nextLine()); // menyimpan nomor produk yang ingin dibeli customer
                                
                                // objek shop memanggil method buyProduct dengan parameter nomor produk yang ingin dibeli dikurang 1 karena array mulai dari 0
                                shop.buyProduct(productNumber - 1); 
                            } catch (NumberFormatException e) { // jika format nomor tidak sesuai dengan nomor yang ditampilkan maka pilihan invalid
                                System.out.println("Invalid product number!"); 
                            }
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "3":
                            System.out.print("\u000c"); // untuk clear screen
                            
                            // objek shop memanggil method getCart() yang fungsinya untuk menampilkan list produk yang telah ditambahkan ke cart atau keranjang
                            shop.getCart(); 
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "4":
                            System.out.print("\u000c"); // untuk clear screen
                            
                            // objek shop memanggil method paymentProccess dengan parameter object scan dari class Scanner 
                            // agar nantinya dapat digunakan di dalam method tersebut untuk menginput jenis pembayaran
                            shop.paymentProccess(scan); 
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "5":
                            System.out.print("\u000c"); // untuk clear screen
                            
                            // objek shop memanggil method getOrderHistory() untuk menampilkan order atau pesanan customer yang telah berhasil dibayar dan dipesan
                            shop.getOrderHistory();
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "6":
                            System.out.print("\u000c"); // untuk clear screen
                            
                            // objek shop memanggil method getUserManager() yang mengembalikan objek userManager
                            // objek userManager memanggil method getCurrentCustomer() yang mengembalikan objek currentCustomer
                            // objek currentCustomer memanggil method getUserProfile() untuk menampilkan profil user
                            shop.getUserManager().getCurrentCustomer().getUserProfile();
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "7":
                            System.out.print("\u000c"); // untuk clear screen
                            
                            // objek shop memanggil method getUserManager() yang mengembalikan objek userManager
                            // objek userManager memanggil method logout() yang akan memberi nilai null pada object currentCustomer
                            // sehingga customer keluar dari akun nya
                            shop.getUserManager().logout(); 
                            System.out.println("Successfully logged out!");
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            menuRunning = false;  // Exit the menu loop
                            break;
                            
                        case "0":
                            System.out.println("Thank you for shopping!");
                            menuRunning = false; // menuRunning diberi false agar keluar dari menu
                            programRunning = false; // programRunning diberi false agar program berhenti
                            break;
                            
                        default:
                            System.out.println("Invalid selection!"); // jika nomor tidak terdapat pada case maka akan menampilkan invalid selection
                            System.out.println("\nPress Enter to continue...");
                            scan.nextLine();
                            break;
                    }
                }
            }
        } while(programRunning);
        scan.close();
    }
}
