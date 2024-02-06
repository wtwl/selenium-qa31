import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest {


    @Test
    public void checkCorrectLogout() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\std\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        LogoutPage logoutPage = new LogoutPage(driver);


        loginPage.open();
        loginPage.fillUsername("tomsmith");
        loginPage.fillPassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        logoutPage.clickLogoutButton();

        assert driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/login");
    }
}
