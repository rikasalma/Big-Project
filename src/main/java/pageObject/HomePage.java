package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver webDriver;

    public HomePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class='LoginButton_LoginButton__3qKtx'][1]")
    private WebElement buttonLogin;

    public void clickButtonLogin(){
        buttonLogin.click();
    }
}
