import model.Customer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CustomerTest extends BaseTest {

    @Test
    public void testExistingUser() {
        Customer customer = MyJDBC.getCustomerById(1);

        Assert.assertEquals(customer.getCustomer_id(), 1);
        Assert.assertEquals(customer.getLastname(), "Haidu");
        Assert.assertEquals(customer.getFirstname(), "Claudiu");
    }

    /**
     * Test
     * 1. Register User
     * 2. Check it if exists in database
     * // 3. Login with the new user
     * // 4. Logout
     * 5. Delete User from database
     * 7. Check that it does not exist in the database
     * // 6. See if login fails with the deleted User
     */


    @Test
    public void registerAndDeleteCreatedCustomer() throws SQLException {
        webDriver.get("http://localhost/upload/index.php?route=account/register");

        webDriver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Tudor");
        webDriver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Marcus");
        webDriver.findElement(By.cssSelector("input[name='email']")).sendKeys("marcus@tudor.com");
        webDriver.findElement(By.cssSelector("input[name='telephone']")).sendKeys("077767893");
        webDriver.findElement(By.cssSelector("input[name='password']")).sendKeys("123456");
        webDriver.findElement(By.cssSelector("input[name='confirm']")).sendKeys("123456");
        webDriver.findElement(By.cssSelector("input[name='agree']")).click();
        webDriver.findElement(By.cssSelector("input[value='Continue']")).click();

        Customer customer = MyJDBC.getCustomerByEmail("marcus@tudor.com");

        Assert.assertEquals(customer.getFirstname(), "Tudor");
        Assert.assertEquals(customer.getFirstname(), "Marcus");

        MyJDBC.deleteUserById(customer.getCustomer_id());

        Customer customerAfterDeletion = MyJDBC.getCustomerByEmail("marcus@tudor.com");

        Assert.assertNull(customer.getFirstname());
        Assert.assertNull(customer.getFirstname());
    }

/*    @Test
    public void loginWithExistingUserName {
        Customer customer = MyJDBC.getCustomerById(1);
        webDriver.get("http://localhost/upload/");



        Assert.assertEquals(customer.getCustomer_id(), 1);
        Assert.assertEquals(customer.getLastname(), "Haidu");
        Assert.assertEquals(customer.getFirstname(), "Claudiu");

    }*/
}
