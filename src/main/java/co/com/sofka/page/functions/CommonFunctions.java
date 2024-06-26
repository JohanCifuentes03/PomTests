package co.com.sofka.page.functions;

import org.openqa.selenium.*;

public class CommonFunctions {
    protected final WebDriver driver;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void typeInto(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void clickSelection(By locator) {
        driver.findElement(locator).click();
    }

    protected void clickSelection(WebElement element) {
        element.click();
    }

    protected void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
    protected void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
    protected void cleanField(WebElement element){
        element.clear();
    }

    protected void scrollTo(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected String getText(Alert alert) {
        return alert.getText();
    }

}
