package Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsService {
    private WebDriverWait wait;
    private WebDriver driver;

    public WaitsService(WebDriver driver, Duration timeout) {
        wait = new WebDriverWait(driver, timeout);
    }

        public WebElement waitForExists (By id){

            return null;
        }

    }