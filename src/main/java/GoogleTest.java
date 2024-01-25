import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\std\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textInput = driver.findElement(By.cssSelector("#input-example input"));
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example button"));

        enableButton.click();

        Thread.sleep(10000);
        textInput.sendKeys("Test");
        System.out.println(textInput.getAttribute("value"));

        driver.close();
    }


}
