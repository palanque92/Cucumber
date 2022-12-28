package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _11_JDBCSteps {
    @Then("Send The query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sorgu) {

        // DB den gerekli listeyi alicam
        ArrayList<ArrayList<String>> dblist =DBUtility.getListData(sorgu);
        System.out.println(dblist);

        // Webden Ekrandaki listeyi alicam
        DialogContent dc = new DialogContent();
        List<WebElement> uiList = dc.nameList;
        for (WebElement e:uiList)
            System.out.println(e.getText()); // ui kontrol


        // sonrada karsilastiracagim
        for (int i = 0; i < dblist.size(); i++) {
            System.out.println("->"+dblist.get(i).get(1).trim()+"<-");
            System.out.println("->"+uiList.get(i).getText().trim()+"<-");

            Assert.assertEquals(dblist.get(i).get(1).trim(),
                    uiList.get(i).getText().trim(),"Hatali durum");
        }
    }
}
