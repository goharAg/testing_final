package com.aua.testinghw;

import com.aua.testinghw.base.BaseTest;
import com.aua.testinghw.pages.common.GoodreadsSearchPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class GoodreadsSearchByAuthorPageTest extends BaseTest
{
    GoodreadsSearchPage searchPage;


    // Search by Author Success Case
    @Test
    public void searchByAuthor(){
        homePage.enterSearchText("Colleen Hoover");
        searchPage = homePage.clickSearch();
        searchPage.closePopUp();

        List<String> names = searchPage.getAuthorList();
        List<String> titles = searchPage.getBookTitleList();

        int index = 0;
        for(String name: names){

            System.out.println(name);
            System.out.println(titles.get(index));
            System.out.println("______________");

            //As the search bar is same for title AND author, the results may include books with titles including authors names

            boolean exists = name.contains("Colleen Hoover") || titles.get(index).toLowerCase().contains("By Colleen Hoover".toLowerCase());

            assertTrue(exists);
            index++;
        }

    }

    //Search by invalid text
    @Test
    public void searchByAuthorFail(){
        String searchValueTest = "298eund189x2";
        homePage.enterSearchText(searchValueTest);
        searchPage = homePage.clickSearch();
        searchPage.closePopUp();

        String searchValue = searchPage.getSearchBarText();
        String result = searchPage.getSearchResultsText();


        assert(searchValue).equals(searchValueTest);
        assert(result).contains("No results.");

    }



}
