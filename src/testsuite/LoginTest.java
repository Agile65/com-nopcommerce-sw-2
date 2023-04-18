package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //  1.click on the ‘Login’ link
        //Find login Link and click on link and user is on the login page
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //  2.Verify the text ‘Welcome, Please Sign In!’
        String expectedMessage = "Welcome, Please Sign In!";
        // Find the web element using xpath
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextElement.getText();
        // JUnit Assert method to verify message
        Assert.assertEquals("Not redirected to Login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // 1. click on the ‘Login’ link
        // Find the Email Field element
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // 2. Enter valid username
        WebElement emailField = driver.findElement(By.id("Email"));
        // Type the Email address to email field element
        emailField.sendKeys("hprime123456@gmail.com");
        // 3. Enter valid password
        // Find the Password field Element
        WebElement emailPassword = driver.findElement(By.name("Password"));
        emailPassword.sendKeys("78932145");
        // 4. Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();
        // 5. Verify the Logout text is display
        String expectedLogOutText = "Log out";
        WebElement LogOutLink = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualLogOutLinkText = LogOutLink.getText();
        Assert.assertEquals("Log out text not displayed", expectedLogOutText, actualLogOutLinkText);
    }

    @Test
    public void verifyTheErrorMessage() {
        //  1.click on the ‘Login’ link
        // Find the Email Field element
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //  2. Enter invalid username
        WebElement emailField = driver.findElement(By.id("Email"));
        // Type the Email address to email field element
        emailField.sendKeys("lime123@gmail.com");
        //  3. Enter invalid password
        // Find the Password field Element
        WebElement emailPassword = driver.findElement(By.name("Password"));
        emailPassword.sendKeys("1234567");
        //  4. Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();
        //  5. Verify the error message
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed as expected", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
