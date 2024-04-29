package co.com.sofka.page.functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CommonFunctions {
    protected final WebDriver driver;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void clickSelection(By locator){
        driver.findElement(locator).click();
    }
    protected void sendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    protected void scrollTo(By locator){
        JavascriptExecutor jse =  (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

}
