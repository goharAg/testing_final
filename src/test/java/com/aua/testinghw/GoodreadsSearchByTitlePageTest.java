package com.aua.testinghw;

import com.aua.testinghw.base.BaseTest;
import com.aua.testinghw.pages.common.GoodreadsSearchPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class GoodreadsSearchByTitlePageTest extends BaseTest
{
    GoodreadsSearchPage searchPage;

// Success case
    @Test
    public void searchByTitle(){
        homePage.enterSearchText("Harry Potter");
        searchPage = homePage.clickSearch();
        searchPage.closePopUp();

        List<String> titles = searchPage.getBookTitleList();

        for(String title : titles){

            System.out.println(title);
            System.out.println("______________");
            Boolean exists = title.toLowerCase().contains("Harry Potter".toLowerCase());

            assertTrue(exists);
        }

    }

    //No Such book Title

    @Test
    public void searchByAuthorFail(){
        String searchValueTest = "Heraty Potyer";
        homePage.enterSearchText(searchValueTest);
        searchPage = homePage.clickSearch();
        searchPage.closePopUp();

        String searchValue = searchPage.getSearchBarText();
        String result = searchPage.getSearchResultsText();


        assert(searchValue).equals(searchValueTest);
        assert(result).contains("No results.");

    }



}
