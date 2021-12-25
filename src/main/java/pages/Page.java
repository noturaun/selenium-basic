package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    private static WebDriver browser;
    private static WebDriverWait wait;

    public Page(WebDriver browser) {
        Page.browser = browser;
        wait = new WebDriverWait(browser, Duration.ofSeconds(20));
    }

    public Page(WebDriver browser, WebDriverWait wait) {
        Page.browser = browser;
        Page.wait = wait;
    }

    public static WebDriver getDriver(){
        return browser;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
