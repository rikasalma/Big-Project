package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {

    public WebDriver webDriver;

    public AuthenticationPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement inputEmail;

    @FindBy(className = "VfPpkd-LgbsSe")
    private WebElement buttonNext;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe" +
            " DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']/div[@class='VfPpkd-RLmnJb']")
    private WebElement buttonNext2;

    public void typeEmail(String email){
        inputEmail.sendKeys(email);
    }

    public void clickButtonNext(){
        buttonNext.click();
    }

    public void typePassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickButtonNext2(){
        buttonNext2.click();
    }
}
