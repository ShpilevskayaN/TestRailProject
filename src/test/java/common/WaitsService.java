package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class WaitsService {

    private WebDriverWait wait;
    private WebDriver driver;

    public WaitsService(WebDriver driver, Duration timeout) {
        wait = new WebDriverWait(driver, timeout);
        this.driver = driver;
    }

    public WebElement waitForVisibility(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForVisibilityLocatedBy(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public List<WebElement> waitForAllVisibilityLocatedBy(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public WebElement waitForPresenceOfElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public boolean waitForElementInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public WebElement waitForClickableElement(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public WebElement fluentWaitForElement(By locator){
        Wait<WebDriver>fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class);
        return fluent.until(driver -> driver.findElement(locator));
    }
}
