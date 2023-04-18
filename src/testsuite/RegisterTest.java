package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    @Before
    public void setUp(){
        openBrowser("http://demo.nopcommerce.com/");
    }
    @Test
    public void UserShouldNavigateToRegisterPageSuccessfully(){
        // 1.click on the ‘Register’ link
        WebElement registerLink=driver.findElement(By.linkText("Register"));
        registerLink.click();
        // Verify the text ‘Register’
        String expectedMessage="Register";
        WebElement actualTextElement=driver.findElement(By.xpath("//h1[text()='Register']"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Register not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //2. click on the ‘Register’ link
        WebElement registerLink=driver.findElement(By.linkText("Register"));
        registerLink.click();
        // Select gender radio button
        driver.findElement(By.id("gender-female")).click();
        // Enter First name
        WebElement firstNameField=driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("Shiva");
        // Enter Last name
        WebElement lastNameField=driver.findElement(By.name("LastName"));
        lastNameField.sendKeys("Vishnu");
        // Select Day Month and Year
        driver.findElement(By.name("DateOfBirthDay")).click();
        driver.findElement(By.xpath("//option[@value='2']")).click();
        driver.findElement(By.name("DateOfBirthMonth")).click();
        driver.findElement(By.xpath("//option[@value='3' and text()='March']")).click();
        driver.findElement(By.name("DateOfBirthYear")).click();
        driver.findElement(By.xpath("//option[@value='1994']")).click();
        // Enter Email address
        driver.findElement(By.id("Email")).sendKeys("hprime12345678@gmail.com");
        // Enter Password
        driver.findElement(By.name("Password")).sendKeys("78932145");
        // Enter Confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("78932145");
        // Click on REGISTER button
        driver.findElement(By.id("register-button")).click();
        // Verify the text 'Your registration completed.’
        String expectedMessage="Your registration completed";
        WebElement actualTextElement=driver.findElement(By.className("result"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Your registration completed not displayed",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
