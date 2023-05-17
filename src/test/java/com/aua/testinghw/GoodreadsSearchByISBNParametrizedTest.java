package com.aua.testinghw;

import com.aua.testinghw.base.BaseTest;
import com.aua.testinghw.pages.common.GoodreadsBookShowPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class GoodreadsSearchByISBNParametrizedTest extends BaseTest
{

    @DataProvider(name = "TestData")
    public Object[][] testData() {
        return new Object[][] {
                { "9781476715926" , "Point of Retreat" },
                {"9781476753188", "Ugly Love"}
        };
    }

    GoodreadsBookShowPage bookShowPage;


    @Test(dataProvider = "TestData")
    public void searchByIBSN(String isbnNumber, String title){
        bookShowPage = homePage.searchByISBN(isbnNumber);

        homePage.closePopUp2();

        assert(bookShowPage.getTitle().toLowerCase()).contains(title.toLowerCase());

    }

}
