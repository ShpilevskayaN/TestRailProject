package tests.ui;

import baseEntities.BaseTest;
import common.WaitsService;
import configuration.ReadProperties;
import io.qameta.allure.Feature;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProjectTest extends BaseTest {

    @Feature("тест на отображение диалогового окна")
    @Test
    public void popUpWindowTest(){

        driver.get("");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));
        WebElement fileUploadPath = wait.waitForClickableElement(By.id(""));
    }

    @Feature("тест на загрузку файла")
    @Test
    public void fileUploadTest() {
        driver.get("https://shpilka.testrail.io/index.php?/cases/add/1");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(20));
        WebElement fileUploadPath = wait.waitForVisibility(By.id("entityAttachmentListEmptyIcon"));
        fileUploadPath.sendKeys("attachment-library-add-icon dz-clickable");
        wait.waitForVisibility(By.id("file-submit")).submit();


    }
    @Feature("тест на граничные значения")
    @Test
    public void addUserName() {
        String userName1 = RandomStringUtils.randomAlphabetic(251);
        loginStep.login(userName1, ReadProperties.password());
        loginPage.errorTextLocator().shouldHave(text("Field Email/User is too long (250 characters at most)."));

        String userName2 = RandomStringUtils.randomAlphabetic(250);
        loginStep.login(userName2, ReadProperties.password());
        loginPage.getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));

        String userName3 = RandomStringUtils.randomAlphabetic(249);
        loginStep.login(userName3, ReadProperties.password());
        loginPage.getErrorTextLocator().shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }
}