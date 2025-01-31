import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prathamesh\\Desktop\\Enzigma\\Selenium Drivers\\chromedriver-win64\\chromedriver.exe");

        // Open the browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the noKodr platform
        driver.get("https://app-staging.nokodr.com/");

        // Close the browser
        driver.quit();
    }
}

