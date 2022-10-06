package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamPage {

    public TeamPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class='GeneralSubNavBar_title__text__3UFWr indiana-scroll-container indiana-scroll-container" +
            "--hide-scrollbars'] / h1[.='QA-14-BP-A']")
    private WebElement verifyTeamPageText;

    @FindBy(xpath = "//a[@href='/companies/61eba2c85080f47b25ddc8f8/teams/632e85803c6e10177263cc42/group-chats/" +
            "632e85803c6e10177263cc46']/div[@class='BoxMenu_container__1flgD']")
    private WebElement groupChatMenu;

    @FindBy(xpath = "//h1[.='Blast!']")
    private WebElement blastMenu;

    @FindBy(xpath = "//a[@href='/companies/61eba2c85080f47b25ddc8f8/teams/632e85803c6e10177263cc42/boards/632e85803c6e1" +
            "0177263cc45']/div[@class='BoxMenu_container__1flgD']")
    private WebElement boardMenu;

    public boolean verifyTeamPage(){
        return verifyTeamPageText.isDisplayed();
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
