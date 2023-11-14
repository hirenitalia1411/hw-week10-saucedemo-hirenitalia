package saucedemo;
/**
 * Project-4 - ProjectName : com-saucedemo
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SauceDemo {

    static String baseUrl = "https://www.saucedemo.com/";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {

        // Step 1: Setup browser
        if (browser.trim().equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else {
        System.out.println("Wrong Browser");
        }

        // Step 2: Open URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        // Step 3: Print title of the page
        System.out.println("Title of the page: " + driver.getTitle());

        // Step 4: Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Step 5: Print the page resource
        System.out.println("Page resources: " + driver.getPageSource());

        // Step 6: Enter email to the email field
        driver.findElement(By.name("user-name")).sendKeys("standard_user");

        // Step 7: Enter password to the password field
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        // Step 8: Click on login button
        driver.findElement(By.name("login-button")).click();

        // Step 9: Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Step 10: Navigate to homepage (using back button on the browser)
        driver.navigate().back();

        // Step 11: Refresh the page (using refresh button on the browser)
        driver.navigate().refresh();

        // Step 12: Close the browser
        driver.quit();
    }
}
