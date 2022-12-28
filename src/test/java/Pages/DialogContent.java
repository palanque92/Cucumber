package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DialogContent extends Parent{

    public DialogContent()
    {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    private WebElement username;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css = "span[class='mat-tooltip-trigger logo-text']")
    private WebElement txtTechnoStudy;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']/input")
    private WebElement codeInput;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'succesfully')]")
    private WebElement successMessage;

    @FindBy(css = "button[class='consent-give']")
    private WebElement acceptCookies;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//input[@data-placeholder='Name']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[text()=' Delete ']")
    private WebElement deleteDialogButton;

    @FindBy(xpath = "(//td[@role='cell'])[2]")
    private WebElement searchResultCell;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']/input")
    private WebElement priorityCode;

    @FindBy(xpath = "(//span[@class='mat-slide-toggle-thumb-container'])[11]")
    private WebElement toggleBar;

    @FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[2]")
    public List<WebElement> nameList;



    WebElement myElement;

    public void findAndSend(String strlement, String value) {
        switch (strlement)
        {
            case "username" : myElement=username;break;
            case "password" : myElement=password;break;
            case "nameInput" : myElement=nameInput;break;
            case "codeInput" : myElement=codeInput;break;
            case "shortName" : myElement=shortName;break;
            case "searchInput" : myElement=searchInput;break;
            case "integrationCode" : myElement=integrationCode;break;
            case "priorityCode" : myElement=priorityCode;break;
        }
            sendKeysFunction(myElement,value);
    }

    public void findAndClick(String Strlement) {
        switch (Strlement)
        {
            case "loginButton" : myElement=loginButton;break;
            case "addButton" : myElement=addButton;break;
            case "saveButton" : myElement=saveButton;break;
            case "acceptCookies" : myElement=acceptCookies;break;
            case "searchButton" : myElement=searchButton;break;
            case "deleteButton" : myElement=deleteButton;break;
            case "deleteDialogButton" : myElement=deleteDialogButton;break;
            case "toggleBar" : myElement=toggleBar;break;


        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strlement, String text) {
        switch (strlement)
        {
            case "txtTechnoStudy" : myElement=txtTechnoStudy;break;
            case "successMessage" : myElement=successMessage;break;
            case "alreadyExist" : myElement=alreadyExist;break;
            case "searchResultCell" : myElement=searchResultCell;break;


        }
        verifyContainsTextFunction(myElement,text);
    }
    public void findAndDelete(String searchText) {

        findAndSend("searchInput", searchText);  // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas

        //wait.until(ExpectedConditions.stalenessOf(deleteButton)); stale zamanını yakalayamadım
        //wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tbody[@role='rowgroup']//tr"),5));

        // findAndContainsText("searchResultCell", searchText); // arama sonuçlarının ilkinde aranan kelime gözükene kadar bekle.

        waitUntilLoading(); // progressbar ın çocukları 0 olana kadar bekle

        findAndClick("deleteButton"); // silme butonua bas, çöp kutusu
        findAndClick("deleteDialogButton"); // dilogdaki silme butonuna bas

    }
}
