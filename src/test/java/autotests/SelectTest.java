package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Документация по Select https://www.selenium.dev/documentation/webdriver/support_features/select_lists/
 */
public class SelectTest {

    private WebDriver chrome;

    @BeforeMethod
    public void setup() {
        chrome = new ChromeDriver();

    }

    @Test
    public void selectTest() {
        chrome.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = chrome.findElement(By.cssSelector("#dropdown"));
        Select dropdownSelect = new Select(dropdown);
        dropdownSelect.selectByVisibleText("Option 2");
    }
}
