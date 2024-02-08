package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

import java.util.List;

public class AddRemoveElementsTest {

    WebDriver driver;
    AddRemoveElementsPage addRemoveElementsPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\std\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        addRemoveElementsPage = new AddRemoveElementsPage(driver);
    }

    @Test
    public void checkSingleAdd() {
        addRemoveElementsPage.addElement();
        assert addRemoveElementsPage.getDeleteButtonsCount() == 1;
    }


    @Test
    public void checkAddMultipleButtons() {
        addRemoveElementsPage.addElements(20);
        assert addRemoveElementsPage.getDeleteButtonsCount() == 20;
    }

    @Test
    public void checkDeleteAll() {
        addRemoveElementsPage.addElements(20);
        addRemoveElementsPage.deleteButtons();

        assert addRemoveElementsPage.getDeleteButtonsCount() == 0;
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
