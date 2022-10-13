package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TeamPage {

    WebDriver webDriver;
    public TeamPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//div[@class='GeneralSubNavBar_title__text__3UFWr indiana-scroll-container indiana-scroll-container" +
            "--hide-scrollbars'] / h1[.='QA-14-BP-A']")
    private WebElement verifyTeamPageText;

    @FindBy(xpath = "//h1[.='Group Chat']")
    private WebElement groupChatMenu;

    @FindBy(xpath = "//h1[.='Blast!']")
    private WebElement blastMenu;

    @FindBy(xpath = "//h1[.='Board']")
    private WebElement boardMenu;

    public void verifyTeamPage(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(verifyTeamPageText));
        verifyTeamPageText.isDisplayed();
    }
    public void clickGroupChatMenu(){
        groupChatMenu.click();
    }

    public void clickBlastMenu(){
        blastMenu.click();
    }

    public void clickBoardMenu(){
        boardMenu.click();
    }
}
