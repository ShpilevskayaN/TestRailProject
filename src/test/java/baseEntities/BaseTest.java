package baseEntities;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import steps.LoginStep;
import common.BrowsersService;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import static configuration.Comfig.CLEAR_COOKIES_AND_STORAGE;
import static configuration.Comfig.HOLD_BROWSER_OPEN;

public class BaseTest {

    protected WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationSteps navigationSteps;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        loginStep = new LoginStep(driver);
        navigationSteps= new NavigationSteps(driver);
        driver.get(ReadProperties.getUrl());
    }


    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if (CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
    @AfterSuite (alwaysRun = true)
    public void close () {
        if (HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }
}