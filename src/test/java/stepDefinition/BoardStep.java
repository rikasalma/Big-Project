package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import pageObject.BoardPage;
import pageObject.TeamPage;

import static stepDefinition.HookStep.webDriver;

public class BoardStep {
    private final TeamPage teamPage = new TeamPage(webDriver);
    private final BoardPage boardPage = new BoardPage(webDriver);

    @Given("User already in Team page")
    public void alreadyInTeamPage() throws InterruptedException {
        Thread.sleep(4000);
        teamPage.verifyTeamPage();
    }

    @When("User click Board Feature")
    public void clickBoardFeature(){
        teamPage.clickBoardMenu();
        Assert.assertEquals("Kanban Board",boardPage.verifyBoardPage());
    }

    @And("User click Add List")
    public void clickAddList() throws InterruptedException {
        Thread.sleep(4000);
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
    public void successCreateNewList() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Creating list is success",boardPage.verifySuccessCreate());
    }

    @And("User didn't type list name")
    public void userDidntTypeListname(){
            boardPage.typeListName("");
    }

    @Then("User failed create new list")
    public void failedCreateNewList() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("List name cannot be empty", boardPage.verifyFailedCreate());
    }

    @And("User click add card in one of the list")
    public void clickAddCard() throws InterruptedException {
        Thread.sleep(3000);
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
    public void clickAddCardButton() throws InterruptedException {
        Thread.sleep(3000);
        boardPage.clickAddCardButton2();
    }

    @Then("User success add card")
    public void successAddCard() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertEquals("Creating card is success", boardPage.verifySuccessAddCard());
    }

    @Then("User failed add card")
    public void failedAddCard() throws InterruptedException {
        Thread.sleep(3000);
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
