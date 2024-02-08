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
public class BasicInteractionsTest {

    private WebDriver chrome;

    @BeforeMethod
    public void setup() {
        chrome = new ChromeDriver();

    }

    @Test
    public void basicInteractionsTest() {
        WebElement usernameInput = chrome.findElement(By.cssSelector("#username"));
        WebElement passwordInput = chrome.findElement(By.cssSelector("#password"));
        WebElement loginButton = chrome.findElement(By.cssSelector("button[type='submit']"));
        WebElement subheadElement = chrome.findElement(By.cssSelector(".subheader"));

        chrome.get("https://the-internet.herokuapp.com/login"); // Переход на указаную страницу
        chrome.navigate().refresh(); // перезагрузка страницы (F5)
        chrome.navigate().back(); // Вернуться к предыдущей странице
        chrome.navigate().forward(); // Перейти к слудующей странице

        chrome.getCurrentUrl(); // Получить текущий URL
        chrome.getTitle(); // Получить название вкладки

        subheadElement.getText(); // получить текст элемента
        subheadElement.getAttribute("class"); // получить указанный атрибут элемента, в данном случае class

        usernameInput.sendKeys("tomsmith");  // Ввод значения в поле ввода
        loginButton.click(); // Клик по элементу

        chrome.quit(); // закрыть вебдрайвер
    }


}