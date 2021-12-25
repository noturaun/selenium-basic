package setup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import java.util.Map;

public class BrowserSetup extends BrowserInstance {
    ChromeDriver browser;
    ChromeOptions options;
    DevTools dev;
    Map<String, String> emulation = Map.of("deviceName", "Pixel 2");

    protected void startBrowser(){
        options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", emulation);
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        browser = new ChromeDriver(options);
//        dev = browser.getDevTools();
        setBrowserInstance(browser);
    }

    protected void quitBrowser(){
        browser.quit();
    }
}
