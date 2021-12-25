package steps;

import io.cucumber.java.en.*;
import pages.GoogleSearchPage;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static setup.BrowserInstance.getBrowserInstance;

public class GoogleSearchDefinitions {
    GoogleSearchPage google = new GoogleSearchPage(getBrowserInstance());

    @Given("{string} on Google homepage")
    public void user_on_google_homepage(String actor) {
        getBrowserInstance().get("https://google.com");
    }
    @When("{word} enter search {string}")
    public void s_he_enter_search_keyword(String actor,String keyword) {
        google.inputKeyword(keyword);
    }
    @Then("{word} should be redirected to result page for {string} or {string}")
    public void s_he_should_be_redirected_to_search_result_pages(String actor,String expectedResult, String alt) {
        List<String> resultString = new ArrayList<>();
        assertNotNull(google.resultLink(expectedResult, alt));
        google.resultLink(expectedResult, alt).forEach(
                result -> assertThat(result).containsAnyOf(expectedResult, alt)
        );
    }
}
