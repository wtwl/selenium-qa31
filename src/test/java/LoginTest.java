import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {
    protected WebDriver driver;
    protected WebElement usernameInput;
    protected WebElement passwordInput;
    protected WebElement loginButton;

    @BeforeMethod
    public void setupDriver() {
        System.out.println("Создаю драйвер для теста...");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        usernameInput = driver.findElement(By.cssSelector("#username"));
        passwordInput = driver.findElement(By.cssSelector("#password"));
        loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    @BeforeSuite
    public void setUp() {
        System.out.println("Настраиваю путь к драйверу...");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\std\\Downloads\\chromedriver-win64\\chromedriver.exe");
    }

    @Test
    public void checkUrl() {
        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");
        loginButton.click();

        String actualUrl = driver.getCurrentUrl();

        assert actualUrl.equals("https://the-internet.herokuapp.com/secure");
    }

    @Test
    public void checkMessage() {
        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");
        loginButton.click();

        String successMessage = driver.findElement(By.cssSelector(".flash.success")).getText();

        assert successMessage.contains("You logged into a secure area!");
    }

    @Test(dataProvider = "credentials")
    public void negativeCheck(String username, String password, String message) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        String successMessage = driver.findElement(By.cssSelector(".flash.error")).getText();

        assert successMessage.contains(message);
    }

    @DataProvider(name = "credentials")
    public Object[][] myDataProvider() {
        return new Object[][] {
                { "toms", "SuperSecretPassword!",  "Your username is invalid!" },
                { "tomsmith", "SuperSecretPassword",  "Your password is invalid!" },
                { "", "123",  "Your username is invalid!" },
                { "21312", "",  "Your username is invalid!" },
                { "dada", "sada",  "Your username is invalid!" },
        };
    }

}
