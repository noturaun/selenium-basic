package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserInstance {
    private static WebDriver browser;
    private static WebDriverWait wait;

    public static WebDriver getBrowserInstance() {
        return browser;
    }

    public void setBrowserInstance(WebDriver browser) {
        BrowserInstance.browser = browser;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void setWait(WebDriverWait wait) {
        BrowserInstance.wait = wait;
    }
}
