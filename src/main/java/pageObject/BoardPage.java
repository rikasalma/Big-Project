package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoardPage {

    WebDriver webDriver;

    public BoardPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//span[.='Kanban Board']")
    private WebElement verifyBoardPage;

    @FindBy(xpath = "//div[@class='Button_container__1WNuB Button_flexStart__2nS1S'][last()]")
    private WebElement addListButton;

    @FindBy(xpath = "//input[@placeholder='Input list name...']")
    private WebElement inputListName;

    @FindBy(xpath = "//button[@class='btn btn-success btn-sm']")
    private WebElement createButton;

    @FindBy(xpath = "//div[@class='SnackbarItem-wrappedRoot css-96yce9']")
    private WebElement verifyCreateList;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]")
    private WebElement verifyFailedCreate;

    @FindBy(xpath = "(//div[@class='ListContainer_ListContainer__buttonBottom__2kZAI'])[last()]")
    private WebElement addCardButton;

    @FindBy(xpath = "(//input[@class='form-control'])[last()]")
    private WebElement inputCardName;

    @FindBy(xpath = "(//div[.='Add Card'])[last()]")
    private WebElement addCardButton2;

    @FindBy(xpath = "(//input[@class='MuiSwitch-input PrivateSwitchBase-input css-1m9pwf3'])[last()]")
    private WebElement switchToggleButton;

    @FindBy(xpath = "//div[@class='SnackbarItem-wrappedRoot css-96yce9']")
    private WebElement verifySuccessAddCard;

    @FindBy(css = ".CreateListButton_icon__12EJS")
    private WebElement cancelListButton;

    public String verifyBoardPage(){
        return verifyBoardPage.getText();
    }

    public void clickAddListButton(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addListButton));
        addListButton.click();
    }

    public void typeListName(String listName){
        inputListName.sendKeys(listName);
    }

    public void clickCreateButton(){
        createButton.click();
    }

    public String verifySuccessCreate(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(verifyCreateList));
        return verifyCreateList.getText();
    }

    public String verifyFailedCreate(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(verifyFailedCreate));
        return verifyFailedCreate.getText();
    }

    public void clickAddCardButton(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addCardButton));
        addCardButton.click();
    }

    public void typeCardName(String cardName){
        inputCardName.sendKeys(cardName);
    }

    public void clickAddCardButton2(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addCardButton2));
        addCardButton2.click();
    }

    public String verifySuccessAddCard(){
        WebDriverWait wait = new WebDriverWait (webDriver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(verifySuccessAddCard));
        return verifySuccessAddCard.getText();
    }

    public void clickSwitchToggle(){
        switchToggleButton.click();
    }

    public void clickCancelListButton(){
        cancelListButton.click();
    }

    public void verifySuccessCancelNewList(){
        addListButton.isDisplayed();
    }
}
