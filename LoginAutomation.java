import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
    public static void main(String[] args) {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prathamesh\\Desktop\\Enzigma\\Selenium Drivers\\chromedriver-win64\\chromedriver.exe");

        // Open Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("https://app-staging.nokodr.com/login");
            // Maximize the window
            driver.manage().window().maximize();
            // Test Case 1: Valid Login
            System.out.println("Testing Valid Login...");
            login(driver, "testuser@example.com", "ValidPassword123");
            checkLoginSuccess(driver);
            // Test Case 2: Invalid Login - Incorrect Password
            System.out.println("Testing Invalid Login - Incorrect Password...");
            login(driver, "testuser@example.com", "WrongPassword");
            checkErrorMessage(driver);
            // Test Case 3: Invalid Login - Empty Fields
            System.out.println("Testing Invalid Login - Empty Fields...");
            login(driver, "", "");
            checkErrorMessage(driver);

        } finally {
            // Close the browser
            driver.quit();
        }
    }
    // Method to perform login action
    public static void login(WebDriver driver, String username, String password) {
        // Find the username field and enter the value
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys(username);

        // Find the password field and enter the value
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

        // Click the Login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }
    // Method to verify successful login
    public static void checkLoginSuccess(WebDriver driver) {
        try {
            WebElement dashboardElement = driver.findElement(By.id("dashboard")); // Update ID if necessary
            if (dashboardElement.isDisplayed()) {
                System.out.println("Login successful - Redirected to dashboard!");
            }
        } catch (Exception e) {
            System.out.println("Login failed - Dashboard not found.");
        }
    }
    // Method to verify error message for failed login
    public static void checkErrorMessage(WebDriver driver) {
        try {
            WebElement errorElement = driver.findElement(By.id("errorMessage")); // Update ID if necessary
            if (errorElement.isDisplayed()) {
                System.out.println("Error message displayed: " + errorElement.getText());
            }
        } catch (Exception e) {
            System.out.println("❌ No error message displayed.");
        }
    }
}

