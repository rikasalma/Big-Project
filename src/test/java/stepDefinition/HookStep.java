package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.AuthenticationPage;
import pageObject.DashboardPage;
import pageObject.HomePage;

public class HookStep {
    protected static WebDriver webDriver;

    @Given("User login with existing account")
    public void landingToHomePage(){
        webDriver.get("https://staging.cicle.app/companies/61eba2c85080f47b25ddc8f8");
//        try{
//            webDriver.get("https://staging.cicle.app");
//            Thread.sleep(3000);
//        }catch (Exception e){
//            System.out.println(e);
//        }finally {
//            webDriver.get("https://staging.cicle.app/companies/61eba2c85080f47b25ddc8f8");
//        }
    }

    @When("User navigate to dashboard page")
    public void navigateToDashboardPage() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(webDriver);
        Thread.sleep(4000);
        Assert.assertEquals("QA-14-BP-A",dashboardPage.verifyDashboardPage());
    }

    @And("User select the team")
    public void selectTheTeam() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(webDriver);
        Thread.sleep(4000);
        dashboardPage.selectTeams();
    }

    @Before
    public void setup() {
        ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.addArguments("--disable-extensions");
        chrome_options.addArguments("--disable-popup-blocking");
        chrome_options.addArguments("--profile-directory=Default");
        chrome_options.addArguments("--ignore-certificate-errors");
        chrome_options.addArguments("--disable-plugins-discovery");
//        chrome_options.addArguments("--incognito");
        chrome_options.addArguments("user_agent=DN");
        chrome_options.addArguments("user-data-dir=C:\\Users\\Rika Salma Oktaviani\\AppData\\Local\\Google\\Chrome\\User Data");
        chrome_options.addArguments("--profile-directory=Default");
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver 15\\chromedriver.exe");
        webDriver = new ChromeDriver(chrome_options);
        webDriver.manage().window().maximize();

    }

    @After
    public void closeBrowser(){
        webDriver.quit();
    }
}
