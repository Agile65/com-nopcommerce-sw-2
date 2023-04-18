package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
// 1. Browser Setup code
public class BaseTest {
    public static WebDriver driver;
   // public static String baseUrl="";

    public void openBrowser(String baseUrl){
        // Launch the Chrome browser
        driver=new ChromeDriver();
        // Open the Url into the browser
        driver.get(baseUrl);
        // Maximise windows
        driver.manage().window().maximize();
        // Implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        // To close all the associated browser windows
        driver.quit();
    }
}
