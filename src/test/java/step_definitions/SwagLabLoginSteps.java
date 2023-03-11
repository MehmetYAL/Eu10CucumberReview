package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.LabLoginPage;
import pages.ShoppingPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SwagLabLoginSteps {

    LabLoginPage login = new LabLoginPage();
    ShoppingPage sp = new ShoppingPage();

    @Given("user goes to the login page")
    public void user_goes_to_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("swaglab.url"));
    }

    @When("user login with validate credentials")
    public void user_login_with_validate_credentials() {
        login.usernameInput.sendKeys(ConfigurationReader.getProperty("swaglab.username"));
        login.passwordInput.sendKeys(ConfigurationReader.getProperty("swaglab.password"));
        login.loginBtn.click();
    }

    @Then("user is on the dashboard")
    public void user_is_on_the_dashboard() {
        String expected = "Swag Labs";
        String actual = sp.title.getText();
        Assert.assertEquals(expected, actual);
    }
}