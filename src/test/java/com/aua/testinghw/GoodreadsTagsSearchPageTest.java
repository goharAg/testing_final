package com.aua.testinghw;

import com.aua.testinghw.base.BaseTest;
import com.aua.testinghw.pages.common.GoodreadsQuotesPage;
import com.aua.testinghw.pages.common.GoodreadsTagSearchPage;
import org.testng.annotations.Test;

import java.util.List;


public class GoodreadsTagsSearchPageTest extends BaseTest
{
    GoodreadsTagSearchPage tagsSearchPage;

    GoodreadsQuotesPage quotesPage;


    @Test
    public void searchQuoteTag(){
        quotesPage = homePage.goQuotePage();

        homePage.closePopUp();

        String tagName = quotesPage.getFirstTagName();

        tagsSearchPage = quotesPage.clickFirstTag();

        List<List<String>> tagNameLists =  tagsSearchPage.getTagsList();

        for(List<String> tageNameList: tagNameLists){
            System.out.println(tagName);
            System.out.println(tageNameList.toString());
            assert(tageNameList).contains(tagName.toLowerCase());
        }


    }

    //Search by two tags
    @Test
    public void searchQuoteTwoTag(){
        quotesPage = homePage.goQuotePage();

        homePage.closePopUp();
        String tagsName = "love truth";

        tagsSearchPage = quotesPage.searchTwoTags(tagsName);

        List<List<String>> tagNameLists =  tagsSearchPage.getTagsList();

        for(List<String> tageNameList: tagNameLists){
            System.out.println(tagsName);
            System.out.println(tageNameList.toString());
            assert(tageNameList).contains("love-truth");
        }

    }

    //No such Tag
    @Test
    public void searchQuoteNOTag(){
        quotesPage = homePage.goQuotePage();

        homePage.closePopUp();
        String tagsName = "love-autumn";

        tagsSearchPage = quotesPage.searchTwoTags(tagsName);

        String resultText =  tagsSearchPage.getResult();

        assert(resultText).contains("Showing 0-0 of 0");


    }



}
