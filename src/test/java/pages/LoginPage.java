package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameInput = By.cssSelector("#username");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void fillUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

}
