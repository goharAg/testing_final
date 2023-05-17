package com.aua.testinghw.pages.common;

import com.aua.testinghw.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.aua.testinghw.constants.locators.GoodreadsHomePageConstants.*;

public class GoodreadsHomePage extends BasePage {
    
    WebDriver driver;
    private By searchButtonClass = By.cssSelector(SEARCH_BUTTON);
    private By searchBarId = By.id(SEARCH_BAR);

    private By quoteLinkSelector = By.cssSelector(QUOTES_FIRST_LINK);

    public GoodreadsHomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
	}

    public void enterSearchText(String text){
        getElement(searchBarId).sendKeys(text);
    }

    public GoodreadsSearchPage clickSearch() {

        WebElement searchButton = getElement(searchButtonClass);

        searchButton.click();
       // searchButton.sendKeys(Keys.ENTER);
        return new GoodreadsSearchPage(driver);
    }

    public GoodreadsBookShowPage searchByISBN(String ibsnNumber){
        enterSearchText(ibsnNumber);
        WebElement searchButton = getElement(searchButtonClass);

        searchButton.click();
        return new GoodreadsBookShowPage(driver);
    }



    public GoodreadsQuotesPage goQuotePage(){
        driver.findElement(quoteLinkSelector).click();

        return new GoodreadsQuotesPage(driver);
    }



}
