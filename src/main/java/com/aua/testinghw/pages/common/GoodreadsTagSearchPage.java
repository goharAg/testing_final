package com.aua.testinghw.pages.common;

import com.aua.testinghw.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.aua.testinghw.constants.locators.GoodreadsTagSearchPageLoactors.*;

public class GoodreadsTagSearchPage extends BasePage {

    WebDriver driver;

    private By tagFooterSelector = By.cssSelector(QUOTE_TAG_FOOTER_SELECTOR);

    private By tagFooterValueSelector = By.cssSelector(QUOTE_TAG_FOOTER_VALUE_SELECTOR);

    private By tagNoSearchResultSelector = By.cssSelector(QUOTE_NO_RESULT);



    public GoodreadsTagSearchPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
	}


    public List<List<String>> getTagsList(){

        List<WebElement> tagFooters = driver.findElements(tagFooterSelector);
        List<List<String>> tagsNames = new ArrayList<>();
        List<String> tagNames = new ArrayList<>();
        for(WebElement tagFooter: tagFooters ){
            List<WebElement> values = tagFooter.findElements(tagFooterValueSelector);

            for(WebElement element: values){
                tagNames.add( element.getText());
            }
            tagsNames.add(tagNames);
        }

        return tagsNames;
    }


public String getResult(){
        return getElement(tagNoSearchResultSelector).getText();
}







}
