package szoftverteszteles.stepdef;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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


    @Given("^The user has opened the browser$")
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

    @When("^The user maximizes the window$")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @When("The user opens the Vimeo {string} website")
    public void goToVimeo(String fromurl) {
        driver.navigate().to(fromurl);
    }

    @Then("A link {string} should exist on {string} element")
    public void getLink(String xpath, String linkurl) {
        assertEquals(driver.findElement(By.xpath(xpath)).getAttribute("href"), linkurl);
    }

    @When("^The user opens the Vimeo login page$")
    public void goToVimeoLogin(){
        driver.navigate().to("https://vimeo.com/log_in");
    }

    @When("^The user enters correct email$")
    public void enterCorrectEmail(){
        driver.findElement(By.xpath("//*[@id=\"signup_email\"]")).sendKeys("softvertestelesora@gmail.com");
    }

    @When("^The user enters correct password$")
    public void enterCorrectPwd(){
        driver.findElement(By.xpath("//*[@id=\"login_password\"]")).sendKeys("szoftverteszteles");
    }

    @When("^The user presses the login button$")
    public void pressLogin(){
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[5]/input")).click();
    }


    @Then("^The user is redirected to Vimeo's home page$")
    public void redirectToHome(){
        assertEquals(driver.getCurrentUrl(), "https://vimeo.com/");
    }

    @When("^The user enters incorrect password$")
    public void enterIncorrectPwd(){
        driver.findElement(By.xpath("//*[@id=\"login_password\"]")).sendKeys("asd");
    }

    @Then("^A red box is displayed with an error message$")
    public void getErrorMessage(){
        assertEquals(driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[4]/div")).getCssValue("background-color"), "rgb(255, 237, 237)");
    }

    @When("^The user presses the videos button$")
    public void pressVideos(){
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/main/div/div/div[1]/div[1]/div/div[1]/section[2]/div[1]/div/div[3]/span/div/div[2]/div/div")).click();
    }

    @Then("^The user is redirected to the videos page$")
    public void redirectedToVideos(){
        assertEquals(driver.getCurrentUrl(), "https://vimeo.com/manage/videos");
    }

    @When("The user clicks on a {string} top menu item with a dropdown list")
    public void clickOnProduct(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    @Then("The color of a {string} button when hovering over the mouse should be {string} lightgray")
    public void  getHoverColor(String xpath, String color){
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath(xpath))).perform();
        assertEquals(driver.findElement(By.xpath(xpath)).getCssValue("background-color"),color);
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
