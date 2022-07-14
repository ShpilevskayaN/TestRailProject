package tests;

import Services.WaitsService;
import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("https://shpilka.testrail.io/index.php?/cases/add/1");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));
        WebElement fileUploadPath = wait.waitForExists(By.id("entityAttachmentListEmptyIcon"));
        fileUploadPath.sendKeys("attachment-library-add-icon dz-clickable");
        wait.waitForExists(By.id("file-submit")).submit();


    }

}

