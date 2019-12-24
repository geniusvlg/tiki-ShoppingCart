import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import user.User;

public class ShoppingCartTest {


    // So in here, don't think that we need to do a very simple test, let's say:
    // Set up: a CartManagement is created
    // 1) a User is new
    // 2) CartManagement register User to a ShoppingCart
    // 3) Create 2 Product apple and orange
    // 4) CartManagement add 2 products for user
    // 5) CartManagement calculate the money for users
    @Test
    public void testCreateFirstUser() {
        User user = new User("John Doe", "john.doe@example.com");
        user.addToShoppingCart("apple", 2);
        user.addToShoppingCart("orange", 1);
        assertEquals(user.getTotalMoney(), 13.89);
    }

    // Same with this one
    @Test
    public void testCreateSecondtUser() {
        User user = new User("John Doe", "john.doe@example.com");
        user.addToShoppingCart("apple", 3);
        user.removeFromShoppingcart("apple", 1);
        assertEquals(user.getTotalMoney(), 9.9);
    }
}
