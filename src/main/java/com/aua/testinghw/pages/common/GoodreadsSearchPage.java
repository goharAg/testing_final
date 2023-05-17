package com.aua.testinghw.pages.common;

import com.aua.testinghw.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.aua.testinghw.constants.locators.GoodreadsHomePageConstants.QUOTES_FIRST_LINK;
import static com.aua.testinghw.constants.locators.GoodreadsSearchPageLoactors.*;

public class GoodreadsSearchPage extends BasePage {
        
    WebDriver driver;
    private By tableName = By.className(TABLE_NAME);
    private By rowSelector = By.tagName(ROW_TAG);
    private By cellSelector = By.tagName(CELL_TAG);
    private By spanSelector = By.tagName(SPAN_TAG);

    private By authorPath = By.cssSelector(AUTHOR_CSS_SELECTOR);
    private By bookPath = By.cssSelector(BOOK_PATH);



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









}
