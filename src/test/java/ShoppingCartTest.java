import cartmanagement.CartManagement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import user.User;

public class ShoppingCartTest {

    @Test
    public void testCreateFirstUser() {
        CartManagement cartManagement = CartManagement.createCartManagement();

        User user = new User("John Doe", "john.doe@example.com");
        cartManagement.createCartForUser(user);
        cartManagement.addProductToShoppingCart(user, "apple", 2);
        cartManagement.addProductToShoppingCart(user, "orange", 1);
        assertEquals(cartManagement.getTotalMoney(user), 4.95 * 2 + 3.99 * 1);
    }

    @Test
    public void testCreateSecondtUser() {
        CartManagement cartManagement = CartManagement.createCartManagement();

        User user = new User("John Doe", "john.doe@example.com");
        cartManagement.createCartForUser(user);
        cartManagement.addProductToShoppingCart(user, "apple", 3);
        cartManagement.removeProductFromShoppingcart(user, "apple", 1);
        assertEquals(cartManagement.getTotalMoney(user), 4.95 * 2);
    }
}
