package tests;

import Services.WaitsService;
import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopUpWindowTest extends BaseTest {

    @Test
     public void popUpWindowTest(){

        driver.get("");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));
        WebElement fileUploadPath = wait.waitForExists(By.id(""));
    }



}
