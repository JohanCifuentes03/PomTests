package co.com.sofka.setup;

import co.com.sofka.webenums.WebBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class WebSetup {
    private static final String DEMO_QA_URL = "https://demoqa.com/";
    protected WebDriver driver;

    private void setupWebDriverUrl(WebBrowser webBrowser) {
        switch (webBrowser) {
            case CHROME -> chromeConfiguration();
            case EDGE -> edgeConfiguration();
            default -> System.out.println("Enter a valid option");
        }
    }

    private void edgeConfiguration() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("ms:inPrivate", true);
        edgeOptions.setCapability("ms:edgeChromium", true);
        edgeOptions.setCapability("ms:edgeOptions", "--headless");
        driver = new EdgeDriver(edgeOptions);
        configureBrowser();
    }

    private void configureBrowser() {
        driver.get(DEMO_QA_URL);
        maximizeWindow();
    }

    private void chromeConfiguration() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        configureBrowser();
    }

    protected void generalSetup(WebBrowser webBrowser) {
        setupWebDriverUrl(webBrowser);
    }

    protected void quiteDrive() {
        driver.quit();
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

}
