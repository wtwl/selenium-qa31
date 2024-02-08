package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
Неявные ожидания
https://tproger.ru/articles/sposoby-ozhidanija-v-java-i-selenium?ysclid=lsdhguc37h794924513
https://www.selenium.dev/documentation/webdriver/waits/
 */
public class ImplicitWaitTest {
    private WebDriver chrome;

    @BeforeMethod
    public void setup() {
        chrome = new ChromeDriver();

    }

    @Test
    public void implicitTest() {
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Говорим сколько ждать драйвер прежде чем появится ошибка, при поиске элемента

        WebElement loginInput = chrome.findElement(By.cssSelector("#username")); // Если элемент не найдётся за 10 секунд, то появится ошибка


    }

}
