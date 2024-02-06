package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    private WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutButton() {
        driver.findElement(By.cssSelector("a[href=\"/logout\"]")).click();
    }
}
