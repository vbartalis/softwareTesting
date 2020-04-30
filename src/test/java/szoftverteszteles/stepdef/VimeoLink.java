package szoftverteszteles.stepdef;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import szoftverteszteles.TestRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

/**
 *Test class
 */
public class VimeoLink extends TestRunner {
    /**
     *The class defines stepdefs for feature files
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VimeoLink.class);  /** Logger */
    private static final String USERNAME = "softvertesteleso1"; /** browserstack username */
    private static final String AUTOMATE_KEY = "u1Kj674f1hKni2jnwAxK"; /** browserstack key */
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.BROWSERSTACK.com/wd/hub"; /** browserstack url */
    private static final String SEPARATOR = "-------------------------------"; /** logger separator */
    private static final boolean BROWSERSTACK = false; /** false = test in local enviroment, true = run in browserstack and circleci */
    private static WebDriver driver;

    /**
     * Constructor for tha class
     */
    public VimeoLink(){
        super();
        LOGGER.info("VimeoLink test started");
    }

    /**
     * Open browser
     * @throws MalformedURLException exception for incorrectly formed url
     */
    @Given("^The user has opened the browser$")
    public void openBrowser() throws MalformedURLException {

        if (BROWSERSTACK) {
            final DesiredCapabilities caps = new DesiredCapabilities();
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

    /**
     * Maximize browser window
     */
    @When("^The user maximizes the window$")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    /**
     * navigate to vimeo site
     * @param fromurl link of the starting link
     */
    @When("The user opens the Vimeo {string} website")
    public void goToVimeo(final String fromurl) {
        driver.navigate().to(fromurl);
    }

    /**
     * check if link exists on an element
     * @param xpath xpath of element to check
     * @param linkurl url of link to check on element
     */
    @Then("A link {string} should exist on {string} element")
    public void checkLink(final String xpath, final String linkurl) {
        assertEquals(driver.findElement(By.xpath(xpath)).getAttribute("href"), linkurl);
    }

    /**
     * The user navigates to login page
     */
    @When("^The user opens the Vimeo login page$")
    public void goToVimeoLogin(){
        driver.navigate().to("https://vimeo.com/log_in");
    }

    /**
     * The user enters a correct email adress
     */
    @When("^The user enters correct email$")
    public void enterCorrectEmail(){
        driver.findElement(By.xpath("//*[@id=\"signup_email\"]")).sendKeys("softvertestelesora@gmail.com");
    }

    /**
     * The user enters the correct password
     */
    @When("^The user enters correct password$")
    public void enterCorrectPwd(){
        driver.findElement(By.xpath("//*[@id=\"login_password\"]")).sendKeys("szoftverteszteles");
    }

    /**
     * The user presess login button and logs in
     */
    @When("^The user presses the login button$")
    public void pressLogin(){
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[5]/input")).click();
    }

    /**
     * The user presses the vimeo button
     */
    @When("^The user presses the vimeo button$")
    public void pressVimeo(){
        driver.findElement(By.xpath("//*[@id=\"topnav_desktop\"]/div/a[1]")).click();
    }

    /**
     * Check if user is redirected to homepage of Vimeo
     */
    @Then("^The user is redirected to Vimeo's home page$")
    public void redirectToHome(){
        assertEquals(driver.getCurrentUrl(), "https://vimeo.com/");
    }

    /**
     * Enter incorrect password
     */
    @When("^The user enters incorrect password$")
    public void enterIncorrectPwd(){
        driver.findElement(By.xpath("//*[@id=\"login_password\"]")).sendKeys("asd");
    }

    /**
     * Check whether the login  error messagebox is red
     */
    @Then("^A red box is displayed with an error message$")
    public void checkErrorMessage(){
        final Color actualColor = Color.fromString(driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[4]/div")).getCssValue("background-color"));
        assert actualColor.asRgb().equals("rgb(255, 237, 237)");

    }

    /**
     * Press videos button
     */
    @When("^The user presses the videos button$")
    public void pressVideos(){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div/div/div[1]/div[1]/div/div[1]/section[2]/div[1]/div/div[3]/span/div/div[2]/div/div")).click();
    }

    /**
     * Ceck if user is redirected to videos page
     */
    @Then("^The user is redirected to the videos page$")
    public void redirectedToVideos(){
        assertEquals(driver.getCurrentUrl(), "https://vimeo.com/manage/videos");
    }

    /**
     * Clicking on top menu bar item which has a dropdown list
     * @param xpath xpath of element to click on
     */
    @When("The user clicks on a {string} top menu item with a dropdown list")
    public void clickOnTopMenuItem(final String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    /**
     * get color of element when hovered over
     * @param xpath xpath of element to hover over
     * @param color expected color of hovered element
     */
    @Then("The color of a {string} button when hovering over the mouse should be {string}")
    public void  checkHoverColor(final String xpath, final String color){
        final Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(xpath))).perform();
        final Color actualColor = Color.fromString(driver.findElement(By.xpath(xpath)).getCssValue("background-color"));
        final Color expectedColor = Color.fromString(color);
        assert actualColor.asRgb().equals(actualColor.asRgb()) : "actual_color: " + actualColor + " " + "expected_colour: " + expectedColor;


    }

    /**
     * open test
     * @param scenario current test scenario
     */
    @Before
    public void before(final Scenario scenario) {
        LOGGER.info(SEPARATOR);
        final String info = "Starting - " + scenario.getName();
        LOGGER.info(info);
        LOGGER.info(SEPARATOR);
    }

    /**
     * closing test
     * @param scenario current test scenario
     */
    @After
    public void after(final Scenario scenario) {
        LOGGER.info(SEPARATOR);
        final String info = scenario.getName() + " Status - " + scenario.getStatus();
        LOGGER.info(info);
        LOGGER.info(SEPARATOR);
        if (driver != null) {
            driver.quit();
        }
    }
}
