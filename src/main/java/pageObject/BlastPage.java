package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlastPage {

    WebDriver webDriver;

    public BlastPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//div[@class='GeneralSubNavBar_title__text__3UFWr indiana-scroll-container " +
            "indiana-scroll-container--hide-scrollbars']/h1[.='Blasts']")
    public WebElement blastText;

    @FindBy(xpath = "//div[@class='BottomNavBar_bottomBar__globalActionSection__1JLBX indiana-scroll-container " +
            "indiana-scroll-container--hide-scrollbars']")
    public WebElement createBlastButton;

    @FindBy(css = "[placeholder='Type a title...']")
    public WebElement textAreaTitle;

    @FindBy(xpath = "//div[@class='fr-element fr-view']")
    public WebElement textAreaDescription;

    @FindBy(xpath = "//button[.='Publish']")
    public WebElement publishButton;

    @FindBy(xpath = "//div[@class='SnackbarItem-wrappedRoot css-96yce9']")
    private WebElement textSuccessCreateBlast;

    @FindBy(xpath = "(//div[@class='Post_container__3xxgM'])[1]")
    private WebElement blastPost;

    @FindBy(xpath = "//input[@class='Main_input__qq9k9 Main_secondary__2bXP3']")
    private WebElement commentSection;

    @FindBy(xpath = "//div[@class='fr-element fr-view']" )
    private WebElement typeComment;

    @FindBy(xpath = "//button[.='Post']")
    private WebElement postButton;

    public boolean verifyBlastPage(){
        return blastText.isDisplayed();
    }

    public void clickCreatBlastButton(){
        createBlastButton.click();
    }

    public void inputTitle(String title){
        textAreaTitle.sendKeys(title);
    }

    public void inputDescription(String description){
        textAreaDescription.sendKeys(description);
    }

    public void clickPublishButton(){
        publishButton.click();
    }

    public String verifyCreateBlast(){
        return textSuccessCreateBlast.getText();
    }

    public void clickBlastPost(){
        blastPost.click();
    }

    public void clickCommentSection(){
        commentSection.click();
    }

    public void inputComment(String comment){
        typeComment.sendKeys(comment);
    }

    public void clickPostButton(){
        postButton.click();
    }
}
