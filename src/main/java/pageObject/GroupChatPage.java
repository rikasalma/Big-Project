package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GroupChatPage {

    WebDriver webDriver;
    public GroupChatPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//p[.='Group Chat']")
    private WebElement verifyGroupChatPage;

    @FindBy(xpath = "//div[@class='fr-element fr-view']/p[1]")
    private WebElement typeMessage;

    @FindBy(css = "[data-testid='SendIcon']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@class='Message_balloonMessage__3dmkS'][last()]")
    private WebElement textSuccessSend;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement attachButton;

    @FindBy(xpath = "//div[@class='SnackbarItem-wrappedRoot css-96yce9']")
    private WebElement textSuccessAttach;

    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_balloon__zRoXK']")
    private WebElement messageHover;

    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div[1]//div[@class='Message_iconOption__3F-Ru']")
    private WebElement messageOption;

    @FindBy(css = ".MessageMenuPopUp_bodySection__BxPUp")
    private WebElement menuMessageIcon;

    @FindBy(xpath = "//div[@class='modal-footer']//button[@type='button']")
    private WebElement deleteMessage;

    @FindBy(xpath = "//div[@class='SnackbarItem-wrappedRoot css-96yce9']")
    private WebElement textSuccessDelete;

    @FindBy(xpath = "//div[@class='infinite-scroll-component ']//div[1]//a[.='Download']")
    private WebElement downloadButton;


    public String verifyGroupChatPage(){
        return verifyGroupChatPage.getText();
    }

    public void inputMessage(String message){
        typeMessage.sendKeys(message);
    }

    public void clickSendButton(){
        sendButton.click();
    }

    public boolean verifySuccessSend(){
        return textSuccessSend.isDisplayed();
    }

    public void attachFile (){
        attachButton.sendKeys("C:\\Users\\Rika Salma Oktaviani\\OneDrive\\Documents\\Sekolah QA\\20220901_214929.pdf");
    }

    public boolean verifySuccessAttachFile(){
        return textSuccessAttach.isDisplayed();
    }

    public void clickMenuMessageIcon() throws InterruptedException {
        Actions action = new Actions(webDriver);
        action.moveToElement(messageHover).perform();
        messageOption.click();
        Thread.sleep(4000);
        menuMessageIcon.click();
        deleteMessage.click();
    }

    public String verifySuccessDelete(){
        return textSuccessDelete.getText();
    }

    public void downloadFiles(){
        downloadButton.click();
    }

    public void successDownloadFile(){
        List<String> browserTabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(browserTabs .get(1));
    }
}
