package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    @Before
    public void setUp(){
        openBrowser("http://demo.nopcommerce.com/");
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        // 1. click on the 'Computers' Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        // Verify the text 'Computers'
        String expectedMessage="Computers";
        WebElement actualTextElement=driver.findElement(By.xpath("//h1"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Computers not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        // 2. click on the 'Electronics' Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile' ]//a[text()='Electronics ']")).click();
        // Verify the text 'Electronics'
        String expectedMessage="Electronics";
        WebElement actualTextElement=driver.findElement(By.xpath("//h1[text()='Electronics']"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Electronics not displayed",expectedMessage,actualMessage);
    }
    @Test
    public  void userShouldNavigateToApparelPageSuccessfully(){
        // 3. click on the ‘Apparel’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']")).click();
        //   Verify the text ‘Apparel’
        String expectedMessage="Apparel";
        WebElement actualTextElement=driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Apparel not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        // 4. click on the ‘Digital downloads’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Digital downloads ')]")).click();
        // Verify the text ‘Digital downloads’
        String expectedMessage="Digital downloads";
        WebElement actualTextElement=driver.findElement(By.xpath("//h1[contains(text(),'')]"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Digital downloads not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        // 5. click on the ‘Books’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[starts-with(text(),'Books ')]")).click();
        // Verify the text ‘Books’
        String expectedMessage="Books";
        WebElement actualTextElement=driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Books not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        // 6. click on the ‘Jewelry’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Jewelry ')]")).click();
        //  Verify the text ‘Jewelry’
        String expectedMessage="Jewelry";
        WebElement actualTextElement=driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Jewelry not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        // 7. click on the ‘Gift Cards’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Gift Cards ')]")).click();
        // Verify the text ‘Gift Cards’
        String expectedMessage="Gift Cards";
        WebElement actualTextElement=driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals(" Gift Cards not displayed",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
