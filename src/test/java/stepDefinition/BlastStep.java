package stepDefinition;

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
    public void typeTitle(String title){
        blastPage.inputTitle(title);
    }

    @And("User write the description {string}")
    public void writeTheDescription(String description){
        blastPage.inputDescription(description);
    }

    @And("User click publish button")
    public void clickPublishButton(){
        blastPage.clickPublishButton();
    }

    @Then("User success create blast")
    public void successCreateBlast(){
        Assert.assertEquals("Create post successful",blastPage.verifyCreateBlast());
    }

    @Then("User failed create blast")
    public void failedCreateBlast(){
        Assert.assertEquals("Field parameter not complete.",blastPage.verifyCreateBlast());
    }

    @And("User click one of the blast")
    public void clickOneOfTheBlast(){
       blastPage.clickBlastPost();
    }

    @And("User type comment {string}")
    public void typeComment(String comment){
        blastPage.clickCommentSection();
        blastPage.inputComment(comment);
    }

    @And("User click post button")
    public void clickPostButton(){
        blastPage.clickPostButton();
    }

    @Then("User success add comment")
    public void successAddComment(){
        blastPage.verifyCreateBlast();
    }
}
