package com.aua.testinghw.pages.base;

import com.aua.testinghw.pages.common.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;

    public Header header;

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

    public void closePopUp(){

        boolean popupNotExists = driver.findElements(By.cssSelector("[data-react-class='ReactComponents.LoginInterstitial']")).isEmpty();
        if(!popupNotExists){
            System.out.println("POP EXISTS");
            By locator = By.cssSelector("[data-react-class='ReactComponents.LoginInterstitial'] div.modal--overlay div.modal__content div.modal__close > button");

            getElement(locator).click();
        }

    }

    public void closePopUp2(){
        boolean popupNotExists = driver.findElements(By.className("Overlay--floating")).isEmpty();
        if(!popupNotExists){
            By locator = By.cssSelector("div.Overlay--floating div.Overlay__window div.Overlay__header div.Overlay__close div.Button__container > button");

            getElement(locator).click();
        }

    }


}