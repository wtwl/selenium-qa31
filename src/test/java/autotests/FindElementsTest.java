package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Здесь показаны способы поиска элементов
Подробнее про локаторы и их виды https://automated-testing.info/t/selenium-obzor-tipov-lokatorov-i-ih-podbor/2269
 */
public class FindElementsTest {

    private WebDriver chrome;

    @BeforeMethod
    public void setup() {
        chrome = new ChromeDriver();
        chrome.get("https://the-internet.herokuapp.com/login");
    }

    /*
     * Здесь работают все приёмы поиска элементов по CSS
     */
    @Test
    public void cssSelector() {
        WebElement usernameInput = chrome.findElement(By.cssSelector("#username")); // Поиск по id
        WebElement row = chrome.findElement(By.cssSelector(".row")); // поиск по классу
        WebElement a = chrome.findElement(By.cssSelector("a")); // поиск по имени тега
        WebElement aWithAttribute = chrome.findElement(By.cssSelector("a[href='http://elementalselenium.com/']")); // поиск аттрибуту

        assert usernameInput.isDisplayed();
        assert row.isDisplayed();
        assert a.isDisplayed();
        assert aWithAttribute.isDisplayed();

    }

    /*
     * Поиск по xpath
     */
    @Test
    public void xpath() {
        WebElement usernameInput = chrome.findElement(By.xpath("//input[@id='username']")); // Поиск по id
        WebElement row = chrome.findElement(By.xpath("//div[@class='row']")); // поиск по классу
        WebElement a = chrome.findElement(By.xpath("//a")); // поиск по имени тега
        WebElement aWithAttribute = chrome.findElement(By.xpath("a[@href='http://elementalselenium.com/']")); // поиск аттрибуту
        WebElement loginButton = chrome.findElement(By.xpath("//button[text()='Login']")); // Поиск по тексту внутри элемента
        WebElement bottomLink = chrome.findElement(By.xpath("//a[contains(text(), 'Elemental')]")); // поиск по подстроке внутри элемента

        assert usernameInput.isDisplayed();
        assert row.isDisplayed();
        assert a.isDisplayed();
        assert aWithAttribute.isDisplayed();
        assert loginButton.isDisplayed();
        assert bottomLink.isDisplayed();
    }
}
