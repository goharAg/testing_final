package com.aua.testinghw.base;

import com.aua.testinghw.pages.common.GoodreadsHomePage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import static com.aua.testinghw.constants.urls.SUTurl.baseUrl;

public class BaseTest {
    public static WebDriver driver;
    public static GoodreadsHomePage homePage;
    
    @BeforeClass
    public void initWebDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);

//    For execution with RemoteWebDriver

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("browserVersion", "112.0");
//        chromeOptions.setCapability("platformName", "Linux");
//        driver = new RemoteWebDriver(new URL(" http://localhost:4444/"), chromeOptions);

    }

    @BeforeMethod
    public void goHome(){
        driver.manage().window().maximize();
        homePage = new GoodreadsHomePage(driver);
        driver.get(baseUrl);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try{
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Files.move(screenshot.toPath(), new File("src/test/screenshots/" +  result.getName() + timestamp + ".jpg").toPath());
        }catch(IOException e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
