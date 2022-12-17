package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.lang.reflect.Type;
import java.util.List;

public class _05_DataTableSteps {
    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    FormContent fc = new FormContent();
    @And("Click on the element in left nav")
    public void clickOnTheElementInLeftNav(DataTable elemanlar) {
        List<String>listElemanlar=elemanlar.asList(String.class);

        for (String eleman : listElemanlar )  {
            ln.findAndClick(eleman);
        }
    }

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elemanlar) {
        List <String> listElemanlar = elemanlar.asList(String.class);

        for ( String strButtonName : listElemanlar ) {
            dc.findAndClick(strButtonName);
        }
    }

    @And("User sendimg the keys in Dialog content")
    public void userSendimgTheKeysInDialogContent(DataTable elemanlar) {
        List<List<String>>listElemanlar = elemanlar.asLists(String.class);

        for (int i = 0; i < listElemanlar.size(); i++) {
            dc.findAndSend(listElemanlar.get(i).get(0),listElemanlar.get(i).get(1));
                            // elemanin adi             // elemanin degeri
        }
    }

    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elemanlar) {
        List <String> listElemanlar = elemanlar.asList(String.class);

        for ( String strButtonName : listElemanlar ) {
            dc.findAndDelete(strButtonName);
        }
    }

    @And("User sendimg the keys in Form Content")
    public void userSendimgTheKeysInFormContent(DataTable elemanlar) {
        List <String> listElemanlar = elemanlar.asList(String.class);

        for ( String strButtonName : listElemanlar ) {
            fc.findAndClick(strButtonName);
        }
    }
}
