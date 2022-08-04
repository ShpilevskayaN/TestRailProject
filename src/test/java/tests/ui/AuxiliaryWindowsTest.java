package tests.ui;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class AuxiliaryWindowsTest extends BaseTest {

    @Test
    public void dialogWindowDeleteTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("First");
        projectOverviewStep.selectSuite();
        testSuitesStep.addTestSuite();
        addTestSuiteStep.createTestSuite("newsuite", "test");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.deleteTestSuite("newsuite");
        editTestSuiteStep.testConfirmation();

    }

    @Test
    public void popupTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.popupText();

    }

    @Test
    public void uploadTest() {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        dashboardStep.openProject("Test project");
        projectOverviewStep.selectSuite();
        testSuitesStep.openTestSuite("First Suite");
        testSuiteOverviewStep.selectEditTestSuite();
        editTestSuiteStep.uploadFile("First Suite", "uploading...")
                .getUpdateMessageLocator()
                .shouldHave(text("Successfully updated the test suite."));
        navigationStep.navigateToDashboardFromTestSuiteOverviewPage();
    }



}
