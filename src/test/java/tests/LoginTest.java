package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        Assert.assertTrue(loginStep.successLogin(ReadProperties.username(),ReadProperties.password()).isPageOpened());
        }

   @Test
   public void incorrectEmailLoginTest() {
       Assert.assertEquals(
               loginStep.incorrectLogin(
                       "YYYIOKO5Ojk", ReadProperties.password()).getErrorTextElement().getText(),
                    "Email/Login or Password is incorrect. Please try again.", "Неверное сообщение об ошибке");
        }

   @Test
   public void incorrectPswLoginTest() {
       Assert.assertEquals(
              loginStep.incorrectLogin(
                     ReadProperties.username(), "spkihyg").getErrorTextElement().getText(),
                    "Email/Login or Password is incorrect. Please try again.", "Неверное сообщение об ошибке");
        }
    }