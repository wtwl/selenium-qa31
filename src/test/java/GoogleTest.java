import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\std\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //работа с js алёртами
        WebElement jsAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        WebElement jsConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        WebElement jsPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        jsPrompt.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(alert.getText());
        alert.sendKeys("123213141");
        alert.accept();

        // Работа с окнами(вкладками)
        String originalWindow = driver.getWindowHandle();

        for (String currentWindow : driver.getWindowHandles()) {
            if (!currentWindow.equals(originalWindow)) {
                driver.switchTo().window(currentWindow);
                break;
            }
        }


        // jsAlert()
        //driver.close();
    }


}
