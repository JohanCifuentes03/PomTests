package co.com.sofka.page;

import co.com.sofka.page.functions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class OrderListPage extends CommonFunctions {
    private final By PRACTICE_SORTABLE_LI = By.xpath("//span[text() = 'Sortable']");
    private final By PRACTICE_ELEMENTS_LIST = By.xpath("//div[@class='vertical-list-container mt-4']/div");

    private List<WebElement> originalWebElements;
    private List<WebElement> modifiedWebElements;

    public OrderListPage(WebDriver driver) {
        super(driver);
    }

    public void openSortableListSection() {
        driver.findElement(PRACTICE_SORTABLE_LI).click();
    }

    public void sortElements() {
        List<WebElement> webElements = driver.findElements(PRACTICE_ELEMENTS_LIST);
        originalWebElements = webElements;
        scrollTo(PRACTICE_ELEMENTS_LIST);

        int lastIndex = webElements.size() - 1;
        for (int i = 0; i < webElements.size(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            WebElement firstElement = webElements.get(0);
            WebElement lastElement = webElements.get(lastIndex -  i);
            Actions actions = new Actions(driver);
            actions.dragAndDrop(firstElement, lastElement).perform();
        }
        modifiedWebElements = driver.findElements(PRACTICE_ELEMENTS_LIST);
    }

    public List<WebElement> getOriginalWebElements() {
        return originalWebElements;
    }

    public List<WebElement> getModifiedWebElements() {
        return modifiedWebElements;
    }
}
