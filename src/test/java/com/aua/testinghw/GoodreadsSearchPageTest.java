package com.aua.testinghw;

import com.aua.testinghw.base.BaseTest;
import com.aua.testinghw.pages.common.GoodreadsSearchPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class GoodreadsSearchPageTest extends BaseTest
{
    GoodreadsSearchPage searchPage;

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
            Boolean exists = name.contains("Colleen Hoover") || titles.get(index).toLowerCase().contains("By Colleen Hoover".toLowerCase());

            assertTrue(exists);
            index++;
        }


    }

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



}
