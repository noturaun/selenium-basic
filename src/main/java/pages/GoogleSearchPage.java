package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class GoogleSearchPage extends Page {
    private WebDriver browser;

    @FindBy(name = "q")
    WebElement input;

    /*
        //div[@aria-level='3' and @role='heading']/div[@role='link'] for mobile
        //div[@class='g']//a//h3 for desktop
     */
    @FindBy(xpath = "//div[@aria-level='3' and @role='heading']/div[@role='link']")
    List<WebElement> results;

    @FindBy(id = "rso")
    WebElement resultContainer;

    public GoogleSearchPage(WebDriver browser) {
        super(browser);
        PageFactory.initElements(browser, this);
    }


    public void inputKeyword(String keyword){
        input.sendKeys(keyword);
        input.sendKeys(Keys.ENTER);
    }

    public List<String> resultLink(String expected, String alt){
        getWait().until(visibilityOf(resultContainer));
        List<String> resultsList = new ArrayList<>();
        results.forEach(item -> {
            if (item.getText().contains(expected) || item.getText().contains(alt)){
                resultsList.add(item.getText());
            }
        });
        return resultsList;
    }
}
