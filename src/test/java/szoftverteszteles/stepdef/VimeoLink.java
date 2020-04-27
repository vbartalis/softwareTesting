package szoftverteszteles.stepdef;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import szoftverteszteles.TestRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class VimeoLink extends TestRunner {
    public static final String USERNAME = "softvertesteleso1";
    public static final String AUTOMATE_KEY = "u1Kj674f1hKni2jnwAxK";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @Given("^I have opened the browser$")
    public void openBrowser() throws MalformedURLException {

        final boolean browserstack = true;

        if (browserstack) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "80");
            caps.setCapability("name", "softvertesteleso1's First Test");
            caps.setCapability("resolution", "1920x1080");
            driver = new RemoteWebDriver(new URL(URL), caps);
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
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


    @Before
    public void before(Scenario scenario) {
        System.out.println("-------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("-------------------------------");
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("-------------------------------");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("-------------------------------");
        if (driver != null) {
            driver.quit();
        }
    }
}
