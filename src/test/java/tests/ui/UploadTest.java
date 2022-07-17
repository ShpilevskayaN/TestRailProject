package tests.ui;

import baseEntities.BaseTest;
import common.WaitsService;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadTest extends BaseTest {


    @Feature("тест на загрузку файла")
    @Test
    public void fileUploadTest() {
        driver.get("https://shpilka.testrail.io/index.php?/cases/add/1");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));
        WebElement fileUploadPath = wait.waitForVisibility(driver.findElement(By.id("entityAttachmentListEmptyIcon")));
        fileUploadPath.sendKeys("attachment-library-add-icon dz-clickable");
        wait.waitForVisibility(driver.findElement(By.id("file-submit"))).submit();
    }
}
