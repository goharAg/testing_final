package com.aua.testinghw.pages.common;

import com.aua.testinghw.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.aua.testinghw.constants.locators.GoodreadsHomePageConstants.QUOTES_FIRST_LINK;
import static com.aua.testinghw.constants.locators.GoodreadsHomePageConstants.QUOTE_SEARCH_SELECTOR;
import static com.aua.testinghw.constants.locators.GoodreadsQuotePageLoactors.QUOTE_FIRST_TAG_SELECTOR;
import static com.aua.testinghw.constants.locators.GoodreadsTagSearchPageLoactors.QUOTE_TAG_SEARCH_BAR;

public class GoodreadsQuotesPage extends BasePage {

    WebDriver driver;

    private By quoteFirstLinkSelector = By.cssSelector(QUOTE_FIRST_TAG_SELECTOR);

    private By quoteTagSearchBar = By.cssSelector(QUOTE_TAG_SEARCH_BAR);


    public GoodreadsQuotesPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
	}


    public GoodreadsTagSearchPage clickFirstTag(){
        driver.findElement(quoteFirstLinkSelector).click();
        return new GoodreadsTagSearchPage(driver);
    }

    public String getFirstTagName(){
        WebElement firstTag = driver.findElement(quoteFirstLinkSelector);
        return firstTag.getText().split(" ")[0];
    }

    public GoodreadsTagSearchPage searchTwoTags(String text){
        WebElement searchBar = driver.findElement(quoteTagSearchBar);
        searchBar.sendKeys(text);
        searchBar.sendKeys(Keys.RETURN);
        return new GoodreadsTagSearchPage(driver);
    }







}
