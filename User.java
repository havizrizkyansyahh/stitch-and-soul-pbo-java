public abstract class User{
    protected String userId;
    protected String username;
    protected String password;
    protected String email;
    protected String fullname;
    
    public User(String username, String password, String email, String fullname){
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
    }
    
    protected abstract String generateUserId();
    public abstract void getUserProfile();
    
    // getter method (Encapsulation)
    public String getUserId(){ return userId; };
    public String getUsername(){ return username; };
    public String getEmail(){ return email; };
    public String getFullname(){ return fullname; };
    protected String getPassword(){ return password; };
}
