package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveElementsPage {
    private WebDriver driver;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addElement() {
        driver.findElement(By.cssSelector(".example > button")).click();
    }

    public void addElements(int n) {
        for(int i = 0; i < n; i++) {
            addElement();
        }
    }

    public void deleteElement() {
        driver.findElement(By.cssSelector(".added-manually")).click();
    }

    public WebElement getDeleteButton() {
        return  driver.findElement(By.cssSelector(".added-manually"));
    }

    public boolean isDeleteButtonVisible() {
        return driver.findElement(By.cssSelector(".added-manually")).isDisplayed();
    }

    public List<WebElement> getDeleteButtons() {
        return driver.findElements(By.cssSelector(".added-manually"));
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(By.cssSelector(".added-manually")).size();
    }

    public void deleteButtons() {
        List<WebElement> deleteButtons = getDeleteButtons();
        for (WebElement button : deleteButtons) {
            button.click();
        }
    }
}
