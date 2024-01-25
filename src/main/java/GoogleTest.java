import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class GoogleTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\std\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Объявление переменной webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement input = driver.findElement(By.cssSelector("#input-example input"));
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example button"));
        enableButton.click();

        /*
        * Ждём пока элемент (input) не станет кликабельный, и только потом
        * возвращаем его в переменную input
        * */
        input = wait.until(
                ExpectedConditions.elementToBeClickable(input)
        );

        input.sendKeys("Test");

        assert input.getAttribute("value").equals("Test");

        driver.close();
    }


}
