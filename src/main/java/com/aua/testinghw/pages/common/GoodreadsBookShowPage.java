package com.aua.testinghw.pages.common;

import com.aua.testinghw.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.aua.testinghw.constants.locators.GoodreadsBookShowPageConstants.BOOK_TITLE;

public class GoodreadsBookShowPage extends BasePage {

    WebDriver driver;

    private By quoteLinkSelector = By.cssSelector(BOOK_TITLE);


    public GoodreadsBookShowPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
	}

    public String getTitle() {
        return driver.findElement(quoteLinkSelector).getText();
    }










}
