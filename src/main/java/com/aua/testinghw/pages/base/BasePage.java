package com.aua.testinghw.pages.base;

import com.aua.testinghw.pages.common.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.aua.testinghw.constants.locators.GoodreadsBasePageConstants.*;

public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;

    public Header header;
    
    private By popup1MainComponentSelector = By.cssSelector(POPUP1_PARENT_CONTAINER);

    private By popup1CloseButton = By.cssSelector(POPUP1_CLOSE_BUTTON);

    private By popup2MainComponentSelector = By.cssSelector(POPUP2_PARENT_CONTAINER);

    private By popup2CloseButton = By.cssSelector(POPUP2_CLOSE_BUTTON);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        header = new Header(driver);
    }
    public WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // Checks and closes popup for the Search Pages
    public void closePopUp(){

        boolean popupNotExists = driver.findElements(popup1MainComponentSelector).isEmpty();
        if(!popupNotExists){
            System.out.println("POP EXISTS");
            getElement(popup1CloseButton).click();
        }

    }

    // Checks and closes popup for the Book Detailed View Pages
    public void closePopUp2(){
        boolean popupNotExists = driver.findElements(popup2MainComponentSelector).isEmpty();
        if(!popupNotExists){
            System.out.println("POP EXISTS");
            getElement(popup2CloseButton).click();
        }

    }


}