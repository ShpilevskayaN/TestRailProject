package tests.ui;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;

public class CrudTSuiteTest extends BaseTest {
    @Test(priority = 1)
    public void createSuiteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("Test project");
        projectOverviewStep.selectSuite();
        testSuitesStep.addTestSuite();
        addTestSuiteStep.createTestSuite("First Suite", "test purposes")
                .getMessageLocator()
                .isDisplayed();
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();

    }

    @Test(priority = 2)
    public void readSuiteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("Test project");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.getTestSuiteName()
                .shouldHave(value("First Suite"));
    }

    @Test(priority = 3)
    public void updateSuiteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("Test project");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.editTestSuite("First Suite", "qegegqegqeg")
                .getUpdateMessageLocator()
                .shouldHave(text("Successfully updated the test suite."));
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();
    }


    @Test(priority = 5)
    public void deleteSuiteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("Test project");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.deleteTestSuite("First Suite")
                .getDeleteMessageLocator()
                .shouldHave(text("Successfully deleted the test suite."));
    }

    @Test(priority = 4)
    public void readSuiteAfterUpdateTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("Test project");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.getTestSuiteName()
                .shouldHave(value("First Suite"));
        editTestSuiteStep.getTestSuiteDescription()
                .shouldHave(text("qegegqegqeg"));
        navigationStep.navigateToDashboardFromEditTestSuitePage();
    }

}
