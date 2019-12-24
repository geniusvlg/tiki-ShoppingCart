package user;

public class User {
    private String name;
    private String emailAddress;

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }


    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
