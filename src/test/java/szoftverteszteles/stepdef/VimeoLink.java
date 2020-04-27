package szoftverteszteles.stepdef;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import szoftverteszteles.TestRunner;

import static org.testng.Assert.assertEquals;

public class VimeoLink extends TestRunner {
    @Given("^I have opened the browser$")
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @When("^I maximize the window$")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @When("I open the Vimeo {string} website")
    public void goToVimeo(String fromurl) {
        driver.navigate().to(fromurl);
    }

    @Then("A link {string} should exist on {string} element")
    public void getLink(String xpath, String linkurl) {
        assertEquals(driver.findElement(By.xpath(xpath)).getAttribute("href"), linkurl);
    }


}
