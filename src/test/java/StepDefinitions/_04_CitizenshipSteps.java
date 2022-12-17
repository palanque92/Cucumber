package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {

    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    @And("Navigate to CitizenShip page")
    public void navigateToCitizenShipPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenShip");

    }

    @When("User a CitizenShip name as {string} short name as {string}")
    public void userACitizenShipNameAsShortNameAs(String name, String shorName) {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("shortName",shorName);
        dc.findAndClick("saveButton");

    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyExist","already");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String arananKelime) {
        dc.findAndDelete(arananKelime);
    }
}
