import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\std\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.ru/");

        WebElement googleInput = driver.findElement(By.cssSelector(".gLFyf"));

        googleInput.sendKeys("Фильмы");
        googleInput.sendKeys(Keys.ENTER);

        String a = "asda";

        driver.close();
    }


}
