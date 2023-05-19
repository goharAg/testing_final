package com.aua.testinghw.pages.common;

import com.aua.testinghw.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.aua.testinghw.constants.locators.GoodreadsSearchByAuthorPageLoactors.*;
import static com.aua.testinghw.constants.locators.GoodreadsSearchByTitlePageLoactors.*;

public class GoodreadsSearchPage extends BasePage {
        
    WebDriver driver;

    private By authorPath = By.cssSelector(AUTHOR_CSS_SELECTOR);
    private By bookPath = By.cssSelector(BOOK_PATH);

    private By searchBarQuery = By.id(SEARCH_BAR_QUERY);

    private By searchResult = By.cssSelector(SEARCH_RESULT);



    public GoodreadsSearchPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
	}


    public List<String> getAuthorList(){

        List<WebElement> authors = driver.findElements(authorPath);
        List<String> names = new ArrayList<>();
        for(WebElement author: authors ){
            names.add(author.getText());
        }

        return names;
    }

    public List<String> getBookTitleList(){

        List<WebElement> titles = getElements(bookPath);
        List<String> bookTitlesList = new ArrayList<>();
        for(WebElement title : titles ){
            bookTitlesList.add(title.getText());
        }

        return bookTitlesList;
    }

    public String getSearchResultsText(){
        WebElement inputElement = driver.findElement(searchResult);
        String t = inputElement.getText();
        System.out.println(t);
        return t;

    }

    public String getSearchBarText(){

        WebElement searchResultElement = driver.findElement(searchBarQuery);
        String t = searchResultElement.getAttribute("value");
        System.out.println(t);
        return t;

    }


}
