import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassword {
    public static void main(String[] args) {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prathamesh\\Desktop\\Enzigma\\Selenium Drivers\\chromedriver-win64\\chromedriver.exe");

        // Open Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Forgot Password page
            driver.get("https://app-staging.nokodr.com/forgot-password");

            // Maximize the window
            driver.manage().window().maximize();

            // Test Case 1: Valid Email
            System.out.println("Testing Valid Email...");
            testForgotPassword(driver, "validuser@example.com");
            checkSuccessMessage(driver);

            // Test Case 2: Invalid Email Format
            System.out.println("Testing Invalid Email Format...");
            testForgotPassword(driver, "invalid-email");
            checkErrorMessage(driver);

            // Test Case 3: Unregistered Email
            System.out.println("Testing Unregistered Email...");
            testForgotPassword(driver, "unregistered@example.com");
            checkErrorMessage(driver);

            // Test Case 4: Blank Email Field
            System.out.println("Testing Blank Email Field...");
            testForgotPassword(driver, ""); // Empty input
            checkErrorMessage(driver);

        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Method to enter email and click Reset Password
    public static void testForgotPassword(WebDriver driver, String email) {
        // Locate the email input field
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(email);

        // Click the Reset Password button
        WebElement resetButton = driver.findElement(By.id("resetButton"));
        resetButton.click();
    }

    // Method to check success message
    public static void checkSuccessMessage(WebDriver driver) {
        try {
            WebElement successElement = driver.findElement(By.id("successMessage"));
            if (successElement.isDisplayed()) {
                System.out.println("Success: " + successElement.getText());
            }
        } catch (Exception e) {
            System.out.println("Success message not displayed.");
        }
    }

    // Method to check error message
    public static void checkErrorMessage(WebDriver driver) {
        try {
            WebElement errorElement = driver.findElement(By.id("errorMessage"));
            if (errorElement.isDisplayed()) {
                System.out.println("Error: " + errorElement.getText());
            }
        } catch (Exception e) {
            System.out.println("No error message displayed.");
        }
    }
}

