package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    WebDriver webDriver;

    public DashboardPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath ="//div[@class='Card_text__22WoI'] / h1[.='QA-14-BP-A']")
    private WebElement verifyDashboardText;

    @FindBy(xpath = "//div[@class='Card_Card__2LWWW']")
    private WebElement selectTeams;

    @FindBy(xpath = "//div[.='QA-14-BP-A24']")
    private WebElement selectTeams2;

    public String verifyDashboardPage(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(verifyDashboardText));
        return verifyDashboardText.getText();
    }

    public void selectTeams(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(selectTeams));
        selectTeams.click();
    }

    public void selectTeams2(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(selectTeams2));
        selectTeams2.click();
    }
}
