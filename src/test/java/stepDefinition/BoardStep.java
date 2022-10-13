package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.BoardPage;
import pageObject.TeamPage;

import static stepDefinition.HookStep.webDriver;

public class BoardStep {
    private final TeamPage teamPage = new TeamPage(webDriver);
    private final BoardPage boardPage = new BoardPage(webDriver);

    @Given("User already in Team page")
    public void alreadyInTeamPage(){
        teamPage.verifyTeamPage();
    }

    @When("User click Board Feature")
    public void clickBoardFeature(){
        teamPage.clickBoardMenu();
        Assert.assertEquals("Kanban Board",boardPage.verifyBoardPage());
    }

    @And("User click Add List")
    public void clickAddList() throws InterruptedException {
        Thread.sleep(5000);
        boardPage.clickAddListButton();
    }

    @And("User type list name {string}")
    public void typeListName(String listName){
        boardPage.typeListName(listName);
    }

    @And("User click create button")
    public void clickCreateButton(){
        boardPage.clickCreateButton();
    }

    @Then("User success create new list")
    public void successCreateNewList(){
        Assert.assertEquals("Creating list is success",boardPage.verifySuccessCreate());
    }

    @And("User didn't type list name")
    public void userDidntTypeListname(){
            boardPage.typeListName("");
    }

    @Then("User failed create new list")
    public void failedCreateNewList(){
        Assert.assertEquals("List name cannot be empty", boardPage.verifyFailedCreate());
    }

    @And("User click add card in one of the list")
    public void clickAddCard(){
        boardPage.clickAddCardButton();
    }

    @And("User type card name")
    public void typeCardName(){
        boardPage.typeCardName("Coba Add Card");
    }

    @And("User didn't type card name")
    public void didntTypeCardName(){
        boardPage.typeCardName("");
    }

    @And("User switch toggle to private")
    public void switchToggleToPrivate(){
        boardPage.clickSwitchToggle();
    }

    @And("User click add card button")
    public void clickAddCardButton(){
        boardPage.clickAddCardButton2();
    }

    @Then("User success add card")
    public void successAddCard(){
        Assert.assertEquals("Creating card is success", boardPage.verifySuccessAddCard());
    }

    @Then("User failed add card")
    public void failedAddCard(){
        Assert.assertEquals("Card name cannot be empty",boardPage.verifyFailedCreate());
    }

    @And("User click cancel button")
    public void clickCancelButton(){
        boardPage.clickCancelListButton();
    }

    @Then("User success cancel create new list")
    public void successCancelCreateNewList(){
        boardPage.verifySuccessCancelNewList();
    }
}
