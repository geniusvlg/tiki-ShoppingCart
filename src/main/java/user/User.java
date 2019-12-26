package user;

import product.Product;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getEmailAddress() == user.getEmailAddress();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailAddress());
    }
}
