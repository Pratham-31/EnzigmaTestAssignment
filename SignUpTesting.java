import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpTesting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prathamesh\\Desktop\\Enzigma\\Selenium Drivers\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Opening the website
            driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");
            // Maximize the window
            driver.manage().window().maximize();
            // Create WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            // Locate the email field and enter the email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            emailField.sendKeys("test@example.com");
            // Locate the password field and enter the password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Test@1234");
            // Locate and click the submit button
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();
            // Wait for success message (update the locator as per the actual HTML)
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
            System.out.println("Signup Successful: " + successMessage.getText());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Quit the browser
            driver.quit();
        }
    }
}
