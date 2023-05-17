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



}
