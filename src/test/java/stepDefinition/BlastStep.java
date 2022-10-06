package stepDefinition;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.BlastPage;
import pageObject.TeamPage;

import static stepDefinition.HookStep.webDriver;

public class BlastStep {

    private final TeamPage teamPage = new TeamPage(webDriver);
    private final BlastPage blastPage = new BlastPage(webDriver);

    @When("User click blast feature")
    public void clickBlastFeature(){
        teamPage.clickBlastMenu();
        blastPage.verifyBlastPage();
    }

    @And("User click create blast")
    public void clickCreateBlast(){
        blastPage.clickCreatBlastButton();
    }
    @And("User type title {string}")
    public void typeTitle(String title) throws InterruptedException {
        Thread.sleep(4000);
        blastPage.inputTitle(title);
    }

    @And("User write the description {string}")
    public void writeTheDescription(String description){
        blastPage.inputDescription(description);
    }

    @And("User click publish button")
    public void clickPublishButton() throws InterruptedException {
        Thread.sleep(4000);
        blastPage.clickPublishButton();
    }

    @Then("User success create blast")
    public void successCreateBlast() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Create post successful",blastPage.verifyCreateBlast());
    }

    @Then("User failed create blast")
    public void failedCreateBlast() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("Field parameter not complete.",blastPage.verifyCreateBlast());
    }

    @And("User click one of the blast")
    public void clickOneOfTheBlast() throws InterruptedException {
        Thread.sleep(4000);
       blastPage.clickBlastPost();
    }

    @And("User type comment {string}")
    public void typeComment(String comment) throws InterruptedException {
        Thread.sleep(4000);
        blastPage.clickCommentSection();
        blastPage.inputComment(comment);
    }

    @And("User click post button")
    public void clickPostButton(){
        blastPage.clickPostButton();
    }

    @Then("User success add comment")
    public void successAddComment() throws InterruptedException {
        Thread.sleep(3000);
        blastPage.verifyCreateBlast();
    }
}
