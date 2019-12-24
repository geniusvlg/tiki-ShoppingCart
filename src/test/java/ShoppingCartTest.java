import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import user.User;

public class ShoppingCartTest {

    @Test
    public void testCreateFirstUser() {
        User user = new User("John Doe", "john.doe@example.com");
        user.addToShoppingCart("apple", 2);
        user.addToShoppingCart("orange", 1);
        assertEquals(user.getTotalMoney(), 13.89);
    }

    @Test
    public void testCreateSecondtUser() {
        User user = new User("John Doe", "john.doe@example.com");
        user.removeFromShoppingcart("apple", 1);
        user.addToShoppingCart("apple", 3);
        user.removeFromShoppingcart("apple", 1);
        assertEquals(user.getTotalMoney(), 9.9);
    }
}
