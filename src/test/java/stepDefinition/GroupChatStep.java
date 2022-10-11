package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.GroupChatPage;
import pageObject.TeamPage;

import static stepDefinition.HookStep.webDriver;

public class GroupChatStep {

    private final TeamPage teamPage = new TeamPage(webDriver);
    private final GroupChatPage groupChatPage = new GroupChatPage(webDriver);

    @When("User click Group Chat Feature")
    public void clickGroupChatFeature(){
        teamPage.clickGroupChatMenu();
        Assert.assertEquals("Group Chat",groupChatPage.verifyGroupChatPage());
    }

    @And("User type Message {string}")
    public void typeMessage(String message){
        groupChatPage.inputMessage(message);
    }

    @And("User click send button")
    public void clickSendButton(){
        groupChatPage.clickSendButton();
    }

    @Then("User success send message")
    public void successSendMessage(){
        groupChatPage.verifySuccessSend();
    }

    @And("User attach the file")
    public void clickAttachButton() throws InterruptedException {
        Thread.sleep(4000);
        groupChatPage.attachFile();
    }

    @Then("User success attach file")
    public void successAttachFile(){
        groupChatPage.verifySuccessAttachFile();
    }

    @And("User delete message")
    public void deleteMessage() throws InterruptedException {
        Thread.sleep(6000);
        groupChatPage.clickMenuMessageIcon();
    }

    @Then("User success delete message")
    public void successDeleteMessage(){
        Assert.assertEquals("Delete group chat message success", groupChatPage.verifySuccessDelete());
    }

    @And("User click download in the message bubble")
    public void clickDownloadInTheMessageBubble(){
        groupChatPage.downloadFiles();
    }

    @Then("User success download file")
    public void successDownloadTheFile(){
        groupChatPage.successDownloadFile();
    }
}
