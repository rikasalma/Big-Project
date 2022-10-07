package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public WebDriver webDriver;

    public DashboardPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath ="//div[@class='Card_text__22WoI'] / h1[.='QA-14-BP-A']")
    private WebElement verifyDashboardText;

    @FindBy(xpath = "//div[@class='Card_Card__2LWWW']")
    private WebElement selectTeams;

    @FindBy(xpath = "//div[.='QA-14-BP-A24']")
    private WebElement selectTeams2;

    public String verifyDashboardPage(){
        return verifyDashboardText.getText();
    }

    public void selectTeams(){
        selectTeams.click();
    }

    public void selectTeams(){
        selectTeams2.click();
    }
}
