import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Tools tools = new Tools();
        String username, email, password, fullname, numberPhone, homeAddress;
        ShopManager shop = new ShopManager();
        String tempScan;
        boolean programRunning = true;
        boolean menuRunning = false;
        
        do{
            if(!shop.getUserManager().isLoggedIn()){
                System.out.print("\u000c"); // Clear screen
                System.out.println("USE BLUEJ FOR BETTER EXPERIENCE (SUPPORT ANSI CODE FOR CLEAR SCREEN)");
                tools.renderPageTitle("Welcome to Stitch & Soul", "=", 100); // To render page title
                System.out.println("Press [1] to login, \nPress [2] to register an account, \nPress [0] to exit the program. \n");
                System.out.print("Select: ");
                tempScan = scan.nextLine();
                
                switch(tempScan){
                    case "1":
                        System.out.print("\u000c"); // ANSI code for clear screen in bluej
                        tools.renderPageTitle("Login to Stitch & Soul", "=", 100);
                        System.out.print("Email: ");
                        email= scan.nextLine();
                        System.out.print("Password: ");
                        password = scan.nextLine();
                        
                        if(shop.getUserManager().login(email, password)){ 
                            menuRunning = true; 
                        } else{ 
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine(); 
                        };
                        
                        break;
                    case "2":
                        System.out.print("\u000c"); // ANSI code for clear screen in bluej
                        tools.renderPageTitle("Register a Stitch & Soul account", "=", 100);
                        System.out.print("Create your username: ");
                        username = scan.nextLine();
                        System.out.print("Create password: ");
                        password = scan.nextLine();
                        System.out.print("Your Email: ");
                        email = scan.nextLine();
                        System.out.print("Your fullname: ");
                        fullname = scan.nextLine();
                        System.out.print("Your home address: ");
                        homeAddress = scan.nextLine();
                        System.out.print("Your number phone: ");
                        numberPhone = scan.nextLine();
                        
                        shop.getUserManager().register(username, password, email, fullname, homeAddress, numberPhone);
                        System.out.println("\nPress Enter to return to main menu...");
                        scan.nextLine();
                        break;
                    case "0":
                        System.out.println("Thank you for visiting our store!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input. please try again.");
                        scan.nextLine();
                        break;
                } 
            } else {
                while(menuRunning) {
                    System.out.print("\u000c");
                    System.out.println("Login successful! Welcome, " + shop.getUserManager().getCurrentCustomer().getFullname());
                    tools.renderPageTitle("Stitch & Soul Main Menu", "=", 100);
                    System.out.println("1. Product Catalogue");
                    System.out.println("2. Buy Products");
                    System.out.println("3. Your Cart");
                    System.out.println("4. Payment Processing (Checkout)");
                    System.out.println("5. Order History");
                    System.out.println("6. Your Profile");
                    System.out.println("7. Logout");
                    System.out.println("0. Exit Program");
                    System.out.print("\nChoose menu: ");
                    
                    tempScan = scan.nextLine();
                    
                    switch (tempScan) {
                        case "1":
                            System.out.print("\u000c");
                            shop.getProductList();
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "2":
                            System.out.print("\u000c");
                            shop.getProductList();
                            System.out.print("\nEnter the number of the product you wish to purchase: ");
                            try {
                                int productNumber = Integer.parseInt(scan.nextLine());
                                shop.buyProduct(productNumber - 1);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid product number!");
                            }
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "3":
                            System.out.print("\u000c");
                            shop.getCart();
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "4":
                            System.out.print("\u000c");
                            shop.paymentProccess(scan);
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "5":
                            System.out.print("\u000c");
                            shop.getOrderHistory();
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "6":
                            System.out.print("\u000c");
                            shop.getUserManager().getCurrentCustomer().getUserProfile();
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            break;
                            
                        case "7":
                            System.out.print("\u000c");
                            shop.getUserManager().logout();
                            System.out.println("Successfully logged out!");
                            System.out.println("\nPress Enter to return to main menu...");
                            scan.nextLine();
                            menuRunning = false;  // Exit the menu loop
                            break;
                            
                        case "0":
                            System.out.println("Thank you for shopping!");
                            menuRunning = false;
                            programRunning = false;
                            //System.exit(0);
                            break;
                            
                        default:
                            System.out.println("Invalid selection!");
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
