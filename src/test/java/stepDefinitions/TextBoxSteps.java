package stepDefinitions;

import io.cucumber.java.en.*;

import webPages.TextBoxPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverFactory;
import testdata.TextBoxTestData;


public class TextBoxSteps {

    WebDriver driver;
    TextBoxPage textBoxPage;
    TextBoxTestData textBoxTestData;


    @Given("user is on DemoQA text box page")
    public void user_is_on_demoqa_text_box_page() {

        {
            DriverFactory.getDriver().get("https://demoqa.com/text-box");
            textBoxPage = new TextBoxPage(DriverFactory.getDriver());

        }
    }

    @When("user enters valid name, email and address")
    public void user_enters_valid_details() {
        textBoxPage.enterFullName(TextBoxTestData.FULL_NAME);
        textBoxPage.enterEmail(TextBoxTestData.EMAIL);
        textBoxPage.enterCurrentAddress(TextBoxTestData.CURRENT_ADDRESS);
        textBoxPage.enterPermanentAddress(TextBoxTestData.PERMANENT_ADDRESS);

    }

    @When("user clicks submit button")
    public void user_clicks_submit_button() {
        textBoxPage.clickSubmit();
    }


    @Then("submitted details should be displayed")
    public void submitted_details_should_be_displayed() {

        String outputText = textBoxPage.getSubmittedOutput();

        Assert.assertTrue(outputText.contains("Mrinal Gupta"),
                "Name is not displayed correctly");

        Assert.assertTrue(outputText.contains("mrinal@test.com"),
                "Email is not displayed correctly");

        Assert.assertTrue(outputText.contains("Bangalore"),
                "Current address is not displayed correctly");

        Assert.assertTrue(outputText.contains("India"),
                "Permanent address is not displayed correctly");

       // driver.quit();
    }

}


