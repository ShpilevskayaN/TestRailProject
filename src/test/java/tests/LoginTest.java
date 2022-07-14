package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Success login")
    public void successLoginTest() {
        Assert.assertFalse(loginStep.successLogin(ReadProperties.username(), ReadProperties.password()).isPageClose());
    }

    @Test(description ="Invalid login")
    public void invalidLogin() {
        Assert.assertEquals(loginStep.incorrectLogin("fbhdgtnfgn",
                ReadProperties.password()).getErrorTextElement().getText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Test(description ="Invalid Psw")
    public void invalidPsw() {
        Assert.assertEquals(
                loginStep.incorrectLogin(
                        ReadProperties.username(), "fhgvghv").getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.");


    }
}
